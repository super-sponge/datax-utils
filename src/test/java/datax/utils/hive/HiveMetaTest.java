package datax.utils.hive;

import com.fasterxml.jackson.databind.ObjectMapper;
import datax.utils.JsonUtils;
import org.junit.Test;

import java.io.File;

public class HiveMetaTest {
    @Test
    public void HiveMetaJson() throws Exception {
        HiveMeta hiveMeta = new HiveMeta();
        hiveMeta.setDefaultfs("hdfs://sdc2.sefon.com:8020");
        hiveMeta.setPath("/apps/hive/warehouse/vote_record/*");
        hiveMeta.setFiletype("orc");
        hiveMeta.setFieldelimiter(",");
        hiveMeta.addColumn("id","long");
        hiveMeta.addColumn("inc_datetime","string");
        hiveMeta.addColumn("random_id","string");
        hiveMeta.addColumn("random_string","string");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hiveMeta);

        JsonUtils.writeJsonToFile("./data/hive.json", json);
    }

    @Test
    public void HiveMetaJsonRead() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        HiveMeta hiveMeta = mapper.readValue(new File("./data/hive.json"), HiveMeta.class);

        System.out.println(hiveMeta);

    }

}