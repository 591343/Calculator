package genwind;

public class Div extends Operation {
    @Override
    public double getResult() {
        double result=0.0;
        try {
            result=getX()/getY();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
