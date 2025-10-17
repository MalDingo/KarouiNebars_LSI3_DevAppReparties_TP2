package serverPackage;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("serveur en écoute");
            Socket socket =server.accept();
            InputStream is = socket.getInputStream();
            System.out.println("serveur en ecoute sur les entier !");
            int nb1=is.read();
            int nb2=is.read();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s=br.readLine();
            float resultat=0;
            switch (s.charAt(0)) {
            case'+':
            	resultat=nb1+nb2;
            	break;
            case'-':
            	resultat=nb1-nb2;
            	break;
            case'/':
            	resultat=nb1/nb2;
            	break;
            case'*':
            	resultat=nb1*nb2;
            	break;
            default:
            	resultat=-1;
            }
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            System.out.println("Résultat envoyé au client.");
            pw.println(resultat);
        } catch (IOException e) {
            System.err.println("Erreur de serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}