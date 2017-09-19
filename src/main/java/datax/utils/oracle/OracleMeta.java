package datax.utils.oracle;

public class OracleMeta {
    private String username;
    private String password;
    private String jdbcUrl;

    public OracleMeta() {
    }

    public OracleMeta(String username, String password, String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
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

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    @Override
    public String toString() {
        return "OracleMeta{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", jdbcUrl='" + jdbcUrl + '\'' +
                '}';
    }
}
