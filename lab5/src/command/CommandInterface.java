package command;

@FunctionalInterface
public interface CommandInterface {
    void execute(String arg);
}
