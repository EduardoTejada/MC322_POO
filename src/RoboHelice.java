// Classe RoboHelice que herda de RoboAereo
// Representa um robô aéreo semelhante a um drone ou helicóptero
// Ele só pode se mover nas direções X e Y após atingir uma altura mínima
public class RoboHelice extends RoboAereo {
    // Atributo que define a altura mínima necessária para se mover
    private int altitudeMin;

    // Construtor da classe RoboHelice
    // Inicializa o robô com nome, direção, posição (x, y), altitude atual, altitude máxima e altitude mínima necessária para movimentação
    public RoboHelice(String n, String d, int x, int y, Ambiente amb, int alt, int altMax, int altMin){
        super(n, d, x, y, amb, alt, altMax); // Chama o construtor da classe RoboAereo
        altitudeMin = altMin; // Define a altura mínima necessária para movimentação
        this.setRepresentacao('H');
        this.setDescricao("Variacao da classe epresenta um robô aéreo semelhante a um drone ou helicóptero, que só pode se mover nas direções X e Y após atingir uma altura mínima");
    }
    
    // Método para mover o robô nas direções X e Y
    @Override
    public void mover(int deltaX, int deltaY){
        // Verifica se o robô atingiu a altitude mínima necessária para movimentação
        if (getAltitude() >= altitudeMin) {
            // Atualiza a posição do robô
            setPosX(getPosX() + deltaX);
            setPosY(getPosY() + deltaY);
        } else {
            // Exibe uma mensagem caso a altura mínima não tenha sido atingida
            System.out.println("Sem altura suficiente para movimentar, altura atual: " + getAltitude() +
                               " altura necessária: " + altitudeMin);
        }
    }

    // Retorna a altura mínima necessária para movimentação
    public int getAltitudeMin() {
        return altitudeMin;
    }

    // Define uma nova altura mínima necessária para movimentação
    public void setAltitudeMin(int altitudeMin) {
        if (altitudeMin < 0) {
            System.out.println("Erro: A altitude mínima não pode ser negativa.");
        } else if (altitudeMin > getAltitudeMaxima()) {
            System.out.println("Erro: A altitude mínima não pode ser maior que a altitude máxima.");
        } else {
            this.altitudeMin = altitudeMin;
        }
    }
}
