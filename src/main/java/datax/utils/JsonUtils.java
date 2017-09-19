package datax.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtils {
    public static String jsonFormatter(String uglyJSONString){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);
        return prettyJsonString;
    }
    public static void writeJsonToFile(String path, String json) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(new File(path)));
        out.write(JsonUtils.jsonFormatter(json));
        out.close();
    }
}
