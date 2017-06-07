package calculator;
import java.util.Scanner;
public class SuperCalculator 
{
     private double result;
     private double precision = 0.0001;
     
     public SuperCalculator( )
    {
        result = 0;
    }

    public void reset( )
    {
        result = 0;
    }

    public void setResult(double newResult)
    {
        result = newResult;
    }

    public double getResult( )
    {
        return result;
    }
    
        /**
     Returns n1 op n2, provided op is one of '+', '-', '*',or '/'.
     Any other value of op throws UnknownOpException.
    */
    public double evaluate(char op, double n1, double n2)
                  throws DivideByZeroException, UnknownOpException
    {
        double answer;
        switch (op)
        {
            case '+':
                answer = n1 + n2;
                break;
            case '-':
                answer = n1 - n2;
                break;
            case '*':
                answer = n1 * n2;
                break;
            case '/':
                if ((-precision < n2) && (n2 < precision))
                    throw new DivideByZeroException( );
                answer = n1 / n2;
                break;
            default:
                throw new UnknownOpException(op);
        }
        return answer;
   }
    
    public double save(double n2)
    {
        double saveAnswer;
        saveAnswer = n2;
        return saveAnswer;
    }
    
    /**
     The heart of a calculator. This does not give
     instructions. Input errors throw exceptions.
    */
    public void doCalculation( ) throws DivideByZeroException,
                                        UnknownOpException
    {
        Scanner keyboard = new Scanner(System.in);

        boolean done = false;
        result = 0;
        while (!done)
        {
           char nextOp = (keyboard.next( )).charAt(0);
            if ((nextOp == 'e') || (nextOp == 'E'))
            {
                done = true;
            }
            
            
            if ((nextOp == 'c') || (nextOp == 'C'))
            {
                reset();
                System.out.println("result resetted");
                System.out.println("updated result = " + result);
            }
            
            if ((nextOp == 'm') || (nextOp == 'M'))
            {   
                double newResult = keyboard.nextDouble();
                result = save(newResult);
                setResult(newResult);
                System.out.println("updated memory " + newResult);
            }
            
            if ((nextOp == 'r') || (nextOp == 'R'))
            {   
                result = 0;
                double newResult = keyboard.nextDouble();
                setResult(newResult);
                getResult();
                System.out.println("recalled saved memory." + newResult);
            }
            
            else
            {
                double nextNumber = keyboard.nextDouble();
                result = evaluate(nextOp, result, nextNumber);
                System.out.println("result " + nextOp + " " +
                                   nextNumber + " = " + result);
                System.out.println("updated result = " + result);
            }
        }
        
    }
    
    public void handleDivideByZeroException(DivideByZeroException e)
    {
        System.out.println("Dividing by zero.");
        System.out.println("Program aborted");
        System.exit(0);
    }

    public void handleUnknownOpException(UnknownOpException e)
    {
        System.out.println(e.getMessage( ));
        System.out.println("Try again from the beginning:");

        try
        {
            System.out.print("Format of each line: ");
            System.out.println("operator number");
            System.out.println("For example: + 3");
            System.out.println("To end, enter the letter e.");
            doCalculation( );
        }
        catch(UnknownOpException e2)
        {
            System.out.println(e2.getMessage( ));
            System.out.println("Try again at some other time.");
            System.out.println("Program ending.");
            System.exit(0);
        }
        catch(DivideByZeroException e3)
        {
            handleDivideByZeroException(e3);
        }
    }
}
