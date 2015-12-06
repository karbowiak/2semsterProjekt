package tools;
import java.util.HashMap;

public class QuickHash extends HashMap<String,String> {
    public QuickHash(String...KeyValuePairs) {
        super(KeyValuePairs.length/2);
        for(int i=0;i<KeyValuePairs.length;i+=2)
            put(KeyValuePairs[i], KeyValuePairs[i+1]);
    }
}