public class Sub extends Operator 
{
    Sub(){ super('-'); }

    @Override
    public double Evaluate(double lhs, double rhs) {
        return lhs-rhs;
    }
}
