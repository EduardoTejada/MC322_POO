public class SensorTemp extends Sensor {
    private Robo robo; // Robô que o sensor está monitorando

    public SensorTemp(double raio, Robo robo) {
        super(raio);
        this.robo = robo;
    }

    @Override
    public void monitorar(Ambiente amb) {
        //Detctando outros Robôs
        for (Robo rb : amb.getRobos()){ //Verifica a lista de outros robôs no ambiente e retorna as coordenadas daqueles que estão dentro do raio do snessor
            if(this.getRaio() >= Math.sqrt(Math.Pow(rb.getPosX() , 2)+Math.Pow(rb.getPosY , 2))){
                System.out.println("Robô detectado: (" + rb.getPosX() + ", " + rb.getPosY() + ")")
            }else{
                System.out.println("Nenhum robô detectado:")
            }
        }
        
    }

    public Robo getRobo() {
        return robo;
    }

    public void setRobo(Robo robo) {
        this.robo = robo;
    }
}
