package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Wypłata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date pensjaOd;
    private Date pensjaDo;
    @ManyToOne
    @JoinColumn(name = "pracownik_id")
    private Pracownik pracownik;
}
