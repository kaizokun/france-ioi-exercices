package exercicesFranceIoi.recursiviteAvance.combinaison;

/**
 * Created by monsio on 2/13/16.
 */
public class Util {


    public static int factorielle(int n){
        if( n == 0 )
            return 1;
        return n * factorielle(n-1);
    }

    public static int nbArrangements(int n, int p)
    {
        if (p == 1)
            return n;
        return n * nbArrangements(n-1,p-1);
    }

    public static int combinaisons(int n, int p ){
        return nbArrangements(n,p) / factorielle(p);
    }


}
