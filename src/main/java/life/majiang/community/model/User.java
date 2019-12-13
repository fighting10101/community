package life.majiang.community.model;

public class User {

    private String account_id;
    private String name;
    private long gmt_creat;
    private long gmt_modified;
    private String token;

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGmt_creat() {
        return gmt_creat;
    }

    public void setGmt_creat(long gmt_creat) {
        this.gmt_creat = gmt_creat;
    }

    public long getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(long gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
