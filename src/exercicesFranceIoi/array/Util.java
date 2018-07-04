package exercicesFranceIoi.array;

import java.util.List;

/**
 * Created by monsio on 13/08/2015.
 */
public class Util {


    public static void showTab( List tab){

        if(tab.isEmpty())
            return;

        System.out.println();
        for(Object t : tab)
            System.out.print(t+" ");

        System.out.println();

    }



}
