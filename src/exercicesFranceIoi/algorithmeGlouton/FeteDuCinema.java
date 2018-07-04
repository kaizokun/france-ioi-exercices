package exercicesFranceIoi.algorithmeGlouton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by monsio on 2/28/16.
 */
public class FeteDuCinema {

    private static final int START = 0, END = 1;

    /**
     * trier par fin de sceance
     * Si la seance qui suit, qui est la premiere a se terminer apres celle en cour, à un debut qui setrouve apres la fin de celle courante
     * on l'ajoute
     * */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int total = input.nextInt();

        int[][] sceances = new int[total][2];

        Arrays.sort(sceances, new Comparator<int[]>() {
            @Override
            public int compare(int[] sceance1, int[] sceance2) {

                return  sceance1[END] - sceance2[END];
            }
        });

        int curEnd = -1;
        int max = 0;

        for(int s = 1 ; s < total ; s ++){

            int[] sceance = sceances[s];

            if( sceance[START] > curEnd ){
                curEnd = sceance[END];
                max ++;
            }
        }

        System.out.println(max);

    }

}
