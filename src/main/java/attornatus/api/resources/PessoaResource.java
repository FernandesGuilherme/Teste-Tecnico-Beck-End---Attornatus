package attornatus.api.resources;

import attornatus.api.model.Endereco;
import attornatus.api.model.Pessoa;
import attornatus.api.repository.EnderecoRepository;
import attornatus.api.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @GetMapping()
    public Iterable <Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pessoa consultarPessoa (@PathVariable("id") long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (Objects.nonNull(pessoa)) {
            return pessoa;
        }
        return null;
    }

    @PostMapping("/criar")
    public Pessoa criarPessoa (@RequestBody @Valid Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PostMapping("/endereco/{id}")
    public Endereco criarEnderecoPessoa (@Valid @RequestBody Endereco endereco, @PathVariable("id") long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (Objects.nonNull(pessoa)) {
            pessoa.setEndereco(endereco);
        }
        return enderecoRepository.save(endereco);
    }

    @PutMapping ("/editar")
    public Pessoa editarPessoa (@Valid @PathVariable("id") long id, @RequestBody Pessoa pessoa ) {
            Pessoa pessoaBD = pessoaRepository.findById(id);

            pessoaBD.setNome(pessoa.getNome());
            pessoaBD.setDataNascimento(pessoa.getDataNascimento());
            pessoaRepository.save(pessoaBD);

            return pessoa;
        }

    @DeleteMapping ("/deletar/{id}")
    public void deletarPessoa (@Valid @PathVariable("id") long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (Objects.nonNull(pessoa)) {
            pessoaRepository.deleteById(id);
        }
    }
}
