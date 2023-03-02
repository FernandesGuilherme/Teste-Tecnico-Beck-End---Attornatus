package attornatus.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Logadouro", nullable = false) @NotNull
    private String logadouro;

    @Column(name = "CEP", nullable = false) @NotNull
    private String cep;

    @Column(name = "Numero", nullable = false) @NotNull
    private long numero;

    @Column(name = "Cidade", nullable = false) @NotNull
    private String cidade;

    @Column(name = "Principal", nullable = false)  //Se true siginifica que o endereço é o principal
    private boolean principal;

}
