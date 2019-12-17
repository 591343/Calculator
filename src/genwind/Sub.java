package genwind;

public class Sub extends Operation {
    @Override
    public double getResult() {
        return getX()-getY();
    }
}
