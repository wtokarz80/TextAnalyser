import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StatisticalAnalysisTest {

    WordIterator wordIterator;
    CharIterator charIterator;

    @BeforeEach
    void init() throws IOException {
        String fileName = "test.txt";
        FileContent fileContent = new FileContent(fileName);
        wordIterator = new WordIterator(fileContent);
        charIterator = new CharIterator(fileContent);
    }

    @Test
    @DisplayName("Checks for specific words in the text")
    void testCountOfMusic() {
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(wordIterator);
        assertEquals(3, statisticalAnalysis.countOf("music"));
    }


    @Test
    @DisplayName("Checking size dictionary of words")
    void testDictionarySize(){
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(wordIterator);
        assertEquals(141, statisticalAnalysis.dictionarySize());
    }

    @Test
    @DisplayName("Checking size of all words in the text")
    void testWordsSize(){
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(wordIterator);
        assertEquals(267, statisticalAnalysis.dataSize());
    }

    @Test
    @DisplayName("Checking size of all letters in the text")
    void testLettersSize(){
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(charIterator);
        assertEquals(1030, statisticalAnalysis.dataSize());
    }

    @Test
    @DisplayName("Checking vowels count in %")
    void testVowelsCount(){
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(charIterator);
        assertEquals(39.03, (Math.round((statisticalAnalysis.vowelsCount()) * 100.00) / 100.00));
    }

    @Test
    @DisplayName("Checking 'a:e' count ratio")
    void testRatioAtoE(){
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(charIterator);
        assertEquals(0.57, (Math.round((statisticalAnalysis.ratioAtoE()) * 100.00) / 100.00));
    }

    @Test
    @DisplayName("Checking words occur more tha 1%")
    void testOccurMoreThan(){
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(wordIterator);
        Set<String> words = new HashSet<>(Arrays.asList("but", "a", "no", "been", "figure", "in", "old", "was", "i", "is", "had",
                "it", "the", "as", "not", "music", "and", "of", "me", "where", "to"));
        assertEquals(words, statisticalAnalysis.occurMoreThan(1));
    }

    @Test
    @DisplayName("Checking specific letters percentage quantity")
    void testLettersPercentageQuantity(){
        String specificLetter1 = "a";
        String specificLetter2 = "l";
        String specificLetter3 = "s";
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(charIterator);
        Map<String, Float> lettersPercentage = statisticalAnalysis.lettersPercentageQuantity();
        float aFloat = lettersPercentage.get(specificLetter1);
        float lFloat = lettersPercentage.get(specificLetter2);
        float sFloat = lettersPercentage.get(specificLetter3);
        assertEquals(7.96, (Math.round((aFloat) * 100.00) / 100.00));
        assertEquals(2.91, (Math.round((lFloat) * 100.00) / 100.00));
        assertEquals(6.12, (Math.round((sFloat) * 100.00) / 100.00));
    }

    @Test
    @DisplayName("Checking how many types of letters are used in text")
    void testHowManyLettersAreUsed(){
        StatisticalAnalysis statisticalAnalysis = new StatisticalAnalysis(charIterator);
        Map<String, Float> lettersPercentage = statisticalAnalysis.lettersPercentageQuantity();
        assertEquals(25, lettersPercentage.size());
    }
}