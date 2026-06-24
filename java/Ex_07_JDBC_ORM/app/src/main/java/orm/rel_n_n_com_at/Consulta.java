package orm.rel_n_n_com_at;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Consulta {

    private Medico medico;
    private Paciente paciente;
    private LocalDateTime horario;

}
