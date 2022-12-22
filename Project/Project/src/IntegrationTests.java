import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.powermock.api.mockito.PowerMockito;

// TOP DOWN INTEGRATION TESTS
public class IntegrationTests {

    // Run Java file BVA
    public static void main(String[] args) throws Exception
    {
        // Nathan
        integrateAddConstructor(Double.MAX_VALUE *-1.0);
        integrateAddConstructor(Double.MAX_VALUE *-1.0 + 1.0);
        integrateAddConstructor(0.0);
        integrateAddConstructor(Double.MAX_VALUE-1.0);
        integrateAddConstructor(Double.MAX_VALUE);
        
        integrateAdd(Double.MAX_VALUE *-1.0);
        integrateAdd(Double.MAX_VALUE *-1.0 + 1.0);
        integrateAdd(0.0);
        integrateAdd(Double.MAX_VALUE-1.0);
        integrateAdd(Double.MAX_VALUE);

        integrateSub(Double.MAX_VALUE *-1.0);
        integrateSub(Double.MAX_VALUE *-1.0 + 1.0);
        integrateSub(0.0);
        integrateSub(Double.MAX_VALUE-1.0);
        integrateSub(Double.MAX_VALUE);

        integrateMul(Double.MAX_VALUE *-1.0);
        integrateMul(Double.MAX_VALUE *-1.0 + 1.0);
        integrateMul(0.0);
        integrateMul(Double.MAX_VALUE-1.0);
        integrateMul(Double.MAX_VALUE);

        // Hannah
        
        integrateDiv(Double.MAX_VALUE *-1.0);
        integrateDiv(Double.MAX_VALUE *-1.0 + 1.0);
        integrateDiv(0.0);
        integrateDiv(Double.MAX_VALUE-1.0);
        integrateDiv(Double.MAX_VALUE);

        integratePow(Double.MAX_VALUE *-1.0);
        integratePow(Double.MAX_VALUE *-1.0 + 1.0);
        integratePow(0.0);
        integratePow(Double.MAX_VALUE-1.0);
        integratePow(Double.MAX_VALUE);

        integrateSqrt(Double.MAX_VALUE *-1.0);
        integrateSqrt(Double.MAX_VALUE *-1.0 + 1.0);
        integrateSqrt(0.0);
        integrateSqrt(Double.MAX_VALUE-1.0);
        integrateSqrt(Double.MAX_VALUE);
        
        //integrateNeg(Double.MAX_VALUE *-1.0);
        //integrateNeg(Double.MAX_VALUE *-1.0 + 1.0);
        integrateNeg(0.0);
        integrateNeg(Double.MAX_VALUE-1.0);
        integrateNeg(Double.MAX_VALUE);
        
    }

    public static void integrateAddConstructor(double num1) throws Exception
    {
        Add add = new Add();
        Add spyAdd = PowerMockito.spy(add);

        Sub sub = new Sub();
        Sub spySub = PowerMockito.spy(sub);

        Mul mul = new Mul();
        Mul spyMul = PowerMockito.spy(mul);

        Div div = new Div();
        Div spyDiv = PowerMockito.spy(div);

        Pow pow = new Pow();
        Pow spyPow = PowerMockito.spy(pow);

        Sqrt sqrt = new Sqrt();
        Sqrt spySqrt = PowerMockito.spy(sqrt);

        Neg neg = new Neg();
        Neg spyNeg = PowerMockito.spy(neg);

        double divValue = num1/2.0;
        double subValue = num1-1.0;
        double mulValue = num1 * 2.0;

        // Stubbing
        PowerMockito.whenNew(Add.class).withAnyArguments().thenReturn(spyAdd);
        PowerMockito.when(spyAdd.Evaluate(num1 - 1, 1.0)).thenReturn(num1);

        PowerMockito.whenNew(Sub.class).withAnyArguments().thenReturn(spySub);
        PowerMockito.when(spySub.Evaluate(num1, 1.0)).thenReturn(subValue);

        PowerMockito.whenNew(Mul.class).withAnyArguments().thenReturn(spyMul);
        PowerMockito.when(spyMul.Evaluate(num1 , 2.0)).thenReturn(mulValue);

        PowerMockito.whenNew(Div.class).withAnyArguments().thenReturn(spyDiv);
        PowerMockito.when(spyDiv.Evaluate(num1 , 2.0)).thenReturn(divValue);

        PowerMockito.whenNew(Pow.class).withAnyArguments().thenReturn(spyPow);
        when(spyPow.Evaluate(num1, 2.0)).thenReturn(Math.pow(num1, 2.0));

        PowerMockito.whenNew(Sqrt.class).withAnyArguments().thenReturn(spySqrt);
        when(spySqrt.Evaluate(num1, 2.0)).thenReturn(Math.sqrt(num1));

        PowerMockito.whenNew(Neg.class).withAnyArguments().thenReturn(spyNeg);
        when(spyNeg.Evaluate(num1, 0.0)).thenReturn(num1*-1);
        
        // Main function call to check
        double[] result = GUI.doMain(num1);
        double[] testResults = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        int i = 0;

        // Run Stubs
        testResults[0] = spyAdd.Evaluate(num1 - 1, 1.0);
        testResults[1] = spySub.Evaluate(num1, 1.0);
        testResults[2] = spyMul.Evaluate(num1, 2.0);
        testResults[3] = spyDiv.Evaluate(num1, 2.0);
        testResults[4] = spyPow.Evaluate(num1, 2.0);
        testResults[5] = spySqrt.Evaluate(num1 , 2.0);
        testResults[6] = spyNeg.Evaluate(num1, 0.0);

        for (double num : result) 
        {
            assertEquals(num, testResults[i], 0);
            i++;
        }

        System.out.print("IntegrateAddConstructor: " + testResults[0] + " Passed\n");
    }

