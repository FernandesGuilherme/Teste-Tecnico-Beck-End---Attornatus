package attornatus.api.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    @JoinColumn(name = "enderecoId")
    private Endereco endereco;
}
