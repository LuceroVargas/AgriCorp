package pe.edu.upc.agricorp.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

@Entity
@Table(name="plants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plant {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Float minimum_space;
    private Integer growthTime;

    /*@JsonIgnore
    @ToStringExclude
    @ManyToOne
    @JoinColumn(name="id_Taxonomy")
    private Taxonomy taxonomy;*/


    /*@OneToMany(mappedBy = "plant", fetch = FetchType.EAGER)
    private List<Cliente_planta> clientePlantas;*/

    //falta solucionar la relación entre las tablas fase y planta

}
