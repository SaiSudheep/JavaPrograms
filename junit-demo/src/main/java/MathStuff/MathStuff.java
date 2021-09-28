package MathStuff;

public class MathStuff {

    public boolean isPositive(int n) {
        if(n > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int add(int a, int b) {
        return a+b;
    }

    public String divide(double a, double b) {
        if(b == 0) {
            return "Cannot be divided";
        } else {
            return String.valueOf(a/b);
        }
    }
}
