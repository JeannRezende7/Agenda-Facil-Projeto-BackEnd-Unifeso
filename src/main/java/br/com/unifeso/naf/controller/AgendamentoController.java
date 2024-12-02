package br.com.unifeso.naf.controller;

import br.com.unifeso.naf.model.Agendamento;
import br.com.unifeso.naf.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    // Método POST para criar agendamento
    @PostMapping
    public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
        // Log para verificar os dados recebidos
        System.out.println("Agendamento recebido: " + agendamento);

        // Criação do agendamento no banco de dados
        Agendamento agendamentoCriado = agendamentoService.criarAgendamento(agendamento);

        // Retorna o agendamento criado com o contato associado
        return agendamentoCriado;
    }

    // Método GET para listar todos os agendamentos
    @GetMapping
    public List<Agendamento> listarAgendamentos() {
        return agendamentoService.listarAgendamentos();
    }

    // Método GET para buscar um agendamento por ID
    @GetMapping("/{id}")
    public Agendamento buscarAgendamento(@PathVariable Long id) {
        return agendamentoService.buscarAgendamento(id);
    }
}
