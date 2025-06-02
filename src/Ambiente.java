import java.util.ArrayList;
import java.util.List;

public class Ambiente {
    // Atributos que definem as dimensões do ambiente
    private int largura;    // Largura do ambiente (eixo Y)
    private int comprimento; // Comprimento do ambiente (eixo X)
    private int altura;     // Altura do ambiente (eixo Z)

    // Mapa tridimensional que indica a ocupação do ambiente
    private TipoEntidade[][][] mapa;

    // Lista de todas as entidades presentes no ambiente
    private List<Entidade> entidades = new ArrayList<>();

    public class ColisaoException extends Exception {
        public ColisaoException(String message) {
            super(message);
        }
    }

    // Construtor para criar um ambiente 2D (sem altura)
    public Ambiente(int l, int c) {
        this.largura = l;    // Define a largura do ambiente
        this.comprimento = c; // Define o comprimento do ambiente
        this.altura = 0; // Define altura como zero
        inicializarMapa();
    }
    
    // Construtor para criar um ambiente 3D (com altura)
    public Ambiente(int l, int c, int a) {
        this.largura = l;     // Define a largura do ambiente
        this.comprimento = c; // Define o comprimento do ambiente
        this.altura = a;      // Define a altura do ambiente
        inicializarMapa();
    }


    private void inicializarMapa(){
        this.mapa = new TipoEntidade[this.comprimento][this.largura][this.altura+1]; // +1 para incluir a altura 0
        
        // Preenche o mapa com VAZIO inicialmente
        for (int x = 0; x < this.comprimento; x++) {
            for (int y = 0; y < this.largura; y++) {
                for (int z = 0; z <= this.altura; z++) {
                    this.mapa[x][y][z] = TipoEntidade.VAZIO;
                }
            }
        }
    }

    public void adicionarObstaculo(Obstaculo o){
        try {
            adicionarEntidade((Entidade)o); // Agora tratando a exceção
        } catch (ColisaoException e) {
            System.err.println("Erro ao adicionar obstáculo: " + e.getMessage());
        }
    }

    public void adicionarRobo(Robo r){
        try {
            adicionarEntidade((Entidade)r);
        } catch (ColisaoException e) {
            System.err.println("Erro ao adicionar robô: " + e.getMessage());
        }
    }

    // Adiciona uma entidade ao ambiente e ao mapa
    public void adicionarEntidade(Entidade e) throws ColisaoException {
        if (!dentroDosLimites(e.getX(), e.getY(), e.getZ())) {
            throw new ColisaoException("Posição fora dos limites do ambiente");
        }
        if (estaOcupado(e.getX(), e.getY(), e.getZ())) {
            throw new ColisaoException("Posição já ocupada");
        }
        
        entidades.add(e);
        mapa[e.getX()][e.getY()][e.getZ()] = e.getTipo();
    }


    // Remove uma entidade do ambiente
    public void removerEntidade(Entidade e) {
        if (entidades.remove(e)) {
            mapa[e.getX()][e.getY()][e.getZ()] = TipoEntidade.VAZIO;
        }
    }

    // Verifica se uma posição está dentro dos limites do ambiente
    public boolean dentroDosLimites(int x, int y) {
        return x >= 0 && x < comprimento && y >= 0 && y < largura;
    }

     // Verifica se uma posição está dentro dos limites do ambiente
    public boolean dentroDosLimites(int x, int y, int z) {
        return x < 0 || x >= comprimento || y < 0 || y >= largura || z < 0 || z > altura;
    }

    // Verifica se uma posição está ocupada
    public boolean estaOcupado(int x, int y, int z) {
        return dentroDosLimites(x, y, z) && mapa[x][y][z] != TipoEntidade.VAZIO;
    }

