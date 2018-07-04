package exercicesFranceIoi.geometrie;

import static exercicesFranceIoi.geometrie.Util.*;

/**
 * Created by monsio on 2/3/16.
 */
public class ReperageDeLieu {


    public static void main(String[] args){

        Vecteur dr = new Vecteur(new Point(20,30),new Point(60,10));

        Point[] pts = new Point[]{
                new Point(10, 10),
                new Point(40, 10),
                new Point(70, 20),
                new Point(20, 60),
                new Point(50, 40),
                new Point(10, 35)
        };


        double normAB = dr.normeVecteur();

        double xAB = dr.longueurAbscisse();
        double yAB = dr.longeurOrdonnee();

        for (Point pt : pts) {

            double distance = projectionSommetBase(dr.getOrigine(),pt,normAB,xAB,yAB);
            System.out.println(distance);
        }


    }

}
