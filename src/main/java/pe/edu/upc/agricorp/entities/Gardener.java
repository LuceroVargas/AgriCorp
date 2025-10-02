package pe.edu.upc.agricorp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gardeners")

public class Gardener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    //@JsonIgnore
    //@OneToMany(mappedBy = "gardener", fetch = FetchType.EAGER)
    //private List<Chat> chat;

    @Override
    public String toString() {
        return "Gardener{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
