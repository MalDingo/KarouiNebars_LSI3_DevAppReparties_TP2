package clientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.BufferedReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import serialization.objet;
import java.io.ObjectOutputStream;


public class Client {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket= new Socket("localhost",1234);
			OutputStream os = socket.getOutputStream();
			Scanner sc = new Scanner(System.in); 
		    System.out.print("Entrez un nombre : ");
		    double nb = sc.nextInt(); 
			
			System.out.print("Entrez un nombre2 : ");
			double nb1=sc.nextInt();
			
			sc.nextLine();
			System.out.print("Entrez un operateur  : ");
			
			String oper=sc.nextLine();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			objet obj = new objet (nb,nb1,oper.charAt(0));
			oos.writeObject(obj);
		
			//l'input 
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String reponse = br.readLine();
	        System.out.println("Résultat reçu du serveur : " + reponse);
			//
	        sc.close();
			os.close();
			socket.close();
			} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
