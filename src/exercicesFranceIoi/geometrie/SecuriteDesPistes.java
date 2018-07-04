package exercicesFranceIoi.geometrie;

import java.util.Scanner;

/**
 * Created by monsio on 2/8/16.
 */
public class SecuriteDesPistes {

    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);

        double xa1 = 20;//sc.nextInt();
        double ya1 = 0;//sc.nextInt();
        double xa2 = 27;//sc.nextInt();
        double ya2 = 27;//sc.nextInt();


        double xb1 = 43;//sc.nextInt();
        double yb1 = 10;//sc.nextInt();
        double xb2 = 38;//sc.nextInt();
        double yb2 = 33;//sc.nextInt();


        Vecteur v1 = new Vecteur(new Point(xa1,ya1),new Point(xa2,ya2));
        Vecteur v2 = new Vecteur(new Point(xb1,yb1),new Point(xb2,yb2));

        System.out.println(v1.intersectionS2e(v2));

    }

}
