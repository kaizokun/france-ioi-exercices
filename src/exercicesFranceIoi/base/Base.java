package exercicesFranceIoi.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by monsio on 1/23/16.
 */
public class Base {

    public static int plusGrandePuissance2( int n ){

        int p = 1;
        for(; p <= n ; p*=2 );
        return p/2;

    }

    private static int i = 0;
/*
    public static List<Integer> decimalToBinary(int n){
        List binTab = new ArrayList<Integer>();
        decimalToBinary(n, binTab);
        return binTab;
    }

    private static void decimalToBinary( int n, List<Integer> binTab ){

        if( n > 1 )
            decimalToBinary(n / 2, binTab);
        else
            i = 0;

        binTab.add(i++,n%2);

    }
*/
    public static List<Integer> decimalToBase(int n, int base){
        List binTab = new ArrayList<Integer>();
        decimalToBase(n, binTab, base);
        return binTab;
    }

    private static void decimalToBase( int n, List<Integer> binTab, int base ){

        if( n >= base ) {
            decimalToBase(n / base, binTab, base);
        }else
            i = 0;

        binTab.add(i++,n%base);

    }

    public static int binaryToDecimal( int tab[] ){

        int nbr = 0;

        for( int n : tab ){
            nbr = nbr * 2 + n ;
        }

        return nbr;
    }

    public static int baseToDecimal(int base, int [] nombre){

        int n = 0 ;
        for( int chiffre : nombre ){
            n = n * base + chiffre ;
        }
        return n;
    }

    public static void main(String[] args) {

        //System.out.println(binaryToDecimal(new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(baseToDecimal(2,new int[]{1,0,0,1}));
/*
        for(int d : decimalToBase(2066555662,2))
            System.out.print(d+".");
*/
    }
}
