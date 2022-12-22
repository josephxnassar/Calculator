public class Sqrt extends Operator
{
    Sqrt(){ super('v'); }

    @Override
    public double Evaluate(double lhs, double rhs) {
        return Math.sqrt(lhs);
    }
}
