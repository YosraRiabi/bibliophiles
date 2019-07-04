package com.yosra.bibliophiles.domain;
import com.yosra.bibliophiles.service.BeanUtil;
import lombok.*;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book extends Auditable{
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String category;
    private String author;
    private String place;
    private Boolean status;

    // comments
    @OneToMany(mappedBy = "book")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<Vote> votes = new ArrayList<>();
    private int voteCount = 0;

    public Book(String title, String category, String author, String place, Boolean status, List<Comment> comments) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.place = place;
        this.comments = comments;
        this.status = status;
    }


    public String getPrettyTime() {
        //PrettyTime pt = new PrettyTime();
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }
    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return
                java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
