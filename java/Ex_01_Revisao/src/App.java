double lerNota(String mensagem) {
    double nota;

    while (true) {
        try {
            nota = Double.parseDouble(IO.readln(mensagem));

            if (nota >= 0 && nota <= 10)
                break;

            IO.println("Nota inválida, digite um valor entre 0 e 10!");
        } catch (NumberFormatException e) {
            IO.println("Entrada inválida, por favor digite um número!");
        }
    }

    return nota;
}

int lerFaltas() {
    int faltas;

    while (true) {
        try {
            faltas = Integer.parseInt(IO.readln("Digite o número de faltas: "));

            if (faltas >= 0 && faltas <= 60)
                break;

            IO.println("Faltas inválidas, digite um valor entre 0 e 60!");
        } catch (NumberFormatException e) {
            IO.println("Entrada inválida, por favor digite um número inteiro!");
        }
    }

    return faltas;
}

void main() {
    var nota1 = lerNota("Digite a primeira nota: ");
    var nota2 = lerNota("Digite a segunda nota: ");
    var nota3 = lerNota("Digite a terceira nota: ");
    var nota4 = lerNota("Digite a quarta nota: ");
    var faltas = lerFaltas();

    var media = (2 * nota1 + 2 * nota2 + 3 * nota3 + 3 * nota4) / 10;
    IO.println("Média: " + media);

    if (faltas > 20)
        IO.println("Reprovado por faltas!");
    else if (media >= 9 && media <= 10)
        IO.println("Aprovado com louvor!");
    else if (media >= 7 && media < 9)
        IO.println("Aprovado!");
    else if (media >= 3 && media < 7)
        IO.println("Recuperação!");
    else
        IO.println("Reprovado por média!");
}
