package datax.utils.stream;


public class SWriter {
    private static class Parameter {
        private Boolean print = true;

        public Boolean getPrint() {
            return print;
        }

        public void setPrint(Boolean print) {
            this.print = print;
        }
    }
    private String name = "streamwriter";
    private Parameter parameter = new Parameter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}
