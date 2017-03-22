import java.util.ArrayList;

public class ControlSet {
    // I1, I2, I3 ex book example
    ArrayList<ArrayList<String>> ex1;
    // B, C, E, slides example
    ArrayList<ArrayList<String>> ex2;


    public ControlSet(){
        ex1 = new ArrayList<ArrayList<String>>();
        ex2 = new ArrayList<ArrayList<String>>();
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

        ex1.add(t100);
        ex1.add(t200);
        ex1.add(t300);
        ex1.add(t400);
        ex1.add(t500);
        ex1.add(t600);
        ex1.add(t700);
        ex1.add(t800);
        ex1.add(t900);

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

        ex2.add(t10);
        ex2.add(t20);
        ex2.add(t30);
        ex2.add(t40);
    }


}
