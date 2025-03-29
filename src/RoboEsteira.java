public class RoboEsteira extends RoboTerrestre{
    private int VelocidadeGiro;
    
    public RoboEsteira(String n, String d, int x, int y, int vMov, int vGiro){
        super(n, d, x, y, vMov);
        VelocidadeGiro = vGiro;
    }

    public void girarRobo(){
        //Percorre as direções cardeais no sentido horário começando da que o robô está apontando, o número de direções percorrida depende da velocidade de giro
            for (int i = 0; i < listaDirecoes.length; i++) {
                if (listaDirecoes[i] == getDirecao()) {
                    setDirecao(listaDirecoes[(i+VelocidadeGiro)-((VelocidadeGiro+i)/4)*4]);
                    break;
                }
            }
        
    }

    public int getVelocidadeGiro() {
        return VelocidadeGiro;
    }

    public void setVelocidadeGiro(int velocidadeGiro) {
        VelocidadeGiro = velocidadeGiro;
    }
}
