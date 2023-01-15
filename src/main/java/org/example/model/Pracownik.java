package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rola;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private Date dataPrzyjecia;
    private Date dataZwolnienia;
    private String miasto;
    private String kodPocztowy;
    private String ulicaNazwa;
    private String nrDomu;
    @OneToMany(mappedBy = "pracownik",cascade = CascadeType.ALL)
//    @JoinColumn(name = "pracownik_id")
    private List<Wypłata> pensje = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "kurier_id")
    private Kurier kurier;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dział_id")
    private OddziałFirmy oddziałFirmy;
}
