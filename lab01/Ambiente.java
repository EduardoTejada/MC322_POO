public class Ambiente {
    private int largura;
    private int altura;

    public Ambiente(int l, int a) {
        this.largura = l;
        this.altura = a;
    }

    public boolean dentroDosLimites(int x, int y){
        return(this.altura >= x && this.largura >= y);
    }
}
 