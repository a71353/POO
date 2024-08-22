import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @autor Goncalo Figueiredo
 * @version 1
 * */
public class Populacao {
    private ArrayList<Caminho> populacao1 = new ArrayList<Caminho>();
    int x,y;

    /**
     * Este método serve para adicionar,caminhos a populacao
     * @param c é o caminho que vai ser adicionado a populacao
     */
    public void  addCaminhoList(Caminho c){
        populacao1.add(c);
    }

    /**
     * Este método vai  retornar a populacao
     * @return retorna a populacao1
     */
    public ArrayList<Caminho> retornaCaminhos(){
        return populacao1;
    }



    /**
     * Este método, serve para retornar uma população,que é formada apenas por caminhos"vencedores".
     * @param generator é o generator que serve para criar torneios aleatórios
     * @return  retorna a população com os caminhos vencedores.
     */
    public Populacao torneio(Random generator,ArrayList<FiguraGeometrica> figs){
        int n=populacao1.size();
        int limite = n;
        Populacao pop= new Populacao();
        Caminho vencedor;
        int primeiro;
        int segundo;
        if(n==1)
            return this;
        while(n>0){
            primeiro=generator.nextInt(limite);
            segundo=generator.nextInt(limite);
            vencedor = this.populacao1.get(primeiro).comparacao_caminhos(populacao1.get(segundo),figs);
            pop.addCaminhoList(vencedor);
            n--;
        }
        return pop;
    }

    /**
     * serve para fazer os unittests
     * @param bla array com os indices
     * @param figs figuras geometrica
     * @return populacao
     */
    public Populacao torneio(int[] bla, ArrayList<FiguraGeometrica> figs){
        int n=populacao1.size();
        int i =0;
        int limite = n;
        Populacao pop= new Populacao();
        Caminho vencedor;
        int primeiro;
        int segundo;
        if(n==1)
            return this;
        while(n>0){
            primeiro=bla[i++];
            segundo=bla[i++];
            vencedor = this.populacao1.get(primeiro).comparacao_caminhos(populacao1.get(segundo),figs);
            pop.addCaminhoList(vencedor);
            n--;
        }
        return pop;
    }

    /**
     * Serve para converter a população em uma string para dar print
     * @return
     */
    public String toString(){
        String b = new String();
        for(int j=0;j<populacao1.size();j++){
            b+="[";
            for(int i=0;i<populacao1.get(j).retornaPontos().size();i++){
                if(j+1==populacao1.size() && i+1==populacao1.get(j).retornaPontos().size())
                    b+="("+(int)populacao1.get(j).retornaPontos().get(i).getX()+";"+(int)populacao1.get(j).retornaPontos().get(i).getY()+")]";
                else if (i+1==populacao1.get(j).retornaPontos().size())
                    b+="("+(int)populacao1.get(j).retornaPontos().get(i).getX()+";"+(int)populacao1.get(j).retornaPontos().get(i).getY()+")]\n";
                else
                    b+="("+(int)populacao1.get(j).retornaPontos().get(i).getX()+";"+(int)populacao1.get(j).retornaPontos().get(i).getY()+") ";
            }
        }
        return b;
    }

    /**
     *Este método serve para adicionar os caminhos, á população
     * @param a é o primeiro caminho
     * @param b é o segundo caminho
     * @param generator é o random usado para criar numeros aleatórios
     */
    public void recombinacaopopulacao(Caminho a, Caminho b,Random generator){
        Caminho[] arraycaminho=a.recombinacao(b,generator);
        this.addCaminhoList(arraycaminho[0]);
        this.addCaminhoList(arraycaminho[1]);
    }

    public void recombinacaopopulacao2(Random generator){
        Populacao pop = new Populacao();
        int n = this.retornaCaminhos().size();
        int m=n;
        if(m%2==0){
            while(m!=0){
                Caminho a = this.retornaCaminhos().get(generator.nextInt(n));
                Caminho b = this.retornaCaminhos().get(generator.nextInt(n));
                Caminho[] arraycaminho=a.recombinacao(b,generator);
                pop.addCaminhoList(arraycaminho[0]);
                pop.addCaminhoList(arraycaminho[1]);
                m-=2;
            }
        }
        else{
            while(m!=1){
                Caminho a = this.retornaCaminhos().get(generator.nextInt(n));
                Caminho b = this.retornaCaminhos().get(generator.nextInt(n));
                Caminho[] arraycaminho=a.recombinacao(b,generator);
                pop.addCaminhoList(arraycaminho[0]);
                pop.addCaminhoList(arraycaminho[1]);
                m-=2;
            }
            Caminho a = this.retornaCaminhos().get(generator.nextInt(n));
            Caminho b = this.retornaCaminhos().get(generator.nextInt(n));
            Caminho[] arraycaminho=a.recombinacao(b,generator);
            pop.addCaminhoList(arraycaminho[0]);
        }
        this.populacao1=pop.populacao1;
    }

