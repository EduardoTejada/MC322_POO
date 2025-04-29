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
            if(this.getRaio() >= Math.sqrt(Math.pow(rb.getPosX(), 2) + Math.pow(rb.getPosY(), 2) + Math.pow(rb.getAltitude(), 2))){
                System.out.println("*************************************************************************************");
                System.out.println("Robô detectado: (" + rb.getPosX() + ", " + rb.getPosY() + ", " + rb.getAltitude() + ")");
                System.out.println("Temperatura: (" + rb.getTemp()+ ")");
                System.out.println("*************************************************************************************");

            }else{
                System.out.println("*************************************************************************************");
                System.out.println("Nenhum robô detectado:");
                System.out.println("*************************************************************************************");
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
