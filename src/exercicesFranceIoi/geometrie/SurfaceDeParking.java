package exercicesFranceIoi.geometrie;

import java.util.Scanner;

/**
 * Created by monsio on 2/8/16.
 *
 * 20 0
 35 48
 44 11
 */
public class SurfaceDeParking {


    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);

       /* Node sommet = new Node(sc.nextInt(),sc.nextInt());
                Vecteur base = new Vecteur(
                new Node(sc.nextInt(),sc.nextInt()),
                new Node(sc.nextInt(),sc.nextInt()));
        */



        Point p1 = new Point(20,0),p2 =  new Point(35,48), p3 = new Point(44,11);

        Vecteur base = new Vecteur(p1,p3);

        double hauteur =  base.projectioCroix(new Vecteur(base.getOrigine(), p2));

        double surface = base.getNormeVecteur() * hauteur;

        System.out.println("base : "+base.getNormeVecteur());
        System.out.println("hauteur : "+hauteur);

        System.out.println((int)surface);

    }
}
