package org.example.model;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Paczka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nazwa;
    private BigDecimal koszt;
    private LocalDateTime czasNadania;
    private LocalDateTime czasWysylki;
    private LocalDateTime czasDostarczenia;
    private String opis;
    private Boolean czyDostarczono;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "kurier_id")
    private Kurier kurier;
    @OneToOne(mappedBy = "paczkaPrzesyłki", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private KosztWysyłki wysyłkiKoszt;
}