    /**
     * Este método,serve para usar a mutação em toda uma população
     * @param pm é o valor usado para ver se é usada a mutação
     * @param generator é o random usado para criar numeros aleatórios
     */

    public void mutacaopopulacao(Double pm,Random generator){
        for (int i = 0; i < this.retornaCaminhos().size();i++){
            Caminho b = this.retornaCaminhos().get(i);
            this.retornaCaminhos().get(i).mutacao(pm,generator);
        }
    }

    /**
     * Este método,serve para (adicionar ou não) um ponto  em todos os caminhos da população
     * @param pa é o valor usado para ver se é usada para a adição
     * @param generator é o random usado para criar numeros aleatórios
     */
    public void adicaopopulacao(Double pa,Random generator){
        for (int i = 0; i < this.retornaCaminhos().size();i++){
            Caminho b = this.retornaCaminhos().get(i);
            this.retornaCaminhos().get(i).adicao(pa,generator);
        }
    }

    /**
     * Este método,serve para (remover ou não) um ponto em todos os caminhos da população
     * @param pr é o valor usado para ver se é usada para a adição
     * @param generator é o random usado para criar numeros aleatórios
     */
    public void remocaopopulacao(Double pr,Random generator){
        for (int i = 0; i < this.retornaCaminhos().size();i++){
            Caminho b = this.retornaCaminhos().get(i);
            this.retornaCaminhos().get(i).remocao(pr,generator);
        }
    }


    public double avaliacao_maxima(ArrayList<FiguraGeometrica> figs){
        double count=0;
        double result=0;
        for(int i=0;i<this.retornaCaminhos().size();i++){
            count=this.retornaCaminhos().get(i).avaliacao(figs);
            if(count>result)
                result=count;
        }
        return result;
    }

    public double avaliacao_media(ArrayList<FiguraGeometrica> figs){
        double result=0;
        for(int i=0;i<this.retornaCaminhos().size();i++)
            result +=this.retornaCaminhos().get(i).avaliacao(figs);
        return result/this.retornaCaminhos().size();
    }

    public double avaliacao_minima(ArrayList<FiguraGeometrica> figs){
        double result;
        double[] bla = new double[this.retornaCaminhos().size()];
        for(int i=0;i<this.retornaCaminhos().size();i++){
            bla[i]=this.retornaCaminhos().get(i).avaliacao(figs);
        }
        result=bla[0];
        for(int i=0;i<this.retornaCaminhos().size();i++){
            if(result>bla[i])
                result=bla[i];
        }
        return result;
    }

    public int contas_minima(ArrayList<FiguraGeometrica> figs){
        int[] bla = new int[this.retornaCaminhos().size()];
        for(int i=0;i<this.retornaCaminhos().size();i++){
            bla[i]=this.retornaCaminhos().get(i).contas(figs);
        }

        int result=bla[0];
        for(int i=0;i< bla.length;i++){
            if(result>bla[i])
                result=bla[i];
        }
        return result;
    }

    public int indice_contas_minima(ArrayList<FiguraGeometrica> figs){
        int result;
        int count=0;
        int[] bla = new int[this.retornaCaminhos().size()];
        for(int i=0;i<this.retornaCaminhos().size();i++){
            bla[i]=this.retornaCaminhos().get(i).contas(figs);
        }
        result=bla[0];
        for(int i=0;i<this.retornaCaminhos().size();i++){
            if(result>bla[i])
                count=i;
        }
        return count;
    }

    public double menor_trajetoria_conta_minima(ArrayList<FiguraGeometrica> figs){
        int n=indice_contas_minima(figs);
        return this.retornaCaminhos().get(n).distanciaCaminho();
    }


}