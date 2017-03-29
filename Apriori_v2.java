import java.util.ArrayList;
import java.util.HashMap;

public class Apriori_v2 {
    public static void main(String[] args) {

        // Apriori Class containing all tools needed to run algorithm
        Apriori ap = new Apriori();

        // ControlSet: examples from lecture slides and from DM book
        ControlSet cs = new ControlSet();
        // ControlSet Example 1 [I1, I2, I5]
        HashMap<ArrayList<String>, Integer> ex1_c3 = ap.getC3(2, cs.ex1);

        // prints first example from ControlSet
//        for (ArrayList<String> als : ex1_c3.keySet()){
//            System.out.println(als + " : " + ex1_c3.get(als));
//        }

        // ControlSet Example 2 [B, C, E]
        HashMap<ArrayList<String>, Integer> ex2_c3 = ap.getC3(2, cs.ex2);

        // prints second example from ControlSet
//        for (ArrayList<String> als : ex2_c3.keySet()){
//            System.out.println(als + " : " + ex2_c3.get(als));
//        }
//
        // generate randomizedDB - (avgSizeOfTransaction, AmountOfTransactions, AmtOfItems)
        int avgSizeOfTransaction = 3;
        int amountOfTransactions = 1000000;
        int amtOfItems = 15;

        TransactionDB randomizedDB = new TransactionDB(avgSizeOfTransaction, amountOfTransactions, amtOfItems);

        int support = 500000;

        // prints out all transactions
//        for (ArrayList<String> als : randomizedDB.transactions){
//            System.out.println(als);
//        }

        ItemFreq L1 = ap.getL1(support, randomizedDB.transactions);
//
//        for (String s : L1.keySet()){
//            System.out.println(s + " : " + L1.get(s));
//        }

        // L2 of RandomizedDB
        HashMap<ArrayList<String>, Integer> L2 = ap.getC2(support, randomizedDB.transactions);

        // L3 of RandomizedDB
        HashMap<ArrayList<String>, Integer> L3 = ap.getC3(support, randomizedDB.transactions);

//        // prints L2
//        for (ArrayList<String> als : L2.keySet()){
//            System.out.println(als + " : " + L2.get(als));
//        }
//





//        // prints L3
//        for (ArrayList<String> als : L3.keySet()){
//            System.out.println(als + " : " + L3.get(als));
//        }

//        // suggestions demo
//        ap.getSuggestionsForL2(L2, L3);

        //friends demo
        String url = "jdbc:sqlite:/Users/krishermstad/Data/sqlite/test.db";
        Sqlite3Connector sqlc = new Sqlite3Connector();
        HashMap<Integer, ArrayList<String>> friendsMap = sqlc.getFriendsFromDatabase(url);
        // convert friends map to ArrayList<ArrayList<String>>
        ArrayList<ArrayList<String>> friendsMapAsTDB = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            friendsMapAsTDB.add(friendsMap.get(i));
        }

        // Get friendsL2
        HashMap<ArrayList<String>, Integer> friendsL2 = ap.getC2(6, friendsMapAsTDB);
        // Print Out L2
//        for(ArrayList<String> als : friendsL2.keySet()){
//            System.out.println(als + " : " + friendsL2.get(als));
//        }

        // Get friendsL3
        HashMap<ArrayList<String>, Integer> friendsL3 = ap.getC3(6, friendsMapAsTDB);

        // Print Out L3
//        for(ArrayList<String> als : friendsL3.keySet()){
//            System.out.println(als + " : " + friendsL3.get(als));
//        }

        // get suggestions comparing L2 to L3
//        ap.getSuggestionsForL2(friendsL2, friendsL3);


    }
}



