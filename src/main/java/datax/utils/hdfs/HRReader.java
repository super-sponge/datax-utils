package datax.utils.hdfs;

public class HRReader {
    private String name;
    private HRParameter parameter;

    public HRReader() {
        this.name = "hdfsreader";
        this.parameter = new HRParameter();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HRParameter getParameter() {
        return parameter;
    }

    public void setParameter(HRParameter parameter) {
        this.parameter = parameter;
    }
}
