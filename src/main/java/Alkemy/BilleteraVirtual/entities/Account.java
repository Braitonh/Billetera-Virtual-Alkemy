package Alkemy.BilleteraVirtual.entities;

import Alkemy.BilleteraVirtual.enums.Currency;
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
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Enumerated(EnumType.STRING)
    public Currency currency;

    public Double transactionLimit;

    public Double balance;

    private LocalDate creationDate;

    private LocalDate updateDate;

    @Column(name = "eliminado", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "userId")
    public User userID;

}
