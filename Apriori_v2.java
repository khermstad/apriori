
import java.util.*;

public class Apriori_v2 {
    public static void main(String[] args) {



        Apriori ap = new Apriori();
        Tools t = new Tools();
        int support = 2;
        ControlSet cs = new ControlSet();

        HashMap<ArrayList<String>, Integer> c3 = ap.getC3(support, cs.ex1);

        for(ArrayList<String> s1 : c3.keySet()){
            System.out.println(s1 + " : " + c3.get(s1));
        }


    }
}



