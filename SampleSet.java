import java.util.ArrayList;

public class SampleSet {
    ArrayList<String> alphabetUC;
    ArrayList<String> alphabetLCUC;
    ArrayList<String> superlist;

    public SampleSet(){

        alphabetUC = new ArrayList<>();
        alphabetUC.add("A");
        alphabetUC.add("B");
        alphabetUC.add("C");
        alphabetUC.add("D");
        alphabetUC.add("E");
        alphabetUC.add("F");
        alphabetUC.add("G");
        alphabetUC.add("H");
        alphabetUC.add("I");
        alphabetUC.add("J");
        alphabetUC.add("K");
        alphabetUC.add("L");
        alphabetUC.add("M");
        alphabetUC.add("N");
        alphabetUC.add("O");
        alphabetUC.add("P");
        alphabetUC.add("Q");
        alphabetUC.add("R");
        alphabetUC.add("S");
        alphabetUC.add("T");
        alphabetUC.add("U");
        alphabetUC.add("V");
        alphabetUC.add("W");
        alphabetUC.add("X");
        alphabetUC.add("Y");
        alphabetUC.add("Z");

        alphabetLCUC = new ArrayList<>();

        for (String s : alphabetUC){
            alphabetLCUC.add(s);
        }
        alphabetLCUC.add("a");
        alphabetLCUC.add("b");
        alphabetLCUC.add("c");
        alphabetLCUC.add("d");
        alphabetLCUC.add("e");
        alphabetLCUC.add("f");
        alphabetLCUC.add("g");
        alphabetLCUC.add("h");
        alphabetLCUC.add("i");
        alphabetLCUC.add("j");
        alphabetLCUC.add("k");
        alphabetLCUC.add("l");
        alphabetLCUC.add("m");
        alphabetLCUC.add("n");
        alphabetLCUC.add("o");
        alphabetLCUC.add("p");
        alphabetLCUC.add("q");
        alphabetLCUC.add("r");
        alphabetLCUC.add("s");
        alphabetLCUC.add("t");
        alphabetLCUC.add("u");
        alphabetLCUC.add("v");
        alphabetLCUC.add("w");
        alphabetLCUC.add("x");
        alphabetLCUC.add("y");
        alphabetLCUC.add("z");

        superlist = new ArrayList<>();
        for(int i = 0; i < 52; i++){
            superlist.add(alphabetLCUC.get(i) + i);
        }


    }




}
