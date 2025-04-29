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
            if(this.getRaio() >= Math.sqrt(Math.Pow((robo.getPosX()-obs.getPosicaoX1()) , 2)+Math.Pow((robo.getPosY()-obs.getPosicaoY1()), 2))){
                System.out.println("*************************************************************************************");
                System.out.println("Obstáculo detectado em: (" + obs.getPosicaoX1() + ", " + obs.getPosicaoY1() + ")")
                System.out.println("*************************************************************************************");
            
            }else if(this.getRaio() >= Math.sqrt(Math.Pow((robo.getPosX()-obs.getPosicaoX1()) , 2)+Math.Pow((robo.getPosY()-obs.getPosicaoY2()) , 2))){

                System.out.println("*************************************************************************************");
                System.out.println("Obstáculo detectado em: (" + obs.getPosicaoX1() + ", " + obs.getPosicaoY2() + ")")
                System.out.println("*************************************************************************************");

            }else if(this.getRaio() >= Math.sqrt(Math.Pow((robo.getPosX()-obs.getPosicaoX2()) , 2)+Math.Pow((robo.getPosY()-obs.getPosicaoY1()) , 2))){
                System.out.println("*************************************************************************************");
                System.out.println("Obstáculo detectado em: (" + obs.getPosicaoX2() + ", " + obs.getPosicaoY1() + ")")
                System.out.println("*************************************************************************************");

            }else if(this.getRaio() >= Math.sqrt(Math.Pow((robo.getPosX()-obs.getPosicaoX2()) , 2)+Math.Pow((robo.getPosY()-obs.getPosicaoY2()) , 2))){
                System.out.println("*************************************************************************************");
                System.out.println("Obstáculo detectado em: (" + obs.getPosicaoX2() + ", " + obs.getPosicaoY2() + ")")
                System.out.println("*************************************************************************************");
            }
            else{
                System.out.println("*************************************************************************************");
                System.out.println("Nenhum Obstáculo detectado")
                System.out.println("*************************************************************************************");
            }
        }
        
        //Detctando outros Robôs
        for (Robo rb : amb.getRobos()){ //Verifica a lista de outros robôs no ambiente e retorna as coordenadas daqueles que estão dentro do raio do snessor
            if(this.getRaio() >= Math.sqrt(Math.pow(rb.getPosX(), 2) + Math.pow(rb.getPosY(), 2) + Math.pow(rb.getAltitude(), 2))){
                System.out.println("*************************************************************************************");
                System.out.println("Robô detectado: (" + rb.getPosX() + ", " + rb.getPosY() + Math.pow(rb.getAltitude()) + ")")
                System.out.println("*************************************************************************************");
            }else{
                System.out.println("*************************************************************************************");
                System.out.println("Nenhum robô detectado:")
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
