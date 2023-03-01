package attornatus.api.resources;

import attornatus.api.model.Endereco;
import attornatus.api.model.Pessoa;
import attornatus.api.repository.EnderecoRepository;
import attornatus.api.repository.PessoaEnderecoRepository;
import attornatus.api.repository.PessoaRepository;
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

    @Autowired
    PessoaEnderecoRepository pessoaEnderecoRepository;


    @GetMapping()
    public Iterable<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/id={id}")
    public Pessoa consultarPessoa(@PathVariable("id") long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (Objects.nonNull(pessoa)) {
            return pessoa;
        }
        return null;
    }

    @PostMapping("/criar")
    public Pessoa criarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PostMapping("/endereco/id={id}")
    public void criarEnderecoPessoa(@RequestBody Endereco endereco, @PathVariable("id") long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (Objects.nonNull(pessoa)) {
            pessoa.setEndereco(endereco);
        }
        enderecoRepository.save(endereco);
    }

    @PutMapping ("/editar/id={id}")
    public Pessoa editarPessoa(@PathVariable("id") long id, @RequestBody Pessoa editPessoa) {
        Pessoa pessoa = pessoaRepository.findById(id);

        if (Objects.nonNull(pessoa)) {
            pessoa.setNome(editPessoa.getNome());
            pessoa.setDataNascimento(editPessoa.getDataNascimento());

            return pessoa;
        }
        return null;
    }

    @DeleteMapping ("/deletar/id={id}")
    public void deletarPessoa(@PathVariable("id") long id) {
        Pessoa pessoa = pessoaRepository.findById(id);
        if (Objects.nonNull(pessoa)) {
            pessoaRepository.deleteById(id);
        }

    }
}
