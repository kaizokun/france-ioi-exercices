package exercicesFranceIoi.tree;

import java.util.*;

/**
 * Created by monsio on 1/25/16.
 */
public class Node implements Comparable<Node> {

    protected Comparable id;
    protected Node parent;
    private Set<Node> children;
    private boolean ancestor = false;

    public Node(Comparable id) {
        children = new LinkedHashSet<>();
        this.setId(id);
    }

    public Node() {

    }

    public Set<Node> getChildren() {
        return children;
    }

    public Node addChild(Node node) {

        this.children.add(node);
        return this;
    }

    public Node removechild( Node node ){
        children.remove(node);
        return this;
    }

    public Comparable getId() {
        return id;
    }

    public void setId(Comparable id) {
        this.id = id;
    }

    public Node getParent() {
        return parent;
    }

    public boolean asParent(){
        return parent != null;
    }

    public boolean asChildren(){
        return children != null && !children.isEmpty();
    }

    public boolean isAncestor() {
        return ancestor;
    }

    public void setAncestor(boolean ancestor) {
        this.ancestor = ancestor;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Node node) {
        return this.id.compareTo(node.id);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        return !(id != null ? !id.equals(node.id) : node.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return ""+id ;
    }
}
