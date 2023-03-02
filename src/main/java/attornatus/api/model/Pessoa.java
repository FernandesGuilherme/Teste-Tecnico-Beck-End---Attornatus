package attornatus.api.model;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Data_Nascimento", nullable = false)
    private String dataNascimento;

    @ManyToOne
    @JoinColumn(name = "enderecoId", nullable = true)
    private Endereco endereco;

}
