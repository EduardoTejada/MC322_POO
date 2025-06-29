package missao;

import ambiente.Ambiente;
import arquivos.EscritorDeArquivo;
import robo.Robo;

// Robô busca obstaculo em um determinado perímetro
public class MissaoColherAmostra implements Missao{

    @Override
    public void executar(Robo r, Ambiente a) {
        int dx = 1, dy = 0;
        while(r.identificarObstaculosAdjacentesAoRobo(a).size() == 0) {
            if(a.dentroDosLimites(r.getX()+dx, r.getY())){
                String msg = "Nada encontrado próximo a " + r.getX() + r.getY();
                System.out.println(msg);
                EscritorDeArquivo.writeFile(msg);
                r.mover(dx, dy);
            } else { // Muda de direção
                if      (dx == 1 && dy == 0)  { dx = 0; dy = 1; }
                else if (dx == 0 && dy == 1)  { dx = -1; dy = 0;}
                else if (dx == -1 && dy == 0) { dx = 0; dy = -1;}
                else if (dx == 0 && dy == -1) break;
            }
        }

        if(r.identificarObstaculosAdjacentesAoRobo(a).size() == 0){
            String msg = "Nada a ser coletado.";
            System.out.println(msg);
            EscritorDeArquivo.writeFile(msg);
        }
        else{
            String msg = "Amostra encontrada: " + r.identificarObstaculosAdjacentesAoRobo(a).get(0);
            System.out.println(msg);
            EscritorDeArquivo.writeFile(msg);
        }
    }
}
