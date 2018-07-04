package exercicesFranceIoi.graphes;

import java.util.LinkedList;

/**
 * Created by monsio on 2/17/16.
 */
public class FermetureLabyrinthe {

    public static void main(String[] args) {

        int nNodes = 12;

        int arcs[][] = new int[][]{
                {1,2}, {1,3}, {2,4}, {2,6}, {3,6},
                {3,7}, {4,5}, {5,7}, {5,9}, {5,10},
                {6,5}, {7,8},{8,11}, {9,12},{10,9},
                {11,10}};


        Node[] nodes = Util.creerGraphe(arcs, nNodes, true);

        LinkedList<Node> ordreVerification = null;

        for( int n = 1 ; n <= nNodes ; n ++ ){
            Node node = nodes[n];
            if(!node.isDestination()){
                ordreVerification = fermerGraphe(node);
                break;
            }
        }

        for (Node node : ordreVerification){
            System.out.print(node.getValue() + " ");
        }


    }


    public static LinkedList<Node> fermerGraphe(Node root){

        LinkedList<Node> ordreVerification = new LinkedList<>();
        fermerGraphe2(root, ordreVerification);
        return ordreVerification;
    }


    /**
     * Cette version parcour le graphe à partir du noeud d'origine ( celui qui n'est destination d'aucun autre )
     * Il parcourt les noeuds de destination du noeud courant et rappelle recursivement la fonction à partir d'un noeud destination
     * qui est une destination unique, tout en supprimant ce lien.
     * Si le graphe comporte un cycle la fonction s'arrete et tout les noeuds ne seront pas enregistrés dans la liste de verification finale.
     * Qui sera donc de taille inferieure au nombre de noeuds.
     * */

    public static void fermerGraphe(Node<Node> node, LinkedList<Node> ordreVerification){

        ordreVerification.add(node);

        for(Node dest : node.getDestinations()){
            dest.decRoots();
            if(dest.getRoots() <= 0){
                fermerGraphe(dest,ordreVerification);
            }
        }

    }

/**
 * Cette version parcourt le graphe en profondeur à partir du noeud d'origine ( celui qui n'est destination d'aucun autre )
 * et supprime les noeuds vers lesquels plus aucun arc ne part en le marquant comme SUPPRIME
 * puis enregistre cet arc supprime en debut de liste. Un noeud vers lequel rien ne part est forcement le dernier à verifier. Et si le graphe ne contient pas de cycle
 * il y en a toujours un. On les retire donc au fur et à mesure pour en revenir à un même problème de taille inferieur.
 * Si une des destinations d'un noeud comprend un noeud déja visité on obtient un cycle et on arrete le programme.
 *
 * */
    public static void fermerGraphe2(Node<Node> node, LinkedList<Node> ordreVerification){

        node.setENCOUR();

        for( Node dest : node.getDestinations() ){
            if(dest.enCours()){
                System.out.println("-1");
                System.exit(0);
            }else if(dest.setAUCUNE_MARQUE()){
                fermerGraphe2(dest,ordreVerification);
            }
        }

        ordreVerification.addFirst(node);
        node.setSUPPRIME();

    }


    public static  LinkedList<Node> fermerGrapheIt(Node<Node> root, int nNodes){

        LinkedList<Node> pile = new LinkedList<>();
        LinkedList<Node> ordreVerification = new LinkedList<>();
        ordreVerification.add(root);

        pile.add(root);

        boolean empile;

        while(!pile.isEmpty() && ordreVerification.size() < nNodes ){

            Node<Node> node = pile.peekLast();

            empile = false;

            for(Node dest : node.getDestinations()){
                dest.decRoots();
                if(dest.getRoots() <= 0){
                    ordreVerification.add(dest);
                    pile.add(dest);
                    empile = true;
                }
            }

            if(!empile){
                pile.removeLast();
            }

        }

        return ordreVerification;

    }



}
