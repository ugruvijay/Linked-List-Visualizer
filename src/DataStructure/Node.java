/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructure;

/**
 *
 * @author Vijay
 */
import javax.swing.JLabel;
 
/*  Class Node  */
public class Node {
    protected JLabel data;
    protected Node link;
    
 
    /*  Constructor  */
    public Node() {
        link = null;
        data = null;
    }    
    /*  Constructor  */
    public Node(JLabel d,Node n) {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n) {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(JLabel d) {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink() {
        return link;
    }    
    /*  Function to get data from current Node  */
    public JLabel getData() {
        return data;
    }
}