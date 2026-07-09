package acesso.modelo.entidade;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Permissao {

    private Usuario usuario;
    private Sala sala;
    private LocalDateTime horario;

}
