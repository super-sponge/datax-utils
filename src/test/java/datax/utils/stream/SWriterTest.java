package datax.utils.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class SWriterTest {
    @Test
    public void jsondump() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(new SWriter()));

    }

}