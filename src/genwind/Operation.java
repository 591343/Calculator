package genwind;

/**
 * @author: 陈晓
 * @date: 2019/12/17
 * 简单工厂模式
 */
public  abstract class Operation {
    private  double x;
    private  double y;
    //获得运算结果
    public   abstract double getResult();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
