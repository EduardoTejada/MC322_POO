public class RoboEsteira extends RoboTerrestre{
    private int VelocidadeGiro;
    
    public RoboEsteira(String n, String d, int x, int y, int vMov, int vGiro){
        super(n, d, x, y, vMov);
        VelocidadeGiro = vGiro;
    }

    public void girarRobo(String sentido){
        //Percorre as direções cardeais começando da que o robô está apontando, o número de direções percorrida depende da velocidade de giro
        if (sentido == "orario") {
            for (int i = 0; i < listaDirecoes.length; i++) {
                if (listaDirecoes[i] == getDirecao()) {
                    setDirecao(listaDirecoes[(i+VelocidadeGiro)-(VelocidadeGiro/4)*4]);
                }
            }
        } else {
            for (int i = 0; i < listaDirecoes.length; i++) {
                if (listaDirecoes[i] == getDirecao()) {
                    setDirecao(listaDirecoes[(i-VelocidadeGiro)+(VelocidadeGiro/4)*4]);
                }            
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
