package exercicesFranceIoi.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by monsio on 1/25/16.
 */
public class Tree {

    private int length = 0;

    private Node root;

    private Map<Comparable,Node> nodes = new TreeMap<>();

    public Tree(Comparable root) {
        this.root = new Node(root);
        nodes.put(root, this.root);
    }
/*
    public Comparable getRoot() {
        return root.getId();
    }

    public void setRoot(Comparable id) {
        this.root.setId(id);
    }
*/


    public void addNode(Comparable child, Comparable parent){


        Node nParent = nodes.get(parent);
        //Si le parent n'existe pas encore on sort
        if(nParent == null){
            System.out.println("Parent ("+parent+") inexistant");
            return;
        }

        Node nChild = nodes.get(child);

        //si l'enfant n'existe pas on le crée et on l'ajoute au treeMap
        if(nChild == null) {
            nChild = new Node(child);
            nodes.put(child,nChild);
        }else{
            System.out.println("référence "+child+" déja ajoutée à "+parent);
            return;
        }


        nChild.setParent(nParent);
        nParent.addChild(nChild);


        this.length ++;

    }

    public void removeNode(Comparable child, Comparable parent){

        Node nChild = nodes.get(child);
        Node nParent = nodes.get(parent);
        
        if( nChild != null && nParent != null ){
            nParent.removechild(nChild);
            nodes.remove(child);
            this.length --;
        }

    }

    public List<Comparable> getPath(Comparable id){
        List path = new LinkedList();
        getPath(id,path);
        return path;
    }

    private void getPath( Comparable id, List path ){

        Node n = nodes.get(id);

        if( n == null || id == root.getId() )
            return;

        if( n.asParent() ) {
            getPath(n.getParent().getId(), path);
        }

        path.add(n.getId());

    }

    public int getDepth(){
        return getDepth(this.root);
    }

    public int getDepth(Comparable id){
        return getDepth(this.nodes.get(id));
    }


    /*
    * La longueur d'un arbre est = à
    * Si il n'a pas d'enfants 0
    * Si il a des enfants la longeur du plus grand sous arbre + 1
    * */
    private int getDepth(Node n){

        if(!n.asChildren())
            return 0;

        int max = 0;

        for( Node child : n.getChildren() ){
            max = Math.max(max,getDepth(child));
        }

        return max + 1;

    }

    public Comparable commomNode( Comparable id1, Comparable id2 ){
        Node n1 = nodes.get(id1);
        Node n2 = nodes.get(id2);

        //on marque les ancetres du node 1
        markAncestor(n1,true);
        //on recherche le premier ancetre du node 2 marqué comm ancetre de node 1
        Node ancestor = findAncestor(n2);

        //remet les boolean dans la position initiale
        markAncestor(n1,false);

        if( ancestor != null ){
            return ancestor.getId();
        }

        return this.root.getId();


    }

    private Node findAncestor(Node node){
        if(node.isAncestor() || node.equals(this.root)){
            return node;
        }else{
            return findAncestor(node.getParent());
        }
    }

    private void markAncestor(Node n, boolean bool){
        n.setAncestor(bool);
        if(n.asParent())
            markAncestor(n.getParent(),bool);
    }


    public void addRemove(){
        addRemove(this.root);
    }

    /*pour l'exercice permettant de retouver l'ordre chronologique d'empilement FIOI - arbres - 4 - Piles de carton
    * Chaque noeud correspond à un carton, le noeud 0 correspond à l'entrepot.
    * Chaques enfant du noeud correspond à un carton qui s'est trouvé directement posé sur le carton parent
    * Permet d'afficher un ordre chronologique d'ajout et de retrait.
    * */

    private void addRemove(Node n){
        for(Node c : n.getChildren()){
            System.out.println("A "+c);
            addRemove(c);
            System.out.println("R "+c);
        }
    }

    private List parcourLargeur(){


        LinkedList<Node> listLargeur = new LinkedList<>();

        listLargeur.addAll(root.getChildren());

        for (int i = 0 ; i < length ; i ++ ){
            Node n = listLargeur.get(i);
            for( Node c : n.getChildren()){
                listLargeur.add(c);
            }

        }

        return listLargeur;

    }


    public static void main(String[] args) {

        Tree tree = new Tree(0);

        //niveau 0
        tree.addNode(3,0);
        tree.addNode(2,0);
        //niveau 1
        tree.addNode(6,3);
        tree.addNode(4,3);
        //niveau 2
        tree.addNode(5,4);
        tree.addNode(1,4);
        tree.addNode(7,4);

       // tree.addRemove();

/*
        for( Object o : tree.getPath(1))
            System.out.print(o+" ");

        */
/*
        int idNode=0;

        System.out.println("Profondeur de l'arbre à partir de "+idNode+" : "+tree.getDepth(idNode));

        int n1=10,n2=9;
        System.out.println("Ancetre commum à "+n1+" et "+n2+" : "+tree.commomNode(n1,n2));
*/

        for( Object n : tree.parcourLargeur())
            System.out.println(n);

    }

}
