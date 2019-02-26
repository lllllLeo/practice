package chat.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGui extends JFrame implements ActionListener{

	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jtp;
	//���� �����ڿ��� ��ü ����
	private ServerBackground server;
	private static String nickName;
	
	public ServerGui() {

		server = new ServerBackground();
		jta = new JTextArea(40,25);
		jtf = new JTextField(25);
		jtp = new JScrollPane(jta);
		
		add(jtp, BorderLayout.CENTER);
		//add(jta, BorderLayout.CENTER); //add(Component comp, Object constraint?/ int index?)
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200, 100, 400, 600);
		setTitle("����");
		
		server.setGui(this); //ServerGui�� server�� �ִ� setGui���� '����� ������'
		server.setting();//������ ������ �ǰ� �Ѵ�. / GUI�� ����ɶ� ������ ���� �����ϵ���
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȭ���� �����ϼ��� : ");
		nickName = sc.nextLine();
		sc.close(); 
		new ServerGui();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		////////////////�ð�ǥ��/////////////////
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("H:mm:ss").format(date));
		////////////////�ð�ǥ��/////////////////
		
		String msg = "["+nickName+"]"+" : "+jtf.getText()+"\t����gui";
		jta.append(/*"\n"+*/msg+"["+today+"]\n"); //������ �ؽ�Ʈ�� ���� ���κп� ����(���⼱ \n)
		//���������� ��µǴ� �κ�
		System.out.print(msg);
		server.sendMessage(msg+"["+today+"]\n"); //�������� �� �޽��� ��������. / ����ð��߰�
		jtf.setText("");
	}
	public void appendMsg(String msg) {
		jta.append(msg); 
		jta.setCaretPosition(jta.getDocument().getLength()-1);
		System.out.print("Ŭ���̾�Ʈ���� ������ �޽��� :"+msg);
		
	}
}
