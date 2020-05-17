import java.util.Iterator;

public class CharIterator implements Iterator<String> {

    private FileContent fileContent;
    private int index;

    CharIterator(FileContent fileContent){
        this.fileContent = fileContent;
    }

    @Override
    public boolean hasNext() {
        if (index == fileContent.getFileChars().size() - 1){
            index = 0;
            return false;
        }
        return true;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String next() {
        if (this.hasNext()){
            return fileContent.getFileChars().get(index++);
        }
        return null;
    }
}
