package pe.edu.upc.agricorp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="recommendations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String message;

    @Override
    public String toString() {
        return "Recommendation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }





}

