package exercicesFranceIoi.recursivite;

import java.util.Scanner;

/**
 * Created by monsio on 1/20/16.
 */
public class fratcaleSierpinski {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int cote = scan.nextInt();

        char pan[][] = new char[cote][cote];

        for( int i = 0 ; i < cote ; i ++ )
            for( int j = 0 ; j < cote ; j ++ )
                pan[i][j] = ' ';

        dessinerFractale(pan,0,0,cote);

        for( int i = 0 ; i < cote ; i ++ ) {
            for (int j = 0; j < cote; j++){
                System.out.print(pan[i][j]);
            }
            System.out.println();
        }

    }

    public static void dessinerFractale(char[][] pan,int lig,int col, int length ){

        if( length == 1 ){
            pan[lig][col] = '#';
            return;
        }

        length/=2;

        dessinerFractale(pan,lig,col,length);
        dessinerFractale(pan,lig,col+length,length);
        dessinerFractale(pan,lig+length,col,length);
    }
}
