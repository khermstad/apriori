import java.lang.reflect.Array;
import java.util.*;

public class Tools {
    public Tools(){

    }

    public ItemFreq getDatabaseItemFreq(ArrayList<ArrayList<String>> tdb){
        ItemFreq itemFreq = new ItemFreq();
        ArrayList<ArrayList<String>> transactions = tdb;

        for(ArrayList<String> transaction : transactions){
            for (String item : transaction){
                if(itemFreq.containsKey(item)){
                    itemFreq.put(item, itemFreq.get((item))+1);
                }
                else{
                    itemFreq.put(item, 1);
                }
            }
        }

        return itemFreq;
    }

    public ItemFreq pruneItemFreq(int support, ItemFreq itemFreq){

        ItemFreq prunedItemFreq = new ItemFreq();
        prunedItemFreq.putAll(itemFreq);

        for(String s : itemFreq.keySet()){
            if(itemFreq.get(s) < support){
                prunedItemFreq.remove(s);
            }
        }
        return prunedItemFreq;
    }

    public ArrayList<ArrayList<String>> getAllPairs(ItemFreq itemFreq){
        Set<String> items = itemFreq.keySet();
        ArrayList<String> itemset = new ArrayList<>();

        for (String s : items){
            itemset.add(s);
        }

        ArrayList<ArrayList<String>> pairs = new ArrayList<>();

        for (int i = itemset.size()-1; i >= -1; i--){
            for (int k = 0; k < i; k++){
                ArrayList<String> trans = new ArrayList<>();
                trans.add(itemset.get(i));
                trans.add(itemset.get(k));
                if (!pairs.containsAll(trans)) {
                    pairs.add(trans);
                }
            }
        }
        return pairs;
    }


    public HashMap<ArrayList<String>, Integer> getPairFreq(ArrayList<ArrayList<String>> pairs, ArrayList<ArrayList<String>> originalDb){
        HashMap<ArrayList<String>, Integer> pairFreq = new HashMap<>();
        for(ArrayList<String> p : pairs){
            pairFreq.put(p, 0);
        }

        for (ArrayList<String> t : originalDb){
            for(ArrayList<String> p : pairs){
                if (t.containsAll(p)){
//                    System.out.println(t + " " + p);
                    pairFreq.put(p, pairFreq.get(p)+1);
                }
            }
        }
        return pairFreq;
    }

    public ArrayList<ArrayList<String>> orderedArrayList(HashMap<ArrayList<String>, Integer> prunedPairFreq){
        ArrayList<ArrayList<String>> orderedList = new ArrayList<>();
        for (ArrayList<String> alstr : prunedPairFreq.keySet()){
            Collections.sort(alstr);
            orderedList.add(alstr);
        }
        return orderedList;
    }


    public HashMap<ArrayList<String>, Integer> prunePairFreq(int support, HashMap<ArrayList<String>, Integer> pairFreq){
        HashMap<ArrayList<String>, Integer> prunedPairFreq = new HashMap<>();
        prunedPairFreq.putAll(pairFreq);

        for (ArrayList<String> t : pairFreq.keySet()){
            if(pairFreq.get(t) < support){
                prunedPairFreq.remove(t);
            }
        }

        return prunedPairFreq;
    }

    public ArrayList<ArrayList<String>> generate3sets(ArrayList<ArrayList<String>> L2){
        ArrayList<ArrayList<String>> C3 = new ArrayList<>();

        // now generate c3 from L2
        for(int i = 0; i < L2.size()-1; i++){
            for (int k = i; k < L2.size()-1; k++){
                if (!L2.get(i).equals(L2.get(k))) {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(L2.get(i).get(0));
                    temp.add(L2.get(i).get(1));
                    if (!temp.contains(L2.get(k).get(0))){
                        temp.add(L2.get(k).get(0));
                    }
                    if (!temp.contains(L2.get(k).get(1))){
                        temp.add(L2.get(k).get(1));
                    }
                    if(temp.size() == 3){
                        int amountOfFreqPair = 0;
                        ArrayList<String> one = new ArrayList<>();
                        one.add(temp.get(0));
                        one.add(temp.get(1));

                        if (L2.contains(one)){
                            amountOfFreqPair++;
                        }

                        ArrayList<String> two = new ArrayList<>();
                        two.add(temp.get(0));
                        two.add(temp.get(2));

                        if (L2.contains(two)){
                            amountOfFreqPair++;
                        }

                        ArrayList<String> three = new ArrayList<>();
                        three.add(temp.get(1));
                        three.add(temp.get(2));

                        if (L2.contains(three)){
                            amountOfFreqPair++;
                        }

                        if(amountOfFreqPair == 3){
                            if(!C3.contains(temp)) {
                                C3.add(temp);
                            }
                        }

                    }
                }
            }
        }
        return C3;
    }

}


