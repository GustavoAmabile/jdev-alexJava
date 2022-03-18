package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Disciplina;
import cursojava.classes.Secretario;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.excecao.ExcecaoProcessarNota;
import cursojava.interfaces.PermitirAcesso;

import javax.naming.spi.DirObjectFactory;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PrimeiraClasseJava {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {

        try {

            lerArquivo();


            String login = JOptionPane.showInputDialog("Informe o login");
            String senha = JOptionPane.showInputDialog("Informe a senha");


            if (new FuncaoAutenticacao(new Diretor(login, senha)).autenticar())/*Vou travar o contrato para autorizar somente quem tem o contrato 100% legítimo*/ {

                List<Aluno> alunos = new ArrayList<Aluno>();

                /*é uma lista que dentro dela temos uma chave que identifica uma sequência de valores também*/
                HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();


                for (int qtd = 1; qtd <= 1; qtd++) {


                    String nome = JOptionPane.showInputDialog("Qual o nome do aluno" + qtd + "?");
                    String idade = JOptionPane.showInputDialog("Qual a idade do aluno?  ");
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
                    aluno1.setIdade(Integer.valueOf(idade));
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
                        //disciplina.setNota(Double.valueOf(notaDisciplina));

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

            } else {
                JOptionPane.showMessageDialog(null, "Acesso não permitido");
            }

        } catch (Exception e) {

            StringBuilder saida = new StringBuilder();


            e.printStackTrace();//Imprime erro no console

            // mensagem do erro ou causa
            System.out.println("Mensagem: " + e.getMessage());

            for (int pos = 0; pos < e.getStackTrace().length; pos++){

                saida.append("\n Classe de erro: " + e.getStackTrace()[pos].getClassName());
                saida.append("\n Método de erro: " + e.getStackTrace()[pos].getMethodName());
                saida.append("\n Linha de erro: " + e.getStackTrace()[pos].getLineNumber());
                saida.append("\n Class de erro: " + e.getClass().getName());

            }

            JOptionPane.showMessageDialog(null, "Erro de conversão de número "
                    + saida.toString());
        }

        finally {
            /*Sempre é executado, ocorrendo Erros ou não*/
            JOptionPane.showMessageDialog(null, "Obrigado por aprender comigo!");
        }
    }

    public static void lerArquivo() throws  FileNotFoundException {
        try{
            File file = new File("D://Arquivo.txt");
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }

    }
}

