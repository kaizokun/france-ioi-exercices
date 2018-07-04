package exercicesFranceIoi.recursiviteAvance.combinaison;

import java.util.Scanner;

/**
 * Created by monsio on 2/12/16.
 */
public class Applications {



    /**
     * Afficher les applications de l'ensemble N [1 - longeur] sur L l'ensemble des lettres
     * On associe à chaque indice une lettre avec repiochage possible
     * F : N -> L
     * taille : L^N
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String lettres = "bimp";//sc.nextLine();
        int longeur = 2;// sc.nextInt();

        int totalApplications = (int) Math.pow(lettres.length(),longeur);

        String applications[] = new String[totalApplications];

        StringBuffer mot = new StringBuffer();

        mot.setLength(longeur);

        applications(longeur, lettres ,applications,0, mot,0);

        for (String app : applications)
        {
            System.out.println(app);
        }

    }

    private static int applications(int longeur, String lettres, String[] applications,int iMot, StringBuffer mot, int pos) {

        if( longeur == 0 ) {
            //System.out.println(mot);
            applications[iMot] = new String(mot);
            return iMot + 1;
        }

        for( int l = 0 ; l < lettres.length() ; l ++){
            mot.setCharAt(pos,lettres.charAt(l));
            iMot = applications(longeur - 1, lettres, applications,iMot, mot,pos+1);
        }

        return iMot;

    }

}
