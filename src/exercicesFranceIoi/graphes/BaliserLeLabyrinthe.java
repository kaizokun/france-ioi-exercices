package exercicesFranceIoi.graphes;

import java.util.LinkedList;

/**
 * Created by monsio on 2/20/16.
 */
public class BaliserLeLabyrinthe {


    public static int cptNodes;
    public static int nArcs = 20, nNoeuds = 12;
    public static boolean arcsDisponibles[][] = new boolean[nNoeuds+2][nNoeuds+2];
    public static LinkedList<Node> pile = new LinkedList<>();

    public static void main(String[] args) {

        int arcs[][] = new int[][]{
                {1,2}, {1,3}, {2,3}, {2,4}, {2,5}, {3,5}, {3,7},
                {4,6},{5,6},{5,7}, {6,7}, {6,8}, {6,10}, {6,11}, {7,8},
                {8,9}, {8,10},{9,10},{10,12},{11,12}};



    Node nodes[] = Util.creerGraphe(arcs, nNoeuds, false);

    for(int n = 1 ; n < nodes.length ; n ++){
            Node<Node> origine = nodes[n];
            for(Node  destination : origine.getDestinations()) {
                arcsDisponibles[origine.getValue()][destination.getValue()] = true;
            }
    }

    if(!parcourir(nodes[1]))
        System.out.println(-1);

    }

    private static boolean parcourir(Node<Node> depart){

        pile.add(depart);

        cptNodes++;

        boolean rs = false;

        if( cptNodes == nArcs+1 ) {

            for(Node n : pile) {
                System.out.print(n.getValue() + " ");
            }

            return true;

        }


        for(Node dest : depart.getDestinations()){

            if(arcsDisponibles[depart.getValue()][dest.getValue()]){

                arcsDisponibles[depart.getValue()][dest.getValue()] = false;
                arcsDisponibles[dest.getValue()][depart.getValue()] = false;
                rs = parcourir(dest);
                if(rs)
                    return true;
                arcsDisponibles[depart.getValue()][dest.getValue()] = true;
                arcsDisponibles[dest.getValue()][depart.getValue()] = true;
                cptNodes--;

            }

        }

        pile.removeLast();

        return rs;

    }


}
