package datax.utils.oracle;

import com.fasterxml.jackson.databind.ObjectMapper;
import datax.utils.JsonUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class OracleMetaTest {
    @Test
    public void OracleMeta() throws Exception {
        OracleMeta oracleMeta = new OracleMeta("test", "test123",
                "jdbc:oracle:thin:@10.20.52.28:1521:orcl");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(oracleMeta);
        JsonUtils.writeJsonToFile("./data/oracle.json", json);
    }

}