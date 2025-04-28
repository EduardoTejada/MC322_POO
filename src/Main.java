public class Main {
    public static void main(String[] args) {
        Ambiente a1 = new Ambiente(10, 10, 10);
        RoboEsteira Tanque = new RoboEsteira("Tanque", "Norte", 1, 2, a1, 1, 6);
        RoboEsfera BB8 = new RoboEsfera("BB8", "Sul", 5, 5, a1, 2, 2); //BB8 é o drone da ultima trilogia de StarWars
        RoboHelice drone = new RoboHelice("drone", "Leste", 2, 3, a1, 0, 7, 2);
        RoboAsa aviao = new RoboAsa("aviao", "Oeste", 6, 7, a1, 0, 10, 4);


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

        //teste movimentação do RoboHelice
        System.out.print("Posição original do "+drone.getNome()+": ");
        drone.exibirPosicao();
        drone.mover(3, 2); //tentativa de mover
        drone.subir(5);
        System.out.println("Nova altura "+drone.getNome()+": "+ drone.getAltitude());
        drone.mover(3, 2); //nova tentativa de mover após elevar a altura
        System.out.print("Nova posição "+drone.getNome()+": ");
        drone.exibirPosicao();

        //teste movimentação robo asa
        System.out.print("Posição original do "+aviao.getNome()+": ");
        aviao.exibirPosicao();
        aviao.mover(3, 2);
        System.out.print("Nova posição "+aviao.getNome()+": ");
        aviao.exibirPosicao();
        System.out.println("Altura original do "+aviao.getNome()+": "+ aviao.getAltitude());
        aviao.subir(3);
        aviao.setVelocidadeMovimento(5); //elevando a velocidade 
        aviao.subir(3); // nova tentativa de elevar a altura
        System.out.println("Nova velocidade do "+aviao.getNome()+": "+ aviao.getVelocidadeMovimento());
        System.out.println("Nova Altura do "+aviao.getNome()+": "+ aviao.getAltitude());


        /*
        drone.subir(5);
        drone.mover(3, 2); //nova tentativa de mover após elevar a altura
        */
        

    }
}
