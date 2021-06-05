
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class OneToOneChatClientServer {

	public static void main(String[] args)throws IOException {
		
		try(Socket socket=new Socket("localhost",9876)){
			Scanner inStream=new Scanner(socket.getInputStream());
			Formatter outStream=new Formatter(socket.getOutputStream());
			Scanner input=new Scanner(System.in);
			String txt;
			do {
				System.out.print("Me:");
				txt=input.nextLine();
				outStream.format(txt+"\n");
				outStream.flush();
				txt=inStream.nextLine();
				System.out.println("Received: "+txt);
			}while(!txt.equalsIgnoreCase("exit"));
		}
	}
}