import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        //print(("hejhej"));
        //throw new RuntimeException();


        readFile("minFil.txt");

    }
    //String[] mat = {"banan", "spaghetti", "tofu"};
//        String[] mat = null;
//
//        try {
//            System.out.println(mat[3]);
//        } catch(NullPointerException | ArrayIndexOutOfBoundsException e) {
//            System.err.println("Fel fel fel");
//            System.out.println("FELMEDDELANDE FRÅN E:"+ e.getMessage());
//            //e.printStackTrace();
//        }


//    private static void readFile(String fileName) throws FileNotFoundException {
//        FileReader fileReader = new FileReader(fileName);
//    }

    private static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fel fel fil");
            System.out.println(fnfe.getMessage());
            fnfe.printStackTrace();
            //throw new RuntimeException();
        } finally {
            System.out.println("Jag körs alla gånger");
        }
    }

//    public static void print(String myString) {
//        print(myString);
//    }
}
