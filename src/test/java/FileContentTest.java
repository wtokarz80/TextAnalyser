import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileContentTest {

    FileContent fileContent;

    @BeforeEach
    void init() throws FileNotFoundException {
        String fileName = "test.txt";
        fileContent = new FileContent(fileName);
        fileContent.readContent();
    }

    @Test
    @DisplayName("Checking if program throw FileNotFoundException when user enter file path that not exist")
    void testNotExistingFileThrowsException() {
        assertThrows(FileNotFoundException.class, () -> new FileContent("wrongNameFile.txt"));
    }

    @Test
    @DisplayName("Checking file name.")
    void getFileName() {
        assertEquals("test.txt", fileContent.getFileName());
    }

    @Test
    @DisplayName("Checking wordIterator name")
    void checkWordIteratorName(){
        assertEquals("WordIterator", fileContent.wordIterator().getClass().getSimpleName());
    }

    @Test
    @DisplayName("Checking if program read existing file and contents at least one word")
    void ifFileContainWord(){
        assertTrue(fileContent.getFileWords().size() > 0);
    }

    @Test
    @DisplayName("Checking if program read existing file and contents at least one letter")
    void ifFileContainLetter(){
        assertTrue(fileContent.getFileChars().size() > 0);
    }

    }





