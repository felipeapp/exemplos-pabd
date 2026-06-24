package modelo.entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contato {

    private int id;
    private String nome;
    private String email;
    private int celular;
    private LocalDate nascimento;
    private LocalDateTime cadastro;

}
