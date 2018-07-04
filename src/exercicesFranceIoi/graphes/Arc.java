package exercicesFranceIoi.graphes;

/**
 * Created by monsio on 2/19/16.
 */
public class Arc {

    private Node origine,destination;

    public Arc(Node origine, Node destination) {
        this.origine = origine;
        this.destination = destination;
    }

    public Node getOrigine() {
        return origine;
    }

    public void setOrigine(Node origine) {
        this.origine = origine;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }


    @Override
    public String toString() {
        return origine +" -> " + destination;
    }
}
