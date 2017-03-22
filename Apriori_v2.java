
import java.util.*;

public class Apriori_v2 {
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> tdb = new ArrayList<>();

        ArrayList<String> t100 = new ArrayList<>();
        t100.add("I1");
        t100.add("I2");
        t100.add("I5");

        ArrayList<String> t200 = new ArrayList<>();
        t200.add("I2");
        t200.add("I4");

        ArrayList<String> t300 = new ArrayList<>();
        t300.add("I2");
        t300.add("I3");

        ArrayList<String> t400 = new ArrayList<>();
        t400.add("I1");
        t400.add("I2");
        t400.add("I4");

        ArrayList<String> t500 = new ArrayList<>();
        t500.add("I1");
        t500.add("I3");

        ArrayList<String> t600 = new ArrayList<>();
        t600.add("I2");
        t600.add("I3");

        ArrayList<String> t700 = new ArrayList<>();
        t700.add("I1");
        t700.add("I3");

        ArrayList<String> t800 = new ArrayList<>();
        t800.add("I1");
        t800.add("I2");
        t800.add("I3");
        t800.add("I5");

        ArrayList<String> t900 = new ArrayList<>();
        t900.add("I1");
        t900.add("I2");
        t900.add("I3");

        tdb.add(t100);
        tdb.add(t200);
        tdb.add(t300);
        tdb.add(t400);
        tdb.add(t500);
        tdb.add(t600);
        tdb.add(t700);
        tdb.add(t800);
        tdb.add(t900);

        ArrayList<ArrayList<String>> tdb2 = new ArrayList<>();

        ArrayList<String> t10 = new ArrayList<>();
        t10.add("A");
        t10.add("C");
        t10.add("D");

        ArrayList<String> t20 = new ArrayList<>();
        t20.add("B");
        t20.add("C");
        t20.add("E");

        ArrayList<String> t30 = new ArrayList<>();
        t30.add("A");
        t30.add("B");
        t30.add("C");
        t30.add("E");

        ArrayList<String> t40 = new ArrayList<>();
        t40.add("B");
        t40.add("E");

        ArrayList<String> t50 = new ArrayList<>();
        t50.add("B");
        t50.add("C");
        t50.add("E");


        tdb2.add(t10);
        tdb2.add(t20);
        tdb2.add(t30);
        tdb2.add(t40);


        Apriori ap = new Apriori();
        Tools t = new Tools();

        int support = 2;

        HashMap<ArrayList<String>, Integer> c3 = ap.getC3(support, tdb2);

        for(ArrayList<String> s1 : c3.keySet()){
            System.out.println(s1 + " : " + c3.get(s1));
        }


    }
}



