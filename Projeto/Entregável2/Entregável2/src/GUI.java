import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GUI {
    private static int[] encomendaX;
    private static int[] encomendaY;
    private static int[] pontoCargaX;
    private static int[] pontoCargaY;

    static ArrayList<FiguraGeometrica> obstaculos = new ArrayList<>();
    public static void main(String[] args) {
        JFrame frame = new JFrame("Encomendas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel encomendaLabel = new JLabel("Coordenadas da encomenda:");
        JLabel pontoCargaLabel = new JLabel("Coordenadas do ponto de carga dos robôs:");
        JTextField encomendaField = new JTextField(10);
        JTextField pontoCargaField = new JTextField(10);
        JButton calculateButton = new JButton("Calcular");
        JLabel obst = new JLabel(" obstaculo retangulo ");
        JTextField figuraobst = new JTextField(10);
        JLabel obstt = new JLabel(" obstaculo Triangulo ");
        JTextField figuraobstt = new JTextField(10);
        JLabel obstC = new JLabel(" obstaculo Circunferencia ");
        JTextField figuraobstc = new JTextField(10);


        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String encomendaText = encomendaField.getText();
                String[] pontosencomenda = encomendaText.split(" ");
                int numpontosenc = pontosencomenda.length;
                encomendaX = new int[numpontosenc];
                encomendaY = new int[numpontosenc];
                for(int j = 0; j < numpontosenc - 1; j+=2){
                    int x = Integer.parseInt(pontosencomenda[j]);
                    int y = Integer.parseInt(pontosencomenda[j+1]);
                    encomendaX[j] = clamp(x, 0, 1000);
                    encomendaY[j] = clamp(y, 0, 1000);
                }

                // Obter as coordenadas do ponto de carga dos robôs
                String pontoCargaText = pontoCargaField.getText();
                String[] pontoCargaCoords = pontoCargaText.split(" ");
                int numPontosCarga = pontoCargaCoords.length;
                pontoCargaX = new int[numPontosCarga];
                pontoCargaY = new int[numPontosCarga];
                for (int i = 0; i < numPontosCarga - 1; i+=2) {
                    int x = Integer.parseInt(pontoCargaCoords[i]);
                    int y = Integer.parseInt(pontoCargaCoords[i + 1]);
                    pontoCargaX[i] = clamp(x, 0, 1000); // Limita o valor de X entre 0 e 1000
                    pontoCargaY[i] = clamp(y, 0, 1000); // Limita o valor de Y entre 0 e 1000
                }

                String figurageo = figuraobst.getText();
                String figurageot = figuraobstt.getText();
                String figurageotc = figuraobstc.getText();
                obstaculos.add(new Retangulo(figurageo));
                obstaculos.add(new Triangulo(figurageot));
                obstaculos.add(new Circunferencia(figurageotc));


                MainFrame mainFrame = new MainFrame();
                mainFrame.setVisible(true);

                // Exemplo de exibição do resultado em um JOptionPane
                JOptionPane.showMessageDialog(mainFrame, "Cálculos concluídos!");
            }
        });

        panel.add(encomendaLabel);
        panel.add(encomendaField);
        panel.add(pontoCargaLabel);
        panel.add(pontoCargaField);


        panel.add(obst);
        panel.add(figuraobst);
        panel.add(obstt);
        panel.add(figuraobstt);
        panel.add(obstC);
        panel.add(figuraobstc);

        panel.add(calculateButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    // Classe para criar o frame principal
    static class MainFrame extends JFrame {
        public MainFrame() {
            setTitle("Resultado");
            setSize(1050, 1050);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }


        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setColor(Color.RED);
            for(int i = 0; i < 4; i++){
                g.fillOval(encomendaX[i], encomendaY[i], 10, 10);  // Desenha um círculo vermelho nas coordenadas da encomenda
            }

            g.setColor(Color.BLUE);
            for (int i = 0; i < 8; i++) {
                g.fillOval(pontoCargaX[i], pontoCargaY[i], 10, 10);  // Desenha um círculo azul nas coordenadas do ponto de carga dos robôs
            }

            g.setColor(Color.BLACK);
            for (FiguraGeometrica obstaculo : obstaculos) {
                obstaculo.desenha(g); // Desenha os obstáculos
            }
        }
    }

    // Função auxiliar para limitar um valor dentro de um intervalo
    private static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}
