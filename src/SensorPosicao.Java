public class SensorPosicao extends Sensor { //a princípio implementado no rrobô terrestre
    private Robo robo; // Robô que o sensor está monitorando

    public SensorPosicao(double raio, Robo robo) {
        super(raio);
        this.robo = robo;
    }

    @Override
    public void monitorar(Ambiente amb) {
        //Detectando obstáculos
        for (Obstaculo obs : amb.getObstaculos()){ //Verifica a lista de obstáculos no ambiente e retorna as coordenadas daqueles que estão dentro do raio do snessor
            if(raio >= Math.sqrt(Math.Pow(obs.getPosicaoX1() , 2)+Math.Pow(obs.getPosicaoY1() , 2))){
                System.out.println("Obstáculo detectado: (" + obs.getPosicaoX1() + ", " + obs.getPosicaoY1() + ")")
            }else{
                System.out.println("Nenhum Obstáculo detectado:")
            }
        }
        
        //Detctando outros Robôs
        for (Robo rb : amb.getRobos()){ //Verifica a lista de outros robôs no ambiente e retorna as coordenadas daqueles que estão dentro do raio do snessor
            if(raio >= Math.sqrt(Math.Pow(rb.getPosX() , 2)+Math.Pow(rb.getPosY , 2))){
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
