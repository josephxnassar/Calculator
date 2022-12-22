public abstract class Operator 
{
    private char op;

    Operator(char newOp)
    {
        this.op = newOp;
    }

    public char getOp(){ return this.op; }

    public abstract double Evaluate(double lhs, double rhs);
}
