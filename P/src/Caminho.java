import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @autor Goncalo Figueiredo
 * @version 1
 * */
public class Caminho {
    private ArrayList<Ponto> pontosList = new ArrayList<Ponto>();
    private int x,y;

    /**
     * Este método cria um construtor, em que leva um generator, um f(que é o tamanho do caminho),e 2 pontos(inicial e final)
     * @param generator é o generator usado para o construtor
     * @param f é o numero de pontos do caminho
     * @param ponto_inicial é ponto inicial do caminho
     * @param ponto_final é o ponto final do caminho
     */
    public Caminho(Random generator,int f,Ponto ponto_inicial,Ponto ponto_final){
        while(f>0){
            if(pontosList.isEmpty())
                addpontoList(ponto_inicial);
            Ponto ponto = new Ponto(generator);
            if(!caminhoContainsPonto(ponto) || ponto.dist(ponto_final) != 0){
                addpontoList(ponto);
                f--;
            }
        }
        addpontoList(ponto_final);
    }

    /**
     * Este método, é um construtor de caminhos, que leva um generator e um inteiro f que é a quantidade de pontos
     * @param generator é o generator para criar o construtor
     * @param f é o numero de pontos do caminho
     */
    public Caminho(Random generator,int f){
        while(f>0){
            Ponto ponto = new Ponto(generator);
            if(!caminhoContainsPonto(ponto)){
                addpontoList(ponto);
                f--;
            }
        }
    }

    /**
     * é um construtor de caminhos que não precisa de parametros para ser usado.
     */
    public Caminho(){

    }

    /**
     * Este método serve para verficiar se existe 2 segmentos de reta iguais, e para isso vai comparar a trajetoria
     * que é uma arrayList de pontos , para se existe 2 vezes um ponto inicial e um mesmo ponto final e nesse caso vai
     * dar print de " trajetoria:vi"
     * @inv trajetória:vi é a invariante que ocorre quando os pontos fornecidos não formam uma trajetória(ou seja
     * quando existe um segmento igual)que é um ponto inicial e ponto final serem exatamente iguais, a outros dentro da trajetoria
     * @return não retorna nada é uma função void
     */

    public void trajetoriavi(){
        for(int i = 0; i <pontosList.size()-1; i++){
            for(int j = i+1; j <pontosList.size(); j++){
                if(pontosList.get(i).getX() == pontosList.get(j).getX() && pontosList.get(i).getY() == pontosList.get(j).getY()){
                    SegmentoReta seg = new SegmentoReta(pontosList.get(i), pontosList.get(i+1)); //serve para confirmar se é segmentoVI
                    System.out.println("Trajetoria:vi");
                    System.exit(0);
                }
            }
        }
    }


