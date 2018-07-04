package exercicesFranceIoi.util;

import java.util.Scanner;

/**
 * Created by monsio on 2/2/16.
 */
public class Util {

    public static Scanner scan = new Scanner(System.in);

    public static int[] liretab( int n ){

        int tab[] = new int[n];

        for(int i = 0 ; i < n ; i ++)
            tab[i] = scan.nextInt();

        return tab;

    }

    public static String getIdent(int d){
        String ident = "";
        for( int i = 0 ; i < d ; i ++ )
            ident+="     ";

        return ident;

    }

    public static int lireInt(){
        return scan.nextInt();
    }

}
