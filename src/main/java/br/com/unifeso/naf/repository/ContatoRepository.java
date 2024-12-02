package br.com.unifeso.naf.repository;

import br.com.unifeso.naf.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
