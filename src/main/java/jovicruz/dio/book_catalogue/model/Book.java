package jovicruz.dio.book_catalogue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String pub_date;
    private String author;
    private Integer total_pages;
    private Integer current_page;
    private String status;
    private Integer rating;
    private String cover_img;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPub_date() {
        return pub_date;
    }
    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Integer getTotal_pages() {
        return total_pages;
    }
    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }
    public Integer getCurrent_page() {
        return current_page;
    }
    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getCover_img() {
        return cover_img;
    }
    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }


    
}
