package exercicesFranceIoi.tree;

import java.util.Set;

/**
 * Created by monsio on 1/25/16.
 */
public class Leef extends Node {


    public Leef(Comparable id) {
        this.setId(id);
    }

    @Override
    public Node addChild(Node node) {
      throw new UnsupportedOperationException();
    }

    @Override
    public Set<Node> getChildren() {
        throw new UnsupportedOperationException();
    }
}
