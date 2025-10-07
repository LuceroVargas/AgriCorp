package pe.edu.upc.agricorp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="phases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long phaseOrder;
    private Long minDay;
    private Long maxDay;


    //@JsonIgnore
    //@OneToMany
    //@JoinColumn(name="recommendation_id")
    //private Recommendation recommendation;

    @Override
    public String toString() {
        return "Phase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", phaseOrder=" + phaseOrder +
                ", minDay=" + minDay +
                ", maxDay=" + maxDay +
                '}';
    }


}
