package paqueteCalentamiento;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		int serverPort = Integer.parseInt(args[0]);
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			while (true) {
				Socket socket = serverSocket.accept();
				Hilo hilo = new Hilo(socket);
				hilo.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
