public class Main {
    public static void main(String[] args) {
        Ambiente a1 = new Ambiente(10, 10, 10);
        RoboEsteira Tanque = new RoboEsteira("Tanque", "Norte", 1, 2, 1, 6);
        RoboEsfera BB8 = new RoboEsfera("BB8", "Sul", 5, 5, 2, 2);

        //Teste da movimentação terrestre
        Tanque.mover(3, 5);
        BB8.mover(15, 9); //a função específica do robo esfera é a sua inércia de movimentação

        System.out.println(a1.dentroDosLimites(Tanque.getPosX(), Tanque.getPosY()));
        System.out.println(a1.dentroDosLimites(BB8.getPosX(), BB8.getPosY()));

        System.out.print("Posição do "+Tanque.getNome()+": ");
        Tanque.exibirPosicao();
        System.out.print("Posição do "+BB8.getNome()+" (note que ele se movimenta mais que o previsto graças à inércia)"+": ");
        BB8.exibirPosicao();

        //Teste do limite de velocidade
        Tanque.setVelocidadeMovimento(15);
        BB8.setVelocidadeMovimento(15);
        Tanque.mover(3, 5);
        BB8.mover(15, 9);

        //Teste das funções específicas robô esteira
        System.out.print("Direção original do "+Tanque.getNome()+": ");
        Tanque.exibirDirecao();
        System.out.print("Direção após rotacionar "+": ");
        Tanque.girarRobo(); //o quanto o robô gira é definido pela variável vGiro
        Tanque.exibirDirecao();
        Tanque.setVelocidadeGiro(3);
        System.out.print("Direção após rotacionar novamente "+": ");
        Tanque.girarRobo();
        Tanque.exibirDirecao();

    }
}
