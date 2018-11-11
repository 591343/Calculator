package genwind;

import java.util.Stack;

class MiddleTraRear {
	   
	   Stack<Character> Symble=new Stack<Character>();//操作符存储栈
	   
	   char []yunsuanfu=new char[]{'-','+','/','*'};//运算符优先级数组
	   
	   public  String tranRear(String input) {
		   String str[];
		   
		   str=input.split(" ");//将运算表达式各个对象拆分开，便于计算
		   input="";
		   
     boolean flag=true;//判断"±"是否被添加过		   
		   
		   String result="";//中缀转后缀的结果
		     
		   for(int i=0;i<str.length;i++) {
			   
			   flag=true;
			   int priorityI=-1;
			   int priorityS=-1;
			   
			   if(str[i].charAt(0)=='±') {
				   result+=(str[i]+" ");
				   flag=false;   
			   }
			   
			if(flag) {   
			   if(Character.isDigit(str[i].charAt(0))) {
				   result+=(str[i]+" ");//如果为运算数则直接输出
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
						   Symble.pop();//弹出(
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
	    	   
	    	   if(a.equals('±')) {//去掉字符串前的“±”
	    		   for(int k=1;k<str[i].length();k++) {
	    			  x+=str[i].charAt(k); 
	    		   }
	    		 
	    		   
	    		number.push(-Double.parseDouble(x));//将前面带"±"的字符串转换为负数   
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
		