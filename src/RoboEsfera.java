// Classe RoboEsfera que herda de RoboTerrestre
// Representa um robô terrestre com inércia adicional ao movimento
public class RoboEsfera extends RoboTerrestre {
  // Atributo que representa a inércia do robô, afetando seu movimento
  private int inercia;

  // Construtor da classe RoboEsfera
  // Inicializa o robô com nome, direção, posição (x, y), velocidade de movimento e inércia
  public RoboEsfera(String n, String d, int x, int y, int vMov, int i){
      super(n, d, x, y, vMov); // Chama o construtor da classe RoboTerrestre
      inercia = i; // Define a inércia do robô
  }

  // Modificação da função mover acrescentando uma quantidade a mais de movimento que depende da inércia do robô
  @Override
  public void mover(int deltaX, int deltaY){
      // Verifica se a velocidade de movimento está dentro do limite permitido
      if (getVelocidadeMaxima() >= getVelocidadeMovimento()) {
          // O robô se move levando em conta a inércia multiplicada pela velocidade
          setPosX(getPosX() + deltaX + inercia * getVelocidadeMovimento());
          setPosY(getPosY() + deltaY + inercia * getVelocidadeMovimento());
      } else {
          System.out.println("Velocidade acima do limite");
      }
  }
  
    public int getInercia() {
      return inercia;
    }

    public void setInercia(int inercia) {
      this.inercia = inercia;
    }
}
