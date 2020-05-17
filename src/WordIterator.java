import java.util.Iterator;

public class WordIterator implements Iterator<String> {

    private FileContent fileContent;
    private int index;

    WordIterator(FileContent fileContent){
        this.fileContent = fileContent;
    }

    @Override
    public boolean hasNext() {
        if (index == fileContent.getFileWords().size() -1){
            index = 0;
            return false;
        }
        return true;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String next(){
        if (this.hasNext()){
            return fileContent.getFileWords().get(index++);
        }
        return null;
    }
}