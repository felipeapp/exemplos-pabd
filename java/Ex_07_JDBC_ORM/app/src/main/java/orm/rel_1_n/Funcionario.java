package orm.rel_1_n;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Funcionario {

    private int id;
    private String nome;
    private int matricula;
    private double salario;

    private Setor setor;
    private LocalDate dataContrato;

}
