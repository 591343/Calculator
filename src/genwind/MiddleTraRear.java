package genwind;

import java.util.Stack;

class MiddleTraRear {
	   
	   Stack<Character> Symble=new Stack<Character>();//�������洢ջ
	   
	   char []yunsuanfu=new char[]{'-','+','/','*'};//��������ȼ�����
	   
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
	   
	   
	  public  String compute(String input) {
		  
		  Stack<Double>number=new Stack<Double>();
		  double  rear=0;
		  String []str;
		  String x="";
		  str=input.split(" ");
		  
	       for(int i=0;i<str.length;i++) {
	    	   Character a=(char)str[i].charAt(0);
	    	   
	    	   if(a.equals('��')) {//ȥ���ַ���ǰ�ġ�����
	    		   for(int k=1;k<str[i].length();k++) {
	    			  x+=str[i].charAt(k); 
	    		   }
	    		 
	    		   
	    		number.push(-Double.parseDouble(x));//��ǰ���"��"���ַ���ת��Ϊ����   
	    	   }
	    	   
	    	   
	    		   //number.push(-Double.parseDouble())
	    	   if(Character.isDigit((char)a)) {
	    		   number.push(Double.parseDouble(str[i]));
	    	   }
	    	   
	    	   else {
	    		   switch(str[i]) {
	    		   case "-":
	    			   rear=number.pop();
	    			   number.push(number.pop()-rear);
	    			  
	    			   break;
	    		   case "+":
	    			   rear=number.pop();
	    			   number.push(number.pop()+rear); 
	    			  
	    			   break;
	    			   
	    		   case "*":
	    			   rear=number.pop();
	    			   number.push(number.pop()*rear); 
	    			 
	    			   break;
	    			   
	    		   case "/":
	    			   rear=number.pop();
	    			   number.push(number.pop()/rear); 
	    			   
	    			   break;
	    			   
	    			   default:
	    		   }
	    		   
	    	   }
	       }
	       
	       return number.pop().toString();
	       
	  }
}
		