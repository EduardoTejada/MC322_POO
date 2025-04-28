// Classe RoboAsa que herda de RoboAereo
// Representa um robô aéreo semelhante a um avião, que só pode ganhar altitude enquanto se movimenta para frente, com uma velocidade mínima
public class RoboAsa extends RoboAereo {
    // Atributo que define a velocidade mínima necessária para o robô subir
    private int velocidadeMinima;
    
    // Atributo que define a velocidade de movimento do robô
    private int velocidadeMovimento = 1;  

    // Construtor da classe RoboAsa
    // Inicializa o robô com nome, direção, posição (x, y), altitude atual, altitude máxima e velocidade mínima para subida
    public RoboAsa(String n, String d, int x, int y, Ambiente amb, int alt, int altMax, int velMin){
        super(n, d, x, y, amb, alt, altMax);  // Chama o construtor da classe RoboAereo
        velocidadeMinima = velMin;  // Define a velocidade mínima necessária para subir
    }

    // Método para subir o robô, aumentando a altitude
    public void subir(int deltaZ){
        // Verifica se o robô está se movendo rápido o suficiente para subir
        if (velocidadeMovimento >= velocidadeMinima) {
            setAltitude(getAltitude() + deltaZ);  // Aumenta a altitude do robô
            this.setTemp(this.getTemp()+1); //no esforço de subida os motores elevam a temperatura do robô
        } else {
            // Exibe uma mensagem caso a velocidade não seja suficiente para subir
            System.out.println("Sem velocidade suficiente para subir, velocidade atual: " + getVelocidadeMovimento() + 
                               " velocidade necessária: " + velocidadeMinima);
        }
    }

    public void descer(int deltaZ){
       super.descer(deltaZ);
       this.setTemp(this.getTemp()-1); //na descida o robô plana com os motores desligados e perde temperatura

        }

    // Retorna a velocidade mínima necessária para subir
    public int getVelocidadeMinima() {
        return velocidadeMinima;
    }

    // Define uma nova velocidade mínima necessária para subir
    public void setVelocidadeMinima(int velocidadeMinima) {
        this.velocidadeMinima = velocidadeMinima;
    }

    // Retorna a velocidade de movimento do robô
    public int getVelocidadeMovimento() {
        return velocidadeMovimento;
    }

    // Define uma nova velocidade de movimento para o robô
    public void setVelocidadeMovimento(int velocidadeMovimento) {
        this.velocidadeMovimento = velocidadeMovimento;
    }
}
