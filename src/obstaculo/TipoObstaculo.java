package obstaculo;
public enum TipoObstaculo {
    PAREDE(6, true),
    PORTA_ABERTA(5, false),
    PORTA_FECHADA(5, true),
    RAMPA(8, false),
    OUTRO(-1, false);

    private final int alturaPadrao;
    private final boolean bloqueiaPassagem;

    TipoObstaculo(int alturaPadrao, boolean bloqueiaPassagem){
        this.alturaPadrao = alturaPadrao;
        this.bloqueiaPassagem = bloqueiaPassagem;
    }

    public int getAlturaPadrao(){
        return alturaPadrao;
    }

    public boolean isBloqueiaPassagem(){
        return bloqueiaPassagem;
    }
}