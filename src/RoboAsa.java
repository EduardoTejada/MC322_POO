public class RoboAsa extends RoboAereo{
/*A ideia aqui é de algo similar a um avião, só pode ganhar altura enquanto se movimenta para frente há uma velocidade mínima*/
private int velocidadeMinima;
private int velocidadeMovimento = 0;    
public RoboAsa(String n, String d, int x, int y, int alt, int altMax, int velMin){
        super(n, d, x, y, alt, altMax);
        velocidadeMinima = velMin;

    }

    public void subir(int deltaZ){
        if (velocidadeMovimento>=velocidadeMinima) {
            setAltitude(getAltitude()+deltaZ);
        }else{
            System.out.println("Sem velocidade suficiente para subir");
        }
    }

    public int getVelocidadeMinima() {
        return velocidadeMinima;
    }

    public void setVelocidadeMinima(int velocidadeMinima) {
        this.velocidadeMinima = velocidadeMinima;
    }

    public int getVelocidadeMovimento() {
        return velocidadeMovimento;
    }

    public void setVelocidadeMovimento(int velocidadeMovimento) {
        this.velocidadeMovimento = velocidadeMovimento;
    }
}
