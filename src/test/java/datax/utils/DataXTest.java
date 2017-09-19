package datax.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataXTest {
    @Test
    public void configHdfsToOracle() throws Exception {
        String json = DataX.ConfigHdfsToOracle("./data/hive.json",
                "/etc/security/keytabs/hive.service.keytab",
                "hive/xj2@EXAMPLE.COM",
                "./data/oracle.json",
                "YX_DXX_TEST1",
                4096,
                false);
        System.out.println(json);
    }

}