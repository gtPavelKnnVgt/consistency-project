package demo.claims.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Слепок Договора
 */
@Entity
@Table(name = "agreement")
@Getter
@Setter
public class Agreement extends BusinessObject {
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "validity_date", nullable = false)
    private LocalDate validityDate;
}
