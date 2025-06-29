package missao;

import ambiente.Ambiente;
import obstaculo.Obstaculo;
import robo.Robo;

//verifica o perimetro e registra obstaculos detectados em uma lista
public class MissaoReconhecerPerimetro implements Missao{

    @Override
    public void executar(Robo r, Ambiente a) {
        for (Obstaculo o : r.identificarObstaculosAdjacentesAoRobo(a)) {
            System.out.println("Obstaculo do tipo: " + o.getTipo() + ", na posicao " + o.getPosicaoX1() + o.getPosicaoX2() + o.getPosicaoY1() + o.getPosicaoY2());
        }
    }
}
