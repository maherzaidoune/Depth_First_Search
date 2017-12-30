package depth.first.search;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author maher
 */

/**
 * Depth First Search Algo is an uninformed graph traversal algorithm
 * which produces a non-optimal solution 
 * but can be useful for traversing quickly into deeper search domains
 * 
 * in that algorithm you start at the top most node in a tree and then
 * follow the left most branch until there exists no more leafs in that branch
 * 
 * ♥ RRDL ♥
 */

public class DepthFirstSearch {
    Node startNode;
    Node goalNode;
    ArrayList<Node> done;
    
    public DepthFirstSearch(Node startNode,Node goalNode){
        this.startNode = startNode;
        this.goalNode = goalNode;
    }
    public boolean search(){
        if (this.startNode.equals(this.goalNode)) {
            System.out.println("Goal is just the start Node");
            return true;
        }
        Stack<Node> lifo = new Stack();
        done = new ArrayList<>();
        lifo.add(startNode);
        while(!lifo.isEmpty()){
            Node current = lifo.pop();
            if(current.equals(goalNode)){
                printDone();
                return true;
            }else{
                done.add(current);
                lifo.addAll(current.getChilden());
            }
        }
        return false;
    }
    
    public void printDone(){
        int steps = 0;
        for(Node n : done){
            System.out.println(++steps + " : " +n.nodeName);
            
        }
    }

    public static void main(String[] args) {
        // Testing ..
        // Binary tree , A,B,C,D,E,F,G 
        Node I = new Node("I",null,null);
        Node H = new Node("H",null,null);
        Node E = new Node("E",null,null);
        Node F = new Node("F",null,null);
        Node G = new Node("G",null,null);
        Node D = new Node("D",H,I);
        Node C = new Node("C",F,G);
        Node B = new Node("B",D,E);
        Node A = new Node("A",B,C);
        
        DepthFirstSearch rrdl = new DepthFirstSearch(A,E);
        if(rrdl.search()){
            System.out.println("success");
        }else{
            System.out.println("nope");
        }
    }
    
}
