package genwind;

import java.util.Stack;
import java.util.Vector;

/**
 * @author chenxiao
 * @date 工具类
 */
public class Util {
    //字符转换方法
    public static String convertToString(Vector<String> a) {
        String outcome="";

        for(int i=0;i<a.size();i++) {
            outcome+=a.get(i);
        }

        return outcome;
    }

    //输入数据计算方法
    public static String compute(String input) {

        Stack<Double> number=new Stack<Double>();
        double  rear=0;
        String []str;
        String x="";
        str=input.split(" ");

        for(int i=0;i<str.length;i++) {
            Character a = (char) str[i].charAt(0);

            if (a.equals('±')) {//去掉字符串前的“±”
                for (int k = 1; k < str[i].length(); k++) {
                    x += str[i].charAt(k);
                }
                number.push(-Double.parseDouble(x));//将前面带"±"的字符串转换为负数
            }


            //number.push(-Double.parseDouble())
            if (Character.isDigit((char) a)) {
                number.push(Double.parseDouble(str[i]));
            } else {
                //四则运算计算处
                rear = number.pop();
                Operation operation = OperationFactory.creatOperation(str[i]);
                operation.setX(number.pop());
                operation.setY(rear);
                number.push(operation.getResult());

            }
        }

        return number.pop().toString();
    }
}
