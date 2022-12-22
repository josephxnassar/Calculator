import static org.junit.Assert.*;

import org.junit.Assert; 
import org.junit.Test;
import org.mockito.internal.stubbing.answers.ThrowsException;
import org.mockito.internal.stubbing.answers.ThrowsExceptionClass;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;


public class UnitTests {

    private Add AddObject;
    private Div DivObject;
    private Neg NegativeObject;
    private Mul MulObject;
    private Sub SubObject;
    private Pow PowObject;
    private Sqrt SqrtObject;

    @BeforeClass
    public static void setUpBeforeClass()throws Exception{    
    }

    @AfterClass
    public static void tearDownAfterClass()throws Exception{
    }

    @Before
    public void setUp() throws Exception{
        AddObject = new Add();
        DivObject = new Div();
        NegativeObject = new Neg();
        MulObject = new Mul();
        SubObject = new Sub();
        PowObject = new Pow();
        SqrtObject = new Sqrt();
    }

    @After
    public void tearDown() throws Exception{
        AddObject = null;
        DivObject = null;
        NegativeObject = null;
        MulObject = null;
        SubObject = null;
        PowObject = null;
        SqrtObject = null;
    }

    @Test
    public void AddTest() {
        double num1 = 10;
        double num2 = 17;
        double result = AddObject.Evaluate(num1, num2);
        Assert.assertEquals(27, result, 0);
    }
    
    @Test
    public void AddTestOneNegative() {
        double num1 = 10;
        double num2 = -17;
        double result = AddObject.Evaluate(num1, num2);
        Assert.assertEquals(-7, result, 0);
    }
    
    @Test
    public void AddTestTwoNegative() {
        double num1 = -10;
        double num2 = -17;
        double result = AddObject.Evaluate(num1, num2);
        Assert.assertEquals(-27, result, 0);
    }
    
    @Test
    public void DivideTest() {
        double num1 = 10;
        double num2 = 5;
        double result = DivObject.Evaluate(num1, num2);
        Assert.assertEquals(2, result, 0);
    }
    
    @Test
    public void DivideTestNegative() {
        double num1 = 10;
        double num2 = -5;
        double result = DivObject.Evaluate(num1, num2);
        Assert.assertEquals(-2, result, 0);
    }
    
    @Test
    public void DivideTestTwoNegative() {
        double num1 = -10;
        double num2 = -5;
        double result = DivObject.Evaluate(num1, num2);
        Assert.assertEquals(2, result, 0);
    }
    
    @Test
    public void DivideTestZero() {
        double num1 = 10;
        double num2 = 0;
        double result = DivObject.Evaluate(num1, num2);
        Assert.assertEquals(Float.POSITIVE_INFINITY, result, 0);
    }
    
    @Test
    public void NegativeTest() {
        double num1 = 10;
        double num2 = 0;
        double result = NegativeObject.Evaluate(num1, num2);
        Assert.assertEquals(-10, result, 0);
    }
    
    @Test
    public void NegativeTest2() {
        double num1 = 0;
        double num2 = 12;
        double result = NegativeObject.Evaluate(num1, num2);
        Assert.assertEquals(-12, result, 0);
    }
    
    @Test
    public void MultiplyTest() {
        double num1 = 10;
        double num2 = 5;
        double result = MulObject.Evaluate(num1, num2);
        Assert.assertEquals(50, result, 0);
    }
    
    @Test
    public void MultiplyTestNegative() {
        double num1 = -10;
        double num2 = 5;
        double result = MulObject.Evaluate(num1, num2);
        Assert.assertEquals(-50, result, 0);
    }

    @Test
    public void MultiplyTestTwoNegative() {
        double num1 = -10;
        double num2 = -5;
        double result = MulObject.Evaluate(num1, num2);
        Assert.assertEquals(50, result, 0);
    }
    
    @Test
    public void MultiplyTestZero() {
        double num1 = 0;
        double num2 = -5;
        double result = MulObject.Evaluate(num1, num2);
        Assert.assertEquals(0, result, 0);
    }
    
    @Test
    public void SubtractTest(){
        double num1 = 10;
        double num2 = 8;
        double result = SubObject.Evaluate(num1, num2);
        Assert.assertEquals(2.0, result, 0);
    }

    @Test
    public void SubtractTest2(){
        double num1 = -10;
        double num2 = -8;
        double result = SubObject.Evaluate(num1, num2);
        Assert.assertEquals(-2.0, result, 0);
    }
    
     @Test
    //Added this to test to make sure evaluate can subtract a positive from a negative.
    public void SubtractTest3(){
        double num1 = -10;
        double num2 = 8;
        double result = SubObject.Evaluate(num1, num2);
        Assert.assertEquals(-18.0, result, 0);
    }

    @Test
    //Added this to make sure evaluate can subtract a negative from a positive.
    public void SubtractTest4(){
        double num1 = 10;
        double num2 = -8;
        double result = SubObject.Evaluate(num1, num2);
        Assert.assertEquals(18.0, result, 0);
    }

    @Test 
    public void PowerTest(){
        double num1 = 2;
        double num2 = 3;
        double result = PowObject.Evaluate(num1, num2);
        Assert.assertEquals(8.0, result,0);

    }

    @Test
    public void PowerTest2(){
        double num1 = -2;
        double num2 = 3;
        double result = PowObject.Evaluate(num1, num2);
        Assert.assertEquals(-8.0, result,0);
    }
    
    @Test
    //Added this test to make sure we can do power to the negative number.
    public void PowerTest3(){
        double num1 = 2;
        double num2 = -2;
        double result = PowObject.Evaluate(num1, num2);
        Assert.assertEquals(0.25, result,0);
    }
    
    @Test
    //Make sure that power to 0 will result in 1.
    public void PowerTest4(){
        double num1 = 4;
        double num2 = 0;
        double result = PowObject.Evaluate(num1, num2);
        Assert.assertEquals(1, result,0);
    }

    @Test
    public void SquareTest(){
        double num1 = 4;
        double num2 = 0;
        double result = SqrtObject.Evaluate(num1, num2);
        Assert.assertEquals(2, result,0);
    }
    
 @Test
    //Blackbox test to test boundary+1 of squareroot.
    public void SquareTest2(){
        double num1 = 1;
        double num2 = 0;
        double result = SqrtObject.Evaluate(num1, num2);
        Assert.assertEquals(1, result,0);
    }

    @Test
    //Blackbox Boundary test of square root.
    public void SquareTest3(){
        double num1 = 0;
        double num2 = 0;
        double result = SqrtObject.Evaluate(num1, num2);
        Assert.assertEquals(0, result,0);
    }
   
    @Test
    //Black Box test to test boundary-1 of squareroot
    public void SquareTestnegative(){
        double num1 = -1;
        double num2 = 0;
        Double result = SqrtObject.Evaluate(num1, num2);
        Assert.assertTrue(result.isNaN());
    }

}
