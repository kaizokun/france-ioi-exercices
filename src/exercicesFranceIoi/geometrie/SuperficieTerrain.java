package exercicesFranceIoi.geometrie;

import java.util.Scanner;

class SuperficieTerrain
{


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int xa1 = scan.nextInt(),
                ya1 = scan.nextInt(),
                xa2 = scan.nextInt(),
                ya2 = scan.nextInt();

        int mainSurface = (xa2-xa1) * (ya2-ya1);

        int n = scan.nextInt();

        for( int i = 0 ; i < n ; i ++ ){

            int xb1 = scan.nextInt(),
                    yb1 = scan.nextInt(),
                    xb2 = scan.nextInt(),
                    yb2 = scan.nextInt();

            mainSurface -= Math.max(0, Math.min(xa2,xb2)-Math.max(xa1,xb1)) *
                    Math.max(0, Math.min(ya2,yb2)-Math.max(ya1,yb1));

        }

        System.out.println(mainSurface);



    }


}
