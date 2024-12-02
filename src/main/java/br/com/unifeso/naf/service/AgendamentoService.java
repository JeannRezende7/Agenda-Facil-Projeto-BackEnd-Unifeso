package br.com.unifeso.naf.service;

import br.com.unifeso.naf.model.Agendamento;
import br.com.unifeso.naf.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class AgendamentoService {

        @Autowired
        private AgendamentoRepository agendamentoRepository;

        // Método para criar agendamento
        public Agendamento criarAgendamento(Agendamento agendamento) {
            return agendamentoRepository.save(agendamento);
        }

        // Método para listar agendamentos
        public List<Agendamento> listarAgendamentos() {
            return agendamentoRepository.findAll();
        }

        public Agendamento buscarAgendamento(Long id) {
            Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
            return agendamento.orElse(null);  // Retorna null se não encontrado
        }
    }

