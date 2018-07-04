package exercicesFranceIoi.graphes;

import exercicesFranceIoi.tree.Node;

import java.util.LinkedList;

/**
 * Created by monsio on 2/16/16.
 */
public class CompterChemins {

    private static int cpt;
    private static int lignes = 10, colones = 10;
    private static char[][] labyrinthe;
    private static LinkedList<char[][]> chemins = new LinkedList<>();


    private static char[][] copyLabyrinthe(){

        char labCopy[][] = new char[lignes][colones];

        for(int lig = 0 ; lig < lignes; lig ++)
            for(int col = 0 ; col < colones; col ++)
                labCopy[lig][col] = labyrinthe[lig][col];

        return labCopy;
    }



    private static void compterChemins(int lig, int col){

        final int dels[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        //On marque le point comme parcouru pour eviter de tourner en rond
        labyrinthe[lig][col] = '*';

        for( int[] del :  dels ){

            int lig2 = lig + del[0];
            int col2 = col + del[1];
            //Si une position à verifier comprend la fin on incremente le compteur et on arrete la boucle ( et la fonction )
            int nextNode = labyrinthe[lig2][col2];
            if(nextNode == 'E' ){
                cpt ++;
                chemins.add(copyLabyrinthe());
                break;
            }
            //Si une position à verifier contient un point on recommence depuis ce point
            else if( nextNode == '.' ){
                compterChemins(lig2,col2);
            }
        }

        //Au retour on rend la case à nouveau accessible pour tester les chemins partant de positions différentes
        labyrinthe[lig][col] = '.';
    }


    static class Node {
        public int lig,col;
        public Node(int lig, int col) {
            this.lig = lig;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "lig=" + lig +
                    ", col=" + col +
                    '}';
        }
    }


    private static void compterCheminsIt(int lig, int col){

        int dels[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        LinkedList<Node> pile = new LinkedList();

        pile.add(new Node(lig,col));
        boolean empile;

        while(!pile.isEmpty()) {
            empile = false;

            Node node = pile.peekLast();

            labyrinthe[node.lig][node.col] = 'o';

            for (int[] del : dels) {

                int lig2 = node.lig + del[0];
                int col2 = node.col + del[1];

                if (labyrinthe[lig2][col2] == 'E') {
                    cpt++;
                    chemins.add(copyLabyrinthe());
                    break;
                } else if (labyrinthe[lig2][col2] == '.') {
                    pile.add(new Node(lig2,col2));
                    empile = true;
                }
            }

            /*
            * Si aucun noeud aus alentours du noeud courant n'a été empilé.
            * On est soit dans un cul de sac ou arrivé à la fin du labyrinthe.
            * Dans ce cas on depile tout les noeud marqué comme noeud de passage.
            * On reviendra soit au debut du labyrinthe. Soit à un noeud empilé precedemment, mais encore non analysé.
            * */
            if(!empile){
                Node top = pile.peekLast();
                while( !pile.isEmpty() && labyrinthe[top.lig][top.col] == 'o') {
                    labyrinthe[top.lig][top.col] = '.';
                    pile.pollLast();
                    top = pile.peekLast();
                }
            }

        }

    }


    public static void main(String[] args) {


        labyrinthe = new char[][]
                {
                        {'#','#','#','#','#','#','#','#','#','#'},
                        {'.','.','.','.','.','.','.','.','.','#'},
                        {'#','#','#','.','#','#','.','#','.','#'},
                        {'#','.','#','#','#','.','.','.','#','#'},
                        {'#','.','#','.','.','.','#','.','.','#'},
                        {'#','.','.','.','#','#','#','#','.','#'},
                        {'#','.','#','.','.','.','.','.','#','#'},
                        {'#','.','.','#','.','.','#','.','.','#'},
                        {'#','.','.','.','#','.','.','#','.','#'},
                        {'#','#','#','#','#','#','#','#','.','#'}};

        /*Evite de devoir tester les sortie de tableau*/
        labyrinthe[1][0] = 'S';
        labyrinthe[lignes-1][colones-2] = 'E';

        compterCheminsIt(1, 1);
        System.out.println(cpt);


/*
        for( char[][] chemin : chemins){
            for(int lig = 0 ; lig < lignes; lig ++){
                for(int col = 0 ; col < colones; col ++){
                   System.out.print(chemin[lig][col] == '*' ? chemin[lig][col] : '-');
                }
                System.out.println();
            }
            System.out.println();
        }
*/
    }

}
