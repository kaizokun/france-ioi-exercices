package exercicesFranceIoi.matrice;

import exercicesFranceIoi.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by monsio on 3/10/16.
 */
public class Matrice {

    public static int totalMul = 0;
    public static int m[][], s[][];


    public static int coutOptimalMulAsc(List<int[][]> mx){

        int n = mx.size();

        m = new int[n][n];
        s = new int[n][n];

        for( int i = 0 ; i < n ; i ++ ) {
            m[i][i] = 0;
        }

        //pour chaque intervalle de matrices de deux à la totalité
        for( int l = 2 ; l < n + 1 ; l ++ ){
            //pour une intervalle partant de zéro sur une longueur l ( cet intervalle de depart s'arette à n moins la longueur + 1 )
            //on teste chaque intervalle
            for( int i = 0 ; i <  n - l + 1 ; i ++ ){
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i ; k < j ; k ++ ){

                    int q = m[i][k] + m[k+1][j] + ( mx.get(i).length * mx.get(k)[0].length * mx.get(j)[0].length );

                    if( q < m[i][j] ){

                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        return m[0][n-1];

    }


    public static void coutOptimalMulDesc(List<int[][]> listMatrix){

        int n = listMatrix.size();

        m = new int[n][n];
        s = new int[n][n];

        for( int i = 0 ; i < n ; i ++ )
            for( int j = 0 ; j < n ; j ++)
                m[i][j] = Integer.MAX_VALUE;

        coutOptimalMulDesc(listMatrix, m, s, 0, n - 1, 0);

    }

    private static int coutOptimalMulDesc(List<int[][]> l, int[][] m, int[][] s, int i, int j, int d){

        if(m[i][j] < Integer.MAX_VALUE)
            return m[i][j];

        if( i == j )
            return 0;

        for( int k = i ; k < j ; k ++ ){

            int q = coutOptimalMulDesc(l, m, s, i, k, d + 1) + coutOptimalMulDesc(l, m, s, k + 1, j, d + 1) + (l.get(i).length * l.get(k)[0].length * l.get(j)[0].length);

            if( q < m[i][j] ){
                m[i][j] = q;
                s[i][j] = k;
            }
        }

        return m[i][j];
    }

    public static void ordreDecoupage(int n){
        ordreDecoupage(0,n-1);
    }

    private static void ordreDecoupage( int i, int j ){


        if( i == j ) {
            System.out.print("A["+i+"]");
            return;
        }

        int k = s[i][j];
        System.out.print(" ( ");
        ordreDecoupage(i, k);

        System.out.print(" * ");
        ordreDecoupage(k+1,j);
        System.out.print(" ) ");


    }


    private static int[][] multiplicationChaineMatrices( List<int[][]> mx, int i, int j ) throws Exception {

        if( i == j ) {
            return mx.get(i);
        }

        // System.out.println(id+"decoupage [ "+i+" - "+j+" ]");
        int k = s[i][j];

        int[][] m1 = multiplicationChaineMatrices(mx, i, k);

        int[][] m2 = multiplicationChaineMatrices(mx, k + 1,j);

        try {
            return mulMatrix(m1,m2);
        } catch (Exception e) {
            throw new Exception("Incompatibilité entre matrices A["+i+"-"+k+"] et A["+(k+1)+"-"+j+"]");
        }

    }

    public static int[][] mulMatrix(int[][] m1, int[][] m2) throws Exception {


        int n = m1[0].length;

        if( n != m2.length)
            throw  new Exception("Matrices incompatibles");

        totalMul += m1.length * m1[0].length * m2[0].length ;

        int m3L = m1.length, m3C = m2[0].length;

        int[][] m3 = new int[m3L][m3C];

        for( int l = 0 ; l < m3L; l++)
            for( int c = 0 ; c < m3C; c++)
            {
                int somme = 0;
                for(int i = 0 ; i < n ; i ++ )
                    somme += m1[l][i] * m2[i][c];

                m3[l][c] = somme;
            }

        return m3;
    }


    public static void showMatrix(int[][] m){
        for(int[] l : m){
            for( int e : l )
                System.out.printf(e+" ");
              //  System.out.printf("[%2d] ", e);
            System.out.println();
        }
    }


    public static void main(String[] args) {



        int[][] m1 = new int[30][35];
        int[][] m2 = new int[35][15];
        int[][] m3 = new int[15][40];
        int[][] m4 = new int[40][20];
        int[][] m5 = new int[20][25];
        int[][] m6 = new int[25][60];
        int[][] m7 = new int[60][10];
        int[][] m8 = new int[10][45];
        int[][] m9 = new int[45][45];
        int[][] m10 = new int[45][10];


        ArrayList<int[][]> listMatrices = new ArrayList<>();

        listMatrices.add(m1);
        listMatrices.add(m2);
        listMatrices.add(m3);
        listMatrices.add(m4);
        listMatrices.add(m5);
        listMatrices.add(m6);
        listMatrices.add(m7);
        listMatrices.add(m8);
        listMatrices.add(m9);
        listMatrices.add(m10);


/*
        int[][] mulRs = m1;

        try {
            for( int i = 1 ; i < listMatrices.size() ; i ++){
                mulRs = mulMatrix( mulRs,listMatrices.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Nombre de multiplication : "+totalMul);

        showMatrix(mulRs);

        */

        long before = new Date().getTime();

        coutOptimalMulDesc(listMatrices);
       // coutOptimalMulAsc(listMatrices);

        long after = new Date().getTime();

        System.out.println("temps (ms) : "+(after-before));

        int n = listMatrices.size() - 1;

        System.out.println("\ncout optimal : "+m[0][n]);
        System.out.println("\npremier decoupage optimal : "+s[0][n]);
        System.out.println();
        ordreDecoupage(listMatrices.size());
        System.out.println();
        try {
           int[][] rs =  multiplicationChaineMatrices(listMatrices,0,listMatrices.size()-1);

           // showMatrix(rs);
            System.out.println();
            System.out.println(rs.length+" X "+rs[0].length);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
