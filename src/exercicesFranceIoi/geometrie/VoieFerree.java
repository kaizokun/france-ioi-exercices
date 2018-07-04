package exercicesFranceIoi.geometrie;

import java.util.Scanner;
import static java.lang.Math.*;

/**
 * Created by monsio on 2/5/16.
 *
 * Lire les points d'extremités du segment AB sur droite D
 * Pour chaque point P
 *      calculer la projection de AP sur la D
 *      calculer le cote restant à parti de AP et de la projection
 * Fin Pour
 *
 */


public class VoieFerree {

    public static double normeVecteur(Point A, Point B){
       return sqrt( pow(A.x - B.x,2.0) + pow(A.y - B.y,2.0));
    }

    public static void main(String[] args) {

        //Scanner scan = new Scanner(System.in);
/*
        Node A = new Node(scan.nextInt(), scan.nextInt()),
              B = new Node(scan.nextInt(), scan.nextInt());
*/
        Point A = new Point(20,0),
              B = new Point(25,28);

        double normeAB = normeVecteur(A, B);
        double xAB = A.x - B.x,
               yAB = A.y - B.y;

        //int nPts = scan.nextInt();
        int nPts = 10;

        Point pts[] = new Point[]{
                new Point(10,3),
                new Point(18,8),
                new Point(3,18),
                new Point(13,21),
                new Point(9,30),
                new Point(15,38),
                new Point(25,36),
                new Point(27,45),
                new Point(38,42),
                new Point(45,36),
        };

        double maxDistCarre = 0;

        Point maxPoint = null;

        for( int i = 0 ; i < nPts ; i ++ ){

            //Node P = new Node(scan.nextInt(),scan.nextInt());

            Point P = pts[i];

            double xAP = A.x - P.x,
                   yAP = A.y - P.y;

            double distPointDroiteCarre = abs(xAP * yAB - yAP * xAB);

            if( distPointDroiteCarre > maxDistCarre ) {
                maxDistCarre = distPointDroiteCarre;
                maxPoint = P;
            }

        }

        System.out.println((int)maxPoint.x+" "+(int)maxPoint.y);

    }

}
