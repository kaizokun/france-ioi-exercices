package exercicesFranceIoi.graphes;


import java.util.LinkedList;

/**
 * Created by monsio on 2/18/16.
 */
public class BloquerUneRoute {

    private static LinkedList<Arc> ponts = new LinkedList<>();

    public static void main(String[] args) {

        int nNodes = 13;

        int arcs[][] = new int[][]{
                {1,2}, {1,3}, {2,4}, {2,5}, {3,5},
                {4,6}, {6,7}, {6,10}, {6,11}, {7,8},
                {8,9}, {8,10},{9,10}, {10,11},{11,12}};


        Node[] nodes = Util.creerGraphe(arcs, nNodes, false);

        trouverCycle(nodes[1],nodes[1],0);

        System.out.println("===========================================");

        System.out.println(ponts.size());

        for(Arc arc : ponts)
            System.out.println(arc);


    }


    private static String getIdent(int depth){

        StringBuilder str = new StringBuilder();

        for(; depth >= 0 ; depth -- ){
            str.append("   ");
        }

        return str.toString();
    }

    /**
     * Cet algorithme consiste en trouver les ponts d'un graphe, çàd les arcs qui relient differentes parties cycliques du graphes.
     * Les ponts sont les arcs qui ne font pas partis d'un cycle.
     * Pour determiner si un arc qui reliant un noeud de départ à un noeud de destination n'est pas un pont,
     * il faut que le noeud de destination retourne une valeur de profondeur de noeud plus petite que le noeud de depart,
     * lors d'un parcour en profondeur à partir de ce noeud de destination.
     * Ce qui signifie que à partir du noeud de destination on peut revenir à un noeud de profondeur antérieure à celui de départ.
     * Cet arc fait donc parti d'un cycle.
     *
     * Est que cet arc n'est donc pas indispensable pour parcourir le graphe. On pourrais donc le supprimer sans rendre les autres noeud innaccessible.
     * */

    private static int trouverCycle(Node<Node> node, Node previous, int depth) {

        node.setCurrentDepth(depth);
        node.setENCOUR();

        int minDepth = depth;

        for(Node dest : node.getDestinations()) {

            if(dest.equals(previous))
                continue;

            if(dest.enCours()) {
                minDepth = Math.min(minDepth,dest.getCurrentDepth());
            }else{

                int valueReturn = trouverCycle(dest,node,depth+1);

                if( valueReturn > depth ) {
                    ponts.add(new Arc(node, dest));
                }else {
                    minDepth = Math.min(minDepth, valueReturn);
                }

            }

        }

        node.setAUCUNE_MARQUE();

        return minDepth;

    }


}
