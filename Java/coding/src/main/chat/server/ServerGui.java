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
	//연동 생성자에서 객체 생성
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
		setTitle("서버");
		
		server.setGui(this); //ServerGui가 server에 있는 setGui에게 '여기로 가져와'
		server.setting();//서버가 세팅이 되게 한다. / GUI가 실행될때 서버도 같이 동작하도록
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대화명을 설정하세요 : ");
		nickName = sc.nextLine();
		sc.close(); 
		new ServerGui();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		////////////////시간표시/////////////////
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("H:mm:ss").format(date));
		////////////////시간표시/////////////////
		
		String msg = "["+nickName+"]"+" : "+jtf.getText()+"\t서버gui";
		jta.append(/*"\n"+*/msg+"["+today+"]\n"); //지정된 텍스트를 문서 끝부분에 붙임(여기선 \n)
		//서버측에서 출력되는 부분
		System.out.print(msg);
		server.sendMessage(msg+"["+today+"]\n"); //서버에게 이 메시지 전송해줘. / 현재시간추가
		jtf.setText("");
	}
	public void appendMsg(String msg) {
		jta.append(msg); 
		jta.setCaretPosition(jta.getDocument().getLength()-1);
		System.out.print("클라이언트에서 보내온 메시지 :"+msg);
		
	}
}
