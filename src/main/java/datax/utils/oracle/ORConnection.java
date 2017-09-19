package datax.utils.oracle;

import java.util.ArrayList;
import java.util.List;

public class ORConnection {
    private String jdbcUrl;
    private List<String> table = new ArrayList<String>(10);

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public List<String> getTable() {
        return table;
    }

    public void setTable(List<String> table) {
        this.table = table;
    }
}
