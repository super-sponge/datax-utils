package datax.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import datax.utils.jobconf.JobHdfsToStream;
import datax.utils.hdfs.HRColumnCell;
import datax.utils.hdfs.HRParameter;
import org.junit.Test;

public class JobHdfsTest {
    @Test
    public void jobDump() throws Exception {
        JobHdfsToStream jobHdfs = new JobHdfsToStream();
        ObjectMapper mapper = new ObjectMapper();

        HRParameter parameter = jobHdfs.getFirstReaderParameter();
        parameter.addColumn(new HRColumnCell(0, "long"));
        parameter.addColumn(new HRColumnCell(1, "string"));
        parameter.addColumn(new HRColumnCell(2, "long"));
        parameter.addColumn(new HRColumnCell(3, "long"));
        parameter.addColumn(new HRColumnCell(4, "date"));
        parameter.setPath("/apps/hive/warehouse/vote_record/*");
        parameter.setDefaultFS("hdfs://sdc2.sefon.com:8020");
        parameter.setFileType("orc");
        parameter.setEncoding("UTF-8");
        parameter.setFieldDelimiter(",");

        System.out.println(JsonUtils.jsonFormatter(mapper.writeValueAsString(jobHdfs)));
    }


}