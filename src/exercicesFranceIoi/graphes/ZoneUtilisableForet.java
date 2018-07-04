package exercicesFranceIoi.graphes;

/**
 * Created by monsio on 2/16/16.
 */
public class ZoneUtilisableForet {

    public static boolean graphes[][];
    public static boolean parcouru[];


    public static void main(String[] args) {

        int nNodes = 12;
        //int nArcs = 14;

        int arcs[][] = new int[][]{
                {1,2},
                {1,3},
                {2,4},
                {2,5},
                {3,5},
                {3,7},
                {4,6},
                {5,6},
                {5,7},
                {6,7},
                {8,9},
                {8,10},
                {9,10},
                {10,11},
                {11,12}};


        parcourirGraphes(arcs,nNodes);

    }

     /*----------------------------OBJETS---------------------------*/

    private static void parcourirGraphes( int arcs[][], int nNodes ) {

        graphes = new boolean[nNodes+1][nNodes+1];

        parcouru = new boolean[nNodes+1];

        Node nodes[] = Util.creerGraphe(arcs, nNodes, true);

        int parcours = 0;
        int maxIntersections = 0;
        Node node;
        for( int n = 1 ; n <= nNodes ; n ++ ){
            node = nodes[n];
            if(!node.isMarque()) {
                node.setMarque(true);
                parcours++;
                maxIntersections = Math.max(maxIntersections, 1 + parcourirGraphes(node));
            }
        }

        System.out.println(parcours+" "+maxIntersections);

    }

    private static int parcourirGraphes(Node<Node> node) {

        int longueur = 0;

        for( Node dest : node.getDestinations() ){

            if(!dest.isMarque()){
                dest.setMarque(true);
                longueur += 1 + parcourirGraphes(dest);
            }
        }

        return longueur;

    }

    /*----------------------------MATRICE---------------------------*/

    private static void parcourirGraphesMatrice( int arcs[][], int nodes  ){

        for( int[] arc : arcs ){
            graphes[arc[0]][arc[1]] = true;
            graphes[arc[1]][arc[0]] = true;
        }

        int parcours = 0;
        int maxIntersections = 0;

        for(int y = 1; y <= nodes ; y ++ ){
            if(!parcouru[y]) {
                parcouru[y] = true;
                parcours++;
                maxIntersections = Math.max(maxIntersections, 1 + parcourirGraphes(y));
            }
        }

        System.out.println(parcours+" "+maxIntersections);

    }

    private static int parcourirGraphes(int y) {

        int longueur = 0;

        for( int x = 1 ; x <= 12 ; x++ ){

            if(!parcouru[x] && graphes[y][x]){
                parcouru[x] = true;
                longueur += 1 + parcourirGraphes(x);
            }
        }

        return longueur;

    }

}
