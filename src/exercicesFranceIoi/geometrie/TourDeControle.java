package exercicesFranceIoi.geometrie;

import java.util.Scanner;

/**
 * Created by monsio on 2/3/16.
 */
public class TourDeControle {


    public static Point closedPoint(Point [] points, Point pt){

        Point closedPt = new Point(0,0);

        double minDist = Double.MAX_VALUE;

        for(Point cpt : points){

            double dist = Util.distanceDeuxPoint(pt,cpt);

            if( dist < minDist ){
                minDist = dist;
                closedPt.x = cpt.x;
                closedPt.y = cpt.y;
            }
        }

        return closedPt;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Point tour = new Point(scan.nextInt(),scan.nextInt());

        int nHouses = scan.nextInt();

        Point houses[] = new Point[nHouses];

        System.out.println(closedPoint(houses,tour));

    }


}

