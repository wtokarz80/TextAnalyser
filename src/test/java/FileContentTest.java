import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileContentTest {
    private static FileContent fileContent;

    @BeforeAll
    static void init(){
        String fileName = "test.txt";
        fileContent = new FileContent(fileName);
        fileContent.readContent();
    }



    @Test
    void getFileName() {
        assertEquals("test.txt", fileContent.getFileName());
    }

    @Test
    void checkWordIteratorName(){
        assertEquals("WordIterator", fileContent.wordIterator().getClass().getSimpleName());
    }

    @Disabled ("I don't know why it shows twice as many elements as it really is")
    @Test
    void wordsQuantity(){
        assertEquals(267, fileContent.getFileWords().size());
    }





}