public class Pow extends Operator
{
    Pow(){ super('^'); }

    @Override
    public double Evaluate(double lhs, double rhs) {
        return Math.pow(lhs, rhs);
    }
}
