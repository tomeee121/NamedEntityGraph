package org.example;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.example.model.*;
import org.example.repos.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class Zapytania {
    private KurierRepository kurierRepository;
    private final PracownikRepository pracownikRepository;
    private PaczkaRepository paczkaRepository;
    public Zapytania(KurierRepository kurierRepository, PaczkaRepository paczkaRepository,
                     PracownikRepository pracownikRepository) {
        this.kurierRepository = kurierRepository;
        this.paczkaRepository = paczkaRepository;
        this.pracownikRepository = pracownikRepository;
    }
    @Transactional
    void inserty() {
        Faker faker = new Faker(new Locale("pl"));
        for (int i = 0; i < 4; i++) {

            Kurier kurier = Kurier.builder().dostarczenia(faker.number().numberBetween(200, 5000))
                    .spoznienia((short) faker.number().numberBetween(0, 1000)).pseudo(faker.name().username())
                    .build();

            List<Paczka> paczki = new ArrayList<>();
            Paczka paczka = null;

            for (int j = 0; j < 2; j++) {
                KosztWysyłki kosztWysyłki = KosztWysyłki.builder().koszt(BigDecimal.valueOf(faker.number().numberBetween(1, 10000))).build();
                paczka = Paczka.builder().nazwa(faker.book().title()).opis(faker.medical().medicineName()).czyDostarczono(false)
                        .koszt(BigDecimal.valueOf(faker.number().numberBetween(1, 100000))).czasNadania(LocalDateTime.now().plusDays(1))
                        .czasWysylki(LocalDateTime.now().plusDays(3)).wysyłkiKoszt(kosztWysyłki).build();
                kosztWysyłki.setPaczkaPrzesyłki(paczka);
                paczka.setKurier(kurier);

                paczki.add(paczka);
            }

            Pracownik pracownik = Pracownik.builder().imie(faker.name().firstName()).nazwisko(faker.name().lastName())
                    .rola(faker.company().profession()).dataPrzyjecia(new Date(faker.number().numberBetween(1, 1672494425)))
                    .dataZwolnienia(new Date(faker.number().numberBetween(1, 1672494425)))
                    .miasto(faker.address().city()).kodPocztowy(faker.address().zipCode()).ulicaNazwa(faker.address().streetName())
                    .nrDomu(faker.address().buildingNumber()).stanowisko(faker.job().position()).build();
            Wypłata wypłata = Wypłata.builder().pensjaOd(new Date(faker.number().numberBetween(1, 1672494425)))
                    .pensjaDo(new Date(faker.number().numberBetween(10000000, 1672494425))).pracownik(pracownik).build();
            pracownik.setPensje(List.of(wypłata));
            pracownik.setKurier(kurier);
            pracownik.setPensje(List.of(wypłata));
            kurier.setPracownik(pracownik);
            pracownik.setKurier(kurier);

            OddziałFirmy oddziałFirmy = OddziałFirmy.builder().działGłówny(faker.commerce().department()).działDrugiegoSzczebla(faker.commerce().department()).build();
            oddziałFirmy.setPracownicy(List.of(pracownik));
            pracownik.setOddziałFirmy(oddziałFirmy);

            kurier.setPaczki(paczki);

            kurierRepository.save(kurier);

        }
        findEntityGraphKurier();
    }

    @Transactional
    void findEntityGraphKurier() {
        List<Kurier> data = kurierRepository.findAllKurierLazy();
        for (Kurier kurier : data) {
            System.out.println(kurier.getPaczki());
            System.out.println(kurier.getPracownik());
        }
    }

}
