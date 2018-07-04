package exercicesFranceIoi.graphes;

/**
 * Created by monsio on 2/17/16.
 */
public class Util {

    public static Node[] creerGraphe(int arcs[][], int nNodes, boolean oriente){

        Node nodes[] = new Node[nNodes+1];

        for( int[] arc : arcs ){

            int origine = arc[0];
            int destination = arc[1];
            Node nodeOrigine = nodes[origine];
            Node nodeDestination = nodes[destination];

            if(nodeOrigine == null){
                nodeOrigine = new Node(origine);
                nodes[origine] = nodeOrigine;
            }

            if(nodeDestination == null){
                nodeDestination = new Node(destination);
                nodes[destination] = nodeDestination;
                nodeDestination.setIsDestination(true);
            }

            nodeOrigine.addDestination(nodeDestination);
            nodeDestination.incRoots();

            if(!oriente){
                nodeDestination.addDestination(nodeOrigine);
                nodeOrigine.incRoots();
            }


        }

        return nodes;
    }


    public static String getIdent(int depth){

        StringBuilder str = new StringBuilder();

        for(; depth >= 0 ; depth -- ){
            str.append("   ");
        }

        return str.toString();
    }

}
