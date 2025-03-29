import java.util.ArrayList;

public class Ambiente {
    // Atributos que definem as dimensões do ambiente
    private int largura;    // Largura do ambiente (eixo Y)
    private int comprimento; // Comprimento do ambiente (eixo X)
    private int altura;     // Altura do ambiente (eixo Z)
    
    // Lista de robôs presentes no ambiente
    private ArrayList<Robo> robos = new ArrayList<Robo>();

    // Construtor para criar um ambiente 2D (sem altura)
    public Ambiente(int l, int c) {
        this.largura = l;    // Define a largura do ambiente
        this.comprimento = c; // Define o comprimento do ambiente
    }

    // Construtor para criar um ambiente 3D (com altura)
    public Ambiente(int l, int c, int a) {
        this.largura = l;     // Define a largura do ambiente
        this.comprimento = c; // Define o comprimento do ambiente
        this.altura = a;      // Define a altura do ambiente
    }

    // Verifica se uma posição (x, y) está dentro dos limites do ambiente
    public boolean dentroDosLimites(int x, int y){
        // Verifica se as coordenadas x e y estão dentro da largura e comprimento do ambiente
        return(this.comprimento >= x && this.largura >= y);
    }

    // Verifica se uma posição (x, y, z) está dentro dos limites do ambiente 3D
    public boolean dentroDosLimites(int x, int y, int z){
        // Verifica se as coordenadas x, y e z estão dentro do comprimento, largura e altura do ambiente
        return(this.comprimento >= x && this.largura >= y && this.altura >= z);
    }

    // Adiciona um robô à lista de robôs do ambiente
    public void adicionarRobo(Robo r){
        this.robos.add(r); // Adiciona o robô à lista de robôs
    }

    // Retorna a largura do ambiente
    public int getLargura() {
        return largura;
    }

    // Define a largura do ambiente
    public void setLargura(int largura) {
        this.largura = largura;
    }

    // Retorna a altura do ambiente
    public int getAltura() {
        return altura;
    }

    // Define a altura do ambiente
    public void setAltura(int altura) {
        this.altura = altura;
    }

    // Retorna a lista de robôs presentes no ambiente
    public ArrayList<Robo> getRobos() {
        return this.robos;
    }

    // Define a lista de robôs presentes no ambiente
    public void setRobos(ArrayList<Robo> r) {
        this.robos = r;
    }

    // Retorna o comprimento do ambiente
    public int getComprimento() {
        return comprimento;
    }

    // Define o comprimento do ambiente
    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }
}
