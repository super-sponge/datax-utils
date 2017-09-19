package datax.utils.oracle;

import java.util.ArrayList;
import java.util.List;

public class ORParameter {
    private String username;
    private String password;
    private List<String> column = new ArrayList<String>(64);
    private List<String> preSql = new ArrayList<String>(3);

    private List<ORConnection> connection = new ArrayList<ORConnection>(1);
    private Integer batchSize ;

    public ORParameter() {
        connection.add(new ORConnection());
        this.batchSize=1024;
    }

    /**
     * 设置oracle 连接串 jdbc:oracle:thin:@[HOST_NAME]:PORT:[DATABASE_NAME]
     * @param url
     */
    public void setJdbcUrl(String url) {
        ORConnection orConnection = connection.get(0);
        orConnection.setJdbcUrl(url);
    }

    /**
     * 设置表名称
     * @param tableName
     */
    public void addTable(String tableName) {
        ORConnection orConnection = connection.get(0);
        orConnection.getTable().add(tableName);
    }

    public void addPreSql(String sql) {
        this.preSql.add(sql);
    }

    public void addColumn(String cell) {
        this.column.add(cell);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getColumn() {
        return column;
    }

    public void setColumn(List<String> column) {
        this.column = column;
    }

    public List<String> getPreSql() {
        return preSql;
    }

    public void setPreSql(List<String> preSql) {
        this.preSql = preSql;
    }

    public List<ORConnection> getConnection() {
        return connection;
    }

    public void setConnection(List<ORConnection> connection) {
        this.connection = connection;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }
}
