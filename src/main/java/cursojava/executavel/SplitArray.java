package cursojava.executavel;

import java.util.Arrays;
import java.util.List;

public class SplitArray {
    public static void main(String[] args) {

        String texto = "alex, curso Java, 80, 90, 70";
        String[] valoresArray = texto.split(",");
        System.out.println(valoresArray);

        System.out.println("Nome : " + valoresArray[0]);
        System.out.println("Curso : " + valoresArray[1]);
        System.out.println("Nota 1 : " + valoresArray[2]);
        System.out.println("Nota 2 : " + valoresArray[3]);
        System.out.println("Nota 3 : " + valoresArray[4]);

        //Convertendo um Array em uma lista
        List<String> list = Arrays.asList(valoresArray);
        for (String valorString:
             list) {
            System.out.println(valorString);
        }

        //Convertendo uma lista em um Array
        String [] conversaoArray = list.toArray(new String[5]);

        for (int pos = 0; pos < conversaoArray.length; pos++){
            System.out.println(conversaoArray[pos]);
        }
    }
}
