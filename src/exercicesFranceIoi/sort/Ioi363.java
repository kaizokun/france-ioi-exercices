package exercicesFranceIoi.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by monsio on 1/13/16.
 */
public class Ioi363 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int totalCar = scan.nextInt();

        int depart[] = new int[totalCar];

        for( int n = 0 ; n < totalCar ; n ++ ){
            depart[n] = scan.nextInt();
        }

        List<String> deplacements = new LinkedList<>();

        for( int a = 0 ; a < totalCar ; a ++){
            for( int fin = totalCar - 1; fin > a ; fin --  ){
                int car1 = depart[fin];
                int car2 = depart[fin-1];
                if( car1 < car2 ){
                    deplacements.add(car2+" "+car1);
                   // System.out.println(car2+" "+car1);
                    depart[fin - 1] = car1;
                    depart[fin] = car2;
                }
            }
        }

        System.out.println(deplacements.size());
        for( String str : deplacements){
            System.out.println(str);
        }

    }

}
