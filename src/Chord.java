public class Chord {

    int root;
    int third;
    int fifth;
    int seventh;

    int[] chordMems = new int[3];

    Chord(int newRoot){
        root = newRoot;
    }

    void setRoot(int newRoot){
        root = newRoot;
    }

    // Major chord types
    void maj(){
        third = (root + 4) % 12;
        fifth = (root + 7) % 12;
    }

    void maj7(){
        third = (root + 4) % 12;
        fifth = (root + 7) % 12;
        seventh = (root + 11) % 12;
    }

    void dom7(){
        third = (root + 4) % 12;
        fifth = (root + 7) % 12;
        seventh = (root + 10) % 12;
    }

    // Minor chord types
    void min(){
        third = (root + 3) % 12;
        fifth = (root + 7) % 12;
    }
    void min7(){
        third = (root + 3) % 12;
        fifth = (root + 7) % 12;
        seventh = (root + 10) % 12;
    }
    void dim(){
        third = (root + 3) % 12;
        fifth = (root + 6) % 12;
    }

    void printMems(){
        System.out.println(root + ", " + third + ", " + fifth);
    }



}
