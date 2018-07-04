package exercicesFranceIoi.algorithmeGlouton;

import exercicesFranceIoi.matrice.Matrice;
import exercicesFranceIoi.util.Util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by monsio on 21/06/16.
 */
public class ChaineProductionBis {

    static int D = 1, TE = 0;

    static int M1[][] = new int[][]{{1,0},{3,0}},
               M2[][] = new int[][]{{3,0},{8,0}};

    static int P[] = new int[]{0,0,0};
    static int F[];
    static int fMin = Integer.MAX_VALUE;

    public static void teMinA( int[][] M ){

        for( int j = 0 ; j < P.length ; j ++ ){
            int p = P[j];
            int debutMin = Integer.MAX_VALUE;
            int finMin = Integer.MAX_VALUE;
            int iMachMin = -1;

            for( int i = 0 ; i < M.length ; i ++ ){
                int[] m = M[i];
                int debut = Math.max(p, m[D]);

                int fin = debut + m[TE];

                if( fin <= finMin && debut <= debutMin ){
                    finMin = fin;
                    debutMin = debut;
                    iMachMin = i;
                }

            }

            M[iMachMin][D] = finMin;
            P[j] = finMin;

        }

        int pMax = Integer.MIN_VALUE;

        for( int p : P ){
            if( p > pMax )
                pMax = p;
        }

        for(int p : P)
            System.out.print(p + " ");
        System.out.println();
        System.out.println(pMax);

    }

    public static void teMinB( int iP ){

        String d = Util.getIdent(iP);

        if( iP == P.length  ){
            System.out.print(d);

            for(int f : F)
                System.out.print(f+" ");
            System.out.println();

            int max =Integer.MIN_VALUE;

            for(int f : F)
                max = Math.max(max,f);

            fMin = Math.min(max,fMin);

            return;
        }

        for( int i = 0 ; i < M2.length ; i ++ ){
            int[] m = M2[i];
            //disponibilite machine
            int di = m[D];
            //debut du traitement ud produit soit le maximum entre la dispo machine et produit
            int debut = Math.max(m[D],P[iP]);
            //fin de traitement du produit
            int fin = debut + m[TE];


            //modification de la disponibilite machine
            m[D] = fin;
            //sauvegarde de la fin de l intervalle pour ce produit
            //System.out.println(d+"enregistrement de "+fin+" à l'indice "+iP);
            F[iP] = fin;

            //LF.add(fin);
            //rapelle pour le prochain produit
            //if( fin < fMin )
                teMinB(iP + 1);
            //LF.removeLast();
            //reinitialisation de la disponibilite machine
            m[D] = di;

        }

    }


    public static void main(String[] args) {

        F = new int[P.length];

        Arrays.sort(M2, new Comparator<int[]>() {
            @Override
            public int compare(int[] m1, int[] m2) {
                return m1[TE] - m2[TE];
            }
        });

        teMinA(M1);

        teMinB(0);

        System.out.println(fMin);


    }

}


