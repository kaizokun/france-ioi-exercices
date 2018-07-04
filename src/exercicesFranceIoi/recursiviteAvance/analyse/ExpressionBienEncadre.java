package exercicesFranceIoi.recursiviteAvance.analyse;

import java.io.*;

/**
 * Created by monsio on 2/13/16.
 */
public class ExpressionBienEncadre {

    private static String charOuvrants = "([{<",
                          charFermants = ")]}>";

    private static int pos = 0;


/*#include  int main(){
    int liste[2[ = {1, 4}; return (liste[0] + liste[1]);
}*/

    interface ReadChar{
        char read();
    }

    public static boolean bienEncadre(final String expression, char fermant){
        return bienEncadre(fermant, new ReadChar() {
            @Override
            public char read() {
                return expression.charAt(pos++);
            }
        });
    }

    public static boolean bienEncadre( File file ){

        try {

            final FileReader fr = new FileReader(file);

            return bienEncadre((char)-1, new ReadChar() {
                @Override
                public char read() {

                    try {
                        return (char) fr.read();
                    } catch (IOException e) {
                       System.exit(-1);
                       return (char) -1;
                    }
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }


    }

    public static boolean bienEncadre( char fermant, ReadChar read){

        final String OUVRANTS = "([{<",
                     FERMANTS = ")]}>"+((char)-1);

        char courant = read.read();//expression.charAt(pos++);

        while( FERMANTS.indexOf(courant) == -1 ){

            int posOuvrant = OUVRANTS.indexOf(courant);
            if( posOuvrant  != -1 && !bienEncadre( FERMANTS.charAt(posOuvrant),read)  ){
                return false;
            }

            courant = read.read();//expression.charAt(pos++);
        }

        return courant == fermant;

    }

    /**
     * Version purement recursive de la fonction
     * */
    /*
    public static boolean bienEncadreRec( char fermant, ReadChar read){

        final String OUVRANTS = "([{<",
                     FERMANTS = ")]}>\n";

        char courant = read.read();//expression.charAt(pos++);

        if( FERMANTS.indexOf(courant) != -1 )
            return courant == fermant;

        int posOuvrant = OUVRANTS.indexOf(courant);
        if( posOuvrant  != -1 && !bienEncadre( FERMANTS.charAt(posOuvrant),read)  )
            return false;

        return bienEncadreRec(fermant,read);

    }
*/



    public static void main(String[] args) {

        //String expression = "#include  int main(){int liste[2] = {1, 4}; return (liste[0] + liste[1]);}\n";


        //System.out.println(bienEncadre(expression, '\n'));


        File file = new File("/home/monsio/FormBean.java");

        System.out.println(bienEncadre(file));


    }

}
