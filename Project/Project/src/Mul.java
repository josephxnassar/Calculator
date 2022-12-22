public class Mul extends Operator
{
    Mul(){ super('*'); }

    // me
    @Override
    public double Evaluate(double lhs, double rhs) {
        return lhs*rhs;
    }
}