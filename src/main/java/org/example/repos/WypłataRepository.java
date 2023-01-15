package org.example.repos;

import org.example.model.Wypłata;
import org.springframework.data.jpa.repository.JpaRepository;

//@State(Scope.Benchmark)
public interface WypłataRepository extends JpaRepository<Wypłata, Long> {

}
