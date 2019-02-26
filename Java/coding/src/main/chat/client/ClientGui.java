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
	Image img = new ImageIcon("D:\\�����з�����\\���\\�ڹ� ä��\\sunglasses.jpg").getImage(); //TextArea�̹�������

	public ClientGui(){
		super(nickName+"���� ä��â�Դϴ�");	//super�� title �̸� �ٲٱ�
		client = new ClientBackground();
		
		//TextArea�̹�������          ��ũ�ѳ������� ��Ŵ
		jta = new JTextArea(40,25) {
			{ setOpaque( false ) ; }
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,null);       //�̹��� �׸���
                super.paintComponent(g);
            }
        };
		
		jtf = new JTextField(25);
		
		jtp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// ���� ��ũ�� ���, ���� ��ũ�� ��� ����
		/*VERTICAL_SCROLLBAR_AS_NEEDED : �ʿ��� ���� ��ũ�� �ٰ� ���̵��� ��
		VERTICAL_SCROLLBAR_ALWAYS : �׻� ��ũ�ѹٰ� ���̵��� ��
		VERTICAL_SCROLLBAR_NEVER : ��ũ�ѹٰ� ������ �ʰ� ��*/

		//jtp = new JScrollPane(jta); 
		//������Ʈ�� ��ũ�� ����� �����Ѵ�. ȭ�麸�� �� ū ������Ʈ�� ǥ���ϱ� ���ؼ��� ��ũ�� ����� �ʿ��ϴ�.
		
		jp = new JPanel();
		
		add(jtp, BorderLayout.CENTER);
		//add(jta, BorderLayout.CENTER); //add(Component comp, Object constraint?/ int index?)
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		jta.setBackground(Color.WHITE);	//ä�ù� ����� ȸ������
		jta.setEditable(false);					//TextArea �κ� Edit ����(false)
		
		//////========��ư=========//////
		b = new JButton("������");

		JPanel p2 = new JPanel();			//���⿡ ��ư�� ���δ�.
        p2.setLayout(new BorderLayout());
        p2.add(b,"East");
        p2.add(jtf);
        add(p2,"South");
        b.addActionListener(this);
        //////========��ư=========//////
        
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		//â�� ������
		setBounds(800, 100, 400, 600);
		setResizable(false);	//âũ�� ����
		//setTitle("Ŭ���̾�Ʈ �κ�");
		
		/*Font win_font=new Font("", Font.BOLD,12);
		setFont(win_font);*/
		//Panel connect = new Panel(); // ���� ȭ��(�ǳ�)
		//setBackground(Color.LIGHT_GRAY);// ���� ȸ������ ����
		//setLayout(new BorderLayout());


		client.setGui(this);
		client.SetNickname(nickName);
		client.connect();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȭ���� �����ϼ��� : ");
		nickName = sc.nextLine();
		sc.close(); 
		new ClientGui();
	}

	@Override	//view action�κ�
	//�޽����Է��ϸ� ������ �κ�
	public void actionPerformed(ActionEvent e) {
		ServerBackground svb = new ServerBackground();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		String today = (new SimpleDateFormat("H:mm:ss").format(date));
		
		if(e.getSource()==b) {
			
			client.sendMessage("\n"+"�˸� : "+"======="+"["+nickName+"]"+"���� �����̽��ϴ�."+"=======\n"); 
           svb.removeClient(nickName);
            setVisible(false);
            toolkit.beep();
            return;
            //���⿡�� �ȹ޾ƿ����� ���⼭ �Ȱ��� ���ڿ��� ����ģ��
            //�������� ����ħ
		}else if(jtf.getText().equals("/clear")){
			 jta.setText("");
	         jtf.setText("");
	         //ä��â�� ������ ����
		}else {
		String msg = "["+nickName+"]"+ " : "+ jtf.getText()+"               "+"["+today+"]"/*+"Ŭ��gui"*/; //Ŭ���̾�Ʈ���� �ߴ�
		//jta.append("Ŭ���̾�Ʈ : "+msg);
		client.sendMessage("\n"+msg);
		jtf.setText("");
		}
	}

	public void appendMsg(String msg) {
		jta.append(msg);
		jta.setCaretPosition(jta.getDocument().getLength()-1);
	}
	
}
