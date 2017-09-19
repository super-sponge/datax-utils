package datax.utils.oracle;

public class OWriter {
    private String name;
    private ORParameter parameter;

    public OWriter() {
        this.name="oraclewriter";
        this.parameter = new ORParameter();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ORParameter getParameter() {
        return parameter;
    }

    public void setParameter(ORParameter parameter) {
        this.parameter = parameter;
    }
}
