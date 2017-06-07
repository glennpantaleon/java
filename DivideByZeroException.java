package calculator;

public class DivideByZeroException extends Exception 
{

    public DivideByZeroException() 
    {
        super("Cannot divide by zero.");
    }

    public DivideByZeroException(double zero) 
    {
        super(zero + " cannot be divide by zero.");
    }
}
