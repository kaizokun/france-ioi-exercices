package exercicesFranceIoi.geometrie;

/**
 * Created by monsio on 2/7/16.
 */
public class PisteAtterissage {

    public static void main(String[] args) {

        Point tour = new Point(25,28);

        Vecteur pistes[] = new Vecteur[]{
                new Vecteur(new Point(10,3),new Point(3,18)),
                new Vecteur(new Point(18,8),new Point(13,21)),
                new Vecteur(new Point(9,30),new Point(15,38)),
                new Vecteur(new Point(25,36),new Point(27,45)),
                new Vecteur(new Point(38,42),new Point(45,36)),
        };


        Vecteur plusProchePiste = null;

        double distanceMin = Double.MAX_VALUE;
/*
        for(Vecteur piste : pistes){

            double longeurPiste = Util.distanceDeuxPoint(piste.extremite, piste.origine);

            double xPiste = piste.longueurAbscisse();
            double yPiste = piste.longeurOrdonnee();

            double projectionP1TourSurPiste = Util.projectionSommetBase(piste.origine,tour,longeurPiste,xPiste,yPiste);

            double curMin;

            if( projectionP1TourSurPiste < 0 ){
                curMin = Util.distanceDeuxPoint(piste.origine, tour);
            }else if( projectionP1TourSurPiste < longeurPiste ){
                double xP1Tour = tour.x - piste.origine.x;
                double yP1Tour = tour.y - piste.origine.y;
                double distancePisteTour = Math.abs(xP1Tour * yPiste - yP1Tour * xPiste) / longeurPiste;
                curMin = distancePisteTour;
            }else{
                curMin = Util.distanceDeuxPoint(piste.extremite, tour);
            }


            if( curMin < distanceMin ){
                distanceMin = curMin;
                plusProchePiste = piste;
            }


        }
*/
        double curMin;

        for(Vecteur piste : pistes){


            Vecteur v2 = new Vecteur(piste.getOrigine(), tour);

            double projection = piste.projection(v2);

            if( projection < 0 ){
                curMin = v2.getNormeVecteur();
            }else if( projection < piste.getNormeVecteur() ){
                curMin = piste.projectioCroix(v2);
            }else{
                curMin = new Vecteur(piste.getExtremite(),tour).getNormeVecteur();
            }


            if( curMin < distanceMin ){
                distanceMin = curMin;
                plusProchePiste = piste;
            }


        }

        System.out.println(distanceMin+" "+plusProchePiste);

    }

}
