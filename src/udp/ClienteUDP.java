package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// creamos el socket
		System.out.println("---Cliente---");
		DatagramSocket socketUDP = new DatagramSocket();
		int puerto = 8888;
		InetAddress host = InetAddress.getByName("localhost");
		// leer en consola
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

		String cad;

		while (true) {
			cad = sc.readLine();
			if (cad.equals("0"))
				break;
			byte[] mens = cad.getBytes();
			DatagramPacket peticion = new DatagramPacket(mens, cad.length(),
					host, puerto);
			// enviamos peticion
			socketUDP.send(peticion);

			// recibir mensaje de servidor
			byte[] bufer = new byte[1000];
			DatagramPacket mensaje = new DatagramPacket(bufer, bufer.length);
			socketUDP.receive(mensaje);
			System.out.println("la respuesta del servidor :"
					+ new String(mensaje.getData()));

		}
	}

}
