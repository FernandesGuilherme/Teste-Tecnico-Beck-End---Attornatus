package attornatus.api.resources;


import attornatus.api.model.Endereco;
import attornatus.api.model.EnderecoPessoa;
import attornatus.api.model.Pessoa;
import attornatus.api.repository.EnderecoRepository;
import attornatus.api.repository.PessoaEnderecoRepository;
import attornatus.api.repository.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/endereco")
public class EnderecoResource {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaEnderecoRepository pessoaEnderecoRepository;


    @GetMapping("/pessoa/id={id}")
    public List <Endereco> listarEndereçosPessoas (@PathVariable ("id") long id){
        Pessoa pessoa = pessoaRepository.findById(id);
        long idEnderecoPessoa = pessoa.getEndereco().getId();

        if (Objects.nonNull(pessoa)) {
            List <Endereco> endereco = enderecoRepository.findById(idEnderecoPessoa);
            return endereco;
        }
        return null;

    }

    @DeleteMapping ("/deletar/id={id}")
    public void deletarPessoa (@PathVariable("id") long id) {
        pessoaRepository.deleteById(id);
    }

}
