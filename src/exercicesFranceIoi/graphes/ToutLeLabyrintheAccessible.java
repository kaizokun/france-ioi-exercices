package exercicesFranceIoi.graphes;

import java.util.LinkedList;

/**
 * Created by monsio on 2/16/16.
 */
public class ToutLeLabyrintheAccessible {

    private static int cpt;
    private static int lignes = 10, colones = 10;
    private static char[][] labyrinthe;


    private static void remplirLabyrinthe(int lig, int col){

        final int dels[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        labyrinthe[lig][col] = '#';

        for( int[] del :  dels ){

            int lig2 = lig + del[0];
            int col2 = col + del[1];

            if(labyrinthe[lig2][col2] == 'E' ){
                break;
            }
            else if( labyrinthe[lig2][col2] == '.'){
                remplirLabyrinthe(lig2, col2);
            }

        }

    }


    public static void main(String[] args) {


        labyrinthe = new char[][]
                {{'#','#','#','#','#','#','#','#','#','#'},
                        {'.','.','.','.','.','.','.','.','.','#'},
                        {'#','#','#','.','.','#','.','#','.','#'},
                        {'#','.','#','#','#','.','.','#','#','#'},
                        {'#','.','#','.','.','.','#','.','.','#'},
                        {'#','.','.','.','#','#','#','#','.','#'},
                        {'#','#','#','.','.','.','.','.','#','#'},
                        {'#','.','.','#','.','.','#','.','.','#'},
                        {'#','.','.','.','#','.','.','#','.','#'},
                        {'#','#','#','#','#','#','#','#','.','#'}};

        labyrinthe[1][0] = 'S';
        labyrinthe[lignes-1][colones-2] = 'E';

        remplirLabyrinthe(1,1);

        int inaccessibles = 0;

        for(int lig = 1 ; lig < lignes - 1; lig ++) {
            for (int col = 1; col < colones - 1; col++) {
                if(labyrinthe[lig][col] == '.')
                    inaccessibles ++;
            }
        }

        /*
        for(int lig = 1 ; lig < lignes - 1; lig ++) {
            for (int col = 1; col < colones - 1; col++) {
                System.out.print(estAccessible[lig][col] ? '*' : '_');
            }
            System.out.println();
        }
        System.out.println();
        for(int lig = 1 ; lig < lignes - 1; lig ++) {
            for (int col = 1; col < colones - 1; col++) {
                System.out.print(labyrinthe[lig][col]);
            }
            System.out.println();
        }
        System.out.println();
*/
        System.out.println(cpt);

        System.out.println(inaccessibles);

    }

}
