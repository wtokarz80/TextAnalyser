import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileContent  implements IterableText{

    private final String fileName;
    private final List<String> fileWords = new ArrayList<>();
    private final List<String> fileChars = new ArrayList<>();
    private final Iterator<String> wordIter;
    private final Iterator<String> charIter;

    FileContent(String fileName){
        this.fileName = fileName;
        readContent();
        wordIter = wordIterator();
        charIter = charIterator();
    }

    public void readContent(){
        try{
            var fileReader = new FileReader(fileName);
            var bufferedReader = new BufferedReader(fileReader);

            String nextLine = null;
            while((nextLine = bufferedReader.readLine()) != null){
                createFileWordsList(nextLine);
                createFileCharsList(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFileCharsList(String nextLine) {
        String stripedLine = nextLine.replaceAll("\\s+", "");
        for (char ch : stripedLine.toCharArray()){
            fileChars.add(String.valueOf(ch).toLowerCase());
        }
    }

    private void createFileWordsList(String nextLine) {
        String[] arrSplitLine = nextLine.trim().split("\\s+");
        for (String s : arrSplitLine) {
            if(!s.equalsIgnoreCase("\\s+")){
                fileWords.add(s.toLowerCase());
            }
        }
    }

    public List<String> getFileWords() {
        return fileWords;
    }

    public List<String> getFileChars() {
        return fileChars;
    }

    public String getFileName() {
        return fileName;
    }

    public Iterator<String> getWordIter() {
        return wordIter;
    }

    public Iterator<String> getCharIter() {
        return charIter;
    }

    @Override
    public Iterator<String> charIterator() {
        return new CharIterator(this);
    }

    @Override
    public Iterator<String> wordIterator() {
        return new WordIterator(this);
    }
}
