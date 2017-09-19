package datax.utils.hdfs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class HRReaderTest {
    @Test
    public void jsondump() throws Exception {
        HRReader reader = new HRReader();
        HRParameter parameter = reader.getParameter();
        parameter.addColumn(new HRColumnCell(0, "long"));
        parameter.addColumn(new HRColumnCell(1, "boolean"));
        parameter.addColumn(new HRColumnCell(2, "double"));
        parameter.setPath("/user/hive/warehouse/mytable01/*");
        parameter.setDefaultFS("hdfs://xxx:port");
        parameter.setFileType("orc");
        parameter.setEncoding("UTF-8");
        parameter.setFieldDelimiter(",");

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(reader));
    }

}