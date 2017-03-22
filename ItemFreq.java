import java.util.HashMap;

public class ItemFreq extends HashMap<String, Integer> {

    public ItemFreq(){

    }

    public void printItemFreq(){
        for (String key : this.keySet()){
            System.out.println(key + ": " + this.get(key));
        }
    }

}
