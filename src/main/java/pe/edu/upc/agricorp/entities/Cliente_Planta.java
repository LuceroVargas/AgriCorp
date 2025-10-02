package pe.edu.upc.agricorp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.agricorp.serviceimpl.Historialmple;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes_plantas")

public class Cliente_Planta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate birthDate;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    //@ManyToOne
    //@JoinColumn(name = "id_plant")
    //private Plant plant;

    @OneToMany(mappedBy = "cliente_planta", fetch = FetchType.EAGER)
    private List<Historial> historials;


    @Override
    public String toString() {
        return "Cliente_Planta{" +
                "id=" + id +
                ", birthDate=" + birthDate +
                '}';
    }


}
