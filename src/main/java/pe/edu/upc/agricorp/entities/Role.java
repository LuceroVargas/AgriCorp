package pe.edu.upc.agricorp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users;


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

}
