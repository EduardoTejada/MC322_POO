import java.util.ArrayList;

public class Robo {
    // Atributos do robô
    private String nome;         // Nome do robô
    private String direcao;      // Direção atual do robô (Norte, Sul, Leste, Oeste)
    private int posicaoX;        // Posição X do robô no ambiente
    private int posicaoY;        // Posição Y do robô no ambiente

    public String[] listaDirecoes = {"Norte","Leste", "Sul", "Oeste"}; // Lista de direções possíveis para o robô

    // Construtor da classe, inicializa o robô com nome, direção e posição inicial
    public Robo(String n, String d, int x, int y){
        this.nome = n;
        this.direcao = d;
        this.posicaoX = x;
        this.posicaoY = y;
    }

    // Método para mover o robô na grade, alterando sua posição X e Y
    public void mover(int deltaX, int deltaY){
        this.posicaoX += deltaX;
        this.posicaoY += deltaY;
    }

    // Exibe a posição atual do robô no console
    public void exibirPosicao(){
        System.out.println(this.posicaoX + " " + this.posicaoY);
    }
    
    // Exibe a direção atual do robô no console
    public void exibirDirecao(){
        System.out.println(this.direcao);
    }

    // Verifica se algum robô está imediatamente ao lado (direita, esquerda, acima ou abaixo)
    private boolean ehAdjacente(Robo outroRobo){
        return(outroRobo.getPosX() == this.posicaoX+1 && outroRobo.getPosY() == this.posicaoY || 
                outroRobo.getPosX() == this.posicaoX-1 && outroRobo.getPosY() == this.posicaoY || 
                outroRobo.getPosX() == this.posicaoX && outroRobo.getPosY() == this.posicaoY+1 || 
                outroRobo.getPosX() == this.posicaoX && outroRobo.getPosY() == this.posicaoY-1);
    }
    
    // Método para identificar se há um obstáculo (outro robô) em uma posição adjacente
    public void identificarObstaculo(Ambiente a){
        ArrayList<Robo> r = a.getRobos(); // Obtém a lista de robôs presentes no ambiente
        for(int i = 0; i < r.size(); i++){
                if(ehAdjacente(r.get(i))) // Verifica se a posição do outro robô é adjacente a desse robô
                    // Exibe uma mensagem informando que há um obstáculo
                    System.out.println("Robo " + r.get(i).getNome() + "na posicao " + r.get(i).getPosX() + ", " + r.get(i).getPosY() + " é um obstáculo");
        }
    }

    // Métodos setters (definem novos valores para os atributos)
    public void setNome(String n){
        this.nome = n;
    }

    public void setDirecao(String d){
        this.direcao = d;
    }

    public void setPosX(int x){
        this.posicaoX = x;
    }

    public void setPosY(int y){
        this.posicaoY = y;
    }

    public void setListaDirecoes(String[] listaDirecoes) {
        this.listaDirecoes = listaDirecoes;
    }

    
    // Métodos getters (retornam os valores dos atributos)
    public String getNome(){
        return this.nome;
    }

    public String getDirecao(){
        return this.direcao;
    }

    public String[] getListaDirecoes() {
        return listaDirecoes;
    }

    public int getPosX(){
        return this.posicaoX;
    }
    
    public int getPosY(){
        return this.posicaoY;
    }
}
