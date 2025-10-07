package pe.edu.upc.agricorp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Table(name="taxonomies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taxonomy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String family;
    private String species;
    private String commonName;
    private String description;


    @JsonIgnore
    @ToStringExclude
    @OneToMany(mappedBy = "taxonomy",fetch = FetchType.EAGER)
    private List<Plant> plants;


}
