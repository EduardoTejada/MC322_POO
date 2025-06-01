import java.util.ArrayList;

public class CentralComunicacao {
    private ArrayList<String> mensagens;

    public CentralComunicacao(ArrayList<String> msg){
        this.mensagens = msg;
    }

    public void registrarMensagem(String remetente, String msg){
        this.mensagens.add(remetente);
    }

    public void exibirMensagens(){
        System.out.println(this.mensagens);
    }

    public ArrayList<String> getMensagens() {
        return mensagens;
    }

    public void setMensagens(ArrayList<String> mensagens) {
        this.mensagens = mensagens;
    }
}
