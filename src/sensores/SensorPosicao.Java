package sensores;
public class SensorPosicao extends Sensor { // Classe que representa um sensor de posição que detecta obstáculos e robôs ao redor
    private Robo robo; // Robô ao qual o sensor está acoplado

    // Construtor do sensor, recebe o raio de detecção e o robô associado
    public SensorPosicao(double raio, Robo robo) {
        super(raio);      // Chama o construtor da superclasse Sensor
        this.robo = robo; // Armazena o robô associado
    }

    // Método que realiza a detecção de obstáculos e outros robôs no ambiente
    @Override
    public void monitorar(Ambiente amb) {
        boolean obstaculoDetectado = false; // Flag para verificar se algum obstáculo foi detectado

        // Itera por todos os obstáculos presentes no ambiente
        for (Obstaculo obs : amb.getObstaculos()) {
            // Lista de coordenadas dos 4 vértices do obstáculo
            double[][] pontos = {
                {obs.getPosicaoX1(), obs.getPosicaoY1()},
                {obs.getPosicaoX1(), obs.getPosicaoY2()},
                {obs.getPosicaoX2(), obs.getPosicaoY1()},
                {obs.getPosicaoX2(), obs.getPosicaoY2()}
            };

            // Verifica se algum dos pontos está dentro do raio do sensor
            for (double[] ponto : pontos) {
                double distancia = Math.sqrt(Math.pow(robo.getPosX() - ponto[0], 2) + Math.pow(robo.getPosY() - ponto[1], 2));
                if (distancia <= this.getRaio()) {
                    System.out.println("*************************************************************************************");
                    System.out.println("Obstáculo detectado em: (" + ponto[0] + ", " + ponto[1] + ")");
                    System.out.println("*************************************************************************************");
                    obstaculoDetectado = true;
                }
            }
        }

        // Caso nenhum obstáculo tenha sido detectado
        if (!obstaculoDetectado) {
            System.out.println("*************************************************************************************");
            System.out.println("Nenhum Obstáculo detectado.");
            System.out.println("*************************************************************************************");
        }

        // Detecção de outros robôs
        boolean roboDetectado = false;
        for (Robo rb : amb.getRobos()) {
            if (rb != robo) { // Evita comparar o robô com ele mesmo
                // Calcula a distância 3D entre os robôs (considerando altitude)
                double distancia = Math.sqrt(
                    Math.pow(robo.getPosX() - rb.getPosX(), 2) +
                    Math.pow(robo.getPosY() - rb.getPosY(), 2) +
                    Math.pow(robo.getAltitude() - rb.getAltitude(), 2)
                );
                // Verifica se o outro robô está dentro do raio de detecção
                if (distancia <= this.getRaio()) {
                    System.out.println("*************************************************************************************");
                    System.out.println("Robô detectado em: (" + rb.getPosX() + ", " + rb.getPosY() + ", " + rb.getAltitude() + ")");
                    System.out.println("*************************************************************************************");
                    roboDetectado = true;
                }
            }
        }

        // Caso nenhum robô tenha sido detectado
        if (!roboDetectado) {
            System.out.println("*************************************************************************************");
            System.out.println("Nenhum Robô detectado.");
            System.out.println("*************************************************************************************");
        }
    }

    // Getters e setters para o robô associado ao sensor
    public Robo getRobo() {
        return robo;
    }

    public void setRobo(Robo robo) {
        this.robo = robo;
    }
}
