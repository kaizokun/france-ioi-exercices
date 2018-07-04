package exercicesFranceIoi.structureDonneeBalayage;

import java.util.Arrays;

/**
 * Created by monsio on 2/12/16.
 */
public class Exercice14 {

    public static void main(String[] args) {



        int points[] = new int[]{1,4,6,8,9,13,15,16,18};

        int largeur = 4;// largeur > 0
        int maxPts = 0;

        Arrays.sort(points);

        for( int e = 0, s = 0; e < points.length ; e ++ ){

            while( points[e] - points[s] > largeur )
                s++;

            maxPts = Math.max(maxPts,e + 1 - s);

        }

        System.out.println(maxPts);
    }

}
