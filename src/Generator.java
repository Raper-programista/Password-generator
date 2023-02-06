package main;

import javax.annotation.processing.Generated;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Generator {
    //main variable
    static StringBuilder password = new StringBuilder();

    public static void main(String[] args) {
        // preparing reader from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // [0] -> letters, [1] -> numbers, [2] -> special characters
        int[] counters = {0, 0, 0};

        //arrays
        char[] letters = createTable(65, 122, 'l');
        char[] numbers = createTable(48, 57, 'n');
        char[] specials = createTable(33, 125, 's');

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
            System.out.println("Format error, you have entered an incorrect value: " + e);
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

        ArrayList<Character> list = new ArrayList<>();

        for (int i = from; i<=to; i++){

            if(type == 'l' && i>90 && i<97)
                continue;
            if(type == 's' && i>47 && i<58)
                continue;
            if(type == 's' && ((i>64 && i<91) || (i>96 && i<123 )))
                continue;

            list.add((char) i);

                /* characters test
              * System.out.println(i + " : " +(char) i);
                */
        }

        char[] table = new char[list.size()];

        for (int i = 0; i < list.size(); i++)
            table[i] = list.get(i);

        return table;
    }

    public String generate() {
        return ""+password;

    }
}
