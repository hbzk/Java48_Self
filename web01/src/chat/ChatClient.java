package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	static PrintStream out;
	static BufferedReader in;
	static String friendName;
	static Scanner scanner;
	
	public static void main(String[] args) throws Exception {
		scanner = new Scanner(System.in);
		System.out.print("서버주소>");
		String serverAddress = scanner.nextLine();
		Socket socket = new Socket(serverAddress, 7777);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 	// > String, 문장 단위의 명령도 수행 할 수 있다.
		
		out = new PrintStream(socket.getOutputStream());		
		
		
		processHello();
		
		String message = null;
		String input = null;
		do {
			System.out.print("입력>");
			input = scanner.nextLine();
			out.println(input);
			
			message = in.readLine();
			System.out.println("[" + friendName + "]" + message);
			if (input.equals("goodbye") && message.equals("ok")) {
				break;
			}
		}	while (true);
		
		in.close();
		out.close();
		socket.close();
	}

	private static void processHello() throws IOException {
	  // 서버에 자신을 알리고, 서버의 이름을 받아서 보관한다.
		out.println("hello ABC");
		friendName = in.readLine().split(" ")[1];
		System.out.println("접속되었습니다.");
  }

}
