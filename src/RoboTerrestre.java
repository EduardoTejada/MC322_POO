// Classe RoboTerrestre que herda da classe Robo
public class RoboTerrestre extends Robo implements InterfaceSensoriavel {
  // Velocidade máxima permitida para o robô terrestre
  private int velocidadeMaxima = 10;
  
  // Velocidade atual do movimento do robô
  private int velocidadeMovimento;

  // Construtor da classe RoboTerrestre
  // Recebe o nome, direção, posição (x, y) e a velocidade de movimento
  public RoboTerrestre(String n, String d, int x, int y, Ambiente amb, int vMov){
      super(n, d, x, y, amb); // Chama o construtor da classe pai (Robo)
      this.velocidadeMovimento = vMov; // Define a velocidade de movimento
      this.setRepresentacao('T');
      this.setDescricao("Variacao da classe para os robos que não podem voar (posicao no eixo z = 0)");
  }

  // Sobrescreve o método mover da classe Robo
  // Move o robô apenas se a velocidade estiver dentro do limite
  @Override
  public void mover(int deltaX, int deltaY){
      if (velocidadeMovimento <= velocidadeMaxima){
          this.setPosX(this.getPosX() + deltaX);
          this.setPosY(this.getPosY() + deltaY);
      } else {
          System.out.println("Velocidade acima do limite");
      }
  }

  // Retorna a velocidade máxima do robô
  public int getVelocidadeMaxima() {
      return velocidadeMaxima;
  }

  // Define uma nova velocidade máxima para o robô
  public void setVelocidadeMaxima(int velocidadeMaxima) {
      this.velocidadeMaxima = velocidadeMaxima;
  }

  // Retorna a velocidade de movimento do robô
  public int getVelocidadeMovimento() {
      return velocidadeMovimento;
  }

  // Define a velocidade de movimento do robô
  public void setVelocidadeMovimento(int velocidadeMovimento) {
      this.velocidadeMovimento = velocidadeMovimento;
  }

  public void acionarSensores(){
    
  }
}
