package exercicesFranceIoi.graphesImplicites;

import exercicesFranceIoi.graphes.Util;
import static java.lang.Math.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by monsio on 2/23/16.
 */
public class GrilleDeCouleur {

    static int ligs ,cols;
    static boolean trouve;
    static char[][] plateau;
    static boolean[] fait;
    static int moves[][] = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    static LinkedList<String> chemins = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        ligs = 6;// sc.nextInt();
        cols = 6;//sc.nextInt();

        Case.setMaxCols(cols);
        Case.setMaxLigs(ligs);

        //fait = new boolean[(int) pow(Case.DIM,4)];
        fait = new boolean[(int) (pow(Case.maxLigs,2)*pow(Case.maxCols,2))];

/**
        plateau = new char[][]{
                {'R','B','V','V'},
                {'J','V','B','B'},
                {'R','B','J','R'}
        };

*/
        plateau = new char[][]{
                {'V','B','V','R','J','B'},
                {'R','J','R','B','R','V'},
                {'V','B','J','J','R','R'},
                {'B','R','R','B','J','J'},
                {'J','B','V','J','V','R'},
                {'V','R','J','J','B','V'}};


        deplacerPions(new Case(0,0),new Case(cols-1,ligs-1), 0);

        if (trouve)
            System.out.println(1);
        else
            System.out.println(0);



    }

    private static void deplacerPions(Case pion1, Case pion2, int depth) {

        if(trouve)
            return;
        if(!pion1.estDansplateau() || !pion2.estDansplateau())
            return;
        if(plateau[pion1.getY()][pion1.getX()] != plateau[pion2.getY()][pion2.getX()])
            return;

        int idSItuation = Case.idSituation(pion1,pion2);

        String ident = Util.getIdent(depth);

        if( fait[idSItuation] ) {
           /* chemins.add(ident+"FAIT : ["+pion1.getX()+";"+pion1.getY()+"] "+plateau[pion1.getY()][pion1.getX()]+"" +
                    " ["+pion2.getX()+";"+pion2.getY()+"] "+plateau[pion2.getY()][pion2.getX()]);*/
            return;
        }

        fait[idSItuation] = true;

        chemins.add(ident+"["+pion1.getX()+";"+pion1.getY()+"] "+plateau[pion1.getY()][pion1.getX()]+"" +
                " ["+pion2.getX()+";"+pion2.getY()+"] "+plateau[pion2.getY()][pion2.getX()]);

        if(pion1.x == cols - 1 && pion1.y == ligs - 1 && pion2.x == 0 && pion2.y == 0){
            trouve = true;
            for(String chemin : chemins)
                System.out.println(chemin);

            chemins = new LinkedList<>();
            return;
        }

        for(int dpP1 = 0 ; dpP1 < 4 ; dpP1 ++ ){

            int p1y2 = pion1.y + moves[dpP1][0];
            int p1x2 = pion1.x + moves[dpP1][1];

            for(int dpP2 = 0 ; dpP2 < 4 ; dpP2 ++ ){
                int p2y2 = pion2.y + moves[dpP2][0];
                int p2x2 = pion2.x + moves[dpP2][1];

                deplacerPions(new Case(p1x2,p1y2),new Case(p2x2,p2y2),depth+1);

            }
        }

        chemins.pollLast();

    }


    static class Case{

        private static int DIM = 30;
        private static int maxLigs,maxCols;
        private int x,y;

        public Case(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /*Retourne le numéro de case pour un tableau de haut en bas et de gauche à droite
                 * case[0][0] = 0 case[29][29] = 29 * 30 + 29 = 870 + 29 = 899
                  * */
        public int idCase(){
            return x * maxLigs + y;
        }

        public static Case caseDeId(int idCase){
            return new Case(idCase/maxLigs, idCase%maxLigs);
        }

        public boolean estDansplateau(){
            return x >=0 && x < maxCols && y >=0 && y < maxLigs;
        }

        public static int idSituation(Case c1, Case c2){
           return c1.idCase() * maxLigs * maxCols + c2.idCase();
        }

        public static Case case1De(int idSituation){
            return caseDeId(idSituation / (maxLigs * maxCols));
        }

        public static Case case2De(int idSituation){
            return caseDeId(idSituation % (maxLigs * maxCols));
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public static int getMaxCols() {
            return maxCols;
        }

        public static int getMaxLigs() {
            return maxLigs;
        }

        public static int getDIM() {
            return DIM;
        }

        public static void setDIM(int DIM) {
            Case.DIM = DIM;
        }

        public static void setMaxLigs(int maxLigs) {
            Case.maxLigs = maxLigs;
        }

        public static void setMaxCols(int maxCols) {
            Case.maxCols = maxCols;
        }
    }




}
