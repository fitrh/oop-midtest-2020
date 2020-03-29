import java.io.IOException;

public abstract class ListTDL {
    public abstract void showList() throws IOException;

    public abstract void add() throws IOException;

    public abstract void update(int i) throws IOException;

    public abstract void detail(int i) throws IOException;

    public abstract void delete(int i) throws IOException;

    public abstract String read(String name) throws IOException;

    public abstract boolean write(String name, String text) throws IOException;
}