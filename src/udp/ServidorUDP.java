package udp;

import java.awt.PageAttributes;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {

	/**
	 * @param args
	 */
	/*
	public static boolean esPrimo(String cad){
		int n = Integer.parseInt(cad);
		for(int x=2 ; x*x <=n; x++){
			if(n%x==0)return false;
		}
		return true;
	}
	*/
	
	public static String recuperar(String cad,int tam){
		String res="";
		for (int i = 0; i < tam; i++) {
			res +=cad.charAt(i);
		}
		return res;
	}
	public static String contarCadenas (String cad){
		int contador = 1, pos;
		String res = cad.trim();
		if(res.isEmpty()){
			contador =0;
		}else{
			pos = res.indexOf(" ");
			while(pos !=-1){
				contador++;
				pos = res.indexOf(" ", pos+1);
			}
		}
		String resultado = Integer.toString(contador);
		return resultado;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("--Servidor--");
		DatagramSocket socketUDP = new DatagramSocket(8888);
		byte[] bufer = new byte[1024];
		while (true) {
			DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
			socketUDP.receive(peticion);

			// envia datos servidor
			/*DatagramPacket mensaje = new DatagramPacket(peticion.getData(),
					peticion.getLength(), peticion.getAddress(),
					peticion.getPort());
				  socketUDP.send(mensaje);
			*/
			String res = new String(peticion.getData());
			String x = recuperar(res,peticion.getLength());
			
			System.out.println("-----"+x);
			/*
			String env = "PRIMO";
			if(!esPrimo(x)){
				env = "NO ES PRIMO";
			}
			*/
			String env = contarCadenas(x);

			byte [] enviar = env.getBytes();
			DatagramPacket mensaje = new DatagramPacket(enviar,
					env.length(), peticion.getAddress(),
					peticion.getPort());
			socketUDP.send(mensaje);
			/*
			System.out.println("Cliente :" + new String(peticion.getData()));
			System.out.println("puerto del cliente" + peticion.getPort());
			System.out.println("tam" + peticion.getLength());
			*/
		}
	}

}
