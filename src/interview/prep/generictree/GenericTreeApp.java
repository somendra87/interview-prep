package interview.prep.generictree;

import java.util.ArrayList;

/**
 * @author somendraprakash created on 04/08/20
 */
public class GenericTreeApp
{
    private class Node{
        int data;
        ArrayList<Node> children;

        Node(){}
        Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }
    private Node root;

    public void construct(){

    }
}
