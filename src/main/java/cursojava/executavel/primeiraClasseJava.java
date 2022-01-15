package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.constantes.StatusAluno;

import javax.naming.spi.DirObjectFactory;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class primeiraClasseJava {
    public static void main(String[] args) {

        String login = JOptionPane.showInputDialog("Informe o login");
        String senha = JOptionPane.showInputDialog("Informe a senha");

        if(login.equalsIgnoreCase("admin")
         && senha.equals("admin"))
        {

            List<Aluno> alunos = new ArrayList<>();

            /*é uma lista que dentro dela temos uma chave que identifica uma sequência de valores também*/
            HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();


            for (int qtd = 1; qtd <= 5; qtd++) {


                String nome = JOptionPane.showInputDialog("Qual o nome do aluno" + qtd + "?");
                //String idade = JOptionPane.showInputDialog("Qual a idade do aluno?  ");
                //String DataNascimento = JOptionPane.showInputDialog("Qual a data de nascimento do aluno?  ");
                //String rg = JOptionPane.showInputDialog("Qual a identidade do aluno?  ");
                //String Cpf = JOptionPane.showInputDialog("Qual o Cpf do aluno?  ");
                //String mae = JOptionPane.showInputDialog("Qual o nome da mãe do aluno?  ");
                //String pai = JOptionPane.showInputDialog("Qual o nome do pai do aluno?  ");
                //String matricula = JOptionPane.showInputDialog("Qual a data da matrícula do aluno?  ");
                //String serie = JOptionPane.showInputDialog("Qual série do aluno?  ");
                //String escola = JOptionPane.showInputDialog("Qual a escola do aluno? ");


                Aluno aluno1 = new Aluno();
                aluno1.setNome(nome);
                //aluno1.setIdade(Integer.valueOf(idade));
                //aluno1.setDataNascimento(DataNascimento);
                //aluno1.setRegistroGeral(rg);
                //aluno1.setNumeroCpf(Cpf);
                //aluno1.setNomeMae(mae);
                //aluno1.setNomePai(pai);
                //aluno1.setDataMatricula(matricula);
                //aluno1.setSerieMatriculado(serie);
                //aluno1.setNomeEscola(escola);

                for (int pos = 1; pos <= 1; pos++) {
                    String nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina: " + pos + " ?");
                    String notaDisciplina = JOptionPane.showInputDialog("Nota da disciplina: " + pos + " ?");
                    Disciplina disciplina = new Disciplina();
                    disciplina.setDisciplina(nomeDisciplina);
                    disciplina.setNota(Double.valueOf(notaDisciplina));

                    aluno1.getDisciplinas().add(disciplina);

                }

                int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover " +
                        "alguma Disciplina? ");
                if (escolha == 0) {
                    int continuarRemover = 0;
                    int posicao = 1;
                    while (continuarRemover == 0) {
                        String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina ? " +
                                "1, 2, 3 ou 4? ");
                        aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
                        posicao++;
                        continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover? ");
                    }

                }
                alunos.add(aluno1);
            }

            maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
            maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());
            maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());

            for (Aluno aluno : alunos) {/*Separei em listas*/
                if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
                    maps.get(StatusAluno.APROVADO).add(aluno);
                } else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.REPROVADO)) {
                    maps.get(StatusAluno.REPROVADO).add(aluno);
                } else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
                    maps.get(StatusAluno.RECUPERACAO).add(aluno);/*Reprovado*/
                }

            }
            System.out.println("--------Listas dos Aprovados-------");
            for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
                System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
            }
            System.out.println("--------Listas dos Reprovados-------");
            for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
                System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());
            }
            System.out.println("--------Listas dos Alunos em Recuperação-------");
            for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
                System.out.println("Resultado = " + aluno.getAlunoAprovado2() + " com média de = " + aluno.getMediaNota());

            }

        }

    }
}