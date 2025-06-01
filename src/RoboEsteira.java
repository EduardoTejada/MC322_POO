// Classe RoboEsteira que herda de RoboTerrestre
// Representa um robô terrestre que se movimenta com esteiras e pode girar
public class RoboEsteira extends RoboTerrestre {
    // Atributo que representa a velocidade de giro do robô
    private int VelocidadeGiro;
    
    // Construtor da classe RoboEsteira
    // Inicializa o robô com nome, direção, posição (x, y), velocidade de movimento e velocidade de giro
    public RoboEsteira(String n, String d, int x, int y, Ambiente amb, int vMov, int vGiro){
        super(n, d, x, y, amb, vMov); // Chama o construtor da classe RoboTerrestre
        VelocidadeGiro = vGiro; // Define a velocidade de giro do robô
        this.setRepresentacao('E');
        this.setDescricao("Representa um robô terrestre que se movimenta com esteiras e pode girar");

    }

    // Método para girar o robô no sentido horário
    public void girarRobo(){
        // Percorre as direções cardeais para encontrar a posição atual do robô
        // O robô gira um número de direções proporcional à sua velocidade de giro
        for (int i = 0; i < listaDirecoes.length; i++) {
            if (listaDirecoes[i] == getDirecao()) {
                // Define a nova direção considerando a rotação e garantindo que o índice permaneça dentro dos limites da lista
                setDirecao(listaDirecoes[(i + VelocidadeGiro) % 4]);
                break; // Interrompe o loop ao encontrar a direção atual
            }
        }
    }

    // Retorna a velocidade de giro do robô
    public int getVelocidadeGiro() {
        return VelocidadeGiro;
    }

    // Define uma nova velocidade de giro para o robô
    public void setVelocidadeGiro(int velocidadeGiro) {
        VelocidadeGiro = velocidadeGiro;
    }
}
