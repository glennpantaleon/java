package calculator;

public class UnknownOpException extends Exception {

    public UnknownOpException() 
    {
        super(" is an unknown operator");
    }

    public UnknownOpException(char op) {
        super(op + " is an unkown operator.");
    }
}
