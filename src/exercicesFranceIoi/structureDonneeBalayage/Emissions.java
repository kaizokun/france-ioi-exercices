package exercicesFranceIoi.structureDonneeBalayage;

/**
 * Created by monsio on 1/31/16.
 */
public class Emissions {


    public static int getMaxEmissions(int tab[], int length){

        int max = 0, currentLength = 0;

        for( int s = 0, e = 0; e < tab.length; e ++ ){

            currentLength += tab[e];

            while( currentLength > length ){
                currentLength -= tab[s];
                s++;
            }

            max = Math.max(max,(e+1)-s);

        }

        return max;

    }


    public static void main(String[] args) {

        System.out.println(getMaxEmissions(new int[]{3, 4, 3, 12, 5, 2, 2},9));

        System.out.println(getMaxEmissions(new int[]{7, 3, 6, 2, 5, 4, 13, 1, 1, 3, 7},21));

    }

}
