package robo;

import ambiente.Ambiente;
import missao.Missao;

public abstract class AgenteInteligente extends Robo{
    
    public AgenteInteligente(String n, String d, int x, int y, Ambiente amb) {
        super(n, d, x, y, amb);
    }

    protected missao.Missao missao;
    
    public void definirMissao(Missao m) {
        this.missao = m;
    }

    public boolean temMissao () {
        return missao != null;
    }

    public abstract void executarMissao(Ambiente a);
}
