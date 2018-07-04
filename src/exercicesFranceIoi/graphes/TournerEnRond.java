package exercicesFranceIoi.graphes;

/**
 * Created by monsio on 2/17/16.
 */
public class TournerEnRond {


    public static void main(String[] args) {

        int nNodes = 12;

        int arcs[][] = new int[][]{
                {1,2}, {1,3}, {2,4}, {2,5},
                {3,5}, {3,7}, {4,6}, {5,6},
                {6,10}, {6,11}, {7,6},{8,7},
                {9,8}, {10,9}, {10,11}, {11,12}};


        Node[] nodes = Util.creerGraphe(arcs, nNodes, true);

        for( int n = 1 ; n <= nNodes ; n ++ ){
            Node node = nodes[n];
            if(!node.isDestination()){
                if(trouverBoucle(node)){
                    System.out.println("OUI");
                }else{
                    System.out.println("NON");
                }
                break;
            }
        }


    }


    private static boolean trouverBoucle(Node<Node> node) {

        node.setMarque(true);

        for(Node destination : node.getDestinations()){

            /*
            * Si la destination n'a pas été marqué ou qu'on a pas trouvé de boucle dans un sous graphes partant de cette destination
            * on parcour les autres destination du noeud en cour. Sinon c'est qu'on a bien trouvé une boucle.
            * */
            if( destination.isMarque() || trouverBoucle(destination) )
                return true;
        }

        node.setMarque(false);

        return false;

    }
    /*
    private static boolean trouverBoucle(Node node) {


        for(Node destination : node.getDestinations()){

            if(destination.isMarque()){
                return true;
            }else{
                destination.setMarque(true);
                if(trouverBoucle(destination)){
                    return true;
                }
                destination.setMarque(false);
            }

        }

        return false;

    }

*/
}
