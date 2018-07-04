package exercicesFranceIoi.graphes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by monsio on 2/16/16.
 */
public class Node<T> {

    private int value;
    private boolean marque = false;
    private MARQUE marque2 = MARQUE.AUCUNE;
    private boolean isDestination = false;
    private int roots = 0;
    private List<T> destinations;
    private int currentDepth;

    public Node(int value) {
        this.value = value;
        this.destinations = new LinkedList<>();
    }

    public int getCurrentDepth() {
        return currentDepth;
    }

    public void setCurrentDepth(int currentDepth) {
        this.currentDepth = currentDepth;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<T> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<T> destinations) {
        this.destinations = destinations;
    }

    public Node addDestination(T node){
        this.destinations.add(node);
        return this;
    }

    public boolean asArcs(){
        return !destinations.isEmpty();
    }

    public boolean isMarque() {
        return marque;
    }

    public void setMarque(boolean marque) {
        this.marque = marque;
    }

    public boolean isDestination() {
        return isDestination;
    }

    public void setIsDestination(boolean isDestination) {
        this.isDestination = isDestination;
    }

    public int getRoots() {
        return roots;
    }

    public void setRoots(int roots) {
        this.roots = roots;
    }

    public void decRoots(){
        this.roots --;
    }

    public void incRoots(){
        this.roots ++;
    }

    public MARQUE getMarque() {
        return marque2;
    }

    public void setSUPPRIME() {
        this.marque2 = MARQUE.SUPPRIME;
    }

    public void setENCOUR() {
        this.marque2 = MARQUE.EN_COUR;
    }

    public boolean enCours(){
        return this.marque2 == MARQUE.EN_COUR;
    }

    public boolean supprime(){
        return this.marque2 == MARQUE.SUPPRIME;
    }

    public boolean setAUCUNE_MARQUE(){
        return this.marque2 == MARQUE.AUCUNE;
    }

    enum MARQUE{
        EN_COUR, SUPPRIME,AUCUNE
    }

    @Override
    public String toString() {
        return ""+value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        return value == node.value;

    }

    @Override
    public int hashCode() {
        return value;
    }
}
