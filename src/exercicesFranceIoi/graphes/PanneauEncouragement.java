package exercicesFranceIoi.graphes;

import java.util.LinkedList;

/**
 * Created by monsio on 2/19/16.
 */
public class PanneauEncouragement {

    private static int lignes = 10, colones = 10, maxProfondeur = lignes / 2 * colones;

    private static char[][] labyrinthe;
    private static LinkedList<Character> directions = new LinkedList<>();
    private static int[][] profondeurs = new int[lignes][colones];
    private static int panneauxProfCptr[] = new int[maxProfondeur];
    private static final int deplacements[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) {

        labyrinthe = new char[][]{
                {'#','#','#','#','#','#','#','#','#','#'},
                {'.','.','.','.','.','.','.','.','.','#'},
                {'#','#','.','.','.','#','.','#','.','#'},
                {'#','.','#','#','#','.','.','.','#','#'},
                {'#','.','#','.','.','.','#','.','.','#'},
                {'#','.','.','.','#','#','#','#','.','#'},
                {'#','.','#','.','.','.','.','.','#','#'},
                {'#','.','.','#','.','.','#','.','.','#'},
                {'#','.','.','.','#','.','.','#','.','#'},
                {'#','#','#','#','#','#','#','#','.','#'}};

        labyrinthe[1][0] = 'S';
        labyrinthe[lignes-1][colones-2] = 'E';

        placerPanneauIt(lignes - 2, colones - 2, 1, true, maxProfondeur);
        showInfo();

        directions.add('E');
        plusCourtChemin(1, 1, profondeurs[1][1] - 1);

        for(char d : directions )
            System.out.print(d + " ");


    }

    private static void plusCourtChemin(int lig, int col, int profondeur) {

        final String NESO = "NESO";

        if(profondeur == 0)
            return;
/*
        System.out.println(lig+" "+col);
        System.out.println(profondeur+" "+labyrinthe[lig][col]);

        if(labyrinthe[lig][col] == 'E')
            return;
*/
        for(int d = 0 ; d < deplacements.length; d ++ ) {
            int[] dep = deplacements[d];
            int lig2 = lig + dep[0];
            int col2 = col + dep[1];
            if(profondeurs[lig2][col2] == profondeur){
                directions.add(NESO.charAt(d));
                plusCourtChemin(lig2, col2, profondeur - 1);
                break;
            }
        }

    }

    private static void showInfo(){

        System.out.println("\n");

        for (int prof = 1 ; prof < maxProfondeur ; prof ++ )
            System.out.print(panneauxProfCptr[prof]+" ");

        System.out.println("\n");

        for (int l = 0 ; l < lignes ; l ++) {
            for (int c = 0; c < colones; c++)
                System.out.printf("%2d ", profondeurs[l][c]);
            System.out.println();
        }

    }


    static class Point{
        int x, y,d;

        public Point(int col, int lig, int dist) {
            this.x = col;
            this.y = lig;
            this.d = dist;
        }
    }


    private static void placerPanneauIt(int lig, int col, int depth, boolean noLimit, int maxProfondeur){

        LinkedList<Point> listePts = new LinkedList();

        //on ajoute la point de depart (dernier) à la liste des points courant à analyser
        listePts.add(new Point(col, lig,1));

        while(!listePts.isEmpty() && ( noLimit || depth < maxProfondeur )){

            //on retire le premier point de la liste courante
            Point pt = listePts.pollFirst();
            //on marque se point comme analysé
            profondeurs[pt.y][pt.x] = pt.d;
            labyrinthe[pt.y][pt.x] = '*';
            //on test les positions aux alentours
            for( int[] dep : deplacements ){

                int lig2 = pt.y + dep[0];
                int col2 = pt.x + dep[1];

                char nextNode = labyrinthe[lig2][col2];

                if(nextNode == 'S' ){
                    continue;
                }
                //Si on obtient un point il s'agit d'une position valide
                if( nextNode == '.' ){
                    //On ajoute le point dans la prochaine liste a analyser
                    listePts.add(new Point(col2,lig2,pt.d+1));
                }

            }

        }

    }



/*
    private static void placerPanneauIt(int lig, int col, int depth, boolean noLimit, int maxProfondeur){

        LinkedList<Point> listePtsCourant = new LinkedList(),
                          listePtsSuivants = new LinkedList();

        //labyrinthe[lig][col] = (char)('0' + (depth - '0'));

        //unique point situé à une distance de 1 de la fin
        panneauxProfCptr[depth] = 1;
        //on ajoute ce point à la liste des points courant à analyser
        //listePtsCourant.add(new Point(col, lig));
        listePtsCourant.add(new Point(col, lig,1));
        while(!listePtsCourant.isEmpty() && ( noLimit || depth < maxProfondeur )){

            //on retire le premier point de la liste courante
            Point pt = listePtsCourant.pollFirst();
            //on marque se point comme analysé
            profondeurs[pt.y][pt.x] = depth;
            labyrinthe[pt.y][pt.x] = '*';
            //on test les positions aux alentours
            for( int[] dep : deplacements ){

                int lig2 = pt.y + dep[0];
                int col2 = pt.x + dep[1];

                char nextNode = labyrinthe[lig2][col2];

                if(nextNode == 'S' ){
                    continue;
                }
                //Si on obtient un point il s'agit d'une position valide
                if( nextNode == '.' ){
                    //On augmente le nombre de point rencontre pour cette profondeur
                    panneauxProfCptr[depth]++;
                    //On ajoute le point dans la prochaine liste a analyser
                    listePtsSuivants.add(new Point(col2,lig2));
                }

            }

            //Si tout les points de la liste courante ont été analysés, la liste est vide, on la remplace par la liste des points suivants
            //  et on incremente la profondeur


            if( listePtsCourant.isEmpty() ){
                listePtsCourant = listePtsSuivants;
                listePtsSuivants = new LinkedList<>();
                depth ++;
            }

        }

    }

*/

}
