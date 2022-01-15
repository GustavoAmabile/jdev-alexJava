package cursojava.principio.responsabilidade;

import org.w3c.dom.ls.LSOutput;

public class TesteConta {
    public static void main(String[] args) {

        ContaBancaria bancaria = new ContaBancaria();
        bancaria.setDescricao("Conta Bancária");

        System.out.println(bancaria);

        bancaria.diminui100Reais();
        bancaria.diminui100Reais();

        System.out.println(bancaria);

        bancaria.sacarDinheiro(400);
        System.out.println(bancaria);

        bancaria.depositoDinheiro(1000);
        System.out.println(bancaria);

        bancaria.soma100Reais();

        System.out.println(bancaria);



    }


}
