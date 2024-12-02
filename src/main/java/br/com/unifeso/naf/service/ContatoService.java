package br.com.unifeso.naf.service;

import br.com.unifeso.naf.model.Contato;
import br.com.unifeso.naf.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }

    public List<Contato> listarTodos() {
        return repository.findAll();
    }

    public Contato salvar(Contato contato) {
        return repository.save(contato);
    }

    public Contato atualizar(Long id, Contato contatoAtualizado) {
        Contato contato = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado!"));
        contato.setNome(contatoAtualizado.getNome());
        contato.setTelefone(contatoAtualizado.getTelefone());
        contato.setEmail(contatoAtualizado.getEmail());
        return repository.save(contato);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
