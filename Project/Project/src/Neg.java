public class Neg extends Operator
{
    Neg(){ super('-'); }

    @Override
    public double Evaluate(double lhs, double rhs) {
        if (lhs == 0) {
            return -rhs;
        }
        else if (rhs == 0) {
            return -lhs;
        }
        return 0;
    }
}