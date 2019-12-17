package genwind;

/**
 * 工厂类
 */
public class OperationFactory {

   public  static  Operation creatOperation(String oper){
     Operation operation=null;
     switch (oper){
         case "+":
             operation=new Add();
             break;
         case "-":
             operation=new Sub();
             break;
         case "*":
             operation=new Mul();
             break;
         case "/":
             operation=new Div();
             break;
         default:
             System.out.println("输入操作符有误");
     }

     return operation;
   }
}
