public class Add extends Operator
{
    Add(){ super('+'); }
    //me

    @Override
    public double Evaluate(double lhs, double rhs) {
        return lhs+rhs; 
    }
}
