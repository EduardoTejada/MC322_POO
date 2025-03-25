import java.util.ArrayList;

public class Ambiente {
    private int largura;
    private int comprimento;
    private int altura;
    private ArrayList<Robo> robos = new ArrayList<Robo>();


    public Ambiente(int l, int c) {
        this.largura = l;
        this.comprimento = c;
    }

    public Ambiente(int l, int c, int a) {
        this.largura = l;
        this.comprimento = c;
        this.altura = a;
    }

    public boolean dentroDosLimites(int x, int y){
        return(this.comprimento >= x && this.largura >= y);
    }

    public boolean dentroDosLimites(int x, int y, int z){
        return(this.comprimento >= x && this.largura >= y && this.altura >= z);
    }

    public void adicionarRobo(Robo r){
        this.robos.add(r);
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public ArrayList<Robo> getRobos() {
        return this.robos;
    }

    public void setRobos(ArrayList<Robo> r) {
        this.robos = r;
    }

    public int getComprimento() {
        return comprimento;
    }

    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }
}
