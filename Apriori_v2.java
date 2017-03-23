
import java.util.*;

public class Apriori_v2 {
    public static void main(String[] args) {
        Apriori ap = new Apriori();
        Tools t = new Tools();
        int support = 10;
        ControlSet cs = new ControlSet();
        HashMap<ArrayList<String>, Integer> c3 = ap.getC3(support, cs.ex1);
        TransactionDB randomizedDB = new TransactionDB(10, 100, 20);
        ItemFreq L1 = ap.getL1(support, randomizedDB.transactions);
        HashMap<ArrayList<String>, Integer> L2 = ap.getC2(support, randomizedDB.transactions);
        HashMap<ArrayList<String>, Integer> L3 = ap.getC3(support, randomizedDB.transactions);
        L1.printItemFreq();
    }
}



