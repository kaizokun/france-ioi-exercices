package exercicesFranceIoi.structureDonneeBalayage;

import java.util.ArrayList;
import java.util.Collections;

/** Created by monsio on 2/11/16.
 */
public class FermetureAnnuelle {

    public static void main(String[] args) {

        int longeurAnnee = 100;
        int nombreShow = 4;

        int inter[][] = new int[][]{
            {90,20},{40,60},{10,30},{65,70}
        };

        ArrayList<AffectationDesSalles.Evenement> events = new ArrayList<>();

        boolean chevauchement = false;

        for( int i = 0 ; i < nombreShow ; i ++ ){

            events.add(new AffectationDesSalles.Evenement(inter[i][0],null,true));
            events.add(new AffectationDesSalles.Evenement(inter[i][1],null,false));

            if( inter[i][0] > inter[i][1]){
                events.add(new AffectationDesSalles.Evenement(0,null,true));
                events.add(new AffectationDesSalles.Evenement(longeurAnnee,null,false));
                chevauchement = true;
            }

        }

        Collections.sort(events);

        int dureeMax = 0;
        int enCour = 0;
        int lastEnd = 0;

        if(!chevauchement) {
            //events.add(new AffectationDesSalles.Evenement(longeurAnnee, null, true));
            dureeMax = events.get(0).date + ( longeurAnnee - events.get(events.size()-1).date );
        }

        for(AffectationDesSalles.Evenement event : events){

            if( event.isStart ){

                if( enCour == 0 )
                    dureeMax = Math.max(event.date - lastEnd,dureeMax);

                enCour ++;

            }else{
                enCour --;
                if(enCour == 0)
                    lastEnd = event.date;
            }

        }

        System.out.println(dureeMax);

    }
}
