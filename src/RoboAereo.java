// Classe RoboAereo que herda da classe Robo
public class RoboAereo extends Robo {
    // Altitude máxima permitida para o robô
    private int altitudeMaxima;

    // Construtor da classe RoboAereo
    // Inicializa o robô com nome, direção, posição (x, y), altitude e altitude máxima
    public RoboAereo(String n, String d, int x, int y, Ambiente amb, int alt, int altMax){
        super(n, d, x, y, amb); // Chama o construtor da classe pai (Robo)
        this.setAltitude(alt); // Define a altitude inicial do robô
        altitudeMaxima = altMax; // Define a altitude máxima permitida
        this.setRepresentacao('A');
        this.setDescricao("Variacao da classe para os robos que pode voar (mover no eixo z)");
    }
    
    // Método para subir o robô em uma determinada altitude (deltaZ)
    public void subir(int deltaZ){
        if (this.getAltitude() + deltaZ <= altitudeMaxima) {
            this.setAltitude(this.getAltitude()+ deltaZ);
        } else {
            this.setAltitude(altitudeMaxima);
            System.out.println("Altura máxima atingida!");
        }
    }
    

    // Método para descer o robô em uma determinada altitude (deltaZ)
    public void descer(int deltaZ){
        if (this.getAltitude() - deltaZ >= 0) {
            this.setAltitude(this.getAltitude()- deltaZ);
        } else {
            this.setAltitude(0);
            System.out.println("O robô já está no chão!");
        }
    }

    // Retorna a altitude máxima permitida para o robô
    public int getAltitudeMaxima() {
        return altitudeMaxima;
    }

    // Define um novo valor para a altitude máxima do robô
    public void setAltitudeMaxima(int altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }
}
