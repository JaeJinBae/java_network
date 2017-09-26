package java_network.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

	public static void main(String[] args) {
		BufferedReader in=null;//클라이언트로부터 보낸 메시지를 읽기위한 reader
		BufferedReader stIn=null;//키보드로부터 입력받기위한 reader
		BufferedWriter out=null;//클라이언트로 보낼 writer
		
		ServerSocket listener=null;//클라이언트의 요청을 대기하는 소켓
		Socket socket=null;//클라이언트와 주고받을 소켓
		
		try {
			listener=new ServerSocket(9999);
			System.out.println("Server Ready~!!");
			socket=listener.accept();//클라이언트와 연결이 성공
			System.out.println("클라이언트와 연결이 되었습니다.");
			
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			stIn=new BufferedReader(new InputStreamReader(System.in));
			out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String clientMsg;
			while(true){
				clientMsg=in.readLine();
				if(clientMsg.equalsIgnoreCase("bye")){
					break;
				}
				System.out.println(clientMsg);
				String outputMsg=stIn.readLine();
				out.write(outputMsg);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				listener.close();
				/*out.close();
				in.close();
				stIn.close();*/
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
