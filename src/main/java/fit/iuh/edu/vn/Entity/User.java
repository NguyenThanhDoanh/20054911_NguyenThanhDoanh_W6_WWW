package fit.iuh.edu.vn.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "intro")
    private String intro;
    @Column(name = "profile")
    private String profile;
    @Column(name = "registered_at", nullable = false)
    private LocalDateTime registeredAt;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PostComment>  postComments=new LinkedHashSet<>();
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Post> posts=new LinkedHashSet<>();
}