    public static void integrateAdd(double num1) throws Exception
    {
        Sub sub = new Sub();
        Sub spySub = PowerMockito.spy(sub);

        Mul mul = new Mul();
        Mul spyMul = PowerMockito.spy(mul);

        Div div = new Div();
        Div spyDiv = PowerMockito.spy(div);

        Pow pow = new Pow();
        Pow spyPow = PowerMockito.spy(pow);

        Sqrt sqrt = new Sqrt();
        Sqrt spySqrt = PowerMockito.spy(sqrt);

        Neg neg = new Neg();
        Neg spyNeg = PowerMockito.spy(neg);

        double divValue = num1/2.0;
        double subValue = num1-1.0;
        double mulValue = num1 * 2.0;

        // Stubbing

        PowerMockito.whenNew(Sub.class).withAnyArguments().thenReturn(spySub);
        PowerMockito.when(spySub.Evaluate(num1, 1.0)).thenReturn(subValue);

        PowerMockito.whenNew(Mul.class).withAnyArguments().thenReturn(spyMul);
        PowerMockito.when(spyMul.Evaluate(num1 , 2.0)).thenReturn(mulValue);

        PowerMockito.whenNew(Div.class).withAnyArguments().thenReturn(spyDiv);
        PowerMockito.when(spyDiv.Evaluate(num1 , 2.0)).thenReturn(divValue);

        PowerMockito.whenNew(Pow.class).withAnyArguments().thenReturn(spyPow);
        when(spyPow.Evaluate(num1, 2.0)).thenReturn(Math.pow(num1, 2.0));

        PowerMockito.whenNew(Sqrt.class).withAnyArguments().thenReturn(spySqrt);
        when(spySqrt.Evaluate(num1, 2.0)).thenReturn(Math.sqrt(num1));

        PowerMockito.whenNew(Neg.class).withAnyArguments().thenReturn(spyNeg);
        when(spyNeg.Evaluate(num1, 0.0)).thenReturn(num1*-1);
        
        // Main function call to check
        double[] result = GUI.doMain(num1);
        double[] testResults = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        int i = 0;

        // Run Stubs
        testResults[0] = num1 - 1.0 + 1.0;
        testResults[1] = spySub.Evaluate(num1, 1.0);
        testResults[2] = spyMul.Evaluate(num1, 2.0);
        testResults[3] = spyDiv.Evaluate(num1, 2.0);
        testResults[4] = spyPow.Evaluate(num1, 2.0);
        testResults[5] = spySqrt.Evaluate(num1 , 2.0);
        testResults[6] = spyNeg.Evaluate(num1, 0.0);

        for (double num : result) 
        {
            assertEquals(num, testResults[i], 0);
            i++;
        }

        System.out.print("IntegrateAdd: " + testResults[0] + " Passed\n");
    }

