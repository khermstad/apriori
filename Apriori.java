
import java.util.ArrayList;
import java.util.HashMap;

public class Apriori {
    Tools t;
    public Apriori(){
        t = new Tools();
    }

    public HashMap<ArrayList<String>, Integer> getC3(int support, ArrayList<ArrayList<String>> tdb){
        HashMap<ArrayList<String>, Integer> c3 = new HashMap<>();

        // 1. Scan D for count of each candidate
        // C1
        ItemFreq dbItemFreq = t.getDatabaseItemFreq(tdb);
        // 2. Compare candidate support count with minimum support count
        // L1 - prune items based on support
        ItemFreq prunedItemFreq = t.pruneItemFreq(support, dbItemFreq);
//        // 3. Generate C2 candidates from L1
        ArrayList<ArrayList<String>> C2pairs = new ArrayList<>();
        C2pairs = t.getAllPairs(prunedItemFreq);
        // 4. Scan D for count of each candidate
        HashMap<ArrayList<String>, Integer> pairFreq = t.getPairFreq(C2pairs, tdb);
        // 5. Compare candidate support count with minimum support count
        // L2 - prune pairs based on support
        HashMap<ArrayList<String>, Integer> prunedPairFreq = t.prunePairFreq(support, pairFreq);
        // 6. Generate C3 candidates from L2
        // C3 - 3-item frequent itemsets
        ArrayList<ArrayList<String>> C3 = new ArrayList<>();
        ArrayList<ArrayList<String>> L2 = t.orderedArrayList(prunedPairFreq);

        // C3 -> pre check against original DB
        C3 = t.generate3sets(L2);
        // 7. Scan Database for count of each candidate
        HashMap<ArrayList<String>, Integer> c3freq = new HashMap<>();
        c3freq = t.getPairFreq(C3, tdb);

        HashMap<ArrayList<String>, Integer> finalC3 = new HashMap<>();
        finalC3 = t.prunePairFreq(support, c3freq);

        return finalC3;
    }
}

