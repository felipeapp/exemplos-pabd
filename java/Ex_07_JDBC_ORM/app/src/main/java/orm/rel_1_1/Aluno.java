package orm.rel_1_1;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Aluno {

    private int id;
    private String nome;
    private int matricula;
    private LocalDate dataIngresso;

    private Tcc tcc;
    private LocalDateTime horarioDefesa;

}
