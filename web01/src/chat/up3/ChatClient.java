package chat.up3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/* 2. 스레드 만들기 - Runnable 인터페이스 구현
 * - Runnable 인터페이스를 구현한다.
 * - 독립적으로 실행할 코드를 run() 메서드에 넣는다.
 * - Thread 객체를 통해 실행한다. (직접 실행 불)
 */
@SuppressWarnings("serial")
public class ChatClient extends Frame implements ActionListener, Runnable {
	
	TextField serverAddress = new TextField(30);
	Button btnConnect = new Button("접속");
	Button btnDisconnect = new Button("끊기");
	TextArea msgPane = new TextArea();
	TextField inputMessage = new TextField();
	
	Socket socket;
	PrintStream out;
	BufferedReader in;
	
	String friendName;
	
	public ChatClient() {
		super("채팅 클라이언트");
		
		Panel temp = new Panel();
		temp.add(new Label("접속 주소"));
		temp.add(serverAddress);
		temp.add(btnConnect);
		temp.add(btnDisconnect);
		
		this.add(temp, BorderLayout.NORTH);
		this.add(msgPane, BorderLayout.CENTER);
		this.add(inputMessage, BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					out.println("goodbye");
					String message = in.readLine(); // 서버에 보낸 메시지 읽는다.
					System.out.println(message);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				disconnect();
				
			  System.exit(0);
			}
		});
		
		btnConnect.addActionListener(this);
		btnDisconnect.addActionListener(this);
		inputMessage.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inputMessage) { // 서버에 보낼 메시지 입력
			msgPane.append("[me] " + inputMessage.getText() + "\n");
			out.println(inputMessage.getText());
			inputMessage.setText("");
			
		} else if (e.getSource() == btnConnect) {
			if (socket != null) {
				msgPane.append("이미 접속중입니다. 끊고 다시 접속하세요.\n");
				return;
			}
			
			try {
				String[] values = serverAddress.getText().split(":");
				socket = new Socket(values[0], Integer.parseInt(values[1]));
				in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				out = new PrintStream(socket.getOutputStream());
				
				out.println("hello ABC_Client");
				String message = in.readLine();
				friendName = message.split(" ")[1];
				msgPane.append("접속되었습니다.\n");
				
				// 스레드 생성 
				// 기본 Thread에가 Runnable 구현체를 넘긴다.
				Thread reader = new Thread(this); 	//
				reader.start(); // 스레드 시작 => 생성자에게 받은 객체의 run() 호출
				
			} catch (Exception ex) {
				msgPane.append(ex.getMessage() + "\n");
			}
		} else if (e.getSource() == btnDisconnect) {
			disconnect();
		}
	}
		
	private void disconnect() {
		try {in.close();} catch(Exception ex) {}
		try {out.close();} catch(Exception ex) {}
		try {socket.close();} catch(Exception ex) {}
		
		in = null;
		out = null;
		socket = null;
		
		msgPane.setText("서버와의 연결을 끊었습니다.\n");
	}
	
	public static void main(String[] args) throws Exception {
		ChatClient chatClient = new ChatClient();
		chatClient.setSize(400, 300);
		chatClient.setVisible(true);
	}
	
	// Runnable 인터페이스에 선언된 메서드 정의
	@Override
	public void run() {
		while (true) {
			try {
				// 서버에서 보내는 데이터 출력
				String message = in.readLine();
				msgPane.append("[" + friendName + "] " + message + "\n");
				
			} catch (Exception ex) {
				msgPane.append(ex.getMessage() + "\n");
			}
		}
	}
}


