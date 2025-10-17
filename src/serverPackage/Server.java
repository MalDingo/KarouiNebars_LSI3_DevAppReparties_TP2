package serverPackage;

import java.io.*;
import java.net.*;
import serialization.objet;
public class Server {
    public static void main(String[] args) throws ClassNotFoundException {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("serveur en écoute");
            Socket socket =server.accept();
            System.out.println("serveur en ecoute sur les entier !");
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            objet op = (objet) in.readObject();
            double result=0;
            switch (op.getOperateur()) {
            case '+': result = op.getA() + op.getB(); break;
            case '-': result = op.getA() - op.getB(); break;
            case '*': result = op.getA() * op.getB(); break;
            case '/': 
                if (op.getB() != 0) result = op.getA() / op.getB(); 
                else System.out.println("Erreur : division par zéro");
                break;
            default: System.out.println("Opérateur non valide");
        }
            
            
            
            
            
            
            
            
            
            
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            System.out.println("Résultat envoyé au client.");
            pw.println(result);
        } catch (IOException e) {
            System.err.println("Erreur de serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}