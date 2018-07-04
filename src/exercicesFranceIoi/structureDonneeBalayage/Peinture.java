package exercicesFranceIoi.structureDonneeBalayage;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by monsio on 2/1/16.
 */
public class Peinture {


    public static int[] searchSum(Integer[] tab, int somme){

        for( int i = 0 ; i < tab.length ; i ++ ){
            int recherche = somme - tab[i];

            if( Arrays.binarySearch(tab, i, tab.length, recherche) > -1 ) {
                return new int[]{tab[i],recherche};
            }

        }

        return null;

    }

    public static int[] searchSumQuick(Integer[] tab, int sum){

        int s = 0, e = tab.length-1;

        while( s <= e  ){

            int curSum = tab[s] + tab[e];

            if( curSum > sum ){
                e--;
            }else if (curSum < sum ){
                    s++;
            }else{
                return new int[]{tab[s],tab[e]};
            }

        }

        return null;

    }

    public static int[] searchSumQuick2(Integer[] tab, int sum){

        for( int s = 0, e = tab.length-1 ; s < tab.length; s++  ){

            int cible = sum - tab[s];

            while( tab[e] > cible && s < e ){
                e--;
            }

            if( cible == tab[e] ){
                return new int[]{tab[s],tab[e]};
            }

        }

        return null;

    }



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Integer tab[] = new Integer[]{1,3,5,6,8,10,13,14,16,18,19,21,32,38,45,47,49,50};



        int[] rs = searchSum(tab,51);

        if(rs == null)
            System.exit(0);

        System.out.println(rs[0]+" + "+rs[1]);

        rs = searchSumQuick(tab, 51);

        if(rs == null)
            System.exit(0);

        System.out.println(rs[0]+" + "+rs[1]);


        rs = searchSumQuick2(tab, 51);

        if(rs == null)
            System.exit(0);

        System.out.println(rs[0]+" + "+rs[1]);

    }

}
