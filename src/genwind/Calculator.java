package genwind;


import java.awt.*;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Container;

import java.awt.Font;

import java.awt.GridLayout;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.Stack;
import java.util.Vector;

import javax.swing.JApplet;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import genwind.MiddleTraRear;

<<<<<<< HEAD
/**
 * @author: chenxiao
 * @date: 2019/12/17
 * �������ͼ��
 */

=======

 
 
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6

public class Calculator extends JApplet implements ActionListener

{
	/**
<<<<<<< HEAD
	 *
	 */

	private static final long serialVersionUID = 1L;
	private JButton rollBackBtn=new JButton("RollBack");
	private ComputationInfo computationInfo;
	private Caretaker c;
	//�Ƿ��ǻ��������
	private boolean flag=false;
	private JTextField textField = new JTextField("0",26);

	private JTextArea ta=new JTextArea(11,12);//������������Ľ����¼

	String operator = "";//����

	boolean flagCharacter=true; //��¼�ϴε��ַ��Ƿ�Ϊ�����ַ�

=======

	 * 

	 */

	private static final long serialVersionUID = 1L;
	

	private JTextField textField = new JTextField("0",26);
	
    
	private JTextArea ta=new JTextArea(11,12);//������������Ľ����¼

	String operator = "";//����
	
	boolean flag =  false;//�ж��Ƿ�������´�����
	
	boolean flagCharacter=true; //��¼�ϴε��ַ��Ƿ�Ϊ�����ַ�
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
	
	Vector<String> input=new Vector<String>();//������ʽ�ӣ����ڷ�����ˣ�
	
	String textWord="";//��ʾ���ı���������
	
	MiddleTraRear transForm=new MiddleTraRear();  //�����������ʽ�ļ���
    
	public void init()//��дApplet��ߵ�init����

	{

		Container C = getContentPane();

		JButton b[] = new JButton[20];

		JPanel panel1= new JPanel();
		JPanel panel2=  new JPanel();
<<<<<<< HEAD
		panel2.setLayout(new BorderLayout());
		JPanel panel3=new JPanel();
		computationInfo=new ComputationInfo();
		c=new Caretaker();
		rollBackBtn.setFont(new Font("����",Font.BOLD,20));
		rollBackBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				computationInfo.restoreMemento(c.getMemento());
				textField.setText(Util.convertToString(computationInfo.getInfo()));
				input=computationInfo.getInfo();
				flag=false;
				System.out.println(input.toString());

			}
		});
		C.add(new JLabel("��ʷ��¼",SwingConstants.RIGHT),BorderLayout.NORTH);//�Ҷ���
		ta.setEditable(false);
		textField.setEditable(false);
		JScrollPane sp=new JScrollPane(ta);
        panel2.add(sp,BorderLayout.CENTER);
        panel2.add(rollBackBtn,BorderLayout.SOUTH);
=======
		JPanel panel3=new JPanel();
		
		C.add(new JLabel("��ʷ��¼",SwingConstants.RIGHT),BorderLayout.NORTH);//�Ҷ���
		
		JScrollPane sp=new JScrollPane(ta);
        panel2.add(sp,BorderLayout.SOUTH);
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
        
        panel1.add(textField, BorderLayout.NORTH);
		C.add(panel2,BorderLayout.EAST);

		panel3.setLayout(new GridLayout(5, 4,0,0));

		String name[]={"7","8","9","��","4","5","6","-","1","2","3","*","C","0","Back","/","(",")","+","="};//���� ��ť

		for(int i=0;i<name.length;i++)//��Ӱ�ť

		{

			b[i] = new JButton(name[i]);

			b[i].setBackground(Color.DARK_GRAY);

			b[i].setForeground(Color.WHITE);//���ּ� ����Ϊ ����ɫ

			if(!Character.isDigit(name[i].charAt(0)))//�ж��Ƿ�Ϊ���������Ϊ�������򽫼���Ϊ��ɫ
				b[i].setBackground(Color.RED);

			b[i].setFont(new Font("����",Font.BOLD,20));//���������ʽ
		

			panel3.add(b[i]);

			b[i].addActionListener(this);

		}
		
		panel1.add(panel3,BorderLayout.SOUTH);
		C.add(panel1,BorderLayout.CENTER);

	}

