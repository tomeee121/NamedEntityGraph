package org.example;

import lombok.AllArgsConstructor;
import org.example.repos.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Starter {
    private KurierRepository kurierRepository;
    private PaczkaRepository paczkaRepository;
    private PracownikRepository pracownikRepository;

    @EventListener(ApplicationReadyEvent.class)
    private void starter() {
        Zapytania zapytania = new Zapytania(kurierRepository, paczkaRepository,pracownikRepository);
        zapytania.inserty();
    }
}
