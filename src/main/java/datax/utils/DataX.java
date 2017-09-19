package datax.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import datax.utils.jobconf.JobHdfsToOracle;
import datax.utils.hdfs.HRColumnCell;
import datax.utils.hdfs.HRParameter;
import datax.utils.hive.HiveMeta;
import datax.utils.oracle.ORParameter;
import datax.utils.oracle.OracleMeta;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DataX {
    private static  final Logger LOG = LoggerFactory.getLogger(DataX.class);

    private static String oraUserName = "user";
    private static String oraPassword = "password123";
    private static String oraURL="jdbc:oracle:thin:@[HOST_NAME]:PORT:[DATABASE_NAME]";


    public static void main(String[] args) throws IOException {
        ExecuteCommandLine(args);
    }

    public static void ExecuteCommandLine(String[] args ) throws IOException{
        Options opts = new Options();
        opts.addOption("h", false, "Help description");
        opts.addOption("f", true, "Hive json path");
        opts.addOption("r", true, "oracle json path");
        opts.addOption("o", true, "json output path");
        opts.addOption("t", true, "Oracle tabname");
        opts.addOption("b", true, "oracle commit batchsize");
        opts.addOption("c", false, "clean oracle table");
        opts.addOption("k", true, "Keytable file");
        opts.addOption("p", true, "pricipal name");

        CommandLineParser parser = new DefaultParser();
        CommandLine cl;
        try {
            cl = parser.parse(opts, args);
            if (cl.getOptions().length > 0) {
                if (cl.hasOption('h')) {
                    HelpFormatter hf = new HelpFormatter();
                    hf.printHelp("May Options", opts);
                } else {
                    String tableName= cl.getOptionValue("t");
                    Integer batchSize= Integer.parseInt(cl.getOptionValue("b"));
                    String hiveJsonPath= cl.getOptionValue("f");
                    String oracleJsonPath = cl.getOptionValue("r");
                    String outJsonPath= cl.getOptionValue("o");
                    String keytab = cl.getOptionValue("k");
                    String principal = cl.getOptionValue("p");


                    String json = ConfigHdfsToOracle(hiveJsonPath, keytab, principal,
                            oracleJsonPath, tableName, batchSize, cl.hasOption("c"));
                    LOG.info("datax job configuration file :");
                    System.out.println(json);
                    JsonUtils.writeJsonToFile(outJsonPath, json);

                }
            } else {
                System.err.println("ERROR_NOARGS");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String ConfigHdfsToOracle(String hiveJsonPath, String keytab, String principal ,
                                            String oracleJsonPath, String oracleTableName, Integer batchSize, boolean clean)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        HiveMeta hiveMeta = mapper.readValue(new File(hiveJsonPath), HiveMeta.class);
        LOG.info("Hive input meta : " + hiveMeta);

        //
        JobHdfsToOracle jobHdfsToOracle = new JobHdfsToOracle();

        HRParameter parameter = jobHdfsToOracle.getFirstReaderParameter();

        parameter.setPath(hiveMeta.getPath());
        parameter.setDefaultFS(hiveMeta.getDefaultfs());
        parameter.setFileType(hiveMeta.getFiletype());
        parameter.setEncoding(hiveMeta.getEncoding());
        parameter.setFieldDelimiter(hiveMeta.getFieldelimiter());
        if (keytab != null && principal != null) {
            parameter.setHaveKerberos("true");
            parameter.setKerberosKeytabFilePath(keytab);
            parameter.setKerberosPrincipal(principal);
        }

        ORParameter orParameter = jobHdfsToOracle.getWriterParameter();
        if(oracleJsonPath != null ) {
            OracleMeta oracleMeta = mapper.readValue(new File(oracleJsonPath), OracleMeta.class);
            LOG.info("Oracle input meta : " + oracleMeta);
            orParameter.setUsername(oracleMeta.getUsername());
            orParameter.setPassword(oracleMeta.getPassword());
            orParameter.setJdbcUrl(oracleMeta.getJdbcUrl());
        } else {
            orParameter.setUsername(oraUserName);
            orParameter.setPassword(oraPassword);
            orParameter.setJdbcUrl(oraURL);
        }
        orParameter.addTable(oracleTableName);
        if (clean) {
            orParameter.addPreSql("truncate table " + oracleTableName);
        } else {
            orParameter.setPreSql(null);
        }
        orParameter.setBatchSize(4096);

        Integer index = 0;
        for(HiveMeta.HiveCell cell : hiveMeta.getColumns()) {
            parameter.addColumn(new HRColumnCell(index ++, cell.getType()));
            orParameter.addColumn(cell.getName());
        }

        return JsonUtils.jsonFormatter(mapper.writeValueAsString(jobHdfsToOracle));
    }
}
