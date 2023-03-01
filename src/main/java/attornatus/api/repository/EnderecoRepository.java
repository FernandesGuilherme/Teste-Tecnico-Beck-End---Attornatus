package attornatus.api.repository;


import attornatus.api.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends CrudRepository <Endereco, Long> {

    List<Endereco> findById (long id);

}
