package pe.edu.upc.agricorp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="pays")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String name;
    private Double amount;


    //@JsonIgnore
    //@ManyToOne
    //@JoinColumn(name="suscription_id")
    //private Suscription suscription;

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }

}