    public static void integrateSub(double num1) throws Exception
    {
        Mul mul = new Mul();
        Mul spyMul = PowerMockito.spy(mul);

        Div div = new Div();
        Div spyDiv = PowerMockito.spy(div);

        Pow pow = new Pow();
        Pow spyPow = PowerMockito.spy(pow);

        Sqrt sqrt = new Sqrt();
        Sqrt spySqrt = PowerMockito.spy(sqrt);

        Neg neg = new Neg();
        Neg spyNeg = PowerMockito.spy(neg);

        double divValue = num1/2.0;
        double mulValue = num1*2.0;

        // Stubbing

        PowerMockito.whenNew(Mul.class).withAnyArguments().thenReturn(spyMul);
        PowerMockito.when(spyMul.Evaluate(num1 , 2.0)).thenReturn(mulValue);

        PowerMockito.whenNew(Div.class).withAnyArguments().thenReturn(spyDiv);
        PowerMockito.when(spyDiv.Evaluate(num1 , 2.0)).thenReturn(divValue);

        PowerMockito.whenNew(Pow.class).withAnyArguments().thenReturn(spyPow);
        when(spyPow.Evaluate(num1, 2.0)).thenReturn(Math.pow(num1, 2.0));

        PowerMockito.whenNew(Sqrt.class).withAnyArguments().thenReturn(spySqrt);
        when(spySqrt.Evaluate(num1, 2.0)).thenReturn(Math.sqrt(num1));

        PowerMockito.whenNew(Neg.class).withAnyArguments().thenReturn(spyNeg);
        when(spyNeg.Evaluate(num1, 0.0)).thenReturn(num1*-1);
        
        // Main function call to check
        double[] result = GUI.doMain(num1);
        double[] testResults = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        int i = 0;

        // Run Stubs
        testResults[0] = num1 - 1.0 + 1.0;
        testResults[1] = num1 - 1.0;
        testResults[2] = spyMul.Evaluate(num1, 2.0);
        testResults[3] = spyDiv.Evaluate(num1, 2.0);
        testResults[4] = spyPow.Evaluate(num1, 2.0);
        testResults[5] = spySqrt.Evaluate(num1 , 2.0);
        testResults[6] = spyNeg.Evaluate(num1, 0.0);

        for (double num : result) 
        {
            assertEquals(num, testResults[i], 0);
            i++;
        }

        System.out.print("IntegrateSub: " + testResults[1] + " Passed\n");
    }

    public static void integrateMul(double num1) throws Exception
    {
        Div div = new Div();
        Div spyDiv = PowerMockito.spy(div);

        Pow pow = new Pow();
        Pow spyPow = PowerMockito.spy(pow);

        Sqrt sqrt = new Sqrt();
        Sqrt spySqrt = PowerMockito.spy(sqrt);

        Neg neg = new Neg();
        Neg spyNeg = PowerMockito.spy(neg);

        double divValue = num1/2.0;

        // Stubbing
        PowerMockito.whenNew(Div.class).withAnyArguments().thenReturn(spyDiv);
        PowerMockito.when(spyDiv.Evaluate(num1 , 2.0)).thenReturn(divValue);

        PowerMockito.whenNew(Pow.class).withAnyArguments().thenReturn(spyPow);
        when(spyPow.Evaluate(num1, 2.0)).thenReturn(Math.pow(num1, 2.0));

        PowerMockito.whenNew(Sqrt.class).withAnyArguments().thenReturn(spySqrt);
        when(spySqrt.Evaluate(num1, 2.0)).thenReturn(Math.sqrt(num1));

        PowerMockito.whenNew(Neg.class).withAnyArguments().thenReturn(spyNeg);
        when(spyNeg.Evaluate(num1, 0.0)).thenReturn(num1*-1);
        
        // Main function call to check
        double[] result = GUI.doMain(num1);
        double[] testResults = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        int i = 0;

        // Run Stubs
        testResults[0] = num1 - 1.0 + 1.0;
        testResults[1] = num1 - 1.0;
        testResults[2] = num1 * 2.0;
        testResults[3] = spyDiv.Evaluate(num1, 2.0);
        testResults[4] = spyPow.Evaluate(num1, 2.0);
        testResults[5] = spySqrt.Evaluate(num1 , 2.0);
        testResults[6] = spyNeg.Evaluate(num1, 0.0);

        for (double num : result) 
        {
            assertEquals(num, testResults[i], 0);
            i++;
        }

        System.out.print("IntegrateMul: " + testResults[2] + " Passed\n");
    }

