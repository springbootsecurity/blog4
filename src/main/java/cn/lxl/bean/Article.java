package cn.lxl.bean;

public class Article {

    private Long id;
    private String title;
    private String summary;
    private String publishDate;
    private Integer cateid;
    private Integer userId;
    private Cate cate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getCateid() {
        return cateid;
    }

    public void setCateid(Integer cateid) {
        this.cateid = cateid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Cate getCate() {
        return cate;
    }

    public void setCate(Cate cate) {
        this.cate = cate;
    }

    public Article(Long id, String title, String summary, String publishDate, Integer cateid, Integer userId, Cate cate) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.publishDate = publishDate;
        this.cateid = cateid;
        this.userId = userId;
        this.cate = cate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", cateid=" + cateid +
                ", userId=" + userId +
                ", cate=" + cate +
                '}';
    }

    public Article() {
        super();
    }



}
