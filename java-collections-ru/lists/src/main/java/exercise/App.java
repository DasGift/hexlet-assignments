package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public static boolean scrabble(String symbols, String str) {
        int length = str.length();
        String[] letters = symbols.split("");
        List coll = new ArrayList(Arrays.asList(letters));

        for (int i = 0; i < length; i++) {
            String current = str.substring(i, i + 1).toLowerCase();

            if (!coll.contains(current)) {
                return false;
            }

            coll.remove(current);
        }

        return true;
}
//END
