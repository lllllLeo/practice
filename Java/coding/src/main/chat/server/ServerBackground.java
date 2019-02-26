package chat.server;

import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServerBackground {

	//1. Ŭ���̾�Ʈ���� ������ �޽����ֱ�
	//2. GUI �����
	//3. �������� Ŭ���̾�Ʈ�� �޽��� �ֱ� / Ŭ��� ���� ����
	private ServerSocket serverSocket; 	//���� ����
	private Socket socket; // �͸� ������ / �޾ƿ� ���� ����
	private ServerGui gui;
	private String msg;
	
	
	//����° �߿��Ѱ�. ����ڵ��� ������ �����ϴ� ���̴�
	private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();
	
	public final void setGui(ServerGui gui) {
		this.gui = gui;
	}
	//������ �����ɶ� �������ִ� �Լ�
	public void setting() {
		try {
			Collections.synchronizedMap(clientsMap); //���� �������� ���ش�.
			//clientMap�� ��Ʈ��ũ ó�����ִ°�
			serverSocket = new ServerSocket(9998);// 7777��Ʈ�� ����ϰڴ�

			while (true) { //������ �� �� : �湮�ڸ� ��� �޾Ƽ� ������ ���ù��� ��� ����
				//1. ù��°. ������ ���� �д�. ��� ���� �޴� �� ��� ���ӹ޾Ƽ� accept�� ��� ������ ������
				System.out.println("�����"); // Ŭ���̾�Ʈ�� ���ö����� ���
				socket = serverSocket.accept(); // ������ �������Ͽ��� ���Ÿ�°� //���� ������ ������ ��� �ݺ��ؼ� ����ڸ� �޴´�.
				System.out.println(socket.getInetAddress() + "���� �����߽��ϴ�.");
				// ���⼭ ���ο� ����� ������ Ŭ���� �����ؼ� ���������� �־�����Ѵ�
				
				Receiver receiver = new Receiver(socket);
				receiver.start(); //������ ����
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}
	// ���� ����(Ŭ���̾�Ʈ) ����� ����
	private void addClient(String nick, DataOutputStream out) {
		String message = "\n"+"�˸� : "+"======="+"["+nick+"]"+"���� �����ϼ̽��ϴ�."+"=======\n";
		sendMessage(message);
		gui.appendMsg(message);
		clientsMap.put(nick,out);
		/*sendMessage(nick+"���� �����ϼ̽��ϴ�.\n");
		clientsMap.put(nick, out);*/
	}
	public void removeClient(String nick) {
		String message ="\n"+"�˸� : "+"======="+"["+nick+"]"+"���� �����̽��ϴ�."+"=======\n";
		sendMessage(message);
		gui.appendMsg(message);
		clientsMap.remove(nick);
		/*sendMessage(nick+"���� �����̽��ϴ�.\n");
		clientsMap.remove(nick);*/
	}
	//���� ����
	public void sendMessage(String msg) {
		Iterator<String> it = clientsMap.keySet().iterator(); //key������ �ݺ�������
		//�ϳ��� �̾Ƴ���
		String key;
		while(it.hasNext()) { //�ݺ��ڿ��� �ϳ��ϳ� Ű�� ���´�
			try {
				key = it.next();
				clientsMap.get(key).writeUTF(msg); //�޽����� ������ ��
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	//=============================================================
	class Receiver extends Thread{
		//2. ���ù��� ������ �ڱ� ȥ�ڼ� ��Ʈ��ũ ������ �޾Ƽ� ��� ���, ��û�ϴ� ��.
		private DataInputStream in;
		private DataOutputStream out;
		// ���Ͽ��� outputstream�� ��´�
		private String nick;
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();	//������ ��Ŷ�� �����
		
		////////////////�ð�ǥ��/////////////////
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("H:mm:ss").format(date));
		////////////////�ð�ǥ��/////////////////
		
		public Receiver(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				
				//���ù��� ó������ Ŭ���̾�Ʈ ���̵� �޾ƿ��� �ʹ�
				nick = in.readUTF();
				addClient(nick, out);
				toolkit.beep();					//�����ϸ� �������� ����.
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		@Override
		public void run() {
			try {
				//��� ��⸸
				while(in!=null) {
					msg=in.readUTF();	//UTF�� �о���δ�.
					sendMessage(msg);
					gui.appendMsg(msg+"\n"/*+"["+today+"]\n"+"������κ�"*/);	//����ð��߰�
					
				}
			} catch (IOException e) {
				//��� ���ӽ� ���⼭ ���� �߻� ���⼭ ������ Ŭ���̾�Ʈ ����
				removeClient(nick);
				toolkit.beep();					//�����ϸ� �������� ����.
			}
			
		}
	}
}
