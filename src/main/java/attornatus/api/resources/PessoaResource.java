package attornatus.api.resources;

import attornatus.api.model.Pessoa;
import attornatus.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PessoaResource {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping(value = "/pessoas")
    public Iterable<Pessoa> listarPessoas (){
     return pessoaRepository.findAll();
    }
}
