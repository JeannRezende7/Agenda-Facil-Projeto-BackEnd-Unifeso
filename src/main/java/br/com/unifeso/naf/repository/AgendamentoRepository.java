package br.com.unifeso.naf.repository;

import br.com.unifeso.naf.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
