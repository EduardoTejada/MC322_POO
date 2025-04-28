public class SensorTemperatura extends Sensor{ //a princípio será implementado no roboAsa
    private Robo robo;

    public SensorTemperatura(double raio, Robo robo){
        super(raio);
        this.robo = robo;
    }

    @Override
    public void monitorar(){
        
        
    }

    public Robo getRobo() {
        return robo;
    }

    public void setRobo(Robo robo) {
        this.robo = robo;
    }
}
