public class Main {
    public static void main(String[] args) {
        Ambiente a1 = new Ambiente(10, 10);
        Robo Senna = new Robo("Senna", 1, 2);
        Robo Mooncake = new Robo("Mooncake", 5, 5);

        Senna.mover(3, 5);
        Mooncake.mover(15, 9);

        System.out.println(a1.dentroDosLimites(Senna.getPosX(), Senna.getPosY()));
        System.out.println(a1.dentroDosLimites(Mooncake.getPosX(), Mooncake.getPosY()));

        System.out.print("Posição do "+Senna.getName()+": ");
        Senna.exibirPosicao();
        System.out.print("Posição do "+Mooncake.getName()+": ");
        Mooncake.exibirPosicao();
    }
}
