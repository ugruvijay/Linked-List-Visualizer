/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructure;

import javax.swing.JLabel;

/**
 *
 * @author Vijay
 */
public class CustomLinkedList {
    protected Node start;
    protected Node end ;
    public int size ;
    NewJFrame j;
 
    /*  Constructor  */
    public CustomLinkedList(NewJFrame j) {
        start = null;
        end = null;
        size = 0;
        this.j = j;
    }
    
    
    
    public CustomLinkedList(int n1){
        Node nptr[] = new Node[n1];
        int i = 0;
        while(i < n1){
            nptr[i] = new Node(new JLabel(""+(i+1)*10),null);
            i++;
        }
        i = 0;
        start = nptr[0];
        while(i < n1-1){
            nptr[i].setLink(nptr[i+1]);
            i++;
        }
        end = nptr[n1-1];
        size = n1;
    }
    
    /*  Function to check if list is empty  */
    public boolean isEmpty() {
        return start == null;
    }
    /*  Function to get size of list  */
    public int getSize() {
        return size;
    }    
    /*  Function to insert an element at begining  */
    public void insertAtStart(JLabel val) {
        Node nptr = new Node(val, null);    
        size++ ;    
        if(start == null) {
            start = nptr;
            end = start;
        } else {
            nptr.setLink(start);
            start = nptr;
        }
    }
    /*  Function to insert an element at end  */
    public void insertAtEnd(JLabel val) {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(start == null) {
            start = nptr;
            end = start;
        }
        else {
            end.setLink(nptr);
            end = nptr;
        }
    }
    /*  Function to insert an element at position  */
    public void insertAtPos(JLabel val , int pos) {
        Node nptr = new Node(val, null);                
        Node ptrcur = start;
        Node ptrprev = null;
        int i = 0;
        if(ptrcur == null){
            start = nptr;
            end = start;
        } else {
            while(ptrcur != null && i < pos-1) {
                ptrprev = ptrcur;
                ptrcur = ptrcur.getLink();
                i++;
            }
            if(ptrprev == null) {
                start = nptr;
                nptr.setLink(ptrcur);
            } else if(ptrcur == null) {
                end.setLink(nptr);
                end = nptr;
                
            } else {
                ptrprev.setLink(nptr);
                nptr.setLink(ptrcur);
            }
        }
        size++; 
    }
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos) {        
        if (pos == 1) {
            start = start.getLink();
            size--; 
            return ;
        } 
        if (pos == size) {
            Node ptrcur = start;
            Node ptrprev = null;
            while (ptrcur != end){
                ptrprev = ptrcur;
                ptrcur = ptrcur.getLink();
            }
            end = ptrprev;
            end.setLink(null);
            size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++){
            if (i == pos) {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
        
    }    
    
    public void reverse(){
        j.list.end = start;
        Node ptrcur = j.list.start;
        Node ptrprev = null;
        Node ptrnext = ptrcur.getLink();
        
        while(ptrcur != null){
            ptrcur.setLink(ptrprev);
            ptrprev = ptrcur;
            ptrcur = ptrnext;
            if(ptrnext != null){
                ptrnext = ptrnext.getLink();
            }
        }
        j.list.start = ptrprev;
        display();
    }
    
    public void doublyReverse(){
        j.dlist.end = start;
        Node ptrcur = j.dlist.start;
        Node ptrprev = null;
        Node ptrnext = ptrcur.getLink();
        
        while(ptrcur != null){
            ptrcur.setLink(ptrprev);
            ptrprev = ptrcur;
            ptrcur = ptrnext;
            if(ptrnext != null){
                ptrnext = ptrnext.getLink();
            }
        }
        j.dlist.start = ptrprev;
        display();
    }
    
    public boolean insertAtStartTest(JLabel val) {
        Node nptr = new Node(val, null);    
        if(size + 1 >10){
            return false;
        }
        if(start == null) {
            start = nptr;
            end = start;
        } else  {
            nptr.setLink(start);
            start = nptr;
        }
        size++ ;
        return true;
    }
    
    public boolean insertAtEndTest(JLabel val) {
        Node nptr = new Node(val, null);    
        if(size + 1 >10){
            return false;
        }
        if(start == null) {
            start = nptr;
            end = start;
        } else  {
            end.setLink(nptr);
            end = nptr;
        }
        size++ ;
        return true;
    }
    
    public boolean insertAtPositionTest(JLabel val , int pos) {
        Node nptr = new Node(val, null);                
        Node ptrcur = start;
        Node ptrprev = null;
        int i = 0;
        int flag = 0;
        if(size+1 > 10){
            return false;
        }
        if(pos > size + 1){
            return false;
        }
        if(ptrcur == null){
            start = nptr;
            end = start;
        } else {
            while(ptrcur != null && i < pos-1) {
                ptrprev = ptrcur;
                ptrcur = ptrcur.getLink();
                i++;
            }
            if(ptrcur == null) {
                end.setLink(nptr);
                end = nptr;
                flag = 1;
            } else {
                ptrprev.setLink(nptr);
                nptr.setLink(ptrcur);
                flag = 1;
            }
        }
        size++; 
        return true;
    }
    
    public boolean deleteAtPositionTest(int pos) {        
        if(pos > size){
            return false;
        }
        if (pos == 1) {
            start = start.getLink();
            size--; 
            return true;
        } 
        if (pos == size) {
            Node ptrcur = start;
            Node ptrprev = null;
            while (ptrcur != end){
                ptrprev = ptrcur;
                ptrcur = ptrcur.getLink();
            }
            end = ptrprev;
            end.setLink(null);
            size --;
            return true;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++){
            if (i == pos) {
                Node tmp = ptr.getLink();
                tmp = tmp.getLink();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getLink();
        }
        size-- ;
        return true;
    }  
    
    public boolean searchTest(JLabel l){
        Node ptr = start;
        if(ptr == null){
            return false;
        }
        else{
            while(ptr!=null){
                if(ptr.getData().getText().equals(l.getText())){
                    return true;
                }
                ptr = ptr.getLink();
            }
        }
        return false;
    }
    
    /*  Function to display elements  */
    public void display()
    {
        //System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }    
        if (start.getLink() == null) {
            System.out.println(start.getData().getText() );
            return;
        }
        Node ptr;
        System.out.print(start.getData().getText()+ "->");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData().getText()+ "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData().getText()+ "\n");
    }

    @SuppressWarnings("ConvertToStringSwitch")
    public void op(){             
        if(j.operation.equals("Insert Front")){
            j.list.insertAtStart(j.rec[j.countofrect]);
            display();
        } else if(j.operation.equals("Insert Rear")){
            j.list.insertAtEnd(j.rec[j.countofrect]);
            display();
        } else if(j.operation.equals("Insert at kth position")){
            if (Integer.parseInt(""+j.singlyPositionComboBox.getSelectedItem()) < 1 || Integer.parseInt(""+j.singlyPositionComboBox.getSelectedItem()) > j.list.getSize()+1){
                j.countofrect --;
            } else{
                j.list.insertAtPos(j.rec[j.countofrect],Integer.parseInt(""+j.singlyPositionComboBox.getSelectedItem()));  
                display();
            }
        } else if(j.operation.equals("Delete Front")){
            j.list.deleteAtPos(1);
            reassignRectangle();
            j.countofrect--;
            display();
        } else if(j.operation.equals("Delete Rear")){
            j.list.deleteAtPos(j.list.size);
            reassignRectangle();
            j.countofrect--;
            display();
        } else if(j.operation.equals("Delete kth node")){
            if (Integer.parseInt(""+j.singlyPositionComboBox.getSelectedItem()) < 1 && Integer.parseInt(""+j.singlyPositionComboBox.getSelectedItem()) > j.list.getSize()) {
                System.out.println("Invalid position\n");
            } else {
                j.list.deleteAtPos(Integer.parseInt(""+j.singlyPositionComboBox.getSelectedItem()));  
                reassignRectangle();
                j.countofrect --;
                display();
            }
        } else if(j.operation.equals("Reverse")){
            j.list.reverse();
        }
        
    }
    
    @SuppressWarnings("ConvertToStringSwitch")
    public void doublyop(){             
        if(j.operation.equals("Insert Front")){
            j.dlist.insertAtStart(j.doublyrec[j.doublycountofrect]);
            display();
        } else if(j.operation.equals("Insert Rear")){
            j.dlist.insertAtEnd(j.doublyrec[j.doublycountofrect]);
            display();
        } else if(j.operation.equals("Insert at kth position")){
            if (Integer.parseInt(""+j.doublyPositionComboBox.getSelectedItem()) < 1 || Integer.parseInt(""+j.doublyPositionComboBox.getSelectedItem()) > j.dlist.getSize()+1){
                j.doublycountofrect --;
            } else{
                j.dlist.insertAtPos(j.doublyrec[j.doublycountofrect],Integer.parseInt(""+j.doublyPositionComboBox.getSelectedItem()));  
                display();
            }
        } else if(j.operation.equals("Delete Front")){
            j.dlist.deleteAtPos(1);
            doublyReassignRectangle();
            j.doublycountofrect--;
            display();
        } else if(j.operation.equals("Delete Rear")){
            j.dlist.deleteAtPos(j.dlist.size);
            doublyReassignRectangle();
            j.doublycountofrect--;
            display();
        } else if(j.operation.equals("Delete kth node")){
            if (Integer.parseInt(""+j.doublyPositionComboBox.getSelectedItem()) < 1 && Integer.parseInt(""+j.doublyPositionComboBox.getSelectedItem()) > j.dlist.getSize()) {
                System.out.println("Invalid position\n");
            } else {
                j.dlist.deleteAtPos(Integer.parseInt(""+j.doublyPositionComboBox.getSelectedItem()));  
                doublyReassignRectangle();
                j.doublycountofrect --;
                display();
            }
        } else if(j.operation.equals("Reverse")){
            j.dlist.doublyReverse();
        }
    }
    
    @SuppressWarnings("ConvertToStringSwitch")
    public void circularop(){             
        if(j.circularGoButton.getText().equals("Insert")){
            j.clist.insertAtStart(j.circularrec[j.circularcountofrect]);
            display();
        } else if(j.circularGoButton.getText().equals("Delete")){
            j.clist.deleteAtPos(1);
            circularReassignRectangle();
            j.circularcountofrect--;
            display();
        } 
    }
    
    public void doublyReassignRectangle(){
        Node ptr = j.dlist.start;
        int i = 0;
        while(ptr != null){
            j.doublyrec[i] = ptr.getData();
            i++;
            ptr = ptr.getLink();
        }
        j.doublyrec[i] = null;
        j.doublyrec[i] = new JLabel();
        j.doublyrec[i].setBackground(new java.awt.Color(0, 0, 255));
        j.doublyrec[i].setLocation(0,270);
        j.doublyrec[i].setVisible(false);
        j.doublyrec[i].setSize(80,40);
        j.doublyrec[i].setOpaque(true);
        j.doublyrec[i].setFont(new java.awt.Font("Tahoma", 1, 14));
        j.doublyPracticalPanel.add(j.doublyrec[i]);
    }
    
    public void reassignRectangle(){
        Node ptr = j.list.start;
        int i = 0;
        while(ptr != null){
            j.rec[i] = ptr.getData();
            i++;
            ptr = ptr.getLink();
        }
        j.rec[i] = null;
        j.rec[i] = new JLabel();
        j.rec[i].setBackground(j.color1);
        j.rec[i].setLocation(0,270);
        j.rec[i].setVisible(false);
        j.rec[i].setSize(80,40);
        j.rec[i].setOpaque(true);
        j.rec[i].setFont(new java.awt.Font("Tahoma", 1, 14));
        j.singlyPracticalPanel.add(j.rec[i]);
    }

    private void circularReassignRectangle() {
        Node ptr = j.clist.start;
        int i = 0;
        while(ptr != null){
            j.circularrec[i] = ptr.getData();
            i++;
            ptr = ptr.getLink();
        }
        j.circularrec[i] = null;
        j.circularrec[i] = new JLabel();
        j.circularrec[i].setBackground(new java.awt.Color(0, 0, 255));
        j.circularrec[i].setLocation(0,270);
        j.circularrec[i].setVisible(false);
        j.circularrec[i].setSize(80,40);
        j.circularrec[i].setOpaque(true);
        j.circularrec[i].setFont(new java.awt.Font("Tahoma", 1, 14));
        j.circularPracticalPanel.add(j.circularrec[i]);
    }

}
