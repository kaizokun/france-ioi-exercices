package exercicesFranceIoi.recursiviteAvance.combinaison;

import java.util.Scanner;

/**
 * Created by monsio on 2/12/16.
 */
public class Combinaisons {

    /**
     * Afficher les combinaisons injectives de l'ensemble N [1 - longeur] sur L l'ensemble des lettres
     * On associe à chaque indice une lettre sans repiochage possible
     * taille : fact(|N|) / fact(|N|-|L|)
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String lettres = "ABCDE";//sc.nextLine();
        int choixTotal = 3;// sc.nextInt();

        int totalCombinaisons = Util.combinaisons(lettres.length(), choixTotal);

        String combinaisons[] = new String[totalCombinaisons];

        StringBuffer combinaison = new StringBuffer();

        combinaison.setLength(choixTotal);

        combinaisons(lettres, choixTotal, combinaisons, combinaison,0 , 1, choixTotal);

        for (String app : combinaisons)
        {
            System.out.println(app);
        }

    }

    /**
     * La boucle s'execute à chaque appel tant que : choixRestants <= lettres.length() - debut + 1
     * choix restant donne le nombre d'element à selectionner pour une sous combinaison à partir d'un certain debut.
     * Il faut donc qu'il reste suffisemment d'element donné par le ( nombre d'element total - debut + 1 )
     **
     * Par exemple pour une combinaison de 3 elements parmis un ensemble de 5 elements (ABCDE)
     * Lors du premier appel recursif le debut est à 1.
     * il nous faut donc choisir une combinaison de 3 elements parmis 5 - 1 + 1 = 5 ce qui est encore réalisable
     * Par contre arrivé à D le debut vaut 4 il n'est donc plus possible de choisir une combinaison de 3 éléments parmis 5 - 4 + 1 = 2 elements restant ...
     *
     * Pour traduire en français la création d'une combinaison de manière récursive :
     * Creer une combinaison de m elements parmis n, consiste à choisir un element n1 puis de l'associer à une combinaison de m-1 éléments parmis n sauf n1, et ainsi de suite...
     *
     * */

    private static int combinaisons( String lettres, int choixTotal, String[] combinaisons, StringBuffer combinaison, int idCombinaison, int debut, int choixRestants) {

        if( choixRestants == 0 ) {
            combinaisons[idCombinaison] = new String(combinaison);
            return idCombinaison + 1;
        }


        while( choixRestants <= lettres.length() - debut + 1 ){

            char lettre = lettres.charAt(debut-1);
            combinaison.setCharAt(choixTotal-choixRestants, lettre);
            idCombinaison = combinaisons(lettres, choixTotal, combinaisons, combinaison, idCombinaison, debut + 1, choixRestants - 1);
            debut ++;
        }

        return idCombinaison;

    }


}
