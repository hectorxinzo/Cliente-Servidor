package paqueteCalentamiento;

import java.io.DataInputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		String serverHost = args[0];
		int serverPort = Integer.parseInt(args[1]);
		Socket socket;
		try {
			socket = new Socket(serverHost, serverPort);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			while (true) {
				String linea = in.readUTF();
				System.out.println(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
