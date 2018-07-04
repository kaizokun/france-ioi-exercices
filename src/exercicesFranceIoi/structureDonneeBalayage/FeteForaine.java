package exercicesFranceIoi.structureDonneeBalayage;

import exercicesFranceIoi.util.Util;

import java.util.Scanner;

/**
 * Created by monsio on 2/2/16.
 */
public class FeteForaine {


    /*
    * Pour un lot courant demarrant de 0
    * Pour chaque element du tableau de point
    *   Tant que le lot suivant (lot courant plus 1 ) est inferieur ou égal ou nombre de lot maximum
    *         ET que nombre de point courant est superieur au lot suivant
    *         lot courant ++;
    *
    *   afficher lot courant
    * */


    public static void lots(int[]points,int[]lots){

        int curLot = 0;

        for(int pt : points){

            while( curLot + 1 < lots.length && pt >= lots[curLot+1]){
                curLot ++;
            }
            System.out.print(lots[curLot] + " ");
        }
    }


    public static void main(String[] args) {

        //lots(new int[]{2,3,7,11,13,14,15},new int[]{1,4,9,11,13,17});

        int nPts = Util.lireInt();

        int[] pts = Util.liretab(nPts);

        int nLots = Util.lireInt();

        int[] lots = Util.liretab(nLots);

        lots(pts,lots);


    }

}
