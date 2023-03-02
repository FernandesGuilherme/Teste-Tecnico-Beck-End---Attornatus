package attornatus.api.repository;


import attornatus.api.model.Pessoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends CrudRepository <Pessoa, Long> {

    Pessoa findById(long id);

}
