package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedEntityGraph(
        name = "kurier-rows",
        attributeNodes = {
                @NamedAttributeNode("pracownik"),
                @NamedAttributeNode("paczki")
        }
)
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Kurier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pseudo;
    private Integer dostarczenia;
    private short spoznienia;
    @OneToMany(mappedBy = "kurier", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Paczka> paczki = new ArrayList<>();
    @OneToOne(mappedBy = "kurier", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Pracownik pracownik;
}