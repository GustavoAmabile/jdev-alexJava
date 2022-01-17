package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Pessoa;
import cursojava.classes.Secretario;
import org.w3c.dom.ls.LSOutput;

public class TestandoClassesFilhas {

    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setNome("Alex Jdev - Treinamento");
        aluno.setIdade(16);
        aluno.setNumeroCpf("1234567");

        Diretor diretor = new Diretor();
        diretor.setNome("Egídio");
        diretor.setRegistroGeral("987654");
        diretor.setIdade(50);

        Secretario secretario = new Secretario();
        secretario.setNome("Geraldo");
        secretario.setExperiencia("Administração");
        secretario.setIdade(18);

        System.out.println(aluno);
        System.out.println(diretor);
        System.out.println(secretario);

        System.out.println(aluno.pessoaMaiorIdade() + " - " + aluno.msgMaiorIdade());
        System.out.println(diretor.pessoaMaiorIdade());
        System.out.println(secretario.pessoaMaiorIdade());

        System.out.println("Salário aluno é : " + aluno.salario());
        System.out.println("Salário diretor é : " + diretor.salario());
        System.out.println("Salário secretário é : " + secretario.salario());

        Pessoa pessoa = new Aluno();
        pessoa = secretario;

        teste(aluno);
        teste(diretor);
        teste(secretario);




    }

    public static void teste(Pessoa pessoa){
        System.out.println("Essa pessoa é demais = " + pessoa.getNome() + " e o salário é de = "
        + pessoa.salario());
    }


}
