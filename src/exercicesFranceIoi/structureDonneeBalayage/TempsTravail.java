package exercicesFranceIoi.structureDonneeBalayage;

import exercicesFranceIoi.util.Util;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by monsio on 2/2/16.
 */
public class TempsTravail {


    /*
    * Avec un tableau d'intervalles [debut-fin] trié par débuts d'intervalles croissants
    *
    * ___________         __________________________     ____________
    *       ________    ___________    _______
    *
    *
    * On conserve à chaque fois la plus grande fin d'intervalle trouvé AbscMax, au debut zero.
    * Une intervalle rencontré par la suite aura pour depart la plus grand valeur entre son debut et AbscMax
    * et pour fin la plus grand valeur entre sa fin et AbscMax.
    *
    * decette manière les intersection entre intervalles ne sont pas additionné à la somme totale.
    *
    * ___________                  _________________     ____________
    *            ___    ___________
    *
    * */

    public static int sumTimes(Intervalle intervalles[]){

        Arrays.sort(intervalles, new Comparator<Intervalle>() {
            @Override
            public int compare(Intervalle i1, Intervalle i2) {
                return i1.start - i2.start;
            }
        });

        int som = 0;
        int abscisseMax = 0;
        for( Intervalle inter : intervalles ){
            som+= Math.max(inter.end,abscisseMax) - Math.max(inter.start,abscisseMax);
            abscisseMax = Math.max(inter.end,abscisseMax);
        }

        return som;
    }

    public static int sumTimes2(Intervalle intervalles[]) {

        /*decouper les intervalles en evenements de debut et de fin*/

        int events[] = new int[intervalles.length*2];

        int iEvent = 0;

        for(Intervalle inter : intervalles){

            /*multiplier par deux permet d'avoir des nombres pair pour chaque valeurs
            * Ensuite le modulo sur l'indice permet d'avoir un nombre paire pour les debut et impair pour les fins
            * Par la suite la division par deux de l'evenement permettra de retrouver la valeur initiale
            * */

            events[iEvent] = (2 * inter.start) + (iEvent++ % 2);

            events[iEvent] = (2 * inter.end) + (iEvent++ % 2);

        }

        Arrays.sort(events);


        int premier = 0, somme = 0, nbreOuvert = 0;

        for(int date : events){

            //Si il s'agit d'un evenement de début
            if( date % 2 == 0 ){
                //Si aucune intervalle en cour n'est ouverte, sinon cet evenement sera tout simplement ignoré
                if(nbreOuvert == 0)
                    //on enregistre l'evenement comme debut d'intervalle ouverte
                    premier = date/2;

                //on incremente le nombre d'evenement de debut d'intervalle ouvert
                nbreOuvert ++;
            }
            //Il s'agit d'un evenement de fin
            else{
                //on decremente le nombre d'evenements d'intervalle ouverte
                nbreOuvert --;

                //cet evenement ferme un unique intervalle ouverte en cour
                if(nbreOuvert == 0){
                    somme += (date/2) - premier;
                }


            }


        }

        return somme;
    }


    static class Intervalle{
        public Intervalle(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int start, end;
    }

    public static void main(String[] args) {

        int nInter = Util.lireInt();
        Intervalle[] intervales = new Intervalle[nInter];

        for(int i = 0 ; i < nInter ; i ++ ){
            intervales[i] = new Intervalle(Util.scan.nextInt(),Util.scan.nextInt());
        }

        System.out.println(sumTimes(intervales));
        System.out.println(sumTimes2(intervales));


    }

}
