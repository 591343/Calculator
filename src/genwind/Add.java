package genwind;

public class Add extends Operation {
    @Override
    public double getResult() {
        return getX()+getY();
    }
}
