package exercicesFranceIoi.structureDonneeBalayage;

/**
 * Created by monsio on 1/28/16.
 */
public class Bentley {

    private static int sommeMax = 0;

    public static int sommeMax(int valeurs[]){
        return sommeMax(valeurs,valeurs.length-1);
    }

    /*
    * Calculer une somme maximum pour une fin donnée c'est
    * calculer le maximum entre : la somme maximum pour une fin précedente plus la valeur de fin courante et la valeur 0
    * de cette manière si le maximum précédent àjouté à la valeur courante est nétagif on repart de zero
    * */

    public static int sommeMax( int valeurs[], int finExclu ){

        if( finExclu == 0 ) {
            return 0;
        }
        else {

            int sommeMaxPrecedente = sommeMax(valeurs, finExclu - 1);
            int max = Math.max(0, valeurs[finExclu] + sommeMaxPrecedente);
            sommeMax = Math.max(sommeMax,max);
            return max;
        }

    }


    public static void main(String[] args) {
        sommeMax(new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7});
        System.out.println(sommeMax);
    }

}
