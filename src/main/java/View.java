import java.util.Map;
import java.util.Set;

public class View {


    public void printTitle(String title) {
        System.out.println(String.format("\n=== %s ===\n", title));
    }

    public void printInt(String title, int dataSize) {
        System.out.println(title + dataSize);
    }

    public void printSet(String title, Set<String> occurMoreThan) {
        System.out.println(title + occurMoreThan);
    }

    public void printFloat(String title, float vowelsCount) {
        System.out.println(title + String.format("%.2f", vowelsCount));
    }

    public void printMap(Map<String, Float> lettersPercentageQuantity) {
        for (String key : lettersPercentageQuantity.keySet()){
            System.out.print(String.format("[%s -> %.2f]", key.toUpperCase(), lettersPercentageQuantity.get(key)));
        }
    }

    public void printText(String text){
        System.out.println(text);
    }
}
