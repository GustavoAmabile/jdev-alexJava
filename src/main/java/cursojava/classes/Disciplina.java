package cursojava.classes;

import java.util.Arrays;
import java.util.Objects;

public class Disciplina {

    /*Cada disciplina terá 4 notas durante o ano inteiro*/
    private Double[] nota = new Double[4];
    private String disciplina;

    public Double[] getNota() {
        return nota;
    }

    public void setNota(Double[] nota) {
        this.nota = nota;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMediaNota(){
        double somaTotal = 0;
        for (int pos = 0; pos < nota.length; pos++){
            somaTotal += nota[pos];
        }
        return somaTotal / 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Arrays.equals(nota, that.nota) && Objects.equals(disciplina, that.disciplina);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(disciplina);
        result = 31 * result + Arrays.hashCode(nota);
        return result;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nota=" + nota +
                ", disciplina='" + disciplina + '\'' +
                '}';
    }
}
