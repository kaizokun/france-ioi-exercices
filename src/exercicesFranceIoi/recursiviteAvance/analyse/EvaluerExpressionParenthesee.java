package exercicesFranceIoi.recursiviteAvance.analyse;

/**
 * Created by monsio on 2/15/16.
 */
public class EvaluerExpressionParenthesee {


    public static int pos = 0;

    public static int lireNombre(String expression){

        int nombre = 0;
        char lu;

        int signe = 1;

        if( expression.charAt(pos) == '-')  {
            signe = -1;
            pos++;
        }

        while( ( lu = expression.charAt(pos) ) >= '0' && lu <= '9' ){
            nombre*=10;
            nombre+= (lu - '0');
            pos++;
        }


        return signe * nombre;
    }

    public static int calculerExpression(String expression,int depth){

        if(expression.charAt(pos) != '(')
            return lireNombre(expression);

            pos++; //curseur apres '('
            int val1 = calculerExpression(expression,depth+1);
            char operateur = expression.charAt(pos++);
            int val2 = calculerExpression(expression,depth+1);
            pos++; //curseur apres ')'

            switch(operateur){
                case '+':
                    return val1 + val2;
                case '-' :
                    return val1 - val2;
                case '*' :
                    return val1 * val2;
                case '/':
                    return val1 / val2;
                case  '%':
                    return val1 % val2;
            }

        return 0;
    }

    public static void main(String[] args) {

        System.out.println(calculerExpression("(((123+42)*3)-(5/2))",0));

    }

}
