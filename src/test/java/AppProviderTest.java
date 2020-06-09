import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppProviderTest {

    private AppProvider appProvider;


    @Test
    void checkFile(){
        appProvider = new AppProvider();
        assertThrows(IllegalArgumentException.class, () -> appProvider.startProgram());
    }
}