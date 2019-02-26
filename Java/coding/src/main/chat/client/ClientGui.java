package chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import chat.server.ServerBackground;

public class ClientGui extends JFrame implements ActionListener {

	private JTextArea jta;
	private JTextField jtf;
	private JScrollPane jtp;
	private JPanel jp; 
	private ClientBackground client;
	private JButton b;
	private Font f1,f2;
	private static String nickName;
	Image img = new ImageIcon("D:\\루룰룰루ㅠ률ㄹ률\\고급\\자바 채팅\\sunglasses.jpg").getImage(); //TextArea이미지삽입

	public ClientGui(){
		super(nickName+"님의 채팅창입니다");	//super로 title 이름 바꾸기
		client = new ClientBackground();
		
		//TextArea이미지삽입          스크롤내려가면 들킴
		jta = new JTextArea(40,25) {
			{ setOpaque( false ) ; }
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,null);       //이미지 그리기
                super.paintComponent(g);
            }
        };
		
		jtf = new JTextField(25);
		
		jtp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// 세로 스크롤 사용, 가로 스크롤 사용 안함
		/*VERTICAL_SCROLLBAR_AS_NEEDED : 필요할 때만 스크롤 바가 보이도록 함
		VERTICAL_SCROLLBAR_ALWAYS : 항상 스크롤바가 보이도록 함
		VERTICAL_SCROLLBAR_NEVER : 스크롤바가 보이지 않게 함*/

		//jtp = new JScrollPane(jta); 
		//컴포넌트에 스크롤 기능을 제공한다. 화면보다 더 큰 컴포넌트를 표시하기 위해서는 스크롤 기능이 필요하다.
		
		jp = new JPanel();
		
		add(jtp, BorderLayout.CENTER);
		//add(jta, BorderLayout.CENTER); //add(Component comp, Object constraint?/ int index?)
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		jta.setBackground(Color.WHITE);	//채팅방 배경을 회색으로
		jta.setEditable(false);					//TextArea 부분 Edit 금지(false)
		
		//////========버튼=========//////
		b = new JButton("나가기");

		JPanel p2 = new JPanel();			//여기에 버튼을 붙인다.
        p2.setLayout(new BorderLayout());
        p2.add(b,"East");
        p2.add(jtf);
        add(p2,"South");
        b.addActionListener(this);
        //////========버튼=========//////
        
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		//창을 보여라
		setBounds(800, 100, 400, 600);
		setResizable(false);	//창크기 고정
		//setTitle("클라이언트 부분");
		
		/*Font win_font=new Font("", Font.BOLD,12);
		setFont(win_font);*/
		//Panel connect = new Panel(); // 접속 화면(판넬)
		//setBackground(Color.LIGHT_GRAY);// 밝은 회색으로 설정
		//setLayout(new BorderLayout());


		client.setGui(this);
		client.SetNickname(nickName);
		client.connect();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대화명을 설정하세요 : ");
		nickName = sc.nextLine();
		sc.close(); 
		new ClientGui();
	}

	@Override	//view action부분
	//메시지입력하면 보내는 부분
	public void actionPerformed(ActionEvent e) {
		ServerBackground svb = new ServerBackground();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("H:mm:ss").format(date));
		
		if(e.getSource()==b) {
			
			client.sendMessage("\n"+"알림 : "+"======="+"["+nickName+"]"+"님이 나가셨습니다."+"=======\n"); 
           svb.removeClient(nickName);
            setVisible(false);
            toolkit.beep();
            return;
            //저기에서 안받아와져서 여기서 똑같은 문자열로 가라친거
            //비프음도 가라침
		}else if(jtf.getText().equals("/clear")){
			 jta.setText("");
	         jtf.setText("");
	         //채팅창을 깨끗이 지움
		}else {
		String msg = "["+nickName+"]"+ " : "+ jtf.getText()+"               "+"["+today+"]"/*+"클라gui"*/; //클라이언트에서 뜨는
		//jta.append("클라이언트 : "+msg);
		client.sendMessage("\n"+msg);
		jtf.setText("");
		}
	}

	public void appendMsg(String msg) {
		jta.append(msg);
		jta.setCaretPosition(jta.getDocument().getLength()-1);
	}
	
}
