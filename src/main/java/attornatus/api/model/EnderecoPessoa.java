package attornatus.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class EnderecoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "idPessoa", nullable = false)
    private Long idPessoa;
    @Column(name = "idEndereco", nullable = false)
    private Long idEndereco;

}
