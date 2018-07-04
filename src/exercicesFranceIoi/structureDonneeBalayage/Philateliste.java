package exercicesFranceIoi.structureDonneeBalayage;

import java.util.Arrays;

/**
 * Created by monsio on 2/2/16.
 */
public class Philateliste {


    public static int shorterDistance (int tab[]){

        Arrays.sort(tab);

        int min = Integer.MAX_VALUE;

        for( int i = 1 ; i < tab.length ; i ++ ){
            min = Math.min(min,tab[i]-tab[i-1]);
        }

        return min;

    }

}
