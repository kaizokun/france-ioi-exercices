package exercicesFranceIoi.string;

import java.util.Scanner;

/**
 * Created by monsio on 1/8/16.
 */
public class IoI342j {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        StringBuffer texte = new StringBuffer(scan.nextLine());

        int charCpt[] = new int[26];

        int iMax = 0;
        int max = 0;

        for( int i = 0 ; i < 26 ; i ++ ){
            charCpt[i] = 0;
        }

        for( int c = 0 ; c < texte.length() ; c ++ ){

            char car = texte.charAt(c);

            if(Character.isLetter(car)) {

                int index = Character.toUpperCase(car) - 'A';

                charCpt[index]++;

                if (charCpt[index] > max) {
                    max = charCpt[index];
                    iMax = index;
                }

            }
        }

        int decalage = - (iMax + 'A' - 'E');

        System.out.println((char)(iMax+'A')+" "+decalage);

        char start;

        for( int c = 0 ; c < texte.length() ; c ++ ){

            char car = texte.charAt(c);

            if( Character.isLetter(car)) {

                start = Character.isUpperCase(car) ? 'A' : 'a';

                char decrypt = (char) (start + ( ( car - start + decalage + 26 ) % 26 ));

                System.out.print(decrypt);
            }else {
                System.out.print(car);
            }

        }


    }
}
