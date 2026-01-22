package pabd.modelo.entidade;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pabd.visao.DateUtil;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Permissao {

	private Usuario usuario;
	private Sala sala;

	@ToString.Exclude
	private LocalDateTime horario;

	@ToString.Include(name = "horario")
	private String getHorarioFormatado() {
		return DateUtil.dateToString(this.horario);
	}

}
