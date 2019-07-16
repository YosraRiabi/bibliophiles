package com.yosra.bibliophiles.domain;

import com.yosra.bibliophiles.service.BeanUtil;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class Link extends Auditable{
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @NotEmpty(message = "Veuillez entrer un titre.")
    private String title;

    @NonNull
    @NotEmpty(message = "Veuillez sélectionner la catégorie")
    String category;

    @NonNull
    @NotEmpty(message = "Veuillez entrer le nom de l'auteur")
    String author;

    @NonNull
    @NotEmpty(message = "Veuillez entrer un url.")
    @URL(message = "Veuillez entrer un url valide.")
    private String url;


    //comments
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "link")
    private List<Vote> votes = new ArrayList<>();
    private int voteCount = 0;

    @ManyToOne
    private User user;

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }


    public String getDomainName() throws URISyntaxException {
        URI uri = new URI(this.url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }
    public String getPrettyTime() {
        PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return pt.format(convertToDateViaInstant(getCreationDate()));
    }
    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return
                java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

    public Link(@NonNull @NotEmpty(message = "Veuillez entrer un titre.") String title, @NonNull @NotEmpty(message = "Veuillez entrer un url.") @URL(message = "Veuillez entrer un url valide.") String url) {
        this.title = title;
        this.url = url;
    }
}
