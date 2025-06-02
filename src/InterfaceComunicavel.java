//Implementada nos robos tipo Aereo
public interface InterfaceComunicavel {
    void enviarMensagem(Robo destinatario, String mensagem);
    void receberMensagem(String mensagem);
}
