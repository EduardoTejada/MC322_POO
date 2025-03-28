public class RoboEsfera extends RoboTerrestre{
    private int inercia;

    public RoboEsfera(String n, String d, int x, int y, int vMov, int i){
        super(n, d, x, y, vMov);
        inercia = i;
    }

    //Modificação da função mover acrescentando uma quantidade a mais de movimento que depende da inércia do robô
    public void mover(int deltaX, int deltaY){
        if (getVelocidadeMaxima() >= getVelocidadeMovimento()) {
            setPosX(getPosX()+deltaX + inercia*getVelocidadeMovimento());
            setPosY(getPosY()+deltaY+ inercia*getVelocidadeMovimento());
          }
    }
}
