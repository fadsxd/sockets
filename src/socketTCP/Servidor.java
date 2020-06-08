package socketTCP;

import java.io.*;
import java.net.*;

public class Servidor {

	/**
	 * @param args
	 */
	/*
	public static boolean letraA(String a){
		boolean sw = false;
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i)=='a'){
				sw = true;
			}
		}
		return sw;
	}*/
	public static String devuelvaCadena (String x){
		int n = Integer.parseInt(x);
		String res="";
		switch (n) {
		case 1:
			res="papel";
			break;
		case 2:
			res="piedra";
			break;
		case 3:
			res="tijera";
		default:
			break;
		}
		return res;
	}
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//creamos socket servidor
		ServerSocket socketServidor = null;
		Socket socketCliente = null;
		//creamos flujo de salida
		BufferedReader in = null;
		//creamos flujo de salida
		PrintWriter out = null;
		System.out.println("--servidor iniciado--");
		//definimos el constructor con el puerto
		socketServidor = new ServerSocket(8888);
		while(true){
			socketCliente = socketServidor.accept();
			//definimos flujos de entrada y salida
			in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())),true);
			
			while(true){
				String mc = in.readLine();
				if(mc.equals("exit"))break;
				/*
				String res = "IMPAR";
				System.out.println(mc);
				if(mc.length()%2==0)
					res = "PAR";	
				*/
				if(devuelvaCadena(mc)=="papel"){
					out.println(devuelvaCadena(mc));
				}
				if(devuelvaCadena(mc)=="piedra"){
					out.println(devuelvaCadena(mc));
				}
				if(devuelvaCadena(mc)=="tijera"){
					out.println(devuelvaCadena(mc));
				}
				System.out.println(devuelvaCadena(mc));
				/*
				
				String res = "";
				if(letraA(mc)){
					res = "Tiene la letra a";
				}else{
					res = "NO tiene la letra a";
				}
				*/
				//mandamos el mensaje
				
			}
			
			//System.out.println("el puerto del cliente "+socketCliente.getPort());
			//System.out.println("El addres del cliente "+socketCliente.getInetAddress());
			//liberamos recursos
			out.close();
			in.close();
			socketCliente.close();
		}
	}

}
