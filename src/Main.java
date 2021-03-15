public class Main {

    //  0   - C
//  1   - C#/Db
//  2   - D
//  3   - D#/Eb
//  4   - E
//  5   - F
//  6   - F#/Gb
//  7   - G
//  8   - G#/Ab
//  9   - A
//  10  - A#/Bb
//  11  - B

    public static void main(String[] args){

        Key a = new Key(2,false);


        a.printKey();
        a.printDeg(2);
        a.printChord(2);
        a.printChord(5);
        a.printChord(1);


    }
}
