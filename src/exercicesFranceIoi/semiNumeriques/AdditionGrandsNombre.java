package exercicesFranceIoi.semiNumeriques;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by monsio on 2/21/16.
 */
public class AdditionGrandsNombre {


    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {



        int base = 2;// scan.nextInt();
        int     lengthCh1 = 4;// scan.nextInt(),
        int     lengthCh2 = 2;//scan.nextInt();

        int lengthMax = Math.max(lengthCh1, lengthCh2);

        int n1[] = new int[lengthMax],
            n2[] = new int[lengthMax];
/*
        n1[0] = 1;
        n1[1] = 1;
        n1[2] = 1;
        n1[3] = 1;

        n2[2] = 1;
        n2[3] = 1;
*/
        LinkedList<Integer> rs = new LinkedList();


        //lireNombre(n1,lengthCh1, lengthMax);
        //lireNombre(n2,lengthCh2, lengthMax);
/*
        voirNombre(n1);
        voirNombre(n2);
        */

        int retenu = 0;

        for( int c = lengthMax - 1 ; c >= 0 ; c-- ){
            int somme = n1[c] + n2[c] + retenu;
            rs.addFirst(somme % base);
            retenu = somme / base;
        }

        if(retenu!=0)
            rs.addFirst(retenu);


        for( int c : rs)
            System.out.print(c +" ");


    }

    static void lireNombre(int[] n,int length, int maxlength){
        for( int c = maxlength - length ; c <  maxlength ; c ++ ){
            n[c] = scan.nextInt();
        }
    }

    static void voirNombre(int[]n){
        for( int c : n )
            System.out.print(c+" ");

        System.out.println();
    }

}
