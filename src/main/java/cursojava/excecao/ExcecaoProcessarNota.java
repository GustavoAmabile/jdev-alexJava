package cursojava.excecao;

public class ExcecaoProcessarNota extends Exception{

    public ExcecaoProcessarNota(String erro) {
        super("Vixxxe, um erro ao processar as notas do aluno " + erro);
    }
}
