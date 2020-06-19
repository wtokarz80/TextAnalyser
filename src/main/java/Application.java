import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] arg) throws FileNotFoundException {

        String[] args = {"test.txt"};
        AppProvider appProvider = new AppProvider(args);
        appProvider.startProgram();

    }
}
