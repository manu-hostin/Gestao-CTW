package org.example.notificador;
public class Notificador {

    private String tipo; // "EMAIL" ou "LOG"

    public Notificador(String tipo) {
        this.tipo = tipo;
    }
    public void notificar(String mensagem) {
        if (tipo.equals("EMAIL")) {
            System.out.println("[EMAIL ENVIADO] " + mensagem);
        } else if (tipo.equals("LOG")) {
            System.out.println("[LOG DO SISTEMA] " + mensagem);
        } else {
            System.out.println("[NOTIFICAÇÃO DESCONHECIDA] " + mensagem);
        }
    }
}
