package exercicesFranceIoi.programmation_dynamique;

import exercicesFranceIoi.util.Util;

/**
 * Created by monsio on 02/06/16.
 */
public class ChoixActivités {

    private static final int S = 0, E = 1;
    private static A[] a;
    private static int[][] m;
    private static A[][] c;

    /*
    * p : previous
    * n : next
    * t : total
    * */


    public static void choixActiviteMax2(){

        m[0][0] = 0;
        m[a.length-1][a.length-1] = 0;

        for( int i = 1 ; i < a.length - 1 ; i ++)
            for( int j = 1 ; j < a.length - 1 ; j ++)
            m[i][j] = 0;

        for( int i = 1 ; i < a.length - 1 ; i ++)
            m[i][i] = 1;

        int max = choixActiviteMax2(0,a.length-1,0);

        System.out.println(max);

    }

    public static int choixActiviteMax2(int i, int j, int d){

        String id = Util.getIdent(d);

        System.out.println(id+"]"+i+" - "+j+"[");

        if( i == j || m[i][j] > 0  ){
            System.out.println(id+"Valeur : "+m[i][j]);
            return m[i][j];
        }

        int max = 0;

        for( int k = i+1; k < j ; k ++ )
            if( a[k].s >= a[i].e && a[k].e <= a[j].s ){
                System.out.println(id+"subdivision : ]"+i+" - "+k+"[ ET ]"+k+" - "+j+"[");
                int curMax = choixActiviteMax2(i,k,d+1) + choixActiviteMax2(k,j,d+1) + 1;
                max = Math.max(max, curMax);
                System.out.println(id+"["+(i+1)+" - "+(j-1)+"] ("+k+")    MAX : "+curMax);
            }

        m[i][j] = max;

        System.out.println(id+"Max : "+m[i][j]);

        return max;

    }

    public static int choixActiviteMax(int p, int d){

        String id = Util.getIdent(d);

        int aS = a[p].s;
        int aE = a[p].e;

        System.out.println(id + " " + a[p]);

        if( m[aS][aE] > Integer.MIN_VALUE ) {
            System.out.println();
            return m[aS][aE];
        }

        if( p + 1 == a.length ) {
            System.out.println();
            return 0;
        }

        int max = Integer.MIN_VALUE; A ch = null;

        for( int n = p + 1 ; n < a.length ; n ++ ){
            if( a[n].s >= a[p].e ){

                int t = 1 + choixActiviteMax(n,d+1);

                if( t > max ){
                    max = t;
                    ch = a[n];
                }
            }
        }

        //System.out.println(id+max);

        m[aS][aE] = max;
        c[aS][aE] = ch;

        return max;

    }

    public static void voirChoix(A a, int f){

        if( f >= 0 ){

            System.out.print(a);
            voirChoix(c[a.s][a.e],f-1);
        }

    }

    public static void main(String[] args) {

        a = new A[]{new A(0,0),new A(1,4),new A(3,5),new A(0,6),new A(5,7),new A(3,9),new A(5,9),new A(6,10),
                new A(8,11),new A(8,12),new A(2,14),new A(12,16),new A(Integer.MAX_VALUE,Integer.MAX_VALUE)};
        m = new int[13][17];
        c = new A[13][17];


        /*
        for(int i = 0 ; i <= 12 ; i ++ )
            for(int j = 0 ; j <= 16 ; j ++ )
                m[i][j] = Integer.MIN_VALUE;

        choixActiviteMax(0,0);

        System.out.println(" maximum : "+m[0][0]);

        voirChoix(a[0],m[0][0]);
*/

        choixActiviteMax2();
    }

    static class A {
        public int s,e;

        public A(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "["+s+" - "+e+"] ";
        }
    }

}
