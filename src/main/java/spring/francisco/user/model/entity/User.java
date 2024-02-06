package spring.francisco.user.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import spring.francisco.shared.Role;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityScan
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(length = 100)
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private Role role;
}
