package a;

public final class h extends RuntimeException {
    public h(Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}