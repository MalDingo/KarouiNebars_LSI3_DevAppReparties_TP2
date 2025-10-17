package clientPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket= new Socket("localhost",1234);
			OutputStream os = socket.getOutputStream();
			Scanner sc = new Scanner(System.in); 
		    System.out.print("Entrez un nombre : ");
		    int nb = sc.nextInt(); // la bonn
			os.write(nb);
			System.out.print("Entrez un nombre2 : ");
			int nb1=sc.nextInt();
			os.write(nb1);
			sc.nextLine();
			System.out.print("Entrez un operateur  : ");
			PrintWriter pw = new PrintWriter(os,true);
			String  oper=sc.nextLine();
			pw.println(oper);
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String reponse = br.readLine();
	        System.out.println("Résultat reçu du serveur : " + reponse);
			sc.close();
			os.close();
			socket.close();
			} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
