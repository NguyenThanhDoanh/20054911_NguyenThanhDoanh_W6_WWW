package fit.iuh.edu.vn.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Post post;
    private String title;
    private boolean published;
    private String content;
    private Instant publishedAt;
    private Instant createdAt;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PostComment parent;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PostComment> postComments=new LinkedHashSet<>();

}