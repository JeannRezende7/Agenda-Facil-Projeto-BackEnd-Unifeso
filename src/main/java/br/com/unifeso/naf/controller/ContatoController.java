package br.com.unifeso.naf.controller;

import br.com.unifeso.naf.model.Agendamento;
import br.com.unifeso.naf.model.Contato;
import br.com.unifeso.naf.service.ContatoService;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

    private final ContatoService service;

    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Contato> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Contato ListarContato(@PathVariable Long id) {
        return service.buscarContato(id);
    }

    @PostMapping
    public Contato criar(@RequestBody Contato contato) {
        return service.salvar(contato);
    }


    @PutMapping("/{id}")
    public Contato atualizar(@PathVariable Long id, @RequestBody Contato contato) {
        return service.atualizar(id, contato);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

