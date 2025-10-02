package pe.edu.upc.agricorp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate date;
    private String observation;
    private Byte image;

    @ManyToOne
    @JoinColumn(name="cliente_planta_id")
    private Cliente_Planta  cliente_planta;

    @Override
    public String toString() {
        return "Historial{" +
                "id=" + id +
                ", date=" + date +
                ", observation='" + observation + '\'' +
                ", image=" + image +
                '}';
    }
}
