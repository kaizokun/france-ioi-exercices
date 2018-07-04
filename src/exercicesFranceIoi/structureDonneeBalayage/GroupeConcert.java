package exercicesFranceIoi.structureDonneeBalayage;

import java.util.Scanner;

/**
 * Created by monsio on 1/31/16.
 *
 * Compter le plus petit inetrvalle du tableau comprenant tout les elements recherchés au moins une fois
 *
 */
public class GroupeConcert {


    public static int minDays(int tab[], int totalGrp){

        int s = 0, e = 0, min = tab.length, cptr = 0;

        int cptrApparition[] = new int [totalGrp+1];

        for( int i = 0 ; i <= totalGrp ; i ++){
            cptrApparition[i]=0;
        }

        do{

            int grpDay = tab[e];

            if( cptrApparition[grpDay] == 0 )
                cptr ++ ;

            cptrApparition[grpDay]++;

            //tout les groupes comptabilisé sur une intervalle
            while( cptr == totalGrp ){
                min = Math.min(min, e+1-s);

                int firstGrp = tab[s];

                cptrApparition[firstGrp] -- ;

                if( cptrApparition[firstGrp] == 0 ){
                    cptr --;
                }

                s++;
            }

            e++;

        }while ( e < tab.length );

        return min;

    }


    public static void main(String[] args) {

         System.out.println(minDays(new int[]{1,2,3,3,2,4,2,5,3,4,4,2,3}, 5));
    }

}
