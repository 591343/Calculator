package genwind;

import java.util.Stack;

/**
 * @author chenxiao
 * @date 2019/12/17
 * ��׺ת��׺��
 */
class MiddleTraRear {
	   
	   Stack<Character> Symble=new Stack<Character>();//�������洢ջ
	   
	   char []yunsuanfu=new char[]{'-','+','/','*'};//��������ȼ�����

	   //��׺���ʽת��׺���ʽ
	   public  String tranRear(String input) {
		   String str[];
		   
		   str=input.split(" ");//��������ʽ���������ֿ������ڼ���
		   input="";
		   
		   boolean flag=true;//�ж�"��"�Ƿ���ӹ�
		   
		   String result="";//��׺ת��׺�Ľ��
		     
		   for(int i=0;i<str.length;i++) {
			   
			   flag=true;
			   int priorityI=-1;
			   int priorityS=-1;
			   
			   if(str[i].charAt(0)=='��') {
				   result+=(str[i]+" ");
				   flag=false;   
			   }
			   
			if(flag) {   
			   if(Character.isDigit(str[i].charAt(0))) {
				   result+=(str[i]+" ");//���Ϊ��������ֱ�����
			   }
			   else {
				   if(Symble.isEmpty()) {
					   Symble.push(str[i].charAt(0));
				   }
				   
				   else {
					   for(int j=0;j<yunsuanfu.length;j++) {
						   if(yunsuanfu[j]==str[i].charAt(0))
							   priorityI=j;
						   if(yunsuanfu[j]==Symble.peek())
							   priorityS=j;	   
					   }
					   
					   if(str[i].charAt(0)=='(') 
						   Symble.push('(');
					   
				       else if(str[i].charAt(0)==')') {
						   while(Symble.peek()!='('){
							   result+=(Symble.pop()+" ");
						   }
						   Symble.pop();//����(
					   }
					   
				       else if(priorityI>priorityS)
				    	   Symble.push(str[i].charAt(0));
					   
				       else {
					     while(priorityI<=priorityS&&Symble.empty()!=true)
					   {
	                       result+=(Symble.pop()+" ");
						  stop: for(int j=0;j<yunsuanfu.length;j++) {
							   if(Symble.empty())
									   break stop;
							   if(Symble.peek()==yunsuanfu[j]) {
								   priorityS=j;
							   }
					        }
					   }
					     Symble.push(str[i].charAt(0));
				   }
			   }
		   }
		      
}
}
		   while(Symble.empty()!=true) {
	       	result+=(Symble.pop()+" ");
	       }
		   return result;
	   }
	   
	   

}
		