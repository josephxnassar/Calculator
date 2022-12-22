public class Div extends Operator
{
    Div(){ super('/'); }
    //me

    @Override
    public double Evaluate(double lhs, double rhs) {
        return lhs/rhs;
    }
}
