package datax.utils.settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobSettingTest {
    @Test
    public void getSpeed() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(new JobSetting()));
    }

}