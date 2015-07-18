package org.dummymailer.mail;//-------------------------------------------------------------------
//BasicSMTPServer.java
//-------------------------------------------------------------------
import org.subethamail.smtp.server.SMTPServer;

public class BasicSMTPServer {
    public static void main(String[] args) {
        MyMessageHandlerFactory myFactory = new MyMessageHandlerFactory() ;
        SMTPServer smtpServer = new SMTPServer(myFactory);
        smtpServer.setPort(12345);
        smtpServer.start();
    }
}