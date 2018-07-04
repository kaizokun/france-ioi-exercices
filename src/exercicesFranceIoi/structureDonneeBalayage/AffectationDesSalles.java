package exercicesFranceIoi.structureDonneeBalayage;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by monsio on 2/11/16.
 */
public class AffectationDesSalles {

    static class Show {

        public int start,end, salle;

        public Show(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }


    static class Evenement implements Comparable<Evenement>{

        public int date;
        public boolean isStart = false;
        public Show show;

        public Evenement(int date, Show show, boolean isStart) {
            this.date = date;
            this.show = show;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Evenement event2) {

            int cmpDate = date - event2.date;

            /*Si les deux dates sont equivalentes et qu'il s'agit d'un evenemnt de fin et de debut l'evenemtn de fin
            * doit être pris en compte en premier afin de liberer la salle affecté.
            * */
            if(cmpDate == 0 && isStart && !event2.isStart)
                    return 1;

            return cmpDate;
        }

    }


    public static void main(String[] args) {

        int salles = 2;
        int totalShow = 5;

        Show shows[] = new Show[]{
                new Show(0,4),
                new Show(4,9),
                new Show(2,6),
                new Show(7,11),
                new Show(10,12)};

        Evenement dates[] = new Evenement[totalShow*2];

        for(int i = 0,j = 0 ; i < (totalShow * 2) ; i+=2,j++){
            dates[i] = new Evenement(shows[j].start,shows[j],true);
            dates[i+1] = new Evenement(shows[j].end,shows[j],false);
        }

        Arrays.sort(dates);

        LinkedList<Integer> sallesDispo = new LinkedList();

        for( int iSalle = salles ; iSalle > 0 ; iSalle -- )
            sallesDispo.add(iSalle);

        for( Evenement date : dates){

            if(date.isStart){

                if( sallesDispo.isEmpty() ){
                    System.out.println("NON");
                    System.exit(0);
                }

                date.show.salle = sallesDispo.pollLast();

            }else{
                sallesDispo.add(date.show.salle);
            }

        }


        for(Show show : shows){
            System.out.print(show.salle+" ");
        }
    }

}
