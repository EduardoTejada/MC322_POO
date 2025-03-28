public class RoboTerrestre extends Robo{
    private int velocidadeMaxima = 10;
    private int velocidadeMovimento;

    public RoboTerrestre(String n, String d, int x, int y, int vMov){
        super(n, d, x, y);
        velocidadeMovimento = vMov;
    }

    public void mover(int deltaX, int deltaY){
      if (velocidadeMaxima >= velocidadeMovimento) {
        setPosX(getPosX()+deltaX);
        setPosY(getPosY()+deltaY);
      }
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(int velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public int getVelocidadeMovimento() {
        return velocidadeMovimento;
    }

    public void setVelocidadeMovimento(int velocidadeMovimento) {
        this.velocidadeMovimento = velocidadeMovimento;
    }
}
