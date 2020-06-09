import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StatisticalAnalysisTest {

    private StatisticalAnalysis statisticalAnalysis;

    @BeforeEach
    void init(){
        FileContent fileContent = new FileContent("test.txt");
        WordIterator wordIterator = new WordIterator(fileContent);
        statisticalAnalysis = new StatisticalAnalysis(wordIterator);
    }

    @Test
    void testCountOfMusic() {
        assertEquals(3, statisticalAnalysis.countOf("music"));
    }

    @Test
    void testDictionarySize(){
        assertEquals(141, statisticalAnalysis.dictionarySize());
    }

    @Test
    void testDataSize(){
        assertEquals(267, statisticalAnalysis.dataSize());
    }

    @Test
    void testOccurMoreThan(){
        Set<String> words = new HashSet<>(Arrays.asList("but", "a", "no", "been", "figure", "in", "old", "was", "i", "is", "had",
                "it", "the", "as", "not", "music", "and", "of", "me", "where", "to"));
        assertEquals(words, statisticalAnalysis.occurMoreThan(1));
    }

}