    // Move uma entidade para uma nova posição
    public void moverEntidade(Entidade e, int novoX, int novoY, int novoZ) throws ColisaoException {
        // Verifica se a nova posição é válida
        dentroDosLimites(novoX, novoY, novoZ);
        
        // Verifica se a nova posição está livre (exceto pela própria entidade)
        if (estaOcupado(novoX, novoY, novoZ) && 
            !(mapa[novoX][novoY][novoZ] == e.getTipo() && 
              e.getX() == novoX && e.getY() == novoY && e.getZ() == novoZ)) {
            throw new ColisaoException("Posição (" + novoX + "," + novoY + "," + novoZ + ") ocupada");
        }

        // Atualiza o mapa
        mapa[e.getX()][e.getY()][e.getZ()] = TipoEntidade.VAZIO;
        mapa[novoX][novoY][novoZ] = e.getTipo();
        
        // Atualiza a posição da entidade
        if (e instanceof Robo) {
            ((Robo) e).setPosX(novoX);
            ((Robo) e).setPosY(novoY);
            ((Robo) e).setAltitude(novoZ);
        }
    }

    // Executa todos os sensores das entidades
    public void executarSensores() {
        for (Entidade entidade : entidades) {
            if (entidade instanceof InterfaceSensoriavel) {
                ((InterfaceSensoriavel) entidade).acionarSensores();
            }
        }
    }

    // Verifica colisões entre entidades
    public void verificarColisoes() throws ColisaoException {
        for (int i = 0; i < entidades.size(); i++) {
            Entidade e1 = entidades.get(i);
            for (int j = i + 1; j < entidades.size(); j++) {
                Entidade e2 = entidades.get(j);
                if (e1.getX() == e2.getX() && e1.getY() == e2.getY() && e1.getZ() == e2.getZ()) {
                    throw new ColisaoException("Colisão detectada entre " +  e1.getDescricao() + " e " + e2.getDescricao() + " na posição (" + e1.getX() + "," + e1.getY() + "," + e1.getZ() + ")");
                }
            }
        }
    }

        // Visualiza o ambiente no plano X,Y
    public void visualizarAmbiente() {
        System.out.println("\n=== VISUALIZAÇÃO DO AMBIENTE ===");
        System.out.println("Legenda: . = Vazio, R = Robô, O = Obstáculo\n");
        
        for (int y = 0; y < largura; y++) {
            for (int x = 0; x < comprimento; x++) {
                char simbolo = '.';
                // Verifica todas as alturas nesta posição X,Y
                for (int z = 0; z <= altura; z++) {
                    if (mapa[x][y][z] == TipoEntidade.ROBO) {
                        simbolo = 'R';
                        break;
                    } else if (mapa[x][y][z] == TipoEntidade.OBSTACULO) {
                        simbolo = 'O';
                        break;
                    }
                }
                System.out.print(simbolo + " ");
            }
            System.out.println();
        }
    }

    // Retorna a largura do ambiente
    public int getLargura() {
        return largura;
    }

    // Define a largura do ambiente
    public void setLargura(int largura) {
        this.largura = largura;
    }

    // Retorna a altura do ambiente
    public int getAltura() {
        return altura;
    }

    // Define a altura do ambiente
    public void setAltura(int altura) {
        this.altura = altura;
    }

    // Retorna o comprimento do ambiente
    public int getComprimento() {
        return comprimento;
    }

    // Define o comprimento do ambiente
    public void setComprimento(int comprimento) {
        this.comprimento = comprimento;
    }

    public TipoEntidade[][][] getMapa() {
        return mapa;
    }

    public List<Entidade> getEntidades() {
        return entidades;
    }

    public ArrayList<Robo> getRobos() {
        List<Entidade> e = entidades;
        ArrayList<Robo> r = new ArrayList<>();
        for(int i = 0; i < e.size(); i++){
            if(e.get(i).getTipo() == TipoEntidade.ROBO){
                r.add((Robo)e);
            }
        }
        return r;
    }

    public ArrayList<Obstaculo> getObstaculos() {
        List<Entidade> e = entidades;
        ArrayList<Obstaculo> o = new ArrayList<>();
        for(int i = 0; i < e.size(); i++){
            if(e.get(i).getTipo() == TipoEntidade.OBSTACULO){
                o.add((Obstaculo)e);
            }
        }
        return o;
    }
}
