package datax.utils.hive;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class HiveMeta {
    public static class HiveCell {
        private String name;
        private String type;

        public HiveCell() {
            this.name = null;
            this.type = null;
        }

        public HiveCell(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private String path;
    private String defaultfs;
    private String filetype;
    private String encoding;
    private String fieldelimiter;
    private List<HiveCell> columns = new ArrayList<HiveCell>(10);


    public void addColumn(String name, String type ) {
        columns.add(new HiveCell(name, type));
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDefaultfs() {
        return defaultfs;
    }

    public void setDefaultfs(String defaultfs) {
        this.defaultfs = defaultfs;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getFieldelimiter() {
        return fieldelimiter;
    }

    public void setFieldelimiter(String fieldelimiter) {
        this.fieldelimiter = fieldelimiter;
    }

    public List<HiveCell> getColumns() {
        return columns;
    }

    public void setColumns(List<HiveCell> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        String cols ="";
        for (HiveCell cell: columns) {
            cols = cols + "{" + cell.getName() + "," + cell.getType() + "},";
        }
        return "HiveMeta{" +
                "path='" + path + '\'' +
                ", defaultfs='" + defaultfs + '\'' +
                ", filetype='" + filetype + '\'' +
                ", encoding='" + encoding + '\'' +
                ", fieldelimiter='" + fieldelimiter + '\'' +
                ", columns=" + cols +
                '}';
    }
}