<<<<<<< HEAD

=======
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
	public void actionPerformed(ActionEvent e)//���̷��Ŷ�������

	{    
        
		int cnt = 0;//�Ƿ�Ϊ=�ű�ʶ��
		
		
		String actionCommand = e.getActionCommand();//�ȵ������ļ�
		
       
		
        if(flag) {//�����´�����
        	textField.setText("");
        	input.clear();//���Vector������Ԫ��
        	flag=false;
        }
        
		if(actionCommand.equals("+")||actionCommand.equals("-")||actionCommand.equals("*") ||actionCommand.equals("/")) {

			input.add(" "+actionCommand+" ");//�������룬���������ʽ�ĳ� ��Ҫ������
			flagCharacter=true;
			
		}
		
		
		else if(actionCommand.equals("Back")) {//���˼�
<<<<<<< HEAD
				if(input.size()>0) {
					input.remove(input.size() - 1);
					textField.setText(Util.convertToString(input));
				}
=======
                input.remove(input.size()-1);
                textField.setText(convertToString(input));
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
                
		}
		else if(actionCommand.equals("(")) { 
			input.add(actionCommand+" ");
			
		}
<<<<<<< HEAD

		else if(actionCommand.equals(")")) {
		   input.add(" "+actionCommand);
		}

=======
		   
		
		
		else if(actionCommand.equals(")")) {
		   input.add(" "+actionCommand);
		}
		
		    
		
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
		else if(actionCommand.equals("C")) {
			
			input.clear();
			textField.setText("0");
			
		}

		else if(actionCommand.equals("="))//���������Ⱥ�ʱ������ input

		{
<<<<<<< HEAD

			textWord = Util.convertToString(input);
			Vector<String> inputC=(Vector<String>) input.clone();

		    computationInfo.setInfo(inputC);
		    c.setMemento(computationInfo.saveMemento());
		    ta.append(textWord+"="+'\n');
			input.add(Util.compute(transForm.tranRear(textWord)));
=======
		    textWord=convertToString(input);
		    ta.append(textWord+'\n');
			input.add(transForm.compute(transForm.tranRear(textWord)));
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
			textField.setText("");//��ձ༭��
			textField.setText(input.lastElement());
			ta.append(input.lastElement()+'\n'+'\n');
			cnt = 1;
			flag=true;
			flagCharacter=true;

		}

		else {
			 if(actionCommand.equals("��")) {
				if(!flagCharacter) {
					input.add(" "+actionCommand);
				}
				     
				else { 
					input.add(actionCommand);
				}
<<<<<<< HEAD
=======
				
				               
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
			 }
			 
			 else{
				 input.add(actionCommand);//����Ϊ�˱����λ�������� ����Ҫ�ӿո�
				 flagCharacter=false;
			     }
			
		}
<<<<<<< HEAD
		if(cnt==0)
		textField.setText(Util.convertToString(input));
	}
	



	public static void main(String args[])
=======

		if(cnt==0)

		textField.setText(convertToString(input));

	}
	
	public static String convertToString(Vector<String> a) {
	String outcome="";
	
	
	for(int i=0;i<a.size();i++) {
	    outcome+=a.get(i);	
	}
	
	return outcome;
	}

	public static void main(String args[])

>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
	{

		JFrame frame = new JFrame("������");

		Calculator applet = new Calculator();

		frame.getContentPane().add(applet, BorderLayout.CENTER);

		applet.init();//applet��init����

<<<<<<< HEAD
		frame.setBounds(300, 300, 500, 300);//���ô��ڴ�С

		frame.setVisible(true);//���ô��ڿɼ�
=======
		frame.setBounds(300, 300, 450, 260);//���ô��ڴ�С

		frame.setVisible(true);//���ô��ڿɼ�

>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
	}

}



