package genwind;

public class Mul extends Operation {
    @Override
    public double getResult() {
        return getX()*getY();
    }
}
