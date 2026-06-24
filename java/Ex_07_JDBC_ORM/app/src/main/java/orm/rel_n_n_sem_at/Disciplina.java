package orm.rel_n_n_sem_at;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Disciplina {

    private int id;
    private String nome;

    private List<Professor> professores;

}
