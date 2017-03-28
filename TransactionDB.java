import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TransactionDB {

    ArrayList<ArrayList<String>> transactions;
    SampleSet ss = new SampleSet();

    public TransactionDB(int avgSampleSetSize, int amountOfTransactions, int amountOfItems){
        transactions = new ArrayList<>();
        ArrayList<String> possibleItems = ss.alphabetLCUC;
        ArrayList<String> itemset = new ArrayList<>();
        Collections.shuffle(possibleItems);
        for (int i = 0; i < amountOfItems; i++){
            itemset.add(possibleItems.get(i));
        }
        Random rd = new Random();
        for (int k = 0; k < amountOfTransactions; k++){
            int sampleSetSize = avgSampleSetSize + rd.nextInt(3);
            Collections.shuffle(itemset);
            ArrayList<String> transaction = new ArrayList<>();
            for (int j = 0; j < sampleSetSize; j++){
                transaction.add(itemset.get(j));
            }
            this.transactions.add(transaction);
        }
    }

}
