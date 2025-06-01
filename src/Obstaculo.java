public class Obstaculo {
    private int posicaoX1, posicaoY1, altura;
    private int posicaoX2, posicaoY2;
    private TipoObstaculo tipoObs;
    private TipoEntidade te = TipoEntidade.OBSTACULO;
    private char representacao = 'O';
    private String descricao = "Obstáculo que pode ou não impedir a passagem do robô";

    public Obstaculo(int posicaoX1, int posicaoY1, int altura, int posicaoX2, int posicaoY2){
        this.posicaoX1 = posicaoX1;
        this.posicaoY1 = posicaoY1;
        this.altura = altura;
        this.posicaoX2 = posicaoX2;
        this.posicaoY2 = posicaoY2;
    }

    public int getPosicaoX1() {
        return posicaoX1;
    }
    public void setPosicaoX1(int posicaoX1) {
        this.posicaoX1 = posicaoX1;
    }
    public int getPosicaoY1() {
        return posicaoY1;
    }
    public void setPosicaoY1(int posicaoY1) {
        this.posicaoY1 = posicaoY1;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getPosicaoX2() {
        return posicaoX2;
    }
    public void setPosicaoX2(int posicaoX2) {
        this.posicaoX2 = posicaoX2;
    }
    public int getPosicaoY2() {
        return posicaoY2;
    }
    public void setPosicaoY2(int posicaoY2) {
        this.posicaoY2 = posicaoY2;
    }
    public TipoObstaculo getTipoObs() { //mudei o nome pq "getTipo" precisa estar na interface do lab 4
        return tipoObs;
    }
    public void setTipo(TipoObstaculo tipo) {
        this.tipoObs = tipo;
    }

    //Como os obstáculos foram programados como tendo volume (x1 e x2, y1 e y2 e altura) usaremos a 
    //posição média para x e y e a altura para z
    public int getX(){
        return (this.posicaoX1 + this.posicaoX2)/2;
    }
    
    public int getY(){
        return (this.posicaoY1 + this.posicaoY2)/2;
    }
    public int getZ(){
        return this.altura;
    }

    public TipoEntidade getTipo(){
        return this.te;
    }

    public char getRepresentacao(){
        return this.representacao;
    }

    public String getDescricao(){
        return this.descricao;
    };
}
