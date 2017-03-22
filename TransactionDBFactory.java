import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TransactionDBFactory {

    SampleSet ss = new SampleSet();
    Random rd = new Random();

    public TransactionDBFactory(){

    }

    public TransactionDB generateRandomDB(int avgTransactionSize, int sampleSetSize, int amountOfTransactions){
        TransactionDB randomizedDB = new TransactionDB();
        ArrayList<String> sampleSet = new ArrayList<>();

        for (int i = 0; i < sampleSetSize; i++){
            sampleSet.add(ss.alphabetUC.get(i));
        }

        for (int i = 0; i < amountOfTransactions; i++){
            Transaction current = new Transaction();
            int transactionSize = avgTransactionSize + rd.nextInt(avgTransactionSize/2);
            Collections.shuffle(sampleSet);
            for (int k = 0; k < transactionSize; k++){
                current.add(sampleSet.get(k));
            }
            randomizedDB.add(current);
        }

        return randomizedDB;
    }
}
