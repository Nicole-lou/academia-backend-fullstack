package com.projetos.academia.repository;

import com.projetos.academia.model.Plano;
import com.projetos.academia.model.Plano.StatusPlano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

    /**
     * Busca todos os planos que possuem o status especificado (StatusPlano.ON)
     * e os ordena de forma ascendente pelo campo 'order'.
     *
     * Nota: O campo 'order' deve existir na entidade Plano.
     */
    List<Plano> findByStatusOrderByOrdemAsc(StatusPlano status);
    List<Plano> findByStatus(StatusPlano status);

    // O método findByStatus original foi substituído pelo método ordenado acima.
}