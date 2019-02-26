package chat.client;

import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientBackground {

	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ClientGui gui;
	private String msg;
	private String nickName;
	
	
	public final void setGui(ClientGui gui) {
		this.gui = gui;
	}
	//Ŭ���̾�Ʈ ������ �Ϸ�Ǹ�
	public void connect() {
		try {
			socket = new Socket("172.22.201.57", 7777);
			System.out.println("���� r�����");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			
			out.writeUTF(nickName); //�������ڸ��� �г��� �����ϸ�, ������ �̰� �г������� �ν��� �ϰ� �ʿ� ���� ����
			//out.writeUTF("���� Ŭ���̾�Ʈ�� ���Ͽ�\n");
			System.out.println("�޽��� ���ۿϷ�");
			
			while(in!=null) {
				msg=in.readUTF();
				gui.appendMsg(msg); //gui�� �޼��� �߰�
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ClientBackground clientbackground = new ClientBackground();
		clientbackground.connect();
		
	}
	public void sendMessage(String msg2) {
		try {
			out.writeUTF(msg2);
		} catch (IOException e) {
		}
	}
	public void SetNickname(String nickName) {
		this.nickName = nickName;
	}
}
