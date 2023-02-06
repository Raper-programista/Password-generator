import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        // preparing reader from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //main variable
        StringBuilder password = new StringBuilder();

        // [0] -> letters, [1] -> numbers, [2] -> special characters
        int[] counters = {0, 0, 0};

        //arrays
        char[] letters = createTable(65, 122, 'l');
        char[] numbers = createTable(48, 57, 'n');
        char[] specials = createTable(21, 47, 's');

        //arrays 2D (dwuwymiarowa tablica)
        char[][] allCharacters = {letters, numbers, specials};

        // ask user about password
        try {
            System.out.println("How many letters you want in your password: ");
            counters[0] = Integer.parseInt(reader.readLine());

            System.out.println("How many numbers you want in your password: ");
            counters[1] = Integer.parseInt(reader.readLine());

            System.out.println("How many special characters you want in your password: ");
            counters[2] = Integer.parseInt(reader.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e){
            System.out.println("Format error, you have entered an incorrect value, ty debilu jebany: " + e);
        }

        // create password
        while (counters[0] > 0 || // or while(counters[0] + counters[1] + counters[2] > 0)
               counters[1] > 0 ||
               counters[2] > 0) {


            //draw a type of characters (array draw)
            int random = new Random().nextInt(0, 3);

            // if it is enough these characters' tape
            if(counters[random] == 0)
                continue;

            // size of draw array
            int length = allCharacters[random].length;

            // draw character
            int index = new Random().nextInt(0, length);
            char sing = allCharacters[random][index];

            // concat password
            password.append(sing);

            counters[random]--;
        }

        System.out.println("Your password is: " + password);
    }
    private static char[] createTable(int from, int to, char type) {

        //size array
        int size = to-from+1;

        //create empty table
        char[] table = new char[size];

        //tall in the table
        for(int i =0; i < size; i++ )
            table[i] = (char) (from+i); // (char) - convert from char to int

        return table;
    }
}
