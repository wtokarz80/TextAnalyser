import java.util.Arrays;
import java.util.Scanner;

public class AppProvider {

    private Scanner scan = new Scanner(System.in);
    private View view = new View();

    AppProvider(){
        scan.useDelimiter(System.lineSeparator());
        startProgram();
    }

    public void startProgram(){
        System.out.println("Enter the names of the text files separated by a comma: ");
        String userInput = scan.next();
        String[] filesName = userInput.split("\\s+");
        for (String fileName : filesName){
            FileContent fileContent = new FileContent(fileName);
            StatisticalAnalysis statAnalysisWords = new StatisticalAnalysis(fileContent.wordIterator());
            StatisticalAnalysis statAnalysisChars = new StatisticalAnalysis(fileContent.charIterator());
            initializeResults(fileContent, statAnalysisChars, statAnalysisWords);
        }
    }

    private void initializeResults(FileContent fileContent, StatisticalAnalysis statAnalysisChars, StatisticalAnalysis statAnalysisWords) {

        long start = System.currentTimeMillis();

        view.printTitle(fileContent.getFileName());
        view.printInt("Char count: ", statAnalysisChars.dataSize());
        view.printInt("Word count: ", statAnalysisWords.dataSize());
        view.printInt("Dictionary size: ", statAnalysisWords.dictionarySize());
        view.printSet("Most used words (>1%): ", statAnalysisWords.occurMoreThan(1));
        view.printInt("'love' count: ", statAnalysisWords.countOf("love"));
        view.printInt("'hate' count: ", statAnalysisWords.countOf("hate"));
        view.printInt("'music' count: ", statAnalysisWords.countOf("music"));
        view.printFloat("vowels %: ", statAnalysisChars.vowelsCount());
        view.printFloat("'a:e' count ratio: ", statAnalysisChars.ratioAtoE());
        view.printMap(statAnalysisChars.lettersPercentageQuantity());

        long end = System.currentTimeMillis();

        System.out.println("\n\nBenchmark time: " + (end - start) + " ms");

    }
}
