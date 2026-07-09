package acesso.modelo.entidade;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private int tag;

}
