import java.util.ArrayList;
        import java.util.Random;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Coordenadas da encomenda: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println("Escreve 4 coordenadas para o ponto de carga dos robots: ");
        int rx1 = sc.nextInt();
        int ry1 = sc.nextInt();
        int rx2 = sc.nextInt();
        int ry2 = sc.nextInt();
        int rx3 = sc.nextInt();
        int ry3 = sc.nextInt();
        int rx4 = sc.nextInt();
        int ry4 = sc.nextInt();

        System.out.println("Calculating...");
        Random generator = new Random(0);
        Ponto p1 = new Ponto(rx1, ry1);
        PontodeCarga ptc1 = new PontodeCarga(p1);
        Ponto p2 = new Ponto(rx2, ry2);
        PontodeCarga ptc2 = new PontodeCarga(p2);
        Ponto p3 = new Ponto(rx3, ry3);
        PontodeCarga ptc3 = new PontodeCarga(p3);
        Ponto p4 = new Ponto(rx4, ry4);
        PontodeCarga ptc4 = new PontodeCarga(p4);

        Ponto e1 = new Ponto(x1, y1);
        Ponto e2 = new Ponto(x2, y2);
        Encomenda encomenda = new Encomenda(e1, e2);
        int n = 1000;
        int[] trajetorias = new int[n];
        for (int i = 0; i < n; i++) {
            trajetorias[i] = generator.nextInt(30);
        }
        ArrayList<FiguraGeometrica> figs = new ArrayList<>();
        figs.add(new Triangulo("Triangulo 30 20 35 25 30 20"));
        figs.add(new Retangulo("Retangulo 43 1 47 1 47 3 43 3"));
        figs.add(new Triangulo("Triangulo 100 120 120 120 120 100"));
        Populacao pop1 = new Populacao(generator, n, trajetorias, encomenda.getInicio(), encomenda.getFim());
        Populacao pop2 = new Populacao(generator, n, trajetorias, encomenda.getInicio(), encomenda.getFim());
        Populacao pop3 = new Populacao(generator, n, trajetorias, encomenda.getInicio(), encomenda.getFim());
        Populacao pop4 = new Populacao(generator, n, trajetorias, encomenda.getInicio(), encomenda.getFim());
        Robot robot1 = new Robot(ptc1, "Online", pop1);
        Robot robot2 = new Robot(ptc2, "Online", pop2);
        Robot robot3 = new Robot(ptc3, "Online", pop3);
        Robot robot4 = new Robot(ptc4, "Online", pop4);
        robot1.hasEnoughEnergyToEncomenda();
        robot2.hasEnoughEnergyToEncomenda();
        robot3.hasEnoughEnergyToEncomenda();
        robot4.hasEnoughEnergyToEncomenda();
        ArrayList<Robot> robots = new ArrayList<>();
        robots.add(robot1);
        robots.add(robot2);
        robots.add(robot3);
        robots.add(robot4);
        Gestor gestor = new Gestor(robots);
        gestor.escolherRobot();
        int index = gestor.escolherRobot();
        //System.out.println(gestor.robots().get(index).path(generator, figs));
        //System.out.println(robot.path(generator, figs));
        //System.out.println(robot1.path(generator, figs));
        //System.out.println(robot4.path(generator, figs));
        //System.out.println(robot.energyneeded().get(robot.encontrarIndiceMinimo()));
        //System.out.println(robot1.energyneeded());
        //System.out.println(robot1.energyneeded().get(robot1.encontrarIndiceMinimo()));
        //System.out.println(robot1.energyneeded().get(robot4.encontrarIndiceMinimo()));
        ArrayList<Ponto> posrobot = gestor.robots().get(index).path(generator, figs).getpontos();
        ArrayList<Double> energyneeded = gestor.robots().get(index).energyneeded();
        Double energiadomelhorcaminho = gestor.robots().get(index).energyneeded().get(robots.get(index).encontrarIndiceMinimo());
        System.out.println(posrobot);
        int lastIndexPrinted = 0;
        System.out.println(index);
        while (true) {
            if(posrobot.size() == 0){
                int xe = sc.nextInt();
                int ye = sc.nextInt();
                int xe1 = sc.nextInt();
                int ye1 = sc.nextInt();
                Ponto pe = new Ponto(xe, ye);
                Ponto pe1 = new Ponto(xe1, ye1);
                encomenda = new Encomenda(pe, pe1);
                pop1 = new Populacao(generator, n, trajetorias, encomenda.getInicio(), encomenda.getFim());
                pop2 = new Populacao(generator, n, trajetorias, encomenda.getInicio(), encomenda.getFim());
                pop3 = new Populacao(generator, n, trajetorias, encomenda.getInicio(), encomenda.getFim());
                pop4 = new Populacao(generator, n, trajetorias, encomenda.getInicio(), encomenda.getFim());
                robot1 = new Robot(ptc1, "Online", pop1);
                robot2 = new Robot(ptc2, "Online", pop2);
                robot3 = new Robot(ptc3, "Online", pop3);
                robot4 = new Robot(ptc4, "Online", pop4);
                gestor = new Gestor(robots);
                index = gestor.escolherRobot();
                posrobot = gestor.robots().get(index).path(generator, figs).getpontos();
                System.out.println(posrobot);
                lastIndexPrinted = 0;
                System.out.println(index);
            }

            for (int j = lastIndexPrinted + 1; j < posrobot.size(); j++) {
                    // Imprima a posição atual do robô
                    if (index == 0) {
                        double battery1 = robot1.bateriam(posrobot.get(j - 1), posrobot.get(j));
                        double batteryp1 = robot2.diminuirBateria();
                        System.out.println("Step n:" + (j - 1) + " (" + posrobot.get(j - 1) + ",(" + String.format("%.2f", battery1) + ")) " + " (" + robot2.p() + ",(" + String.format("%.2f", batteryp1) + ")) " + " " + robot4.p() + ",(" + String.format("%.2f", batteryp1) + ")) " + robot3.p() + ",(" + String.format("%.2f", batteryp1) + ")) ");
                    }
                    if (index == 1) {
                        double battery2 = robot2.bateriam(posrobot.get(j - 1), posrobot.get(j));
                        double batteryp1 = robot1.diminuirBateria();
                        System.out.println("Step n:" + (j - 1) + " (" + robot1.p() + ",(" + String.format("%.2f", batteryp1) + "))" + " (" + posrobot.get(j - 1) + ",(" + String.format("%.2f", battery2) + "))" + " (" + robot4.p() + ",(" + String.format("%.2f", batteryp1) + "))" + " (" + robot3.p() + ",(" + String.format("%.2f", batteryp1) + "))");
                    }
                    if (index == 2) {
                        double battery3 = robot3.bateriam(posrobot.get(j - 1), posrobot.get(j));
                        double batteryp3 = robot1.diminuirBateria();
                        System.out.println("Step n:" + (j - 1) + " (" + robot1.p() + ",(" + String.format("%.2f", batteryp3) + "))" + " (" + robot2.p() + ",(" + String.format("%.2f", batteryp3) + "))" + " (" + robot4.p() + ",(" + String.format("%.2f", batteryp3) + "))" + " (" + posrobot.get(j - 1) + ",(" + String.format("%.2f", battery3) + "))");
                    }
                    if (index == 3) {
                        double battery4 = robot4.bateriam(posrobot.get(j - 1), posrobot.get(j));
                        double batteryp4 = robot1.diminuirBateria();
                        System.out.println("Step n:" + (j - 1) + " (" + robot1.p() + ",(" + String.format("%.2f", batteryp4) + "))" + " (" + robot2.p() + ",(" + String.format("%.2f", batteryp4) + "))" + " (" + posrobot.get(j - 1) + ",(" + String.format("%.2f", battery4) + "))" + " (" + robot3.p() + ",(" + String.format("%.2f", batteryp4) + "))");
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            for(int b = 0; b < 2; b++){
                if(b == 0){
                    if (index == 0) {
                        double battery1 = robot1.bateriam(posrobot.get(posrobot.size() - 2), posrobot.get(posrobot.size() - 1));
                        double batteryp1 = robot2.diminuirBateria();
                        System.out.println("Step n:" + (posrobot.size() - 1) + " (" + posrobot.get(posrobot.size() - 1) + ",(" + String.format("%.2f", battery1) + ")) " + robot2.p() + ",(" + String.format("%.2f", batteryp1) + ")) " + " " + robot4.p() + ",(" + String.format("%.2f", batteryp1) + ")) " + " " + robot3.p() + ",(" + String.format("%.2f", batteryp1) + ")) ");
                    }
                    if (index == 1) {
                        double battery2 = robot2.bateriam(posrobot.get(posrobot.size() - 2), posrobot.get(posrobot.size() - 1));
                        double batteryp1 = robot1.diminuirBateria();
                        System.out.println("Step n:" + (posrobot.size() - 1) + " (" + robot1.p() + ",(" + String.format("%.2f", batteryp1) + ")) " + posrobot.get(posrobot.size() - 1) + ",(" + String.format("%.2f", battery2) + ")) " + " " + robot4.p() + ",(" + String.format("%.2f", batteryp1) + ")) " + " " + robot3.p() + ",(" + String.format("%.2f", batteryp1) + ")) ");
                    }
                    if (index == 2) {
                        double battery3 = robot3.bateriam(posrobot.get(posrobot.size() - 2), posrobot.get(posrobot.size() - 1));
                        double batteryp3 = robot1.diminuirBateria();
                        System.out.println("Step n:" + (posrobot.size() - 1) + " (" + robot1.p() + ",(" + String.format("%.2f", batteryp3) + ")) " + robot2.p() + ",(" + String.format("%.2f", batteryp3) + ")) " + " " + robot4.p() + ",(" + String.format("%.2f", batteryp3) + ")) " + " " + posrobot.get(posrobot.size() - 1) + ",(" + String.format("%.2f", battery3) + ")) ");
                    }
                    if (index == 3) {
                        double battery4 = robot4.bateriam(posrobot.get(posrobot.size() - 2), posrobot.get(posrobot.size() - 1));
                        double batteryp4 = robot1.diminuirBateria();
                        System.out.println("Step n:" + (posrobot.size() - 1) + " (" + robot1.p() + ",(" + String.format("%.2f", batteryp4) + ")) " + robot2.p() + ",(" + String.format("%.2f", batteryp4) + ")) " + " " + posrobot.get(posrobot.size() - 1) + ",(" + battery4 + ")) " + " " + robot3.p() + ",(" + String.format("%.2f", batteryp4) + ")) ");
                    }
                    lastIndexPrinted = posrobot.size() - 1; // Update the last index printed
                }
                if(b == 1){
                    posrobot.clear();
                }
            }
        }
        }
    }