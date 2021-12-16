package se.iths.demo.asyncdemo211220.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
public class GitHubuser {

    @JsonIgnoreProperties(ignoreUnknown=true)

    private String name;
    private String blog;
    private String created_at;
    private String html_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
}
