package org.example.repos;

import org.example.model.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
//@State(Scope.Benchmark)
public interface PracownikRepository extends JpaRepository<Pracownik, Long> {

}
