package exercicesFranceIoi.geometrie;

/**
 * Created by monsio on 2/3/16.
 */
public class Util {

    public static double distanceDeuxPoint( Point p1, Point p2 ){
      return Math.sqrt(Math.pow(p1.x - p2.x,2.0) + Math.pow(p1.y - p2.y,2.0));
    }

    /*====================== SOMMET ANGLE DROIT ======================*/

    public static double projectionCoteSurBase(Point b1, Point b2, Point sommet){
        return projectionCoteSurBase(distanceDeuxPoint(b1,b2),distanceDeuxPoint(b1,sommet));
    }

    public static double projectionCoteSurBase (double base, double baseSommet){
        return Math.pow(baseSommet,2.0) / base;
    }

    /*================================================================*/

    public static double projectionSommetBase(Point A, Point C, double normeAB, double xAB, double yAB){

        double xAC = C.x - A.x,
               yAC = C.y - A.y;

        return (xAC * xAB + yAC * yAB) / normeAB;

    }


}
