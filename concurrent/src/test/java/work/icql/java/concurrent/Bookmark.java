package work.icql.java.concurrent;

/**
 * @author icql
 * @version 1.0
 * @date 2019/4/15 15:01
 * @Title Bookmark
 * @Description Bookmark
 */
public class Bookmark {
    private String data;
    private Integer version;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
