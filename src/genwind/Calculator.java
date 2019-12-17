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
 * 计算机视图类
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
	//是否是回退引起的
	private boolean flag=false;
	private JTextField textField = new JTextField("0",26);

	private JTextArea ta=new JTextArea(11,12);//用于算术运算的结果记录

	String operator = "";//操作

	boolean flagCharacter=true; //记录上次的字符是否为数字字符

=======

	 * 

	 */

	private static final long serialVersionUID = 1L;
	

	private JTextField textField = new JTextField("0",26);
	
    
	private JTextArea ta=new JTextArea(11,12);//用于算术运算的结果记录

	String operator = "";//操作
	
	boolean flag =  false;//判断是否进行了下次运算
	
	boolean flagCharacter=true; //记录上次的字符是否为数字字符
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
	
	Vector<String> input=new Vector<String>();//操作的式子（用于方便回退）
	
	String textWord="";//显示在文本区的文字
	
	MiddleTraRear transForm=new MiddleTraRear();  //进行算术表达式的计算
    
	public void init()//覆写Applet里边的init方法

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
		rollBackBtn.setFont(new Font("宋体",Font.BOLD,20));
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
		C.add(new JLabel("历史纪录",SwingConstants.RIGHT),BorderLayout.NORTH);//右对齐
		ta.setEditable(false);
		textField.setEditable(false);
		JScrollPane sp=new JScrollPane(ta);
        panel2.add(sp,BorderLayout.CENTER);
        panel2.add(rollBackBtn,BorderLayout.SOUTH);
=======
		JPanel panel3=new JPanel();
		
		C.add(new JLabel("历史纪录",SwingConstants.RIGHT),BorderLayout.NORTH);//右对齐
		
		JScrollPane sp=new JScrollPane(ta);
        panel2.add(sp,BorderLayout.SOUTH);
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
        
        panel1.add(textField, BorderLayout.NORTH);
		C.add(panel2,BorderLayout.EAST);

		panel3.setLayout(new GridLayout(5, 4,0,0));

		String name[]={"7","8","9","±","4","5","6","-","1","2","3","*","C","0","Back","/","(",")","+","="};//设置 按钮

		for(int i=0;i<name.length;i++)//添加按钮

		{

			b[i] = new JButton(name[i]);

			b[i].setBackground(Color.DARK_GRAY);

			b[i].setForeground(Color.WHITE);//数字键 设置为 蓝颜色

			if(!Character.isDigit(name[i].charAt(0)))//判断是否为非数字如果为非数字则将键改为红色
				b[i].setBackground(Color.RED);

			b[i].setFont(new Font("宋体",Font.BOLD,20));//设置字体格式
		

			panel3.add(b[i]);

			b[i].addActionListener(this);

		}
		
		panel1.add(panel3,BorderLayout.SOUTH);
		C.add(panel1,BorderLayout.CENTER);

	}

<<<<<<< HEAD

=======
>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
	public void actionPerformed(ActionEvent e)//键盘符号动作处理

	{    
        
		int cnt = 0;//是否为=号标识符
		
		
		String actionCommand = e.getActionCommand();//等到所按的键
		
       
		
        if(flag) {//进行下次运算
        	textField.setText("");
        	input.clear();//清楚Vector中所有元素
        	flag=false;
        }
        
		if(actionCommand.equals("+")||actionCommand.equals("-")||actionCommand.equals("*") ||actionCommand.equals("/")) {

			input.add(" "+actionCommand+" ");//设置输入，把输入的样式改成 需要的样子
			flagCharacter=true;
			
		}
		
		
		else if(actionCommand.equals("Back")) {//回退键
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

		else if(actionCommand.equals("="))//当监听到等号时，则处理 input

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
			textField.setText("");//清空编辑框
			textField.setText(input.lastElement());
			ta.append(input.lastElement()+'\n'+'\n');
			cnt = 1;
			flag=true;
			flagCharacter=true;

		}

		else {
			 if(actionCommand.equals("±")) {
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
				 input.add(actionCommand);//数字为了避免多位数的输入 不需要加空格
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

		JFrame frame = new JFrame("计算器");

		Calculator applet = new Calculator();

		frame.getContentPane().add(applet, BorderLayout.CENTER);

		applet.init();//applet的init方法

<<<<<<< HEAD
		frame.setBounds(300, 300, 500, 300);//设置窗口大小

		frame.setVisible(true);//设置窗口可见
=======
		frame.setBounds(300, 300, 450, 260);//设置窗口大小

		frame.setVisible(true);//设置窗口可见

>>>>>>> 6280c7677c3968d782e68d0b8b7df7f63f5e65d6
	}

}



