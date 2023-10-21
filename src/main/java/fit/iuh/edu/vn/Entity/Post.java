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
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "published", nullable = false)
    private boolean published;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "postComments", nullable = false)
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PostComment> postComments= new LinkedHashSet<>();
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Post parent;
    @Column(name = "meta_title", nullable = false)
    private String metaTitle;
    @Column(name = "meta_description", nullable = false)
    private String summary;
    @Column(name = "meta_keywords", nullable = false)
    private Instant createdAt;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Post> posts = new LinkedHashSet<>();
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;
    @Column(name = "created_at", nullable = false)
    private Instant updatedAt;
    @Column(name = "updated_at", nullable = false)
    private Instant publishedAt;


}
