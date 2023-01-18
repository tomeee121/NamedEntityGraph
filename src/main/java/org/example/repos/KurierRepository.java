package org.example.repos;

import org.example.model.Kurier;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KurierRepository extends JpaRepository<Kurier, Long> {
    @EntityGraph(value = "kurier-rows", type = EntityGraph.EntityGraphType.FETCH)
    @Query(value = "select k from Kurier k")
    List<Kurier> findAllKurierLazy();

}
