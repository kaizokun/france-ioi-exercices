package exercicesFranceIoi.string;

import java.util.Scanner;

/**
 * Created by monsio on 1/7/16.
 */
public class IoI342i {

    public static void main(String[] args) {

        System.out.println(100%122);
        Scanner scan = new Scanner(System.in);

        int nPages = scan.nextInt();

        scan.nextLine();

        int code;
        for( int p = 2 ; p <= nPages ; p ++ ){

            if( p % 2 == 0 ){
                code = -3 * p;
            }else{
                code = 5 * p;
            }

            code %= 26;

            StringBuffer texte = new StringBuffer(scan.nextLine());

            for( int c = 0 ; c < texte.length() ; c ++ ){

                char chara = texte.charAt(c);
                char start;

                if( Character.isLetter(chara) ){

                    start = Character.isUpperCase(chara) ? 'A' : 'a';

                    chara = (char)( start + ( chara - start + code + 26 ) % 26 );

                    texte.setCharAt(c, chara);
                }

            }

            System.out.println(texte);


        }

    }
}
