public class NotEnoughProductsException extends RuntimeException{
    public NotEnoughProductsException() {}
    public NotEnoughProductsException(String message) {
        super(message);
    }

}
