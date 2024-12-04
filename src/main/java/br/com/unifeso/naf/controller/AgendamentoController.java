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
        Long contatoId = agendamento.getContato().getContatoId();
        Contato contato = contatoService.buscarContato(contatoId);  // Método para buscar o Contato

        if (contato == null) {
            throw new RuntimeException("Contato não encontrado!");
        }

        agendamento.setContato(contato);

        Agendamento agendamentoCriado = agendamentoService.criarAgendamento(agendamento);

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

    @PutMapping("/{id}")
    public Agendamento atualizar(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        Long contatoId = agendamento.getContato().getContatoId();
        Contato contato = contatoService.buscarContato(contatoId);

        if (contato == null) {
            throw new RuntimeException("Contato não encontrado!");
        }

        agendamento.setContato(contato);

        return agendamentoService.atualizar(id, agendamento);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        agendamentoService.excluir(id);
    }
}
