package org.example.repos;

import org.example.model.Paczka;
import org.springframework.data.jpa.repository.JpaRepository;

//@State(Scope.Benchmark)
public interface PaczkaRepository extends JpaRepository<Paczka, Integer> {
}
