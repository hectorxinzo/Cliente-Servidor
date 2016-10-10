package paqueteCalentamiento;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hilo extends Thread {

	Socket socket;

	public Hilo(Socket serv) {
		socket = serv;
	}

	public void run() {
		try {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (true) {
				System.out.println("*******");
				Calendar calendario = Calendar.getInstance();
				int hora=calendario.get(Calendar.HOUR_OF_DAY);
				int minutos=calendario.get(Calendar.MINUTE);
				int segundos=calendario.get(Calendar.SECOND);
				String time= hora+":"+minutos+":"+segundos;
				out.writeUTF(time);
				sleep(1000);
			}
		} catch (SocketException e) {
			System.out.println("Canalización rota");
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
