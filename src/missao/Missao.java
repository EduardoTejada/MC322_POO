package missao;

import ambiente.Ambiente;
import robo.Robo;

public interface Missao{
    void executar(Robo r, Ambiente a);
}