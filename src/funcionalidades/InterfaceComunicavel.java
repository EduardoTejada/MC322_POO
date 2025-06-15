package funcionalidades;
//Implementada nos robos tipo Aereo

import robo.Robo;

public interface InterfaceComunicavel {
    void enviarMensagem(Robo destinatario, String mensagem);
    void receberMensagem(String mensagem);
}
