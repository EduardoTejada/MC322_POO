public class RoboAereo extends Robo {
    private int altitude;
    private int altitudeMaxima;

    public RoboAereo(String n, String d, int x, int y, int alt, int altMax){
        super(n, d, x, y);
        altitude = alt;
        altitudeMaxima = altMax;
    }
    
    public void subir(int deltaZ){
        altitude += deltaZ;
    }

    public void descer(int deltaZ){
        altitude -= deltaZ;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getAltitudeMaxima() {
        return altitudeMaxima;
    }

    public void setAltitudeMaxima(int altitudeMaxima) {
        this.altitudeMaxima = altitudeMaxima;
    }
}
