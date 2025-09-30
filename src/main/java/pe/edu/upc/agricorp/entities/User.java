package pe.edu.upc.agricorp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;
}
