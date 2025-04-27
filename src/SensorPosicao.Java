public class SensorPosicao extends Sensor {
    private Robo robo; // Robô que o sensor está monitorando

    public SensorPosicao(double raio, Robo robo) {
        super(raio);
        this.robo = robo;
    }

    @Override
    public void monitorar() {
        System.out.println("Posição do robô: (" + robo.getPosX() + ", " + robo.getPosY() + ")");
    }

    public Robo getRobo() {
        return robo;
    }

    public void setRobo(Robo robo) {
        this.robo = robo;
    }
}
