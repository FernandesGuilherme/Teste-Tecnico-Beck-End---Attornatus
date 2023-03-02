package pessoa;

import attornatus.api.model.Pessoa;
import attornatus.api.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.Objects;

public class PessoaTest {

    @Autowired
    PessoaRepository pessoaRepository;

    @Test
    public void deletarPessoa() throws SQLException {
        Pessoa pessoa = pessoaRepository.findById(202);
        if (Objects.nonNull(pessoa)){
            pessoaRepository.delete(pessoa);
        }
        throw new SQLException();
    }
}
