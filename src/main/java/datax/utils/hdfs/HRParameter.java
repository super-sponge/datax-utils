package datax.utils.hdfs;

import java.util.ArrayList;
import java.util.List;

public class HRParameter {
    private String path;
    private String defaultFS;
    private List<HRColumnCell> column = new ArrayList<HRColumnCell>(64);
    private String fileType;
    private String encoding;
    private String fieldDelimiter;
    private String haveKerberos;
    private String kerberosKeytabFilePath;
    private String kerberosPrincipal;


    public HRParameter(String path, String defaultFS, String fileType, String encoding, String fieldDelimiter) {
        this.path = path;
        this.defaultFS = defaultFS;
        this.fileType = fileType;
        this.encoding = encoding;
        this.fieldDelimiter = fieldDelimiter;
        this.haveKerberos = "false";
    }

    public HRParameter() {
        this.haveKerberos = "false";
    }


    public void setColumn(List<HRColumnCell> column) {
        this.column = column;
    }

    public List<HRColumnCell> getColumn() {
        return column;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDefaultFS() {
        return defaultFS;
    }

    public void setDefaultFS(String defaultFS) {
        this.defaultFS = defaultFS;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getFieldDelimiter() {
        return fieldDelimiter;
    }

    public void setFieldDelimiter(String fieldDelimiter) {
        this.fieldDelimiter = fieldDelimiter;
    }

    public String getHaveKerberos() {
        return haveKerberos;
    }

    public void setHaveKerberos(String haveKerberos) {
        this.haveKerberos = haveKerberos;
    }

    public String getKerberosKeytabFilePath() {
        return kerberosKeytabFilePath;
    }

    public void setKerberosKeytabFilePath(String kerberosKeytabFilePath) {
        this.kerberosKeytabFilePath = kerberosKeytabFilePath;
    }

    public String getKerberosPrincipal() {
        return kerberosPrincipal;
    }

    public void setKerberosPrincipal(String kerberosPrincipal) {
        this.kerberosPrincipal = kerberosPrincipal;
    }

    public void addColumn(HRColumnCell cell) {
        this.column.add(cell);
    }
}
