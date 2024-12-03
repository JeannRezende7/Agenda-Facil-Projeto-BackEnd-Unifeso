package br.com.unifeso.naf.controller;

import br.com.unifeso.naf.model.Agendamento;
import br.com.unifeso.naf.model.Contato;
import br.com.unifeso.naf.service.AgendamentoService;
import br.com.unifeso.naf.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;
    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public Agendamento criarAgendamento(@RequestBody Agendamento agendamento) {
        // Buscar o Contato pelo ID
        Long contatoId = agendamento.getContato().getContatoId();
        Contato contato = contatoService.buscarContato(contatoId);  // Método para buscar o Contato

        if (contato == null) {
            throw new RuntimeException("Contato não encontrado!");
        }

        // Associa o Contato ao Agendamento
        agendamento.setContato(contato);

        // Criação do agendamento no banco de dados
        Agendamento agendamentoCriado = agendamentoService.criarAgendamento(agendamento);

        // Retorna o agendamento criado com o contato associado
        return agendamentoCriado;
    }


    @GetMapping
    public List<Agendamento> listarAgendamentos() {
        return agendamentoService.listarAgendamentos();
    }

    @GetMapping("/{id}")
    public Agendamento buscarAgendamento(@PathVariable Long id) {
        return agendamentoService.buscarAgendamento(id);
    }
}
