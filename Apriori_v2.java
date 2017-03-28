import java.util.ArrayList;
import java.util.HashMap;

public class Apriori_v2 {
    public static void main(String[] args) {

        Apriori ap = new Apriori();

        int support = 2;

        ControlSet cs = new ControlSet();
        HashMap<ArrayList<String>, Integer> c3 = ap.getC3(support, cs.ex1);

        // generate randomizedDB - (avgSizeOfTransaction, AmountOfTransactions, AmtOfItems)
        TransactionDB randomizedDB = new TransactionDB(3, 200, 3);

//        ItemFreq L1 = ap.getL1(support, randomizedDB.transactions);

        // L2 of RandomizedDB
        HashMap<ArrayList<String>, Integer> L2 = ap.getC2(support, randomizedDB.transactions);
        // L3 of RandomizedDB
        HashMap<ArrayList<String>, Integer> L3 = ap.getC3(support, randomizedDB.transactions);


        // prints second example from ControlSet
        for (ArrayList<String> als : c3.keySet()){
            System.out.println(als + " : " + c3.get(als));
        }

        // prints L2
        for (ArrayList<String> als : L2.keySet()){
            System.out.println(als + " : " + L2.get(als));
        }

        // prints L3
        for (ArrayList<String> als : L3.keySet()){
            System.out.println(als + " : " + L3.get(als));
        }



    }
}



