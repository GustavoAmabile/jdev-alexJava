package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;

import javax.swing.*;
import java.util.jar.JarOutputStream;

public class ArrayVetor {
    public static void main(String[] args) {

        Double[] notas = {8.8, 7.7, 9.9, 6.6};
        Double[] notasLogica = {7.7, 8.8, 6.6, 7.7};

        //criação do aluno
        Aluno aluno = new Aluno();
        aluno.setNome("Gustavo Amabile");
        aluno.setNomeEscola("JDEV treinamento");

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Alberto Lisboa");
        aluno1.setNomeEscola("JDEV treinamento");

        //criação da disciplina
        Disciplina disciplina = new Disciplina();
        disciplina.setDisciplina("Curso de Java");
        disciplina.setNota(notas);

        aluno.getDisciplinas().add(disciplina);
        aluno1.getDisciplinas().add(disciplina);

        Disciplina disciplina1 = new Disciplina();
        disciplina1.setDisciplina("Lógica de Programação");
        disciplina1.setNota(notasLogica);

        aluno.getDisciplinas().add(disciplina1);
        aluno1.getDisciplinas().add(disciplina1);

        //-----------------------------------------------------------------

        Aluno[] arrayAlunos = new Aluno[2];
        arrayAlunos[0] = aluno;
        arrayAlunos[1] = aluno1;
        for (int pos = 0; pos < arrayAlunos.length; pos++) {
            System.out.println("Nome do aluno é: " + arrayAlunos[pos].getNome());
            System.out.println();
            for (Disciplina d : arrayAlunos[pos].getDisciplinas()){
                System.out.println("Nome da disciplina é : " + d.getDisciplina());
                System.out.println();
                for (int posnota = 0; posnota < d.getNota().length; posnota++){
                    System.out.println("A nota número " +
                             + posnota + " é igual = " + d.getNota()[posnota]);

                }
                System.out.println();
            }
        }

//        System.out.println("Nome do aluno = " + aluno.getNome() + "\nInscrito no curso: " + aluno.getNomeEscola());
//        System.out.println();
//        System.out.println("------ Disciplinas do Aluno -----");
//
//        for (Disciplina d:
//             aluno.getDisciplinas()) {
//
//            System.out.println();
//            System.out.println("Disciplina : " + d.getDisciplina());
//            System.out.println("As notas da disciplina são: ");
//
//            double notaMax = 0.0;
//            for (int pos = 0; pos < d.getNota().length; pos++){
//                System.out.println("Nota " + pos + " é igual = " + d.getNota()[pos]);
//                if (pos == 0){
//                    notaMax = d.getNota()[pos];
//                } else {
//                    if(d.getNota()[pos] > notaMax){
//                        notaMax = d.getNota()[pos];
//                    }
//                }
//            }
//            System.out.println("A maior nota da Disciplina  " + d.getDisciplina() + " , é de valor : " + notaMax);
//            System.out.println();
//
//            double notaMin = 0.0;
//            for (int pos = 0; pos < d.getNota().length; pos++){
//                System.out.println("Nota " + pos + " é igual = " + d.getNota()[pos]);
//                if (pos == 0){
//                    notaMin = d.getNota()[pos];
//                } else {
//                    if(d.getNota()[pos] < notaMin){
//                        notaMin  = d.getNota()[pos];
//                    }
//                }
//            }
//            System.out.println("A menor nota da Disciplina  " + d.getDisciplina() + " , é de valor : " + notaMin);
//
//
//
//        }



    }
}
