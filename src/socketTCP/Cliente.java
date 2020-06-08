package socketTCP;

import java.io.*;
import java.net.*;
import java.util.Date; 
public class Cliente {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//creamos un socket
		Socket socketCliente = null;
		// creamos flujo de entrada
		BufferedReader in= null;
		// creamos flujo de salida
		PrintWriter out = null;
		Date fecha = new Date();
		
		System.out.println("--Cliente--");
		//contructor por defecto con 2 argumentos ip y puerto
		socketCliente = new Socket ("localhost",8888);
		//definimos flujos de entrada y salida 
		in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
		
		//bufer para crear en consola
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
		System.out.println("Menu :");
		System.out.println("-opcion 1");
		System.out.println("-opcion 2");
		System.out.println("-opcion 3");
		System.out.println("-exit");
		//mensaje de consola
		String cad = sc.readLine();
		//enviando
		out.println(cad);
		if(cad.equals("exit"))break;
		//imprimimos mensaje del servidor
		String ms = in.readLine();
		System.out.println("Servidor:"+ms);
		}
		//liberamos los recursos
		out.close();
		in.close();
		sc.close();
		socketCliente.close();
	}

}
