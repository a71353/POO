

public class Circunferencia extends FiguraGeometrica{
    private Ponto ponto1;
    private double raio;

    /**
     * Este método serve para estudar se é ou não uma circunferencia
     */
    public void circunferenciaVF(){
        if(this.raio<0){
            System.out.println("Circunferencia:vi");
            System.exit(0);
        }
    }

    /**
     * É O construtor, que cria uma circunferencia, com 1 ponto e um numero double que representa o raio
     * @param ponto1 é o ponto1
     * @param raio é numero de raio
     */
    public Circunferencia(Ponto ponto1,double raio){
        this.ponto1=ponto1;
        this.raio=raio;
        circunferenciaVF();
    }

    /**
     *Este método serve para criar um construtor de circunferencias, com base numa string
     * @param palavra é a string usada
     */
    public Circunferencia(String palavra){
        String frase[] =palavra.split(" ");
        this.ponto1=new Ponto(Double.parseDouble(frase[1]),Double.parseDouble(frase[2]));
        this.raio=Double.parseDouble(frase[3]);
        circunferenciaVF();
    }

    /**
     * Este método estuda, se um segmento(não vertical) toca ou não na circunferencia
     * @param seg é o segmento de reta(não vertical) que vai ser estudado
     * @return retonra um booleano que representa se toca ou não
     */
    private boolean verificaciruloseg(SegmentoReta seg){     //ve os casos de serem retas normais
        boolean f=false;
        double m= seg.r().m();
        //double b= seg.r().b();
        double r= Math.pow(this.raio,2);
        double d=seg.r().b()-this.ponto1.getY();
        Double a =1 + Math.pow(m,2);
        Double b = 2*(-this.ponto1.getX())+2*(m)*d;
        Double c = Math.pow(this.ponto1.getX(),2) + Math.pow(d,2)-r;
        if((Math.pow(b,2)-4*a*c)<0)
            return false;
        Double x1= (-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
        Double x2= (-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
        if((x1<=Math.max(seg.r().getPonto1().getX(),seg.r().getPonto2().getX()) && x1>=Math.min(seg.r().getPonto1().getX(),seg.r().getPonto2().getX())) || (x2<=Math.max(seg.r().getPonto1().getX(),seg.r().getPonto2().getX()) && x2>=Math.min(seg.r().getPonto1().getX(),seg.r().getPonto2().getX())))
            f=true;
        return f;
    }
    /**
     * Este método estuda, se um segmento vertical toca ou não na circunferencia
     * @param seg é o segmento de reta que vai ser estudado(vertical)
     * @return retonra um booleano que representa se toca ou não
     */
    private boolean verificavertical(SegmentoReta seg){
        boolean f=false;
        double a = 1;
        double b = -2 * this.ponto1.getY();
        double c = Math.pow(seg.ponto1().getX(),2) + Math.pow(this.ponto1.getX(),2) - (2 * seg.ponto1().getX() * this.ponto1.getX()) + Math.pow(this.ponto1.getY(),2) - Math.pow(this.raio,2);
        if((Math.pow(b,2)-4*a*c)<0)
            return false;
        Double y1= (-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
        Double y2= (-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
        if((y1<=Math.max(seg.r().getPonto1().getY(),seg.r().getPonto2().getY()) && y1>=Math.min(seg.r().getPonto1().getY(),seg.r().getPonto2().getY())) || (y2<=Math.max(seg.r().getPonto1().getY(),seg.r().getPonto2().getY()) && y2>=Math.min(seg.r().getPonto1().getY(),seg.r().getPonto2().getY())))
                   f=true;
        return f;
    }

    /**
     * Este metodo serve para ver se um qualquer segmento de rata bate na cirncunferencia
     * @param seg é o segmento usado
     * @return retorna  um booleano
     */
    public boolean verificacao(SegmentoReta seg){
        boolean f= false;
        if(seg.ponto1().getX()==seg.ponto2().getX())
           f=verificavertical(seg);
        else
            f=verificaciruloseg(seg);
        return f;
    }

    /**
     * Este método com ajuda da verificao serve para ver se o segmento toca ou não
     * @param seg é o segmento usado para testar
     * @return retorna uma string
     */
    public String stringToPrint(SegmentoReta seg){
        String print;
        if(verificacao(seg))
            print="Fail";
        else
            print="Ok";
        return print;
    }

}
