package Alkemy.BilleteraVirtual.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@SQLDelete(sql = "UPDATE User SET eliminado = true WHERE id = ?")
@Where(clause = "eliminado = false")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private LocalDate creationDate;

    private LocalDate updateDate;

    @Column(name = "eliminado", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean deleted;

}
