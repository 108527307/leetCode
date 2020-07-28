package javaTest;

public class MyException extends Exception {
    private String message;

    public MyException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