    /**
     * Serve para adicionar um ponto ao caminho
     * @param p ponto adicionado
     */
    public void addpontoList(Ponto p){
        pontosList.add(p);
        trajetoriavi();
    }
    /**
     * Este método, vai verificar, quantas figuras geometricas são atingidos pela arraylist de segmentos de reta.
     * @return vai retornar um numero inteiro que representa o numero de vezes que o segmento bate nas figuras.
     */
    public int contas(ArrayList<FiguraGeometrica> figs){
        int result = 0;
        for (int i = 0; i < figs.size(); i++) {
            for (int j = 1; j < this.retornaPontos().size(); j++) {
                SegmentoReta sg = new SegmentoReta(this.retornaPontos().get(j-1),this.retornaPontos().get(j));
                if (figs.get(i).verificacao(sg)){
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Este método serve para ver se o caminho já contem o ponto p ou não
     * @param p é o ponto testado
     * @return um booleano em que o false quer dizer que o caminho não possui o ponto
     */
    public boolean caminhoContainsPonto(Ponto p){
        boolean f= false;
        for(int i =0;i<this.retornaPontos().size();i++){
            if(this.retornaPontos().get(i).getX()==p.getX() && this.retornaPontos().get(i).getY()==p.getY())
                f=true;
        }
        return f;
    }

    /**
     * serve para retornar pontos
     * @return
     */
    public ArrayList<Ponto> retornaPontos(){
        return pontosList;
    }

    /**
     * Serve para calcular a distancia percorrida pelo caminho
     * @return retorna um double que representa a distancia
     */
    public double distanciaCaminho(){
        double result=0;
        for(int i=0;i<this.retornaPontos().size()-1;i++){
            result+=this.retornaPontos().get(i).dist(this.retornaPontos().get(i+1));
        }
        return result;
    }

    /**
     * Este método, vai estudar um caminho comparado com algumas figuras geometricas
     * @param figs
     * @return
     */
    public double avaliacao(ArrayList<FiguraGeometrica> figs){
        return 1/(distanciaCaminho() + Math.exp(contas(figs)));
    }

    /**
     * Este método serve para comparar caminhos
     * @param a é o caminho dado para testar
     *
     * @return retorna o caminho com melhor avaliacao
     */
    public Caminho comparacao_caminhos(Caminho a,ArrayList<FiguraGeometrica> figs){
        if(this.avaliacao(figs)<a.avaliacao(figs))
            return a;
        return this;
    }

    /**
     * serve para passar para uma string o caminho
     * @return retorna uma string
     */
    public String toString(){
        String print = "[";
        for(int j = 0; j < this.retornaPontos().size(); j++){
            if(j+1 == this.retornaPontos().size())
                print += "(" + (int) this.retornaPontos().get(j).getX() + ";" +  (int) this.retornaPontos().get(j).getY()+ ")";
            else
                print += "(" + (int)this.retornaPontos().get(j).getX() + ";" +  (int)this.retornaPontos().get(j).getY()+ ") ";
        }
        print += "]";
        return print;
    }


    public Caminho[] recombinacao(Caminho a,Random generator){
        Caminho[] arrayCaminhos=new Caminho[2];
        int primeiro=generator.nextInt(this.retornaPontos().size()-1);
        int segundo=generator.nextInt(a.retornaPontos().size()-1);
        Caminho b=new Caminho();
        Caminho c= new Caminho();
        for(int i=0;i<=primeiro;i++)
            b.addpontoList(this.retornaPontos().get(i));

        for(int i=segundo+1;i<a.retornaPontos().size();i++){
            if(!b.caminhoContainsPonto(a.retornaPontos().get(i)))
                b.addpontoList(a.retornaPontos().get(i));
        }

        for(int i=0;i<=segundo;i++)
            c.addpontoList(a.retornaPontos().get(i));

        for (int i=primeiro+1;i<this.retornaPontos().size();i++){
            if(!c.caminhoContainsPonto(this.retornaPontos().get(i)))
                c.addpontoList(this.retornaPontos().get(i));
        }
        arrayCaminhos[0]=b;
        arrayCaminhos[1]=c;
        return arrayCaminhos;
    }

    /**
     * Este método serve para fazer uma mutação, ou seja se o r<pm então é escolhido
     * um ponto aleatório do caminho e é trocado por outro aleatório
     * @param pm é o valor que tem que ser maior que o r
     * @param generator é usado para ver valores aleatórios
     */
    public void mutacao(Double pm,Random generator) {
        if (this.retornaPontos().size() <= 2)
            return;
        double r = generator.nextDouble(1);
        if (r < pm) {
            int n = generator.nextInt(this.retornaPontos().size() - 2) + 1;
            Ponto ponto = new Ponto(generator);
            if (!this.caminhoContainsPonto(ponto))
                this.retornaPontos().set(n, ponto);
        }
    }

    /**
     * Este método, serve para adicionar um ponto a trajetória, caso o r<pa
     * @param pa é o valor que tem que ser maior que o r
     * @param generator é usado para ter os valores aleatórios
     */

    public void adicao(Double pa,Random generator){
        double r=generator.nextDouble(1);
        if(r<pa){
            if(this.retornaPontos().size() <= 2){
                Ponto ponto1 = new Ponto(generator);
                if(!this.caminhoContainsPonto(ponto1)){
                    this.pontosList.add(1,ponto1);
                    return;
                }
            }
            int n=generator.nextInt(this.retornaPontos().size()-2)+2;
            Ponto ponto = new Ponto(generator);
            if(!this.caminhoContainsPonto(ponto))
                this.pontosList.add(n,ponto);
        }
    }

    /**
     * Este método, serve para (remover ou não) um ponto da trajetória
     * @param pr é o numero dado para ver se remove ou não
     * @param generator é usado para gerar numeros aleatórios
     */
    public void remocao(Double pr,Random generator) {
        if (this.retornaPontos().size() <= 2)
            return;
        double r = generator.nextDouble(1);
        if (r < pr) {
            int n = generator.nextInt(this.retornaPontos().size() - 2) + 1;
            this.retornaPontos().remove(n);
        }
    }

}