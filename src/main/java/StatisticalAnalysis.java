import java.util.*;

public class StatisticalAnalysis {

    private final Iterator<String> dataIterator;

    public StatisticalAnalysis(Iterator<String> dataIterator){
        this.dataIterator = dataIterator;
    }

    public int countOf(String...words){
        int count = 0;
        while(dataIterator.hasNext()){
            if(Arrays.asList(words).contains(dataIterator.next())){
                count += 1;
            }
        }
        return count;
    }

    public int dictionarySize() {
        Set<String> total = new HashSet<>();
        while (dataIterator.hasNext()) {
            total.add(dataIterator.next());
        }
        return total.size();
    }

    public float vowelsCount(){
        float count = 0;
        String[] vowels = {"a", "e", "i", "o", "u"};
        while (dataIterator.hasNext()){
            if(Arrays.asList(vowels).contains(dataIterator.next())){
                count += 1;
            }
        }
        float result = (100 * count) / dataSize();
        return (float) (Math.round(result * 100.00) / 100.00);
    }

    public int dataSize(){
        int count = 0;
        while (dataIterator.hasNext()){
            dataIterator.next();
            count += 1;
        }
        return count;
    }


    public float ratioAtoE(){
        int countA = countOf("a");
        int countB = countOf("e");
        float result = (float) countA / (float) countB;
        return (float) (Math.round(result * 100.00) / 100.00);
    }


    public Set<String> occurMoreThan(Integer moreThan){
        float percent = (moreThan * (float)dataSize() / 100);
        Set<String> wordsWithCondition = new HashSet<>();
        Map<String, Integer> elementsMap = getStringIntegerMap();
        Set<Map.Entry<String, Integer>> entries = elementsMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if(entry.getValue() >= percent){
                wordsWithCondition.add(entry.getKey());
            }
        }
        return wordsWithCondition;
    }

    public Map<String, Integer> getStringIntegerMap() {
        Map<String, Integer> elementsMap = new HashMap<>();
        while(dataIterator.hasNext()){
            elementsMap.merge(dataIterator.next(), 1, Integer::sum);
        }
        return elementsMap;
    }

    public Map<String, Float> lettersPercentageQuantity(){
        Map<String, Integer> elementsMap = getStringIntegerMap();
        Map<String, Float> lettersPercentage = new HashMap<>();
        Set<Map.Entry<String, Integer>> entries = elementsMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            lettersPercentage.put(entry.getKey(), (100 * (float)entry.getValue()) / (float) dataSize());
        }
    return lettersPercentage;
    }
}