    public static void integrateDiv(double num1) throws Exception
    {
        Pow pow = new Pow();
        Pow spyPow = PowerMockito.spy(pow);

        Sqrt sqrt = new Sqrt();
        Sqrt spySqrt = PowerMockito.spy(sqrt);

        Neg neg = new Neg();
        Neg spyNeg = PowerMockito.spy(neg);

        // Stubbing

        PowerMockito.whenNew(Pow.class).withAnyArguments().thenReturn(spyPow);
        when(spyPow.Evaluate(num1, 2.0)).thenReturn(Math.pow(num1, 2.0));

        PowerMockito.whenNew(Sqrt.class).withAnyArguments().thenReturn(spySqrt);
        when(spySqrt.Evaluate(num1, 2.0)).thenReturn(Math.sqrt(num1));

        PowerMockito.whenNew(Neg.class).withAnyArguments().thenReturn(spyNeg);
        when(spyNeg.Evaluate(num1, 0.0)).thenReturn(num1*-1);
        
        // Main function call to check
        double[] result = GUI.doMain(num1);
        double[] testResults = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        int i = 0;

        // Run Stubs
        testResults[0] = num1 - 1.0 + 1.0;
        testResults[1] = num1 - 1.0;
        testResults[2] = num1 * 2.0;
        testResults[3] = num1 / 2.0;
        testResults[4] = spyPow.Evaluate(num1, 2.0);
        testResults[5] = spySqrt.Evaluate(num1 , 2.0);
        testResults[6] = spyNeg.Evaluate(num1, 0.0);

        for (double num : result) 
        {
            assertEquals(num, testResults[i], 0);
            i++;
        }

        System.out.print("IntegrateDiv: " + testResults[3] + " Passed\n");
    }

    public static void integratePow(double num1) throws Exception
    {
        Sqrt sqrt = new Sqrt();
        Sqrt spySqrt = PowerMockito.spy(sqrt);

        Neg neg = new Neg();
        Neg spyNeg = PowerMockito.spy(neg);

        // Stubbing
        PowerMockito.whenNew(Sqrt.class).withAnyArguments().thenReturn(spySqrt);
        when(spySqrt.Evaluate(num1, 2.0)).thenReturn(Math.sqrt(num1));

        PowerMockito.whenNew(Neg.class).withAnyArguments().thenReturn(spyNeg);
        when(spyNeg.Evaluate(num1, 0.0)).thenReturn(num1*-1);
        
        // Main function call to check
        double[] result = GUI.doMain(num1);
        double[] testResults = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        int i = 0;

        // Run Stubs
        testResults[0] = num1 - 1.0 + 1.0;
        testResults[1] = num1 - 1.0;
        testResults[2] = num1 * 2.0;
        testResults[3] = num1 / 2.0;
        testResults[4] = Math.pow(num1, 2.0);
        testResults[5] = spySqrt.Evaluate(num1 , 2.0);
        testResults[6] = spyNeg.Evaluate(num1, 0.0);

        for (double num : result) 
        {
            assertEquals(num, testResults[i], 0);
            i++;
        }

        System.out.print("IntegratePow: " + testResults[4] + " Passed\n");
    }

    public static void integrateSqrt(double num1) throws Exception
    {
        Neg neg = new Neg();
        Neg spyNeg = PowerMockito.spy(neg);

        // Stubbing
        PowerMockito.whenNew(Neg.class).withAnyArguments().thenReturn(spyNeg);
        when(spyNeg.Evaluate(num1, 0.0)).thenReturn(num1*-1);
        
        // Main function call to check
        double[] result = GUI.doMain(num1);
        double[] testResults = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        int i = 0;

        // Run Stubs
        testResults[0] = num1 - 1.0 + 1.0;
        testResults[1] = num1 - 1.0;
        testResults[2] = num1 * 2.0;
        testResults[3] = num1 / 2.0;
        testResults[4] = Math.pow(num1, 2.0);
        testResults[5] = Math.sqrt(num1);
        testResults[6] = spyNeg.Evaluate(num1, 0.0);

        for (double num : result) 
        {
            assertEquals(num, testResults[i], 0);
            i++;
        }

        System.out.print("IntegrateSqrt: " + testResults[5] + " Passed\n");
    }

    public static void integrateNeg(double num1) throws Exception
    {
        // Main function call to check
        double[] result = GUI.doMain(num1);
        double[] testResults = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
        int i = 0;

        testResults[0] = num1 - 1.0 + 1.0;
        testResults[1] = num1 - 1.0;
        testResults[2] = num1 * 2.0;
        testResults[3] = num1 / 2.0;
        testResults[4] = Math.pow(num1, 2.0);
        testResults[5] = Math.sqrt(num1);
        testResults[6] = num1 * -1.0;

        for (double num : result) 
        {
            assertEquals(num, testResults[i], 0);
            i++;
        }

        System.out.print("IntegrateNeg: " + testResults[6] + " Passed\n");
    }
}
