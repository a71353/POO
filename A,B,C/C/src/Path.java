import java.util.ArrayList;

public class Path {

    private ArrayList<Ponto> Parray;
    Path(){
        Parray = new ArrayList<Ponto>();
    }

    public void addPontos(Ponto p){
        Parray.add(p);
    }

    public double caminhototal(){
        double total = 0;
        int n = Parray.size();
        for(int i = 0; i < n - 1; i++){
            total += Parray.get(i).dist(Parray.get(i+1));
        }
        return total;
    }

}