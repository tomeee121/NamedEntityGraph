package org.example.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class KosztWysyłki {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal koszt;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paczka_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Paczka paczkaPrzesyłki;

}