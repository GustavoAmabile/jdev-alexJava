package cursojava.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TelaTimeThread extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout());//Painel de componentes

    private JLabel descricaoHora = new JLabel("Nome");

    private JTextField mostraTempo = new JTextField();

    private JLabel descricaoHora1 = new JLabel("E-mail");

    private JTextField mostraTempo1 = new JTextField();

    private JButton jButton = new JButton("Add Lista");
    private JButton jButton1 = new JButton("Stop");

    private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

//    private Runnable thread = new Runnable() {
//        @Override
//        public void run() {
//            while(true){//Fica sempre rodando
//                mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
//                        format(Calendar.getInstance().getTime()));
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    };
//
//    private Runnable thread1 = new Runnable() {
//        @Override
//        public void run() {
//            while(true){
//                mostraTempo1.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").
//                        format(Calendar.getInstance().getTime()));
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    };

//    private Thread threadTime;
//    private Thread thread1Time;

    public TelaTimeThread() {/*Executa o que tiver dentro no momento da abertura da execução*/

        setTitle("Minha tela de time com thread");
        setSize(new Dimension(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);
        //Primeira parte concluída

        GridBagConstraints gridBagConstraints = new GridBagConstraints();//Controlador de posicionamento de componentes
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        descricaoHora.setPreferredSize(new Dimension(200, 25));
        jPanel.add(descricaoHora, gridBagConstraints);

        mostraTempo.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        //mostraTempo.setEditable(false);
        jPanel.add(mostraTempo,gridBagConstraints);

        descricaoHora1.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(descricaoHora1, gridBagConstraints);

        mostraTempo1.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        //mostraTempo1.setEditable(false);
        jPanel.add(mostraTempo1, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        jButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridy++;
        jPanel.add(jButton, gridBagConstraints);

        jButton1.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx++;
        jPanel.add(jButton1, gridBagConstraints);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//Executa o clique no botão


                if (fila == null){
                    fila = new ImplementacaoFilaThread();
                    fila.start();
                }
                for(int qtd = 0; qtd < 100; qtd++){//Simulando 100 envios em massa
                ObjetoFilaThread filaThread = new ObjetoFilaThread();
                filaThread.setNome(mostraTempo.getText());
                filaThread.setEmail(mostraTempo1.getText() + " " + qtd);

                fila.add(filaThread);}
//                threadTime = new Thread(thread);
//                threadTime.start();
//
//                thread1Time = new Thread(thread1);
//                thread1Time.start();

//                jButton.setEnabled(false);
//                jButton1.setEnabled(true);

            }
        });

        //jButton1.setEnabled(false);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fila.stop();
                fila = null;
//                threadTime.stop();
//                thread1Time.stop();

//                jButton.setEnabled(true);
//                jButton1.setEnabled(false);
            }
        });

        fila.start();

        add(jPanel, BorderLayout.WEST);


        //Sempre será o último comando
        setVisible(true);//torna a tela visível para o usuário
    }
}
