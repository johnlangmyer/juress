/*

This class creates a Key object that can be queried for diatonic chords from a major or minor key.

*/
import java.util.HashMap;

public class Key {

    // True for Major, false for Minor key
    boolean isMajor;

    int root;

    HashMap<Integer,Integer> keyDegs = new HashMap<Integer,Integer>();
    HashMap<Integer,int[]> keyChords = new HashMap<Integer,int[]>();
    HashMap<Integer,String> translator = new HashMap<Integer,String>();


    Key(int newRoot, boolean major){
        isMajor = major;
        root = newRoot;
        setTranslator();
        setDegrees(isMajor);
        setChords(isMajor);
    }

    // checks the root of the chord to see if accidentals will be sharp (#) or flat (b)
    boolean rootIsFlat(int rootToCheck){

        // Major flat keys -   F, Bb, Eb, Ab, Db
        int[] majorFlatKeys = {5, 10,  3,  8,  1};

        //Minor flat keys -    D, G, C, F, Bb
        int[] minorFlatKeys = {2, 7, 0, 5, 10};

        // Depending on if the key is major or not, check the root against appropriate flat key signatures
        // if a match of the root is found, return true (the key is flat) or false (the key is not flat)
        if (isMajor) {
            for (int i = 0; i < majorFlatKeys.length; i++) {
                if (majorFlatKeys[i] == rootToCheck) {
                    return true;
                }
            }
            return false;
        } else {
            for (int i = 0; i < minorFlatKeys.length; i++) {
                if (minorFlatKeys[i] == rootToCheck) {
                    return true;
                }
            }
            return false;
        }
    }

    //  method used to translate a pitch class to a alphabetical note-name for printing and testing
    void setTranslator(){
        translator.put(0,"C");
        translator.put(2,"D");
        translator.put(4,"E");
        translator.put(5,"F");
        translator.put(7,"G");
        translator.put(9,"A");
        translator.put(11,"B");

        // Insert appropriate accidental notes depending on if the key is found to be flat or sharp
        if (rootIsFlat(root)){
            translator.put(1,"Db");
            translator.put(3,"Eb");
            translator.put(6,"Gb");
            translator.put(8,"Ab");
            translator.put(10,"Bb");
        } else {
            translator.put(1,"C#");
            translator.put(3,"D#");
            translator.put(6,"F#");
            translator.put(8,"G#");
            translator.put(10,"A#");
        }
    }

    // Sets pitch-class degrees of key scale to HashMap so a pitch-class can be obtained
    // from the diatonic scale degree.
    void setDegrees(boolean major){
        keyDegs.put(1, root);
        if (major){
            keyDegs.put(2, (root + 2) % 12);
            keyDegs.put(3, (root + 4) % 12);
            keyDegs.put(4, (root + 5) % 12);
            keyDegs.put(5, (root + 7) % 12);
            keyDegs.put(6, (root + 9) % 12);
            keyDegs.put(7, (root + 11) % 12);
        } else {
            keyDegs.put(2, (root + 2) % 12);
            keyDegs.put(3, (root + 3) % 12);
            keyDegs.put(4, (root + 5) % 12);
            keyDegs.put(5, (root + 7) % 12);
            keyDegs.put(6, (root + 8) % 12);
            keyDegs.put(7, (root + 10) % 12);
        }

    }

    // Sets diatonic triads of the key scale to HashMap so the pitch-classes of a given
    // diatonic triad can be obtained from the scale degree root.
    void setChords(boolean major){
        if (major){
            keyChords.put(1,makeMajChord(keyDegs.get(1)));
            keyChords.put(2,makeMinChord(keyDegs.get(2)));
            keyChords.put(3,makeMinChord(keyDegs.get(3)));
            keyChords.put(4,makeMajChord(keyDegs.get(4)));
            keyChords.put(5,makeMajChord(keyDegs.get(5)));
            keyChords.put(6,makeMinChord(keyDegs.get(6)));
            keyChords.put(7,makeDimChord(keyDegs.get(7)));
        } else {
            keyChords.put(1,makeMinChord(keyDegs.get(1)));
            keyChords.put(2,makeDimChord(keyDegs.get(2)));
            keyChords.put(3,makeMajChord(keyDegs.get(3)));
            keyChords.put(4,makeMinChord(keyDegs.get(4)));
            keyChords.put(5,makeMinChord(keyDegs.get(5)));
            keyChords.put(6,makeMajChord(keyDegs.get(6)));
            keyChords.put(7,makeMajChord(keyDegs.get(7)));
        }
    }

    int[] makeMajChord(int chordRoot){
        int[] chordMems = new int[3];
        chordMems[0] = chordRoot;
        chordMems[1] = (chordRoot + 4) % 12;
        chordMems[2] = (chordRoot + 7) % 12;
        return chordMems;
    }

    int[] makeMinChord(int chordRoot){
        int[] chordMems = new int[3];
        chordMems[0] = chordRoot;
        chordMems[1] = (chordRoot + 3) % 12;
        chordMems[2] = (chordRoot + 7) % 12;
        return chordMems;
    }

    int[] makeDimChord(int chordRoot){
        int[] chordMems = new int[3];
        chordMems[0] = chordRoot;
        chordMems[1] = (chordRoot + 3) % 12;
        chordMems[2] = (chordRoot + 6) % 12;
        return chordMems;
    }

    void printKey(){
        String keyString = "";
        for (int i = 1; i < 8; i++){
            keyString = keyString + translator.get(keyDegs.get(i)) + " ";
        }
        System.out.println(keyString);
    }



    void printDeg(int i){
        System.out.println(translator.get(keyDegs.get(i)));
    }

    void printChord(int i){
        int[] tempChord = new int[3];
        tempChord = keyChords.get(i);
        for (int chordMem : tempChord){
            System.out.print(translator.get(chordMem) + " ");
        }
        System.out.print("\n");
    }




}
