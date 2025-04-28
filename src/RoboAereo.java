// Classe RoboAereo que herda da classe Robo
public class RoboAereo extends Robo {
    // Altitude atual do robô
    private int altitude;
    
    // Altitude máxima permitida para o robô
    private int altitudeMaxima;

    // Construtor da classe RoboAereo
    // Inicializa o robô com nome, direção, posição (x, y), altitude e altitude máxima
    public RoboAereo(String n, String d, int x, int y, Ambiente amb, int alt, int altMax){
        super(n, d, x, y, amb); // Chama o construtor da classe pai (Robo)
        altitude = alt; // Define a altitude inicial do robô
        altitudeMaxima = altMax; // Define a altitude máxima permitida
    }
    
    // Método para subir o robô em uma determinada altitude (deltaZ)
    public void subir(int deltaZ){
        if (altitude + deltaZ <= altitudeMaxima) {
            altitude += deltaZ;
        } else {
            altitude = altitudeMaxima;
            System.out.println("Altura máxima atingida!");
        }
    }
    

    // Método para descer o robô em uma determinada altitude (deltaZ)
    public void descer(int deltaZ){
        if (altitude - deltaZ >= 0) {
            altitude -= deltaZ;
        } else {
            altitude = 0;
            System.out.println("O robô já está no chão!");
        }
    }
    

    // Retorna a altitude atual do robô
    public int getAltitude() {
        return altitude;
    }

    // Define um novo valor para a altitude do robô
    public void setAltitude(int altitude) {
        this.altitude = altitude;
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
