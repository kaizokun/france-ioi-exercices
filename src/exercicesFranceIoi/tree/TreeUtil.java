package exercicesFranceIoi.tree;

/**
 * Created by monsio on 1/24/16.
 */
public class TreeUtil {

    public static int depth( Node node ){

        if(node.getChildren().isEmpty())
            return 0;

        int maxLength = 0;

        for( Node node2 : node.getChildren() ){
            maxLength = Math.max(maxLength, depth(node2));
        }

        return maxLength + 1;

    }

    class Leaf extends Node{

    }


    public static void main(String[] args) {

/*
            Node root = new Node(0);

            Node n1 = new Node(1);
            Node n2 = new Node(2);

            root.addChild(n1).addChild(n2);

            Node n3 = new Node(3);
            Node n4 = new Node(4);
            Node n5 = new Node(5);

            n1.addChild(n3);
            n2.addChild(n4).addChild(n5);

            Node n6 = new Node(6);
            Node n7 = new Node(7);
            Node n8 = new Node(8);

            n3.addChild(n6).addChild(n7).addChild(n8);

            n8.addChild(new Node(9));

            System.out.println(depth(root));
*/
    }

}
