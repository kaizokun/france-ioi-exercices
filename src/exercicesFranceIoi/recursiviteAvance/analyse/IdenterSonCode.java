package exercicesFranceIoi.recursiviteAvance.analyse;

/**
 * Created by monsio on 2/14/16.
 */
public class IdenterSonCode {

    public static int pos = 0;

    public static String getIdentation(int depth){
        StringBuilder ident = new StringBuilder();

        for( int p = 0; p < depth * 3 ; p ++ ){
            ident.append(' ');
        }

        return new String(ident);

    }

    public static void identer(String expression, StringBuilder ident){

        /*
        (pos < expression.length())
        obligatoire si l'expression se termine par une parenthese fermante
        */

        while( /* pos < expression.length() && */ expression.charAt(pos++) == '{' ){
            System.out.println(ident.toString()+"{");
            identer(expression, new StringBuilder(ident.toString()+"   "));
            System.out.println(ident.toString()+"}");
        }

    }

    public static void main(String[] args) {

        //String expression = "{{}}{}";
        String expression = "{{{}}{{{{}}}}}{}\n";

        try{
            //identer(expression,0);
            identer(expression, new StringBuilder(""));
        }catch (Exception e){
                e.printStackTrace();
        }


    }

}
