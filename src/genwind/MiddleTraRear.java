package genwind;

import java.util.Stack;

/**
 * @author chenxiao
 * @date 2019/12/17
 * 中缀转后缀类
 */
class MiddleTraRear {
	   
	   Stack<Character> Symble=new Stack<Character>();//操作符存储栈
	   
	   char []yunsuanfu=new char[]{'-','+','/','*'};//运算符优先级数组

	   //中缀表达式转后缀表达式
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
	   
	   

}
		