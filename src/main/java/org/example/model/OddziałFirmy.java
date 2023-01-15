package org.example.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dzial")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class OddziałFirmy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dzial_glowny")
    private String działGłówny;
    @Column(name = "dzial_drugiego_szczebla")
    private String działDrugiegoSzczebla;
    @OneToMany(mappedBy = "oddziałFirmy", cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "dział_id", nullable = false)
    private List<Pracownik> pracownicy = new ArrayList<>();
}
