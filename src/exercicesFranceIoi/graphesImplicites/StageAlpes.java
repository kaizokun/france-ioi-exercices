package exercicesFranceIoi.graphesImplicites;

import java.util.LinkedList;

/**
 * Created by monsio on 2/22/16.
 */
public class StageAlpes {

    static int longeurCircuit = 100, nombreJours = 100, cptr = 0 ;
    static int circuit[] = new int[nombreJours];

    public static void main(String[] args) {

        stages(0,1);

    }



    public static void stages( int jour, int longueurprecedente ){

        if(jour == nombreJours ) {

            StringBuilder str = new StringBuilder("");
            for(int c : circuit)
                str.append(c+" ");
            System.out.println(str);

            return;
        }

        for( int l = longueurprecedente ; l <= longeurCircuit ; l ++ ){
            circuit[jour] = l;
            stages(jour + 1, l);
        }

    }


}
