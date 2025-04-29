import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Ambiente a1 = new Ambiente(10, 10, 10);
        RoboEsteira Tanque = new RoboEsteira("Tanque", "Norte", 1, 2, a1, 1, 6);
        RoboEsfera BB8 = new RoboEsfera("BB8", "Sul", 5, 5, a1, 2, 2); //BB8 é o drone da ultima trilogia de StarWars
        RoboHelice drone = new RoboHelice("drone", "Leste", 2, 3, a1, 0, 7, 2);
        RoboAsa aviao = new RoboAsa("aviao", "Oeste", 6, 7, a1, 0, 10, 4);

        SensorTemp s1_t = new SensorTemp(0, Tanque);
        SensorTemp s2_t = new SensorTemp(0, BB8);
        SensorTemp s3_t = new SensorTemp(0, drone);
        SensorTemp s4_t = new SensorTemp(0, aviao);

        Tanque.adicionarSensor(s1_t);
        BB8.adicionarSensor(s2_t);
        drone.adicionarSensor(s3_t);
        aviao.adicionarSensor(s4_t);

        SensorPosicao s1_p = new SensorPosicao(5, Tanque);
        SensorPosicao s2_p = new SensorPosicao(5, BB8);
        SensorPosicao s3_p = new SensorPosicao(5, drone);
        SensorPosicao s4_p = new SensorPosicao(5, aviao);
        
        Tanque.adicionarSensor(s1_p);
        BB8.adicionarSensor(s2_p);
        drone.adicionarSensor(s3_p);
        aviao.adicionarSensor(s4_p);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== MENU INTERATIVO =====");
            System.out.println("1 - Visualizar status dos robôs");
            System.out.println("2 - Visualizar status do ambiente");
            System.out.println("3 - Mover robô");
            System.out.println("4 - Subir/Descer robô aéreo");
            System.out.println("5 - Usar sensores");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(Tanque);
                    System.out.println(BB8);
                    System.out.println(drone);
                    System.out.println(aviao);
                    break;
                case 2:
                    System.out.println(a1);
                    break;
                case 3:
                    System.out.println("Escolha um robo (1: Tanque, 2: BB8): ");
                    int escolha = scanner.nextInt();
                    System.out.print("Mover - Digite dx: ");
                    int dx = scanner.nextInt();
                    System.out.print("Digite dy: ");
                    int dy = scanner.nextInt();
                    switch(escolha) {
                        case 1:
                            Tanque.mover(dx, dy);
                            break;
                        case 2:
                            BB8.mover(dx, dy);
                            break;
                        default:
                            System.out.println("Robo invalido!");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Escolha um robo (1: Drone, 2: Aviao): ");
                    int escolha2 = scanner.nextInt();
                    
                    System.out.print("Escolha o movimento (1: Subir, 2: Descer): ");
                    int altOpcao = scanner.nextInt();
                    System.out.print("Valor: ");
                    int valor = scanner.nextInt();

                    switch(escolha) {
                        case 1:
                            if (altOpcao == 1)
                                drone.subir(valor);
                            else
                                drone.descer(valor);
                            break;
                        case 2:
                            if (altOpcao == 1)
                                aviao.subir(valor);
                            else
                            aviao.descer(valor);
                            break;
                        default:
                            System.out.println("Robo invalido!");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Escolha um tipo de sensor (1: Temperatura, 2: Posicao): ");
                    int escolha3 = scanner.nextInt();
                    
                    System.out.print("Escolha o sensor (1: Tanque, 2: BB8, 3: Drone, 4: Aviao): ");
                    int escolha4 = scanner.nextInt();

                    switch(escolha4) {
                        case 1:
                            if(escolha3 == 1) s1_t.monitorar(a1); else if(escolha3 == 2) s1_p.monitorar(a1);
                            else System.out.println("Sensor invalido!");
                            break;
                        case 2:
                            if(escolha3 == 1) s2_t.monitorar(a1); else if(escolha3 == 2) s2_p.monitorar(a1);
                            else System.out.println("Sensor invalido!");
                            break;
                        case 3:
                            if(escolha3 == 1) s3_t.monitorar(a1); else if(escolha3 == 2) s3_p.monitorar(a1);
                            else System.out.println("Sensor invalido!");
                            break;
                        case 4:
                            if(escolha3 == 1) s4_t.monitorar(a1); else if(escolha3 == 2) s4_p.monitorar(a1);
                            else System.out.println("Sensor invalido!");
                            break;
                        default:
                            System.out.println("Sensor invalido!");
                            break;
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
        /*
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
        */
    }
}
