package life.majiang.community.dto;

public class GithubUser {

    private String login;
    private String id;
    private String name;
    private String bio;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "login='" + login + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
