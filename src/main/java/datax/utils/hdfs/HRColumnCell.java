package datax.utils.hdfs;

public class HRColumnCell {
    private Integer index ;
    private String type;

    public HRColumnCell(Integer index, String type) {
        this.index = index;
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
