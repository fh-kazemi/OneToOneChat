import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class OneToOneChatServerSocket {
	public static void main(String[] args) throws IOException {
		
		try(ServerSocket server=new ServerSocket(9876)){
			Socket socket=server.accept();
			Scanner inStream=new Scanner(socket.getInputStream());
			Formatter outStream=new Formatter(socket.getOutputStream());
			Scanner input=new Scanner(System.in);
			String txt;
			do {
				txt=inStream.nextLine();
				System.out.println("Received: "+txt);
				System.out.print("Me:");
				txt = input.nextLine();
				outStream.format(txt + "\n");
				outStream.flush();
			}while(!txt.equalsIgnoreCase("exit"));
		}
	}
}
