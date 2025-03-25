import java.util.ArrayList;

public class Robo {
    private String nome;
    private String direcao;
    private int posicaoX;
    private int posicaoY;
    
    public Robo(String n, String d, int x, int y){
        this.nome = n;
        this.direcao = d;
        this.posicaoX = x;
        this.posicaoY = y;
    }

    public void mover(int deltaX, int deltaY){
        this.posicaoX += deltaX;
        this.posicaoY += deltaY;
    }

    public void exibirPosicao(){
        System.out.println(this.posicaoX + " " + this.posicaoY);
    }

    public void identificarObstaculo(Ambiente a){
        ArrayList<Robo> r = a.getRobos();
        for(int i = 0; i < r.size(); i++){
            if( r.get(i).getPosX() == this.posicaoX+1 && r.get(i).getPosY() == this.posicaoY || 
                r.get(i).getPosX() == this.posicaoX-1 && r.get(i).getPosY() == this.posicaoY || 
                r.get(i).getPosX() == this.posicaoX && r.get(i).getPosY() == this.posicaoY+1 || 
                r.get(i).getPosX() == this.posicaoX && r.get(i).getPosY() == this.posicaoY-1)
                System.out.println("Robo " + r.get(i).getNome() + "na posicao " + r.get(i).getPosX() + ", " + r.get(i).getPosY() + " é um obstáculo");;
        }
    }

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

    public String getNome(){
        return this.nome;
    }

    public String getDirecao(){
        return this.direcao;
    }

    public int getPosX(){
        return this.posicaoX;
    }
    
    public int getPosY(){
        return this.posicaoY;
    }
}
