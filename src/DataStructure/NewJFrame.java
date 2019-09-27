/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructure;

import AppPackage.AnimationClass;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Vijay
 */
public class NewJFrame extends javax.swing.JFrame {
    public static int singlycount = 1;
    public static int doublycount = 1;
    public static int circularcount = 1;
    public int singlyQuizMarks = 0;
    public int doublyQuizMarks = 0;
    public int circularQuizMarks = 0;
    public int countofrect = -1;
    public int doublycountofrect = -1;
    public int circularcountofrect = -1;
    public static int x_coordinate = 150;
    public static int x_coordinate1 = 150;
    public static int d_x_coordinate1 = 150;
    public static int c_x_coordinate1 = 150;
    public static int singlyspeedofanimation = 10;
    public static int doublyspeedofanimation = 10;
    public static int circularspeedofanimation = 10;
    public static int noofpixels = 2;
    public static int doublynoofpixels = 2;
    public static int circularnoofpixels = 2;
    public static int i=0;
    public static int jk=1,ij=1,k=0,ki=1;
    public String operation;
    public JLabel rec[];
    public JLabel doublyrec[];
    public JLabel circularrec[];
    public JLabel arrowLabel[];
    public JLabel doublyarrowLabel[];
    public JLabel circulararrowLabel[];
    public Color color1;
    public Color color2;
    public Color color3;
    public Color color4;
    public Color color5;
    public Color color6;
    CustomPlayer player;
    NewJFrame j;
    CountDownTimer cdts;
    CountDownTimer cdtd;
    CountDownTimer cdtc;
    DataInputStream din = null;
    DataOutputStream dout = null;
    AnimationClass AC;
    CustomLinkedList list;
    CustomLinkedList dlist;
    CustomLinkedList clist;
    CardLayout cl;
    ButtonGroup mainbg;
    ButtonGroup singlybg;
    ButtonGroup doublybg;
    ButtonGroup menubg;
    ButtonGroup dsmenubg;
    ButtonGroup singlyQuizbg;
    ButtonGroup doublyQuizbg;
    ButtonGroup circularQuizbg;
    ButtonGroup circularbg;
    PreparedStatement pst = null;
    Connection conn = null;
    ResultSet rt = null;
    PreparedStatement pst1 = null;
    ResultSet rt1=null;
    PreparedStatement pst2 = null;
    ResultSet rt2 = null;
    /**
     * Creates new form NewJFrame
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public NewJFrame() {
        super("Linked List Visualisation");
        initComponents();
        try{
            dout = new DataOutputStream(new FileOutputStream("Replay.txt"));
            din = new DataInputStream(new FileInputStream("Replay.txt"));
        } catch(FileNotFoundException fnfe){
            JOptionPane.showMessageDialog(null,fnfe);
        } 
        
        cl = new CardLayout();
        
        jPanel1.setLayout(cl);
        
        AC = new AnimationClass();
        
        conn=MySqlConnect.ConnectDb(); 
               
        list = new CustomLinkedList(this);
        dlist = new CustomLinkedList(this);
        clist = new CustomLinkedList(this);
        j = this;
        
        jPanel1.add("Main",mainPanel);
        jPanel1.add("Singly",singlyLLPanel);
        jPanel1.add("Doubly",doublyLLPanel);
        jPanel1.add("Circular",circularLLPanel);
        
        singlyTheoryTextArea.setText("\n\tSingly linked list is the most basic linked data structure. In this the elements can be placed anywhere in the heap memory, unlike array which uses contiguous locations. Nodes in a linked list are linked together using a next field, which stores the address of the next node i.e., each node of the list refers to its successor, and the last node contains the NULL reference. It has a dynamic size, which can be determined only at run time.\n\nPerformance:\n\n1) The advantage of a singly linked list is its ability to expand, to accept virtually unlimited number of nodes in a fragmented memory environment.\n2) The disadvantage is its speed. Operations in a singly-linked list are slow as it uses sequential search to locate a node. ");
        singlyTheoryTextArea.setLineWrap(true);
        singlyTheoryTextArea.setCaretPosition(0);
        singlyTheoryTextArea.setWrapStyleWord(true);
        
        doublyTheoryTextArea.setText("\n\tDoubly-linked list is a more sophisticated form of linked list data structure. Each node of the list contain two references (or links) – one to the previous node and other to the next node. The previous link of the first node and the next link of the last node points to NULL. In comparison to singly-linked list, doubly-linked list requires handling of more pointers but less information is required as one can use the previous links to observe the preceding element. It has a dynamic size, which can be determined only at run time.\n\nPerformance:\n\n1) The advantage of a doubly linked list is that, we don’t need to keep track of the previous node for traversal or no need of traversing the whole list for finding the previous node.\n2 )The disadvantage is that more pointers needs to be handled and more links need to be updated. ");
        doublyTheoryTextArea.setLineWrap(true);
        doublyTheoryTextArea.setCaretPosition(0);
        doublyTheoryTextArea.setWrapStyleWord(true);
        
        circularTheoryTextArea.setText("\n\tCircular linked list is a more complicated linked data structure. In this the elements can be placed anywhere in the heap memory unlike array which uses contiguous locations. Nodes in a linked list are linked together using a next field, which stores the address of the next node, i.e each node of the list refers to its successor and the last node points back to the first node unlike singly linked list. It has a dynamic size, which can be determined only at run time.\n\nPerformance:\n\n1)The advantage is that we no longer need both a head and tail variable to keep track of the list. Even if only a single variable is used, both the first and the last list elements canbe found in constant time. Also, for implementing queues we will only need one pointer, namely tail, to locate both head and tail.\n2) The disadvantage is that the algorithms have become more complicated. ");
        circularTheoryTextArea.setLineWrap(true);
        circularTheoryTextArea.setCaretPosition(0);
        circularTheoryTextArea.setWrapStyleWord(true);
        
        player = new CustomPlayer(this);
        player.setPath("Welcome.mp3");
        player.play(-1);
        
        menubg = new ButtonGroup();
        menubg.add(acrylMenuRadioButton);
        menubg.add(aeroMenuRadioButton);
        menubg.add(aluminiumMenuRadioButton);
        menubg.add(bernsteinMenuRadioButton);
        menubg.add(fastMenuRadioButton);
        menubg.add(graphiteMenuRadioButton);
        menubg.add(hifiMenuRadioButton);
        menubg.add(lunaMenuRadioButton);
        menubg.add(mcwinMenuRadioButton);
        menubg.add(mintMenuRadioButton);
        menubg.add(noireMenuRadioButton);
        menubg.add(smartMenuRadioButton);
        menubg.add(textureMenuRadioButton);
        noireMenuRadioButton.setSelected(true);
                
        mainbg = new ButtonGroup();
        mainbg.add(singlyRadioButton);
        mainbg.add(doublyRadioButton);
        mainbg.add(circularRadioButton);
        
        menubg = new ButtonGroup();
        menubg.add(singlyRadioButtonMenuItem);
        menubg.add(doublyRadioButtonMenuItem);
        menubg.add(circularRadioButtonMenuItem);
        menubg.clearSelection();
        
        singlybg = new ButtonGroup();
        singlybg.add(singlyInsertRadioButton);
        singlybg.add(singlyDeleteRadioButton);
        singlybg.add(singlySearchRadioButton);
        singlybg.add(singlyReverseRadioButton);
        
        doublybg = new ButtonGroup();
        doublybg.add(doublyInsertRadioButton);
        doublybg.add(doublyDeleteRadioButton);
        doublybg.add(doublySearchRadioButton);
        doublybg.add(doublyReverseRadioButton);
        
        circularbg = new ButtonGroup();
        circularbg.add(circularInsertRadioButton);
        circularbg.add(circularDeleteRadioButton);
        circularbg.add(circularSearchRadioButton);
        
        
        doublyQuizbg = new ButtonGroup();
        doublyQuizbg.add(doublyQuizRadioButton1);
        doublyQuizbg.add(doublyQuizRadioButton2);
        doublyQuizbg.add(doublyQuizRadioButton3);
        doublyQuizbg.add(doublyQuizRadioButton4);
        doublyQuizbg.clearSelection();
        
        doublyQuizRadioButton1.setVisible(false);
        doublyQuizRadioButton2.setVisible(false);
        doublyQuizRadioButton3.setVisible(false);
        doublyQuizRadioButton4.setVisible(false);
        doublyQuizWrongAnsLabel.setVisible(false);
        doublyCheckButton.setVisible(false);
        doublyReattemptButton.setVisible(false);
        
        circularQuizbg = new ButtonGroup();
        circularQuizbg.add(circularQuizRadioButton1);
        circularQuizbg.add(circularQuizRadioButton2);
        circularQuizbg.add(circularQuizRadioButton3);
        circularQuizbg.add(circularQuizRadioButton4);
        circularQuizbg.clearSelection();
        
        circularQuizRadioButton1.setVisible(false);
        circularQuizRadioButton2.setVisible(false);
        circularQuizRadioButton3.setVisible(false);
        circularQuizRadioButton4.setVisible(false);
        circularCheckButton.setVisible(false);
        circularReattemptButton.setVisible(false);
        
        circularQuizQuestion.setText("INSTRUCTIONS: 1) There will be 6 questions and each question has four options.");
        circularQuizQuestion1.setText("2) Once you click on the next button you will not be able to reattempt the previous question");
        
        singlyQuizbg = new ButtonGroup();
        singlyQuizbg.add(singlyQuizRadioButton1);
        singlyQuizbg.add(singlyQuizRadioButton2);
        singlyQuizbg.add(singlyQuizRadioButton3);
        singlyQuizbg.add(singlyQuizRadioButton4);
        singlyQuizbg.clearSelection();
        
        
        singlyQuizQuestion1.setText("INSTRUCTIONS: 1) There will be 10 questions and each question has four options.");
        singlyQuizQuestion.setText("2) Once you click on the next button you will not be able to reattempt the previous question");
        singlyQuizRadioButton1.setVisible(false);
        singlyQuizRadioButton2.setVisible(false);
        singlyQuizRadioButton3.setVisible(false);
        singlyQuizRadioButton4.setVisible(false);
        singlyQuizwrongAnsLabel.setVisible(false);
        singlyReattempt.setVisible(false);
        singlyCheckButton.setVisible(false);     
        rec = new JLabel[10];
        doublyrec = new JLabel[10];
        circularrec = new JLabel[10];
        arrowLabel = new JLabel[10];
        doublyarrowLabel = new JLabel[10];
        circulararrowLabel = new JLabel[10];
        
        createRectangle();
       
        theme1.setText("Default");
        theme2.setText("Blue");
        theme3.setText("Green");
        theme4.setVisible(false);
        theme5.setVisible(false);
        theme6.setVisible(false);
        
                
        singlyGoButton.setVisible(false);
        singlyPositionLabel.setVisible(false);
        singlyWarningLabel.setVisible(false);
        singlyPositionComboBox.setVisible(false);
        
        
        doublyGoButton.setVisible(false);
        doublyPositionLabel.setVisible(false);
        doublyWarningLabel.setVisible(false);
        doublyPositionComboBox.setVisible(false);
        
        circularGoButton.setVisible(false);
        circularWarningLabel.setVisible(false);
        
        singlyspeedofanimation = singlySpeedControllerSlider.getValue();
        doublyspeedofanimation = doublySpeedControllerSlider.getValue();
        circularspeedofanimation = circularSpeedControllerSlider.getValue();
        
        color1 = Color.BLUE;
        color3 = Color.BLUE;
        color5 = Color.BLUE;
        
        singlyChangeColorButton.setLabel("");
        doublyChangeColorButton.setLabel("");
        circularChangeColorButton.setLabel("");
        
        this.setLocationRelativeTo(null);
        
        singlyHeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        doublyHeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        circularHeadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        singlyInsertComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                singlyPositionLabel.setVisible(false);
                singlyPositionComboBox.setVisible(false);
                Object item = singlyInsertComboBox.getSelectedItem();
                if ("Insert at kth position".equals(item)) {
                    operation = "Insert at kth position";
                    singlyPositionLabel.setVisible(true);
                    singlyPositionComboBox.setVisible(true);
                    singlyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else if("Insert Front".equals(item)){
                    operation = "Insert Front";
                    singlyGoButton.setVisible(true);
                    invalidate();
                    validate();
                    //Go.setVisible(true);
                } else if("Insert Rear".equals(item)) {
                    operation = "Insert Rear";
                    singlyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else {
                    operation = "Select";
                    singlyGoButton.setVisible(false);
                }
            }
        });
        
        singlyDeleteComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                singlyPositionLabel.setVisible(false);
                singlyPositionComboBox.setVisible(false);
                Object item = singlyDeleteComboBox.getSelectedItem();
                if ("Delete kth node".equals(item)) {
                    operation = "Delete kth node";
                    singlyPositionLabel.setVisible(true);
                    singlyPositionComboBox.setVisible(true);
                    singlyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else if("Delete Front".equals(item)) {
                    operation = "Delete Front";
                    singlyGoButton.setVisible(true);
                    invalidate();
                    validate();
                    //Go.setVisible(true);
                } else if("Delete Rear".equals(item)){
                    operation = "Delete Rear";
                    singlyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else {
                    operation = "Select";
                    singlyGoButton.setVisible(false);
                }
            }
        });
        singlyInsertComboBox.setVisible(false);
        singlyDeleteComboBox.setVisible(false);
        
        doublyInsertComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                doublyPositionLabel.setVisible(false);
                doublyPositionComboBox.setVisible(false);
                Object item = doublyInsertComboBox.getSelectedItem();
                if ("Insert at kth position".equals(item)) {
                    operation = "Insert at kth position";
                    doublyPositionLabel.setVisible(true);
                    doublyPositionComboBox.setVisible(true);
                    doublyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else if("Insert Front".equals(item)){
                    operation = "Insert Front";
                    doublyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else if("Insert Rear".equals(item)) {
                    operation = "Insert Rear";
                    doublyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else {
                    operation = "Select";
                    doublyGoButton.setVisible(false);
                }
            }
        });
        
        doublyDeleteComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                doublyPositionLabel.setVisible(false);
                doublyPositionComboBox.setVisible(false);
                Object item = doublyDeleteComboBox.getSelectedItem();
                if ("Delete kth node".equals(item)) {
                    operation = "Delete kth node";
                    doublyPositionLabel.setVisible(true);
                    doublyPositionComboBox.setVisible(true);
                    doublyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else if("Delete Front".equals(item)) {
                    operation = "Delete Front";
                    doublyGoButton.setVisible(true);
                    invalidate();
                    validate();
                    //Go.setVisible(true);
                } else if("Delete Rear".equals(item)){
                    operation = "Delete Rear";
                    doublyGoButton.setVisible(true);
                    invalidate();
                    validate();
                } else {
                    operation = "Select";
                    doublyGoButton.setVisible(false);
                }
            }
        });
        
        doublyInsertComboBox.setVisible(false);
        doublyDeleteComboBox.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        singlyRadioButton = new javax.swing.JRadioButton();
        doublyRadioButton = new javax.swing.JRadioButton();
        circularRadioButton = new javax.swing.JRadioButton();
        nextButton = new javax.swing.JButton();
        singlyLLPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        singlyTheoryPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        singlyTheoryTextArea = new javax.swing.JTextArea();
        singlyPlayButton = new javax.swing.JButton();
        singlyStopButton = new javax.swing.JButton();
        singlyPracticalPanel = new javax.swing.JPanel();
        singlyValueLabel = new javax.swing.JLabel();
        singlyValueTextField = new javax.swing.JTextField();
        singlyOperationLabel = new javax.swing.JLabel();
        singlyInsertRadioButton = new javax.swing.JRadioButton();
        singlyDeleteRadioButton = new javax.swing.JRadioButton();
        singlySearchRadioButton = new javax.swing.JRadioButton();
        singlyReverseRadioButton = new javax.swing.JRadioButton();
        singlyInsertComboBox = new javax.swing.JComboBox();
        singlyDeleteComboBox = new javax.swing.JComboBox();
        singlyPositionComboBox = new javax.swing.JComboBox();
        singlyPositionLabel = new javax.swing.JLabel();
        singlyWarningLabel = new javax.swing.JLabel();
        singlyGoButton = new javax.swing.JButton();
        singlySpeedControllerSlider = new javax.swing.JSlider();
        singlySpeedConrollerLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        singlyCodeSegmentTextArea = new javax.swing.JTextArea();
        singlyCodeSegmentLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        singlyChangeColorButton = new java.awt.Button();
        singlyChangeColorLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        singlyApplicationPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        singlyQuizPanel = new javax.swing.JPanel();
        singlyQuizQuestion1 = new javax.swing.JLabel();
        singlyQuizRadioButton1 = new javax.swing.JRadioButton();
        singlyQuizRadioButton2 = new javax.swing.JRadioButton();
        singlyQuizRadioButton3 = new javax.swing.JRadioButton();
        singlyQuizRadioButton4 = new javax.swing.JRadioButton();
        singlyCheckButton = new javax.swing.JButton();
        singlyQuizNextButton = new javax.swing.JButton();
        singlyQuizwrongAnsLabel = new javax.swing.JLabel();
        singlyQuizQuestion = new javax.swing.JLabel();
        singlyCountdownLabel = new javax.swing.JLabel();
        singlyReattempt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        singlyHeadingLabel = new javax.swing.JLabel();
        doublyLLPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        doublyTheoryPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        doublyTheoryTextArea = new javax.swing.JTextArea();
        doublyPlayButton = new javax.swing.JButton();
        doublyStopButton = new javax.swing.JButton();
        doublyPracticalPanel = new javax.swing.JPanel();
        doublyValueLabel = new javax.swing.JLabel();
        doublyValueTextField = new javax.swing.JTextField();
        doublyOperationLabel = new javax.swing.JLabel();
        doublyInsertRadioButton = new javax.swing.JRadioButton();
        doublyDeleteRadioButton = new javax.swing.JRadioButton();
        doublySearchRadioButton = new javax.swing.JRadioButton();
        doublyReverseRadioButton = new javax.swing.JRadioButton();
        doublyWarningLabel = new javax.swing.JLabel();
        doublyInsertComboBox = new javax.swing.JComboBox();
        doublyDeleteComboBox = new javax.swing.JComboBox();
        doublyPositionLabel = new javax.swing.JLabel();
        doublyPositionComboBox = new javax.swing.JComboBox();
        doublyGoButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        doublySpeedControllerSlider = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        doublyChangeColorButton = new java.awt.Button();
        jScrollPane5 = new javax.swing.JScrollPane();
        doublyCodeSegmentTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        doublyApplicationPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        doublyQuizPanel = new javax.swing.JPanel();
        doublyQuizQuestion1 = new javax.swing.JLabel();
        doublyQuizQuestion = new javax.swing.JLabel();
        doublyQuizRadioButton1 = new javax.swing.JRadioButton();
        doublyQuizRadioButton2 = new javax.swing.JRadioButton();
        doublyQuizRadioButton3 = new javax.swing.JRadioButton();
        doublyQuizRadioButton4 = new javax.swing.JRadioButton();
        doublyCheckButton = new javax.swing.JButton();
        doublyNextButton = new javax.swing.JButton();
        doublyQuizWrongAnsLabel = new javax.swing.JLabel();
        doublyCountdownLabel = new javax.swing.JLabel();
        doublyReattemptButton = new javax.swing.JButton();
        doublyHeadingLabel = new javax.swing.JLabel();
        circularLLPanel = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        circularTheoryPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        circularTheoryTextArea = new javax.swing.JTextArea();
        circularPlayButton = new javax.swing.JButton();
        circularStopButton = new javax.swing.JButton();
        circularPracticalPanel = new javax.swing.JPanel();
        circularValueLabel = new javax.swing.JLabel();
        circularOperationLabel = new javax.swing.JLabel();
        circularInsertRadioButton = new javax.swing.JRadioButton();
        circularDeleteRadioButton = new javax.swing.JRadioButton();
        circularSearchRadioButton = new javax.swing.JRadioButton();
        circularGoButton = new javax.swing.JButton();
        circularValueTextField = new javax.swing.JTextField();
        circularWarningLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        circularSpeedControllerSlider = new javax.swing.JSlider();
        circularSpeedConrollerLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        circularChangeColorButton = new java.awt.Button();
        jScrollPane6 = new javax.swing.JScrollPane();
        circularCodeSegmentTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        circularApplicationPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        circularQuizPanel = new javax.swing.JPanel();
        circularQuizQuestion = new javax.swing.JLabel();
        circularQuizQuestion1 = new javax.swing.JLabel();
        circularQuizRadioButton1 = new javax.swing.JRadioButton();
        circularQuizRadioButton2 = new javax.swing.JRadioButton();
        circularQuizRadioButton3 = new javax.swing.JRadioButton();
        circularQuizRadioButton4 = new javax.swing.JRadioButton();
        circularCheckButton = new javax.swing.JButton();
        circularNextButton = new javax.swing.JButton();
        circularReattemptButton = new javax.swing.JButton();
        circularCountdownLabel = new javax.swing.JLabel();
        circularHeadingLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        datastructureMenu = new javax.swing.JMenu();
        singlyRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        doublyRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        circularRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        formatMenu = new javax.swing.JMenu();
        lookandfeelMenu = new javax.swing.JMenu();
        acrylMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        aeroMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        aluminiumMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        bernsteinMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        fastMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        graphiteMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        hifiMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        lunaMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        mcwinMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        mintMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        noireMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        smartMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        textureMenuRadioButton = new javax.swing.JRadioButtonMenuItem();
        themeMenu = new javax.swing.JMenu();
        theme1 = new javax.swing.JMenuItem();
        theme2 = new javax.swing.JMenuItem();
        theme3 = new javax.swing.JMenuItem();
        theme4 = new javax.swing.JMenuItem();
        theme5 = new javax.swing.JMenuItem();
        theme6 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        creditsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(635, 360));
        setPreferredSize(new java.awt.Dimension(700, 605));
        setResizable(false);

        mainPanel.setMaximumSize(new java.awt.Dimension(635, 344));
        mainPanel.setMinimumSize(new java.awt.Dimension(635, 344));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        jLabel1.setText("    Linked List Visualization");

        singlyRadioButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        singlyRadioButton.setText("Singly Linked List");

        doublyRadioButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        doublyRadioButton.setText("Doubly Linked List");

        circularRadioButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        circularRadioButton.setText("Circular Linked List");

        nextButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 894, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(circularRadioButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doublyRadioButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(singlyRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(singlyRadioButton)
                .addGap(18, 18, 18)
                .addComponent(doublyRadioButton)
                .addGap(18, 18, 18)
                .addComponent(circularRadioButton)
                .addGap(26, 26, 26)
                .addComponent(nextButton)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        singlyLLPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        singlyTheoryTextArea.setEditable(false);
        singlyTheoryTextArea.setColumns(20);
        singlyTheoryTextArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        singlyTheoryTextArea.setLineWrap(true);
        singlyTheoryTextArea.setRows(5);
        singlyTheoryTextArea.setWrapStyleWord(true);
        singlyTheoryTextArea.setOpaque(false);
        jScrollPane1.setViewportView(singlyTheoryTextArea);

        singlyPlayButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg"))); // NOI18N
        singlyPlayButton.setText("Play");
        singlyPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyPlayButtonActionPerformed(evt);
            }
        });

        singlyStopButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyStopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/stop.jpg"))); // NOI18N
        singlyStopButton.setText("Stop");
        singlyStopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyStopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout singlyTheoryPanelLayout = new javax.swing.GroupLayout(singlyTheoryPanel);
        singlyTheoryPanel.setLayout(singlyTheoryPanelLayout);
        singlyTheoryPanelLayout.setHorizontalGroup(
            singlyTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, singlyTheoryPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(singlyTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(singlyPlayButton)
                    .addComponent(singlyStopButton))
                .addGap(18, 18, 18))
        );
        singlyTheoryPanelLayout.setVerticalGroup(
            singlyTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
            .addGroup(singlyTheoryPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(singlyPlayButton)
                .addGap(121, 121, 121)
                .addComponent(singlyStopButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Theory", singlyTheoryPanel);

        singlyPracticalPanel.setLayout(null);

        singlyValueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyValueLabel.setText("Enter data :");
        singlyPracticalPanel.add(singlyValueLabel);
        singlyValueLabel.setBounds(90, 20, 90, 17);
        singlyPracticalPanel.add(singlyValueTextField);
        singlyValueTextField.setBounds(190, 20, 40, 20);

        singlyOperationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyOperationLabel.setText("Select Operation :");
        singlyPracticalPanel.add(singlyOperationLabel);
        singlyOperationLabel.setBounds(90, 60, 140, 17);

        singlyInsertRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyInsertRadioButton.setText("Insert");
        singlyInsertRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyInsertRadioButtonActionPerformed(evt);
            }
        });
        singlyPracticalPanel.add(singlyInsertRadioButton);
        singlyInsertRadioButton.setBounds(220, 57, 80, 25);

        singlyDeleteRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyDeleteRadioButton.setText("Delete");
        singlyDeleteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyDeleteRadioButtonActionPerformed(evt);
            }
        });
        singlyPracticalPanel.add(singlyDeleteRadioButton);
        singlyDeleteRadioButton.setBounds(300, 57, 80, 23);

        singlySearchRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlySearchRadioButton.setText("Search");
        singlySearchRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlySearchRadioButtonActionPerformed(evt);
            }
        });
        singlyPracticalPanel.add(singlySearchRadioButton);
        singlySearchRadioButton.setBounds(380, 57, 90, 25);

        singlyReverseRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyReverseRadioButton.setText("Reverse");
        singlyReverseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyReverseRadioButtonActionPerformed(evt);
            }
        });
        singlyPracticalPanel.add(singlyReverseRadioButton);
        singlyReverseRadioButton.setBounds(470, 57, 100, 25);

        singlyInsertComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyPracticalPanel.add(singlyInsertComboBox);
        singlyInsertComboBox.setBounds(120, 90, 170, 23);

        singlyDeleteComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyPracticalPanel.add(singlyDeleteComboBox);
        singlyDeleteComboBox.setBounds(150, 90, 140, 23);

        singlyPositionComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyPositionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        singlyPracticalPanel.add(singlyPositionComboBox);
        singlyPositionComboBox.setBounds(410, 90, 60, 23);

        singlyPositionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyPositionLabel.setText("Position :");
        singlyPracticalPanel.add(singlyPositionLabel);
        singlyPositionLabel.setBounds(310, 95, 80, 14);

        singlyWarningLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyWarningLabel.setForeground(new java.awt.Color(255, 0, 0));
        singlyWarningLabel.setText("* No data entered");
        singlyPracticalPanel.add(singlyWarningLabel);
        singlyWarningLabel.setBounds(290, 20, 140, 17);

        singlyGoButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyGoButton.setText("Insert");
        singlyGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyGoButtonActionPerformed(evt);
            }
        });
        singlyPracticalPanel.add(singlyGoButton);
        singlyGoButton.setBounds(260, 130, 80, 25);

        singlySpeedControllerSlider.setMajorTickSpacing(20);
        singlySpeedControllerSlider.setMaximum(120);
        singlySpeedControllerSlider.setMinimum(20);
        singlySpeedControllerSlider.setMinorTickSpacing(10);
        singlySpeedControllerSlider.setPaintTicks(true);
        singlySpeedControllerSlider.setSnapToTicks(true);
        singlySpeedControllerSlider.setValue(70);
        singlySpeedControllerSlider.setAutoscrolls(true);
        singlySpeedControllerSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        singlySpeedControllerSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                singlySpeedControllerSliderStateChanged(evt);
            }
        });
        singlyPracticalPanel.add(singlySpeedControllerSlider);
        singlySpeedControllerSlider.setBounds(310, 320, 360, 110);

        singlySpeedConrollerLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlySpeedConrollerLabel.setText("Animation Speed Controller ");
        singlyPracticalPanel.add(singlySpeedConrollerLabel);
        singlySpeedConrollerLabel.setBounds(100, 360, 210, 20);

        singlyCodeSegmentTextArea.setEditable(false);
        singlyCodeSegmentTextArea.setColumns(20);
        singlyCodeSegmentTextArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        singlyCodeSegmentTextArea.setLineWrap(true);
        singlyCodeSegmentTextArea.setRows(5);
        singlyCodeSegmentTextArea.setWrapStyleWord(true);
        singlyCodeSegmentTextArea.setBorder(null);
        singlyCodeSegmentTextArea.setOpaque(false);
        jScrollPane4.setViewportView(singlyCodeSegmentTextArea);

        singlyPracticalPanel.add(jScrollPane4);
        jScrollPane4.setBounds(800, 360, 480, 180);

        singlyCodeSegmentLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyCodeSegmentLabel.setText("Code Segment ");
        singlyPracticalPanel.add(singlyCodeSegmentLabel);
        singlyCodeSegmentLabel.setBounds(930, 330, 110, 17);
        singlyPracticalPanel.add(jSeparator1);
        jSeparator1.setBounds(0, 310, 1360, 10);

        singlyChangeColorButton.setBackground(new java.awt.Color(0, 0, 255));
        singlyChangeColorButton.setLabel("button1");
        singlyChangeColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyChangeColorButtonActionPerformed(evt);
            }
        });
        singlyPracticalPanel.add(singlyChangeColorButton);
        singlyChangeColorButton.setBounds(270, 480, 57, 24);

        singlyChangeColorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyChangeColorLabel.setText("Change Node Color ");
        singlyPracticalPanel.add(singlyChangeColorLabel);
        singlyChangeColorLabel.setBounds(100, 485, 170, 17);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        singlyPracticalPanel.add(jButton1);
        jButton1.setBounds(640, 40, 73, 23);

        jTabbedPane1.addTab("Demonstration", singlyPracticalPanel);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/hash_dico.jpg"))); // NOI18N

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setText("                      A hash table is simply an array that is addressed via a hash function. Each element is a pointer to a linked list of containing related data.\nTo insert a new item in the table, we hash the key to determine which list the item goes on, and then insert the item at the beginning of the list. Entries \nin the hash table are dynamically allocated and entered on a linked list associated with each hash table entry.");
        jTextArea2.setOpaque(false);
        jScrollPane8.setViewportView(jTextArea2);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Hash Table :");

        javax.swing.GroupLayout singlyApplicationPanelLayout = new javax.swing.GroupLayout(singlyApplicationPanel);
        singlyApplicationPanel.setLayout(singlyApplicationPanelLayout);
        singlyApplicationPanelLayout.setHorizontalGroup(
            singlyApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
            .addGroup(singlyApplicationPanelLayout.createSequentialGroup()
                .addGroup(singlyApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(singlyApplicationPanelLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel7))
                    .addGroup(singlyApplicationPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)))
                .addContainerGap(599, Short.MAX_VALUE))
        );
        singlyApplicationPanelLayout.setVerticalGroup(
            singlyApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, singlyApplicationPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        jTabbedPane1.addTab("Application", singlyApplicationPanel);

        singlyQuizQuestion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        singlyQuizRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        singlyQuizRadioButton1.setText("jRadioButton1");

        singlyQuizRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        singlyQuizRadioButton2.setText("jRadioButton2");

        singlyQuizRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        singlyQuizRadioButton3.setText("jRadioButton3");

        singlyQuizRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        singlyQuizRadioButton4.setText("jRadioButton4");

        singlyCheckButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyCheckButton.setText("Check");
        singlyCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyCheckButtonActionPerformed(evt);
            }
        });

        singlyQuizNextButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyQuizNextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/take-our-quiz-blue-292x300.jpg"))); // NOI18N
        singlyQuizNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyQuizNextButtonActionPerformed(evt);
            }
        });

        singlyQuizwrongAnsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyQuizwrongAnsLabel.setForeground(new java.awt.Color(255, 0, 0));
        singlyQuizwrongAnsLabel.setText("* Select any one");

        singlyQuizQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        singlyCountdownLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        singlyReattempt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        singlyReattempt.setText("Reattempt");
        singlyReattempt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyReattemptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout singlyQuizPanelLayout = new javax.swing.GroupLayout(singlyQuizPanel);
        singlyQuizPanel.setLayout(singlyQuizPanelLayout);
        singlyQuizPanelLayout.setHorizontalGroup(
            singlyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singlyQuizPanelLayout.createSequentialGroup()
                .addGroup(singlyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(singlyQuizPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(singlyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(singlyQuizRadioButton2)
                            .addComponent(singlyQuizRadioButton1)
                            .addComponent(singlyQuizRadioButton3)
                            .addComponent(singlyQuizRadioButton4)
                            .addComponent(singlyQuizwrongAnsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(singlyQuizPanelLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(singlyCheckButton)
                        .addGap(40, 40, 40)
                        .addComponent(singlyQuizNextButton)
                        .addGap(28, 28, 28)
                        .addComponent(singlyReattempt))
                    .addGroup(singlyQuizPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(singlyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(singlyQuizQuestion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(singlyQuizQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))))
                .addContainerGap(685, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, singlyQuizPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(singlyCountdownLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        singlyQuizPanelLayout.setVerticalGroup(
            singlyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(singlyQuizPanelLayout.createSequentialGroup()
                .addComponent(singlyCountdownLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(singlyQuizQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(singlyQuizQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(singlyQuizRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(singlyQuizRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(singlyQuizRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(singlyQuizRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(singlyQuizwrongAnsLabel)
                .addGroup(singlyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(singlyQuizPanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(singlyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(singlyCheckButton)
                            .addComponent(singlyQuizNextButton)))
                    .addGroup(singlyQuizPanelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(singlyReattempt)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quiz", singlyQuizPanel);

        singlyHeadingLabel.setBackground(new java.awt.Color(0, 102, 102));
        singlyHeadingLabel.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        singlyHeadingLabel.setText("Singly Linked List");
        singlyHeadingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        singlyHeadingLabel.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(singlyHeadingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(singlyHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout singlyLLPanelLayout = new javax.swing.GroupLayout(singlyLLPanel);
        singlyLLPanel.setLayout(singlyLLPanelLayout);
        singlyLLPanelLayout.setHorizontalGroup(
            singlyLLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        singlyLLPanelLayout.setVerticalGroup(
            singlyLLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, singlyLLPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        doublyLLPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        doublyTheoryPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        doublyTheoryTextArea.setEditable(false);
        doublyTheoryTextArea.setColumns(20);
        doublyTheoryTextArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        doublyTheoryTextArea.setLineWrap(true);
        doublyTheoryTextArea.setRows(5);
        doublyTheoryTextArea.setWrapStyleWord(true);
        doublyTheoryTextArea.setBorder(null);
        doublyTheoryTextArea.setOpaque(false);
        jScrollPane2.setViewportView(doublyTheoryTextArea);

        doublyPlayButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg"))); // NOI18N
        doublyPlayButton.setText("Play");
        doublyPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyPlayButtonActionPerformed(evt);
            }
        });

        doublyStopButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyStopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/stop.jpg"))); // NOI18N
        doublyStopButton.setText("Stop");
        doublyStopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyStopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout doublyTheoryPanelLayout = new javax.swing.GroupLayout(doublyTheoryPanel);
        doublyTheoryPanel.setLayout(doublyTheoryPanelLayout);
        doublyTheoryPanelLayout.setHorizontalGroup(
            doublyTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doublyTheoryPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1188, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(doublyTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doublyStopButton)
                    .addComponent(doublyPlayButton))
                .addGap(18, 18, 18))
        );
        doublyTheoryPanelLayout.setVerticalGroup(
            doublyTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doublyTheoryPanelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(doublyPlayButton)
                .addGap(121, 121, 121)
                .addComponent(doublyStopButton)
                .addContainerGap(293, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );

        jTabbedPane2.addTab("Theory", doublyTheoryPanel);

        doublyPracticalPanel.setLayout(null);

        doublyValueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyValueLabel.setText("Enter data :");
        doublyPracticalPanel.add(doublyValueLabel);
        doublyValueLabel.setBounds(76, 20, 100, 17);
        doublyPracticalPanel.add(doublyValueTextField);
        doublyValueTextField.setBounds(180, 20, 50, 20);

        doublyOperationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyOperationLabel.setText("Select Operation :");
        doublyPracticalPanel.add(doublyOperationLabel);
        doublyOperationLabel.setBounds(76, 69, 123, 17);

        doublyInsertRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyInsertRadioButton.setText("Insert");
        doublyInsertRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyInsertRadioButtonActionPerformed(evt);
            }
        });
        doublyPracticalPanel.add(doublyInsertRadioButton);
        doublyInsertRadioButton.setBounds(217, 65, 90, 25);

        doublyDeleteRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyDeleteRadioButton.setText("Delete");
        doublyDeleteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyDeleteRadioButtonActionPerformed(evt);
            }
        });
        doublyPracticalPanel.add(doublyDeleteRadioButton);
        doublyDeleteRadioButton.setBounds(310, 65, 90, 25);

        doublySearchRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublySearchRadioButton.setText("Search");
        doublySearchRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublySearchRadioButtonActionPerformed(evt);
            }
        });
        doublyPracticalPanel.add(doublySearchRadioButton);
        doublySearchRadioButton.setBounds(410, 65, 100, 25);

        doublyReverseRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyReverseRadioButton.setText("Reverse");
        doublyReverseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyReverseRadioButtonActionPerformed(evt);
            }
        });
        doublyPracticalPanel.add(doublyReverseRadioButton);
        doublyReverseRadioButton.setBounds(510, 65, 110, 25);

        doublyWarningLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyWarningLabel.setForeground(new java.awt.Color(255, 0, 0));
        doublyWarningLabel.setText("* No data entered");
        doublyPracticalPanel.add(doublyWarningLabel);
        doublyWarningLabel.setBounds(260, 20, 126, 17);

        doublyInsertComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyPracticalPanel.add(doublyInsertComboBox);
        doublyInsertComboBox.setBounds(100, 110, 190, 23);

        doublyDeleteComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyPracticalPanel.add(doublyDeleteComboBox);
        doublyDeleteComboBox.setBounds(130, 110, 140, 23);

        doublyPositionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyPositionLabel.setText("Position :");
        doublyPracticalPanel.add(doublyPositionLabel);
        doublyPositionLabel.setBounds(320, 110, 64, 17);

        doublyPositionComboBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyPracticalPanel.add(doublyPositionComboBox);
        doublyPositionComboBox.setBounds(400, 110, 50, 23);

        doublyGoButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyGoButton.setText("Go");
        doublyGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyGoButtonActionPerformed(evt);
            }
        });
        doublyPracticalPanel.add(doublyGoButton);
        doublyGoButton.setBounds(280, 150, 90, 25);
        doublyPracticalPanel.add(jSeparator2);
        jSeparator2.setBounds(0, 310, 1366, 2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Animation Speed Controller");
        doublyPracticalPanel.add(jLabel2);
        jLabel2.setBounds(100, 360, 210, 20);

        doublySpeedControllerSlider.setMajorTickSpacing(20);
        doublySpeedControllerSlider.setMaximum(120);
        doublySpeedControllerSlider.setMinimum(20);
        doublySpeedControllerSlider.setMinorTickSpacing(10);
        doublySpeedControllerSlider.setPaintTicks(true);
        doublySpeedControllerSlider.setSnapToTicks(true);
        doublySpeedControllerSlider.setValue(70);
        doublySpeedControllerSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                doublySpeedControllerSliderStateChanged(evt);
            }
        });
        doublyPracticalPanel.add(doublySpeedControllerSlider);
        doublySpeedControllerSlider.setBounds(310, 345, 320, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Change Node Color ");
        doublyPracticalPanel.add(jLabel3);
        jLabel3.setBounds(100, 490, 150, 17);

        doublyChangeColorButton.setBackground(new java.awt.Color(0, 0, 255));
        doublyChangeColorButton.setLabel("button1");
        doublyChangeColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyChangeColorButtonActionPerformed(evt);
            }
        });
        doublyPracticalPanel.add(doublyChangeColorButton);
        doublyChangeColorButton.setBounds(250, 485, 57, 24);

        doublyCodeSegmentTextArea.setColumns(20);
        doublyCodeSegmentTextArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        doublyCodeSegmentTextArea.setLineWrap(true);
        doublyCodeSegmentTextArea.setRows(5);
        doublyCodeSegmentTextArea.setWrapStyleWord(true);
        doublyCodeSegmentTextArea.setOpaque(false);
        jScrollPane5.setViewportView(doublyCodeSegmentTextArea);

        doublyPracticalPanel.add(jScrollPane5);
        jScrollPane5.setBounds(870, 370, 390, 170);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Code Segment");
        doublyPracticalPanel.add(jLabel4);
        jLabel4.setBounds(1010, 340, 110, 17);

        jTabbedPane2.addTab("Demonstration", doublyPracticalPanel);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/demoscr.JPG"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Playlist in a Music Player");

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("              A playlist is a collection of songs which is stored in a doubly linked list where each song is considered \nto be a node. Since we can go back to the previous song or go front to the next song, it is one of the common application\nof doubly linked list.");
        jTextArea3.setWrapStyleWord(true);
        jTextArea3.setOpaque(false);
        jScrollPane9.setViewportView(jTextArea3);

        javax.swing.GroupLayout doublyApplicationPanelLayout = new javax.swing.GroupLayout(doublyApplicationPanel);
        doublyApplicationPanel.setLayout(doublyApplicationPanelLayout);
        doublyApplicationPanelLayout.setHorizontalGroup(
            doublyApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
            .addGroup(doublyApplicationPanelLayout.createSequentialGroup()
                .addGroup(doublyApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doublyApplicationPanelLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel11))
                    .addGroup(doublyApplicationPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel12)))
                .addContainerGap(761, Short.MAX_VALUE))
        );
        doublyApplicationPanelLayout.setVerticalGroup(
            doublyApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doublyApplicationPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Applications", doublyApplicationPanel);

        doublyQuizQuestion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyQuizQuestion1.setText("Instruction : 1) There will be ten question and each question contains four options.");

        doublyQuizQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyQuizQuestion.setText("2) Once you click on the next button you connot reattempt the previous question.");

        doublyQuizRadioButton1.setText("jRadioButton1");

        doublyQuizRadioButton2.setText("jRadioButton2");

        doublyQuizRadioButton3.setText("jRadioButton3");

        doublyQuizRadioButton4.setText("jRadioButton4");

        doublyCheckButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyCheckButton.setText("Check");
        doublyCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyCheckButtonActionPerformed(evt);
            }
        });

        doublyNextButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyNextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/take-our-quiz-blue-292x300.jpg"))); // NOI18N
        doublyNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyNextButtonActionPerformed(evt);
            }
        });

        doublyQuizWrongAnsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyQuizWrongAnsLabel.setForeground(new java.awt.Color(255, 0, 0));
        doublyQuizWrongAnsLabel.setText("* Select one option");

        doublyCountdownLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        doublyReattemptButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doublyReattemptButton.setText("Reattempt");
        doublyReattemptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyReattemptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout doublyQuizPanelLayout = new javax.swing.GroupLayout(doublyQuizPanel);
        doublyQuizPanel.setLayout(doublyQuizPanelLayout);
        doublyQuizPanelLayout.setHorizontalGroup(
            doublyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doublyQuizPanelLayout.createSequentialGroup()
                .addGroup(doublyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(doublyQuizPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(doublyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doublyQuizRadioButton2)
                            .addComponent(doublyQuizRadioButton1)
                            .addComponent(doublyQuizRadioButton3)
                            .addComponent(doublyQuizRadioButton4)))
                    .addGroup(doublyQuizPanelLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addGroup(doublyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(doublyQuizWrongAnsLabel)
                            .addComponent(doublyCheckButton))
                        .addGap(31, 31, 31)
                        .addComponent(doublyNextButton)
                        .addGap(38, 38, 38)
                        .addComponent(doublyReattemptButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(doublyQuizPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(doublyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(doublyQuizQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(doublyQuizQuestion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doublyCountdownLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        doublyQuizPanelLayout.setVerticalGroup(
            doublyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(doublyQuizPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(doublyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(doublyQuizQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doublyCountdownLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(doublyQuizQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(doublyQuizRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(doublyQuizRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(doublyQuizRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(doublyQuizRadioButton4)
                .addGap(18, 18, 18)
                .addComponent(doublyQuizWrongAnsLabel)
                .addGap(20, 20, 20)
                .addGroup(doublyQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doublyCheckButton)
                    .addComponent(doublyNextButton)
                    .addComponent(doublyReattemptButton))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quiz", doublyQuizPanel);

        doublyHeadingLabel.setBackground(new java.awt.Color(0, 102, 102));
        doublyHeadingLabel.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        doublyHeadingLabel.setText("Doubly Linked List");
        doublyHeadingLabel.setOpaque(true);

        javax.swing.GroupLayout doublyLLPanelLayout = new javax.swing.GroupLayout(doublyLLPanel);
        doublyLLPanel.setLayout(doublyLLPanelLayout);
        doublyLLPanelLayout.setHorizontalGroup(
            doublyLLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
            .addComponent(doublyHeadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        doublyLLPanelLayout.setVerticalGroup(
            doublyLLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, doublyLLPanelLayout.createSequentialGroup()
                .addComponent(doublyHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        circularLLPanel.setPreferredSize(new java.awt.Dimension(1366, 768));

        jTabbedPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        circularTheoryTextArea.setEditable(false);
        circularTheoryTextArea.setColumns(20);
        circularTheoryTextArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        circularTheoryTextArea.setLineWrap(true);
        circularTheoryTextArea.setRows(5);
        circularTheoryTextArea.setWrapStyleWord(true);
        circularTheoryTextArea.setOpaque(false);
        jScrollPane3.setViewportView(circularTheoryTextArea);

        circularPlayButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg"))); // NOI18N
        circularPlayButton.setText("Play");
        circularPlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularPlayButtonActionPerformed(evt);
            }
        });

        circularStopButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularStopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/stop.jpg"))); // NOI18N
        circularStopButton.setText("Stop");
        circularStopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularStopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout circularTheoryPanelLayout = new javax.swing.GroupLayout(circularTheoryPanel);
        circularTheoryPanel.setLayout(circularTheoryPanelLayout);
        circularTheoryPanelLayout.setHorizontalGroup(
            circularTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circularTheoryPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1186, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(circularTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(circularPlayButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(circularStopButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        circularTheoryPanelLayout.setVerticalGroup(
            circularTheoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circularTheoryPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(circularPlayButton)
                .addGap(121, 121, 121)
                .addComponent(circularStopButton)
                .addContainerGap(312, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );

        jTabbedPane3.addTab("Theory", circularTheoryPanel);

        circularPracticalPanel.setLayout(null);

        circularValueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularValueLabel.setText("Enter data : ");
        circularPracticalPanel.add(circularValueLabel);
        circularValueLabel.setBounds(120, 33, 110, 24);

        circularOperationLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularOperationLabel.setText("Select Operation :");
        circularPracticalPanel.add(circularOperationLabel);
        circularOperationLabel.setBounds(120, 76, 150, 17);

        circularInsertRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularInsertRadioButton.setText("Insert");
        circularInsertRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularInsertRadioButtonActionPerformed(evt);
            }
        });
        circularPracticalPanel.add(circularInsertRadioButton);
        circularInsertRadioButton.setBounds(280, 75, 90, 25);

        circularDeleteRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularDeleteRadioButton.setText("Delete");
        circularDeleteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularDeleteRadioButtonActionPerformed(evt);
            }
        });
        circularPracticalPanel.add(circularDeleteRadioButton);
        circularDeleteRadioButton.setBounds(370, 75, 100, 25);

        circularSearchRadioButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularSearchRadioButton.setText("Search");
        circularSearchRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularSearchRadioButtonActionPerformed(evt);
            }
        });
        circularPracticalPanel.add(circularSearchRadioButton);
        circularSearchRadioButton.setBounds(480, 75, 100, 25);

        circularGoButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularGoButton.setText("Go");
        circularGoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularGoButtonActionPerformed(evt);
            }
        });
        circularPracticalPanel.add(circularGoButton);
        circularGoButton.setBounds(300, 140, 82, 25);
        circularPracticalPanel.add(circularValueTextField);
        circularValueTextField.setBounds(240, 37, 60, 20);

        circularWarningLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularWarningLabel.setForeground(new java.awt.Color(255, 51, 0));
        circularWarningLabel.setText("* No Data Entered");
        circularPracticalPanel.add(circularWarningLabel);
        circularWarningLabel.setBounds(370, 40, 140, 17);
        circularPracticalPanel.add(jSeparator3);
        jSeparator3.setBounds(0, 310, 1360, 10);

        circularSpeedControllerSlider.setMajorTickSpacing(20);
        circularSpeedControllerSlider.setMaximum(120);
        circularSpeedControllerSlider.setMinimum(20);
        circularSpeedControllerSlider.setMinorTickSpacing(10);
        circularSpeedControllerSlider.setPaintTicks(true);
        circularSpeedControllerSlider.setSnapToTicks(true);
        circularSpeedControllerSlider.setValue(70);
        circularSpeedControllerSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                circularSpeedControllerSliderStateChanged(evt);
            }
        });
        circularPracticalPanel.add(circularSpeedControllerSlider);
        circularSpeedControllerSlider.setBounds(380, 360, 320, 40);

        circularSpeedConrollerLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularSpeedConrollerLabel.setText("Animation Speed Controller");
        circularPracticalPanel.add(circularSpeedConrollerLabel);
        circularSpeedConrollerLabel.setBounds(120, 370, 230, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Change Node Color ");
        circularPracticalPanel.add(jLabel5);
        jLabel5.setBounds(120, 470, 160, 17);

        circularChangeColorButton.setBackground(new java.awt.Color(0, 0, 255));
        circularChangeColorButton.setLabel("button1");
        circularChangeColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularChangeColorButtonActionPerformed(evt);
            }
        });
        circularPracticalPanel.add(circularChangeColorButton);
        circularChangeColorButton.setBounds(300, 470, 57, 24);

        circularCodeSegmentTextArea.setColumns(20);
        circularCodeSegmentTextArea.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        circularCodeSegmentTextArea.setLineWrap(true);
        circularCodeSegmentTextArea.setRows(5);
        circularCodeSegmentTextArea.setWrapStyleWord(true);
        circularCodeSegmentTextArea.setBorder(null);
        circularCodeSegmentTextArea.setOpaque(false);
        jScrollPane6.setViewportView(circularCodeSegmentTextArea);

        circularPracticalPanel.add(jScrollPane6);
        jScrollPane6.setBounds(830, 360, 420, 180);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Code Segment");
        circularPracticalPanel.add(jLabel6);
        jLabel6.setBounds(990, 340, 110, 17);

        jTabbedPane3.addTab("Demonstration", circularPracticalPanel);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/trani.gif"))); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("             In ring topology, each device is assumed to be a node which are connected using circular linked list.\nA signal is passed along the ring in one direction, from one node to another until it reaches its destination.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setOpaque(false);
        jScrollPane7.setViewportView(jTextArea1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Ring Topology");

        javax.swing.GroupLayout circularApplicationPanelLayout = new javax.swing.GroupLayout(circularApplicationPanel);
        circularApplicationPanel.setLayout(circularApplicationPanelLayout);
        circularApplicationPanelLayout.setHorizontalGroup(
            circularApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(circularApplicationPanelLayout.createSequentialGroup()
                .addGroup(circularApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(circularApplicationPanelLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel8))
                    .addGroup(circularApplicationPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel9)))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        circularApplicationPanelLayout.setVerticalGroup(
            circularApplicationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circularApplicationPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Application", circularApplicationPanel);

        circularQuizQuestion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        circularQuizQuestion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        circularQuizRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularQuizRadioButton1.setText("jRadioButton1");

        circularQuizRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularQuizRadioButton2.setText("jRadioButton2");

        circularQuizRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularQuizRadioButton3.setText("jRadioButton3");

        circularQuizRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularQuizRadioButton4.setText("jRadioButton4");

        circularCheckButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularCheckButton.setText("Check");
        circularCheckButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularCheckButtonActionPerformed(evt);
            }
        });

        circularNextButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularNextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/take-our-quiz-blue-292x300.jpg"))); // NOI18N
        circularNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularNextButtonActionPerformed(evt);
            }
        });

        circularReattemptButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        circularReattemptButton.setText("Reattempt");
        circularReattemptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularReattemptButtonActionPerformed(evt);
            }
        });

        circularCountdownLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout circularQuizPanelLayout = new javax.swing.GroupLayout(circularQuizPanel);
        circularQuizPanel.setLayout(circularQuizPanelLayout);
        circularQuizPanelLayout.setHorizontalGroup(
            circularQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circularQuizPanelLayout.createSequentialGroup()
                .addGroup(circularQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(circularQuizPanelLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(circularCheckButton)
                        .addGap(26, 26, 26)
                        .addComponent(circularNextButton)
                        .addGap(42, 42, 42)
                        .addComponent(circularReattemptButton))
                    .addGroup(circularQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, circularQuizPanelLayout.createSequentialGroup()
                            .addGap(109, 109, 109)
                            .addGroup(circularQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(circularQuizRadioButton2)
                                .addComponent(circularQuizRadioButton1)
                                .addComponent(circularQuizRadioButton3)
                                .addComponent(circularQuizRadioButton4)))
                        .addGroup(circularQuizPanelLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(circularQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(circularQuizQuestion1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addComponent(circularQuizQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(851, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, circularQuizPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(circularCountdownLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        circularQuizPanelLayout.setVerticalGroup(
            circularQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(circularQuizPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(circularCountdownLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(circularQuizQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(circularQuizQuestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(circularQuizRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(circularQuizRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(circularQuizRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(circularQuizRadioButton4)
                .addGap(15, 15, 15)
                .addGroup(circularQuizPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(circularNextButton)
                    .addComponent(circularCheckButton)
                    .addComponent(circularReattemptButton))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Quiz", circularQuizPanel);

        circularHeadingLabel.setBackground(new java.awt.Color(0, 102, 102));
        circularHeadingLabel.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        circularHeadingLabel.setText("Circular Linked List");
        circularHeadingLabel.setOpaque(true);

        javax.swing.GroupLayout circularLLPanelLayout = new javax.swing.GroupLayout(circularLLPanel);
        circularLLPanel.setLayout(circularLLPanelLayout);
        circularLLPanelLayout.setHorizontalGroup(
            circularLLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(circularHeadingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
        );
        circularLLPanelLayout.setVerticalGroup(
            circularLLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, circularLLPanelLayout.createSequentialGroup()
                .addComponent(circularHeadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(singlyLLPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(doublyLLPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(circularLLPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(singlyLLPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(doublyLLPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(circularLLPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        datastructureMenu.setText("Data Structures");

        singlyRadioButtonMenuItem.setSelected(true);
        singlyRadioButtonMenuItem.setText("Singly LL");
        singlyRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlyRadioButtonMenuItemActionPerformed(evt);
            }
        });
        datastructureMenu.add(singlyRadioButtonMenuItem);

        doublyRadioButtonMenuItem.setSelected(true);
        doublyRadioButtonMenuItem.setText("Doubly LL");
        doublyRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doublyRadioButtonMenuItemActionPerformed(evt);
            }
        });
        datastructureMenu.add(doublyRadioButtonMenuItem);

        circularRadioButtonMenuItem.setSelected(true);
        circularRadioButtonMenuItem.setText("Circular LL");
        circularRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                circularRadioButtonMenuItemActionPerformed(evt);
            }
        });
        datastructureMenu.add(circularRadioButtonMenuItem);

        jMenuBar1.add(datastructureMenu);

        formatMenu.setText("Design");

        lookandfeelMenu.setText("Look and Feel");

        acrylMenuRadioButton.setSelected(true);
        acrylMenuRadioButton.setText("Acryl");
        acrylMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acrylMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(acrylMenuRadioButton);

        aeroMenuRadioButton.setSelected(true);
        aeroMenuRadioButton.setText("Aero");
        aeroMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aeroMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(aeroMenuRadioButton);

        aluminiumMenuRadioButton.setSelected(true);
        aluminiumMenuRadioButton.setText("Aluminium");
        aluminiumMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aluminiumMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(aluminiumMenuRadioButton);

        bernsteinMenuRadioButton.setSelected(true);
        bernsteinMenuRadioButton.setText("Bernstein");
        bernsteinMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bernsteinMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(bernsteinMenuRadioButton);

        fastMenuRadioButton.setSelected(true);
        fastMenuRadioButton.setText("Fast");
        fastMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(fastMenuRadioButton);

        graphiteMenuRadioButton.setSelected(true);
        graphiteMenuRadioButton.setText("Graphite");
        graphiteMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphiteMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(graphiteMenuRadioButton);

        hifiMenuRadioButton.setSelected(true);
        hifiMenuRadioButton.setText("Hifi");
        hifiMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hifiMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(hifiMenuRadioButton);

        lunaMenuRadioButton.setSelected(true);
        lunaMenuRadioButton.setText("Luna");
        lunaMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunaMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(lunaMenuRadioButton);

        mcwinMenuRadioButton.setSelected(true);
        mcwinMenuRadioButton.setText("McWin");
        mcwinMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcwinMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(mcwinMenuRadioButton);

        mintMenuRadioButton.setSelected(true);
        mintMenuRadioButton.setText("Mint");
        mintMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mintMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(mintMenuRadioButton);

        noireMenuRadioButton.setSelected(true);
        noireMenuRadioButton.setText("Noire");
        noireMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noireMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(noireMenuRadioButton);

        smartMenuRadioButton.setSelected(true);
        smartMenuRadioButton.setText("Smart");
        smartMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smartMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(smartMenuRadioButton);

        textureMenuRadioButton.setSelected(true);
        textureMenuRadioButton.setText("Texture");
        textureMenuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textureMenuRadioButtonActionPerformed(evt);
            }
        });
        lookandfeelMenu.add(textureMenuRadioButton);

        formatMenu.add(lookandfeelMenu);

        themeMenu.setText("Themes");

        theme1.setText("Default");
        theme1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme1ActionPerformed(evt);
            }
        });
        themeMenu.add(theme1);

        theme2.setText("Blue");
        theme2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme2ActionPerformed(evt);
            }
        });
        themeMenu.add(theme2);

        theme3.setText("Green");
        theme3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme3ActionPerformed(evt);
            }
        });
        themeMenu.add(theme3);

        theme4.setText("jMenuItem4");
        theme4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme4ActionPerformed(evt);
            }
        });
        themeMenu.add(theme4);

        theme5.setText("jMenuItem5");
        theme5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme5ActionPerformed(evt);
            }
        });
        themeMenu.add(theme5);

        theme6.setText("jMenuItem6");
        theme6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theme6ActionPerformed(evt);
            }
        });
        themeMenu.add(theme6);

        formatMenu.add(themeMenu);

        jMenuBar1.add(formatMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        creditsMenuItem.setText("Credits");
        creditsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(creditsMenuItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if(singlyRadioButton.isSelected()){
            singlyRadioButtonMenuItem.setSelected(true);
            cl.show(jPanel1,"Singly");
            j.setExtendedState( j.getExtendedState()|NewJFrame.MAXIMIZED_BOTH );
        }
        else if(doublyRadioButton.isSelected()){
            doublyRadioButtonMenuItem.setSelected(true);
            cl.show(jPanel1,"Doubly");
            j.setExtendedState( j.getExtendedState()|NewJFrame.MAXIMIZED_BOTH );
        }
        else if(circularRadioButton.isSelected()){
            circularRadioButtonMenuItem.setSelected(true);
            cl.show(jPanel1,"Circular");
            j.setExtendedState( j.getExtendedState()|NewJFrame.MAXIMIZED_BOTH );
        } else {
            JOptionPane.showMessageDialog(null,"Select any one!!!","Error",JOptionPane.OK_OPTION);
        }
        
    }//GEN-LAST:event_nextButtonActionPerformed

    private void singlyGoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyGoButtonActionPerformed
        singlyWarningLabel.setVisible(false);
        if(singlyGoButton.getText().equals("Insert") && singlyInsertComboBox.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(null,"Select one of the following","Error",JOptionPane.OK_OPTION);
            return;
        }
        if(singlyGoButton.getText().equals("Insert") || singlyGoButton.getText().equals("Search")){
            if(singlyValueTextField.getText().length()!=0){
                if(countofrect < 10 && singlyGoButton.getText().equals("Search")){
                    if(countofrect == -1){
                        singlyValueTextField.setText("");
                        JOptionPane.showMessageDialog( null, "Linked List Empty","Error",JOptionPane.OK_OPTION);
                        return;
                    }
                    searchNode();
                    return;
                }
                if(countofrect < 9 && singlyGoButton.getText().equals("Insert")){
                    countofrect++;
                    rec[countofrect].setText(singlyValueTextField.getText());
                    rec[countofrect].setHorizontalAlignment(SwingConstants.CENTER);
                    rec[countofrect].setVerticalAlignment(SwingConstants.CENTER);
                    if(countofrect < 10 && singlyGoButton.getText().equals("Insert") && operation.equals("Insert Rear")){
                        insertRear(countofrect);
                        try {
                            dout.write(singlyValueTextField.getText().getBytes());
                            dout.write("  insertRear".getBytes());
                            dout.write(13);
                            dout.write(10);
                        } catch (IOException ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if(countofrect<10 && singlyGoButton.getText().equals("Insert") && operation.equals("Insert Front")){
                        insertFront(countofrect);
                        try {
                            dout.write(singlyValueTextField.getText().getBytes());
                            dout.write("  insertFront".getBytes());
                            dout.write(13);
                            dout.write(10);
                        } catch (IOException ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if(countofrect<10 && singlyGoButton.getText().equals("Insert") && operation.equals("Insert at kth position")){
                        insertAnyPosition(countofrect);
                        try {
                            dout.write(singlyValueTextField.getText().getBytes());
                            dout.write("  insertAnyPosition".getBytes());
                            dout.write(13);
                            dout.write(10);
                        } catch (IOException ex) {
                            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } 
                } else{
                    JOptionPane.showMessageDialog(null,"Maximum Limit Reached","ERROR",JOptionPane.OK_OPTION);
                }
            } else{
                singlyWarningLabel.setVisible(true);
            }
            singlyValueTextField.setText("");
            return;
        }
        if(singlyReverseRadioButton.isSelected()){
            if(countofrect == -1){
                JOptionPane.showMessageDialog(null,"Linked List empty","Error",JOptionPane.OK_OPTION);
                return;
            }
            operation = "Reverse";
            if(countofrect == 0){
                JOptionPane.showMessageDialog(null,"Cannot reverse","Info",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            reverse();
        } else if(singlyGoButton.getText().equals("Delete") && singlyDeleteComboBox.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(null,"Select one of the following","Error",JOptionPane.OK_OPTION);
        } else if(countofrect >= 0 && singlyGoButton.getText().equals("Delete") && operation.equals("Delete Front")){
            deleteFront();
        } else if(countofrect >= 0 && singlyGoButton.getText().equals("Delete") && operation.equals("Delete Rear")){
            deleteRear();
        } else if(countofrect >= 0 && singlyGoButton.getText().equals("Delete") && operation.equals("Delete kth node")){
            delete_kth_node();
        } 
        else {
            JOptionPane.showMessageDialog( null, "Linked List Empty","Error",JOptionPane.OK_OPTION);
        } 
    }//GEN-LAST:event_singlyGoButtonActionPerformed

    private void singlySearchRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlySearchRadioButtonActionPerformed
        singlyValueLabel.setEnabled(true);
        singlyValueTextField.setEnabled(true);
        singlyWarningLabel.setVisible(false);
        singlyInsertComboBox.setVisible(false);
        singlyDeleteComboBox.setVisible(false);
        singlyGoButton.setText("Search");
        singlyGoButton.setVisible(true);
        singlyPositionComboBox.setVisible(false);
        singlyPositionLabel.setVisible(false);
    }//GEN-LAST:event_singlySearchRadioButtonActionPerformed

    private void singlyDeleteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyDeleteRadioButtonActionPerformed
        singlyDeleteComboBox.setSelectedItem("Select");
        singlyPositionComboBox.setVisible(false);
        singlyPositionLabel.setVisible(false);
        singlyValueLabel.setEnabled(false);
        singlyValueTextField.setEnabled(false);
        singlyWarningLabel.setVisible(false);
        singlyInsertComboBox.setVisible(false);
        singlyDeleteComboBox.setVisible(true);
        singlyGoButton.setVisible(true);
        if(singlyDeleteComboBox.getItemCount()==0){
            singlyDeleteComboBox.addItem("Select");
            singlyDeleteComboBox.addItem("Delete Front");
            singlyDeleteComboBox.addItem("Delete Rear");
            singlyDeleteComboBox.addItem("Delete kth node");
            singlyGoButton.setVisible(false);
        }
        singlyGoButton.setText("Delete");
        removeItemFromComboBox();
    }//GEN-LAST:event_singlyDeleteRadioButtonActionPerformed

    private void singlyInsertRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyInsertRadioButtonActionPerformed
        singlyInsertComboBox.setSelectedItem("Select");
        singlyValueLabel.setEnabled(true);
        singlyPositionComboBox.setVisible(false);
        singlyPositionLabel.setVisible(false);
        singlyValueTextField.setEnabled(true);
        singlyDeleteComboBox.setVisible(false);
        singlyInsertComboBox.setVisible(true);
        singlyGoButton.setText("Insert");
        singlyGoButton.setVisible(true);
        addItemToComboBox();
        if(singlyInsertComboBox.getItemCount()==0){
            System.out.println("HI");
            singlyInsertComboBox.addItem("Select");
            singlyInsertComboBox.addItem("Insert Front");
            singlyInsertComboBox.addItem("Insert Rear");
            singlyInsertComboBox.addItem("Insert at kth position");
            singlyGoButton.setVisible(false);
        }   
    }//GEN-LAST:event_singlyInsertRadioButtonActionPerformed

    private void singlyPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyPlayButtonActionPerformed
        if(singlycount==1){
            singlycount++;
            player = null;
            player = new CustomPlayer(this);
            player.setPath("Singly linked list.mp3");
            player.play(-1);
            singlyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/pause1.jpg")));
            singlyPlayButton.setText("Pause");
        } else if(singlyPlayButton.getText().equals("Play")){
            singlyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/pause1.jpg")));
            singlyPlayButton.setText("Pause");
            player.resume();
        } else{
            singlyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg")));
            singlyPlayButton.setText("Play");
            player.pause();
        }
    }//GEN-LAST:event_singlyPlayButtonActionPerformed

    private void singlyStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyStopButtonActionPerformed
        if(singlycount>1){
            player.stop();
            singlyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg")));
            singlyPlayButton.setText("Play");
            singlycount = 1;
        }
    }//GEN-LAST:event_singlyStopButtonActionPerformed

    private void singlyReverseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyReverseRadioButtonActionPerformed
        singlyValueLabel.setEnabled(false);
        singlyValueTextField.setEnabled(false);
        singlyPositionComboBox.setVisible(false);
        singlyPositionLabel.setVisible(false);
        singlyWarningLabel.setVisible(false);
        singlyInsertComboBox.setVisible(false);
        singlyDeleteComboBox.setVisible(false);
        singlyGoButton.setVisible(true);
        singlyGoButton.setText("Reverse");
    }//GEN-LAST:event_singlyReverseRadioButtonActionPerformed

    private void acrylMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acrylMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme2.setVisible(true);
            theme3.setVisible(true);            
            theme4.setVisible(true);
            theme1.setText("Default");
            theme2.setText("Green");
            theme3.setText("Lemmon");
            theme4.setText("Red");
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_acrylMenuRadioButtonActionPerformed

    private void aeroMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aeroMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme2.setVisible(true);
            theme3.setVisible(true);
            theme1.setText("Default");
            theme2.setText("Gold");
            theme3.setText("Green");
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_aeroMenuRadioButtonActionPerformed

    private void aluminiumMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aluminiumMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme1.setText("Default");
            theme2.setVisible(false);
            theme3.setVisible(false);
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_aluminiumMenuRadioButtonActionPerformed

    private void bernsteinMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bernsteinMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme1.setText("Default");
            theme2.setVisible(false);
            theme3.setVisible(false);
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_bernsteinMenuRadioButtonActionPerformed

    private void fastMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme2.setVisible(true);
            theme3.setVisible(true);
            theme1.setText("Default");
            theme2.setText("Blue");
            theme3.setText("Green");
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_fastMenuRadioButtonActionPerformed

    private void graphiteMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphiteMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme2.setVisible(true);
            theme3.setVisible(true);
            theme1.setText("Default");
            theme2.setText("Blue");
            theme3.setText("Green");
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_graphiteMenuRadioButtonActionPerformed

    private void hifiMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hifiMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme1.setText("Default");
            theme2.setVisible(false);
            theme3.setVisible(false);            
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_hifiMenuRadioButtonActionPerformed

    private void lunaMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunaMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme2.setVisible(true);
            theme3.setVisible(true);
            theme1.setText("Default");
            theme2.setText("Blue");
            theme3.setText("Green");
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_lunaMenuRadioButtonActionPerformed

    private void mcwinMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcwinMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme2.setVisible(true);
            theme3.setVisible(true);
            theme1.setText("Default");
            theme2.setText("Modern");
            theme3.setText("Pink");
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_mcwinMenuRadioButtonActionPerformed

    private void mintMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mintMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme1.setText("Default");
            theme2.setVisible(false);
            theme3.setVisible(false);            
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_mintMenuRadioButtonActionPerformed

    private void noireMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noireMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme1.setText("Default");
            theme2.setVisible(false);
            theme3.setVisible(false);            
            theme4.setVisible(false);
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_noireMenuRadioButtonActionPerformed

    private void smartMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smartMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme2.setVisible(true);
            theme3.setVisible(true);            
            theme4.setVisible(true);
            theme5.setVisible(true);
            theme6.setVisible(true);
            theme1.setText("Default");
            theme2.setText("Gold");
            theme3.setText("Green");
            theme4.setText("Brown");
            theme5.setText("Lemmon");
            theme6.setText("Gray");
            
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_smartMenuRadioButtonActionPerformed

    private void textureMenuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textureMenuRadioButtonActionPerformed
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            SwingUtilities.updateComponentTreeUI(j);
            theme1.setText("Default");
            theme2.setText("Rock");
            theme3.setText("Texttile");
            theme4.setText("Snow");
            theme5.setVisible(false);
            theme6.setVisible(false);
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
    }//GEN-LAST:event_textureMenuRadioButtonActionPerformed

    private void theme2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme2ActionPerformed
        String thm = theme2.getText();
        setTheme(thm);
    }//GEN-LAST:event_theme2ActionPerformed

    private void theme3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme3ActionPerformed
        String thm = theme3.getText();
        setTheme(thm);
    }//GEN-LAST:event_theme3ActionPerformed

    private void theme1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme1ActionPerformed
        String thm = theme1.getText();
        setTheme(thm);
    }//GEN-LAST:event_theme1ActionPerformed

    private void theme4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme4ActionPerformed
        String thm = theme4.getText();
        setTheme(thm);
    }//GEN-LAST:event_theme4ActionPerformed

    private void theme5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme5ActionPerformed
        String thm = theme5.getText();
        setTheme(thm);
    }//GEN-LAST:event_theme5ActionPerformed

    private void theme6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theme6ActionPerformed
        String thm = theme6.getText();
        setTheme(thm);
    }//GEN-LAST:event_theme6ActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        Credits c = new Credits();
        c.setVisible(true);
        c.setSize(500,500);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void creditsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsMenuItemActionPerformed
        
    }//GEN-LAST:event_creditsMenuItemActionPerformed

    private void doublyPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyPlayButtonActionPerformed
        if(doublycount==1){
            doublycount++;
            player = null;
            player = new CustomPlayer(this);
            player.setPath("doubly ll.mp3");
            player.play(-1);
            doublyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/pause1.jpg")));
            doublyPlayButton.setText("Pause");
        } else if(doublyPlayButton.getText().equals("Play")){
            doublyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/pause1.jpg")));
            doublyPlayButton.setText("Pause");
            player.resume();

        } else{
            doublyPlayButton.setText("Play");
            doublyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg")));
            player.pause();
        }
    }//GEN-LAST:event_doublyPlayButtonActionPerformed

    private void doublyStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyStopButtonActionPerformed
        if(doublycount>1){
            player.stop();
            doublyPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg")));
            doublyPlayButton.setText("Play");
            doublycount = 1;
        }
    }//GEN-LAST:event_doublyStopButtonActionPerformed

    private void singlyRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyRadioButtonMenuItemActionPerformed
        cl.show(jPanel1,"Singly");
        singlyRadioButton.setSelected(true);
        j.setExtendedState( j.getExtendedState()|NewJFrame.MAXIMIZED_BOTH );
    }//GEN-LAST:event_singlyRadioButtonMenuItemActionPerformed

    private void doublyRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyRadioButtonMenuItemActionPerformed
        cl.show(jPanel1,"Doubly");
        doublyRadioButton.setSelected(true);
        j.setExtendedState( j.getExtendedState()|NewJFrame.MAXIMIZED_BOTH );
    }//GEN-LAST:event_doublyRadioButtonMenuItemActionPerformed

    private void circularRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularRadioButtonMenuItemActionPerformed
        cl.show(jPanel1,"Circular");
        circularRadioButton.setSelected(true);
        j.setExtendedState( j.getExtendedState()|NewJFrame.MAXIMIZED_BOTH );
    }//GEN-LAST:event_circularRadioButtonMenuItemActionPerformed

    private void doublyInsertRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyInsertRadioButtonActionPerformed
        doublyInsertComboBox.setSelectedItem("Select");
        doublyValueLabel.setEnabled(true);
        doublyValueTextField.setEnabled(true);
        doublyDeleteComboBox.setVisible(false);
        doublyInsertComboBox.setVisible(true);
        doublyGoButton.setText("Insert");
        doublyGoButton.setVisible(true);
        addItemToComboBox();
        if(doublyInsertComboBox.getItemCount()==0){
            System.out.println("doubly HI");
            doublyInsertComboBox.addItem("Select");
            doublyInsertComboBox.addItem("Insert Front");
            doublyInsertComboBox.addItem("Insert Rear");
            doublyInsertComboBox.addItem("Insert at kth position");
            doublyGoButton.setVisible(false);
        }
        
    }//GEN-LAST:event_doublyInsertRadioButtonActionPerformed

    private void doublyDeleteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyDeleteRadioButtonActionPerformed
        doublyDeleteComboBox.setSelectedItem("Select");
        doublyValueLabel.setEnabled(false);
        doublyValueTextField.setEnabled(false);
        doublyWarningLabel.setVisible(false);
        doublyInsertComboBox.setVisible(false);
        doublyDeleteComboBox.setVisible(true);
        doublyGoButton.setVisible(true);
        if(doublyDeleteComboBox.getItemCount()==0){
            doublyDeleteComboBox.addItem("Select");
            doublyDeleteComboBox.addItem("Delete Front");
            doublyDeleteComboBox.addItem("Delete Rear");
            doublyDeleteComboBox.addItem("Delete kth node");
            doublyGoButton.setVisible(false);
        }
        doublyGoButton.setText("Delete");
        removeItemFromComboBox();
    }//GEN-LAST:event_doublyDeleteRadioButtonActionPerformed

    private void doublySearchRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublySearchRadioButtonActionPerformed
        doublyValueLabel.setEnabled(true);
        doublyValueTextField.setEnabled(true);
        doublyWarningLabel.setVisible(false);
        doublyInsertComboBox.setVisible(false);
        doublyDeleteComboBox.setVisible(false);
        doublyGoButton.setText("Search");
        doublyGoButton.setVisible(true);
        doublyPositionLabel.setVisible(false);
        doublyPositionComboBox.setVisible(false);
    }//GEN-LAST:event_doublySearchRadioButtonActionPerformed

    private void doublyReverseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyReverseRadioButtonActionPerformed
        doublyValueLabel.setEnabled(false);
        doublyValueTextField.setEnabled(false);
        doublyWarningLabel.setVisible(false);
        doublyInsertComboBox.setVisible(false);
        doublyDeleteComboBox.setVisible(false);
        doublyPositionLabel.setVisible(false);
        doublyPositionComboBox.setVisible(false);
        doublyGoButton.setVisible(true);
        doublyGoButton.setText("Reverse");
    }//GEN-LAST:event_doublyReverseRadioButtonActionPerformed

    private void doublyGoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyGoButtonActionPerformed
        doublyWarningLabel.setVisible(false);
        if(doublyGoButton.getText().equals("Insert") && doublyInsertComboBox.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(null,"Select one of the following","Error",JOptionPane.OK_OPTION);
            return;
        }
        if(doublyGoButton.getText().equals("Insert") || doublyGoButton.getText().equals("Search")){
            if(doublyValueTextField.getText().length()!=0){
                if(doublycountofrect < 10 && doublyGoButton.getText().equals("Search")){
                    if(doublycountofrect == -1){
                        doublyValueTextField.setText("");
                        JOptionPane.showMessageDialog( null, "Linked List Empty","Error",JOptionPane.OK_OPTION);
                        return;
                    }
                    doublySearchNode();
                    return;
                }
                if(doublycountofrect < 9 && doublyGoButton.getText().equals("Insert")){
                    doublycountofrect++;
                    doublyrec[doublycountofrect].setText(doublyValueTextField.getText());
                    doublyrec[doublycountofrect].setHorizontalAlignment(SwingConstants.CENTER);
                    doublyrec[doublycountofrect].setVerticalAlignment(SwingConstants.CENTER);
                    if(doublycountofrect < 10 && doublyGoButton.getText().equals("Insert") && operation.equals("Insert Rear")){
                        doublyInsertRear(doublycountofrect);
                    } else if(doublycountofrect<10 && doublyGoButton.getText().equals("Insert") && operation.equals("Insert Front")){
                        doublyInsertFront(doublycountofrect);
                    } else if(doublycountofrect<10 && doublyGoButton.getText().equals("Insert") && operation.equals("Insert at kth position")){
                        doublyInsertAnyPosition(doublycountofrect);
                    } 
                } else{
                    JOptionPane.showMessageDialog( null, "Maximum Limit Reached","Error",JOptionPane.OK_OPTION);
                }    
            } else{
                doublyWarningLabel.setVisible(true);
            }
            doublyValueTextField.setText("");
            return;
        }
        if(doublyReverseRadioButton.isSelected()){
            if(doublycountofrect == -1){
                JOptionPane.showMessageDialog(null,"Linked list empty","Error",JOptionPane.OK_OPTION);
                return;
            }
            operation = "Reverse";
            if(doublycountofrect == 0){
                JOptionPane.showMessageDialog(null,"Cannot reverse","Info",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            doublyreverse();
        } else if(doublyGoButton.getText().equals("Delete") && doublyDeleteComboBox.getSelectedItem().equals("Select")) {
            JOptionPane.showMessageDialog(null,"Select one of the following","Error",JOptionPane.OK_OPTION);
        } else if(doublycountofrect >= 0 && doublyGoButton.getText().equals("Delete") && operation.equals("Delete Front")){
            doublyDeleteFront();
        } else if(doublycountofrect >= 0 && doublyGoButton.getText().equals("Delete") && operation.equals("Delete Rear")){
            doublyDeleteRear();
        } else if(doublycountofrect >= 0 && doublyGoButton.getText().equals("Delete") && operation.equals("Delete kth node")){
            doublyDelete_kth_node();
        } 
        else {
            JOptionPane.showMessageDialog( null, "Linked List Empty","Error",JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_doublyGoButtonActionPerformed

    private void singlyQuizNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyQuizNextButtonActionPerformed
        if(singlyQuizNextButton.getText().equals("SUBMIT")){
            JOptionPane.showMessageDialog(null,"You scored "+singlyQuizMarks+"/10","Marks",JOptionPane.INFORMATION_MESSAGE);
            //singlyReattempt.setVisible(true);
            cdts.countdownTimers.stop();
            singlyCountdownLabel.setVisible(false);
            return;
        }
        if(jk == 1){
            singlyQuizNextButton.setIcon(null);
            singlyQuizNextButton.setText("Next");
            singlyCheckButton.setVisible(false);
            singlyCountdownLabel.setVisible(true);
        }
        if(jk>1){
            singlyCheckButton.doClick();
            cdts.countdownTimers.stop();
        }
        //cdt = null;
        cdts = new CountDownTimer(j);
        
        singlyQuizwrongAnsLabel.setVisible(false);
        singlyQuizQuestion1.setVisible(false);
        
        singlyQuizbg.clearSelection();
        singlyQuizRadioButton1.setVisible(true);
        singlyQuizRadioButton2.setVisible(true);
        singlyQuizRadioButton3.setVisible(true);
        singlyQuizRadioButton4.setVisible(true);
        try{
            String sql;
            sql = "Select * from Mquestion where rowid=?";
            pst=conn.prepareStatement(sql);
            pst.setInt(1,jk);
            rt=pst.executeQuery();
           if( rt.next()) {
               singlyQuizQuestion.setText(jk+":"+rt.getString("Question"));
               singlyQuizRadioButton1.setText(rt.getString("Answer1"));
               singlyQuizRadioButton2.setText(rt.getString("Answer2"));
               singlyQuizRadioButton3.setText(rt.getString("Answer3"));
               singlyQuizRadioButton4.setText(rt.getString("Answer4"));
           }
        }catch(SQLException e){}
        if(jk==10)
            singlyQuizNextButton.setText("SUBMIT");
        jk++; 
    }//GEN-LAST:event_singlyQuizNextButtonActionPerformed

    private void singlyCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyCheckButtonActionPerformed
       singlyQuizwrongAnsLabel.setVisible(false);
       String cur="",selected;
       int flag = 0;
       try {
           cur=rt.getString("CurAnswer");
       }catch (SQLException ex) {
           Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(singlyQuizRadioButton1.isSelected()){
           selected=singlyQuizRadioButton1.getText();
           if(cur.equals(selected)){
              singlyQuizMarks++;
           }
       }else if (singlyQuizRadioButton2.isSelected()){
           selected=singlyQuizRadioButton2.getText();
           if(cur.equals(selected)){
               singlyQuizMarks++;
           }
       }else if (singlyQuizRadioButton3.isSelected()){
            selected=singlyQuizRadioButton3.getText();
            if(cur.equals(selected)){
                singlyQuizMarks++;
            }
        } else if (singlyQuizRadioButton4.isSelected()){
            selected=singlyQuizRadioButton4.getText();
            if(cur.equals(selected)){
                singlyQuizMarks++;
            }
        }
    }//GEN-LAST:event_singlyCheckButtonActionPerformed

    private void doublyNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyNextButtonActionPerformed
        if(doublyNextButton.getText().equals("SUBMIT")){
            JOptionPane.showMessageDialog(null,"You scored "+doublyQuizMarks+"/10","Marks",JOptionPane.INFORMATION_MESSAGE);
            //doublyReattemptButton.setVisible(true);
            cdtd.countdownTimerd.stop();
            doublyCountdownLabel.setVisible(false);
            return;
        }
        if(ij == 1){
            doublyNextButton.setIcon(null);
            doublyNextButton.setText("Next");
            doublyCheckButton.setVisible(false);
            doublyCountdownLabel.setVisible(true);
        }
        if(ij>1){
            doublyCheckButton.doClick();
            cdtd.countdownTimerd.stop();
        }
        //cdt = null;
        cdtd = new CountDownTimer(j);
        doublyQuizWrongAnsLabel.setVisible(false);
        doublyQuizQuestion1.setVisible(false);
        
        doublyQuizbg.clearSelection();
        doublyQuizRadioButton1.setVisible(true);
        doublyQuizRadioButton2.setVisible(true);
        doublyQuizRadioButton3.setVisible(true);
        doublyQuizRadioButton4.setVisible(true);
        try{
            String sql;
            sql = "Select * from Mquestion2 where rowid=?";
            pst1=conn.prepareStatement(sql);
            pst1.setInt(1,ij);
            System.out.println(ij);
            rt1=pst1.executeQuery();
           if( rt1.next()) {
               doublyQuizQuestion.setText(ij+":"+rt1.getString("QuestionDoubly"));
               doublyQuizRadioButton1.setText(rt1.getString("Answer1Doubly"));
               doublyQuizRadioButton2.setText(rt1.getString("Answer2Doubly"));
               doublyQuizRadioButton3.setText(rt1.getString("Answer3Doubly"));
               doublyQuizRadioButton4.setText(rt1.getString("Answer4Doubly"));
           }
        }catch(SQLException e){}
        if(ij==10){
            doublyNextButton.setText("SUBMIT");
            doublyCheckButton.setVisible(false);
            return;
        }
        ij++; 
    }//GEN-LAST:event_doublyNextButtonActionPerformed

    private void doublyCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyCheckButtonActionPerformed
       doublyQuizWrongAnsLabel.setVisible(false);
       String cur="",selected;
       int flag = 0;
       try {
           cur=rt1.getString("CurAnswerDoubly");
       }catch (SQLException ex) {
           Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(doublyQuizRadioButton1.isSelected()){
           selected=doublyQuizRadioButton1.getText();
           if(cur.equals(selected)){
              doublyQuizMarks++;
           } 
       }else if (doublyQuizRadioButton2.isSelected()){
           selected=doublyQuizRadioButton2.getText();
           if(cur.equals(selected)){
               doublyQuizMarks++;
           }
       }else if (doublyQuizRadioButton3.isSelected()){
            selected=doublyQuizRadioButton3.getText();
            if(cur.equals(selected)){
                doublyQuizMarks++;
            }
        } else if (doublyQuizRadioButton4.isSelected()){
            selected=doublyQuizRadioButton4.getText();
            if(cur.equals(selected)){
                doublyQuizMarks++;
            }
        }
    }//GEN-LAST:event_doublyCheckButtonActionPerformed

    private void singlySpeedControllerSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_singlySpeedControllerSliderStateChanged
        singlyspeedofanimation = singlySpeedControllerSlider.getMaximum() - singlySpeedControllerSlider.getValue() + 1;
        System.out.println(singlyspeedofanimation);
    }//GEN-LAST:event_singlySpeedControllerSliderStateChanged

    private void singlyChangeColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyChangeColorButtonActionPerformed
        int index = 0;
        JColorChooser j = new JColorChooser();
        color2 = JColorChooser.showDialog(this,"Select Node Color", color1);
        if(color2 != null){
            singlyChangeColorButton.setBackground(color2);
            color1 = color2;
        }
        while(index < 10){
            rec[index].setBackground(color1);
            index++;
        }
    }//GEN-LAST:event_singlyChangeColorButtonActionPerformed

    private void doublyChangeColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyChangeColorButtonActionPerformed
        int index = 0;
        JColorChooser j = new JColorChooser();
        color4 = JColorChooser.showDialog(this,"Select Node Color", color1);
        if(color4 != null){
            doublyChangeColorButton.setBackground(color4);
            color3 = color4;
        }
        while(index < 10){
            doublyrec[index].setBackground(color3);
            index++;
        }
    }//GEN-LAST:event_doublyChangeColorButtonActionPerformed

    private void doublySpeedControllerSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_doublySpeedControllerSliderStateChanged
        doublyspeedofanimation = doublySpeedControllerSlider.getMaximum() - doublySpeedControllerSlider.getValue() + 1;
        System.out.println(doublyspeedofanimation);
    }//GEN-LAST:event_doublySpeedControllerSliderStateChanged

    private void singlyReattemptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlyReattemptActionPerformed
        singlyReattempt.setVisible(false);
        singlyQuizQuestion1.setText("INSTRUCTIONS: 1) There will be 10 questions and each question has four options.");
        singlyQuizQuestion.setText("2) Once you click on the next button you will not be able to reattempt the previous question");
        jk = 1;   
        singlyQuizNextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/take-our-quiz-blue-292x300.jpg")));
        singlyQuizNextButton.setText("");
        singlyQuizMarks = 0;
        singlyQuizQuestion1.setVisible(true);
        singlyQuizRadioButton1.setVisible(false);
        singlyQuizRadioButton2.setVisible(false);
        singlyQuizRadioButton3.setVisible(false);
        singlyQuizRadioButton4.setVisible(false);
        singlyQuizwrongAnsLabel.setVisible(false);
        cdts.countdownTimers.stop();
    }//GEN-LAST:event_singlyReattemptActionPerformed

    private void doublyReattemptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doublyReattemptButtonActionPerformed
        doublyReattemptButton.setVisible(false);
        doublyQuizQuestion1.setText("INSTRUCTIONS: 1) There will be 10 questions and each question has four options.");
        doublyQuizQuestion.setText("2) Once you click on the next button you will not be able to reattempt the previous question");
        ij = 1;   
        doublyNextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/take-our-quiz-blue-292x300.jpg")));
        doublyNextButton.setText("");
        doublyQuizMarks = 0;
        doublyQuizQuestion1.setVisible(true);
        doublyQuizRadioButton1.setVisible(false);
        doublyQuizRadioButton2.setVisible(false);
        doublyQuizRadioButton3.setVisible(false);
        doublyQuizRadioButton4.setVisible(false);
        doublyQuizWrongAnsLabel.setVisible(false);
        cdtd.countdownTimerd.stop();
    }//GEN-LAST:event_doublyReattemptButtonActionPerformed

    private void circularInsertRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularInsertRadioButtonActionPerformed
        circularValueLabel.setEnabled(true);
        circularValueTextField.setEnabled(true);
        circularGoButton.setText("Insert");
        circularGoButton.setVisible(true);   
    }//GEN-LAST:event_circularInsertRadioButtonActionPerformed

    private void circularDeleteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularDeleteRadioButtonActionPerformed
        circularValueLabel.setEnabled(false);
        circularValueTextField.setEnabled(false);
        circularGoButton.setText("Delete");
        circularGoButton.setVisible(true);   
    }//GEN-LAST:event_circularDeleteRadioButtonActionPerformed

    private void circularSearchRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularSearchRadioButtonActionPerformed
        circularValueLabel.setEnabled(true);
        circularValueTextField.setEnabled(true);
        circularGoButton.setText("Search");
        circularGoButton.setVisible(true);   
    }//GEN-LAST:event_circularSearchRadioButtonActionPerformed

    private void circularGoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularGoButtonActionPerformed
        doublyWarningLabel.setVisible(false);
        if(circularGoButton.getText().equals("Insert") || circularGoButton.getText().equals("Search")){
            if(circularValueTextField.getText().length()!=0){
                if(circularcountofrect < 10 && circularGoButton.getText().equals("Search")){
                    if(circularcountofrect == -1){
                        circularValueTextField.setText("");
                        JOptionPane.showMessageDialog( null, "Linked List Empty","Error",JOptionPane.OK_OPTION);
                        return;
                    }
                    circularSearchNode();
                    return;
                }
                if(circularcountofrect < 9 && circularGoButton.getText().equals("Insert")){
                    circularcountofrect++;
                    circularrec[circularcountofrect].setText(circularValueTextField.getText());
                    circularrec[circularcountofrect].setHorizontalAlignment(SwingConstants.CENTER);
                    circularrec[circularcountofrect].setVerticalAlignment(SwingConstants.CENTER);
                    circularInsertFront(circularcountofrect); 
                } else{
                    JOptionPane.showMessageDialog( null, "Maximum Limit Reached","Error",JOptionPane.OK_OPTION);
                }    
            } else{
                circularWarningLabel.setVisible(true);
            }
            circularValueTextField.setText("");
            return;
        }
        if(circularcountofrect >= 0 && circularGoButton.getText().equals("Delete")){
            circularDeleteFront();
        }
        else {
            JOptionPane.showMessageDialog( null, "Linked List Empty","Error",JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_circularGoButtonActionPerformed

    private void circularChangeColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularChangeColorButtonActionPerformed
        int index = 0;
        JColorChooser j = new JColorChooser();
        color6 = JColorChooser.showDialog(this,"Select Node Color", color1);
        if(color6 != null){
            circularChangeColorButton.setBackground(color6);
            color5 = color6;
        }
        while(index < 10){
            circularrec[index].setBackground(color5);
            index++;
        }
    }//GEN-LAST:event_circularChangeColorButtonActionPerformed

    private void circularSpeedControllerSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_circularSpeedControllerSliderStateChanged
        circularspeedofanimation = circularSpeedControllerSlider.getMaximum() - circularSpeedControllerSlider.getValue() + 1;
//        System.out.println(circularspeedofanimation);
    }//GEN-LAST:event_circularSpeedControllerSliderStateChanged

    private void circularNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularNextButtonActionPerformed
        if(circularNextButton.getText().equals("SUBMIT")){
            JOptionPane.showMessageDialog(null,"You scored "+circularQuizMarks+"/6","Marks",JOptionPane.INFORMATION_MESSAGE);
            //circularReattemptButton.setVisible(true);
            cdtc.countdownTimerc.stop();
            circularCountdownLabel.setVisible(false);
            return;
        }
        if(ki == 1){
            circularNextButton.setIcon(null);
            circularNextButton.setText("Next");
            circularCheckButton.setVisible(false);
            circularCountdownLabel.setVisible(true);
        }
        if(ki>1){
            circularCheckButton.doClick();
            cdtc.countdownTimerc.stop();
        }
        //cdt = null;
        cdtc = new CountDownTimer(j);
        circularQuizQuestion.setVisible(false);
        
        circularQuizbg.clearSelection();
        circularQuizRadioButton1.setVisible(true);
        circularQuizRadioButton2.setVisible(true);
        circularQuizRadioButton3.setVisible(true);
        circularQuizRadioButton4.setVisible(true);
        try{
            String sql;
            sql = "Select * from Mquestion3 where rowid=?";
            pst2=conn.prepareStatement(sql);
            pst2.setInt(1,ki);
            System.out.println(ki);
            rt2 = pst2.executeQuery();
            if( rt2.next()) {
               circularQuizQuestion1.setText(ki+":"+rt2.getString("Question"));
               circularQuizRadioButton1.setText(rt2.getString("Answer1"));
               circularQuizRadioButton2.setText(rt2.getString("Answer2"));
               circularQuizRadioButton3.setText(rt2.getString("Answer3"));
               circularQuizRadioButton4.setText(rt2.getString("Answer4"));
            }
        }catch(SQLException e){}
        if(ki==6){
            circularNextButton.setText("SUBMIT");
            circularCheckButton.setVisible(false);
            return;
        }
        ki++; 
    }//GEN-LAST:event_circularNextButtonActionPerformed

    private void circularPlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularPlayButtonActionPerformed
        if(circularcount==1){
            circularcount++;
            player = null;
            player = new CustomPlayer(this);
            player.setPath("circular.mp3");
            player.play(-1);
            circularPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/pause1.jpg")));
            circularPlayButton.setText("Pause");
        } else if(circularPlayButton.getText().equals("Play")){
            circularPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/pause1.jpg")));
            circularPlayButton.setText("Pause");
            player.resume();
        } else{
            circularPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg")));
            circularPlayButton.setText("Play");
            player.pause();
        }
    }//GEN-LAST:event_circularPlayButtonActionPerformed

    private void circularStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularStopButtonActionPerformed
        if(circularcount>1){
            player.stop();
            circularPlayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/play-button12.jpg")));
            circularPlayButton.setText("Play");
            circularcount = 1;
        }
    }//GEN-LAST:event_circularStopButtonActionPerformed

    private void circularCheckButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularCheckButtonActionPerformed
       String cur="",selected;
       try {
           cur=rt2.getString("CorrectAnswer");
       }catch (SQLException ex) {
           Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(circularQuizRadioButton1.isSelected()){
           selected=circularQuizRadioButton1.getText();
           if(cur.equals(selected)){
              circularQuizMarks++;
           }
       }else if (circularQuizRadioButton2.isSelected()){
           selected=circularQuizRadioButton2.getText();
           if(cur.equals(selected)){
               circularQuizMarks++;
           }
       }else if (circularQuizRadioButton3.isSelected()){
            selected=singlyQuizRadioButton3.getText();
            if(cur.equals(selected)){
                circularQuizMarks++;
            }
        } else if (circularQuizRadioButton4.isSelected()){
            selected=circularQuizRadioButton4.getText();
            if(cur.equals(selected)){
                circularQuizMarks++;
            }
        }
    }//GEN-LAST:event_circularCheckButtonActionPerformed

    private void circularReattemptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_circularReattemptButtonActionPerformed
        circularReattemptButton.setVisible(false);
        circularQuizQuestion.setText("INSTRUCTIONS: 1) There will be 10 questions and each question has four options.");
        circularQuizQuestion1.setText("2) Once you click on the next button you will not be able to reattempt the previous question");
        ki = 1;   
        circularNextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/take-our-quiz-blue-292x300.jpg")));
        circularNextButton.setText("");
        circularQuizMarks = 0;
        circularQuizQuestion.setVisible(true);
        circularQuizRadioButton1.setVisible(false);
        circularQuizRadioButton2.setVisible(false);
        circularQuizRadioButton3.setVisible(false);
        circularQuizRadioButton4.setVisible(false);
        cdtc.countdownTimerc.stop();
    }//GEN-LAST:event_circularReattemptButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        byte b[];
        String s,s1,s2;
        int x;
        while(countofrect>-1){
            rec[countofrect].setVisible(false);
            deleteFront();
            countofrect--;
        
        try{
            s = din.readLine();
            x = s.indexOf(" ");
            s1 = s.substring(0, x);
            s2 = s.substring(x+1);
            System.out.println(s1+"\t"+s2);
            singlyValueTextField.setText(s1);
            insertRear(countofrect++);
        
        }catch(Exception e){
        
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        } catch(  ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException c){}
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JRadioButtonMenuItem acrylMenuRadioButton;
    private javax.swing.JRadioButtonMenuItem aeroMenuRadioButton;
    private javax.swing.JRadioButtonMenuItem aluminiumMenuRadioButton;
    private javax.swing.JRadioButtonMenuItem bernsteinMenuRadioButton;
    private javax.swing.JPanel circularApplicationPanel;
    private java.awt.Button circularChangeColorButton;
    private javax.swing.JButton circularCheckButton;
    private javax.swing.JTextArea circularCodeSegmentTextArea;
    public javax.swing.JLabel circularCountdownLabel;
    private javax.swing.JRadioButton circularDeleteRadioButton;
    public javax.swing.JButton circularGoButton;
    private javax.swing.JLabel circularHeadingLabel;
    private javax.swing.JRadioButton circularInsertRadioButton;
    private javax.swing.JPanel circularLLPanel;
    public javax.swing.JButton circularNextButton;
    private javax.swing.JLabel circularOperationLabel;
    private javax.swing.JButton circularPlayButton;
    public javax.swing.JPanel circularPracticalPanel;
    private javax.swing.JPanel circularQuizPanel;
    private javax.swing.JLabel circularQuizQuestion;
    private javax.swing.JLabel circularQuizQuestion1;
    private javax.swing.JRadioButton circularQuizRadioButton1;
    private javax.swing.JRadioButton circularQuizRadioButton2;
    private javax.swing.JRadioButton circularQuizRadioButton3;
    private javax.swing.JRadioButton circularQuizRadioButton4;
    public javax.swing.JRadioButton circularRadioButton;
    public javax.swing.JRadioButtonMenuItem circularRadioButtonMenuItem;
    private javax.swing.JButton circularReattemptButton;
    private javax.swing.JRadioButton circularSearchRadioButton;
    private javax.swing.JLabel circularSpeedConrollerLabel;
    private javax.swing.JSlider circularSpeedControllerSlider;
    private javax.swing.JButton circularStopButton;
    private javax.swing.JPanel circularTheoryPanel;
    private javax.swing.JTextArea circularTheoryTextArea;
    private javax.swing.JLabel circularValueLabel;
    private javax.swing.JTextField circularValueTextField;
    private javax.swing.JLabel circularWarningLabel;
    private javax.swing.JMenuItem creditsMenuItem;
    private javax.swing.JMenu datastructureMenu;
    private javax.swing.JPanel doublyApplicationPanel;
    private java.awt.Button doublyChangeColorButton;
    private javax.swing.JButton doublyCheckButton;
    private javax.swing.JTextArea doublyCodeSegmentTextArea;
    public javax.swing.JLabel doublyCountdownLabel;
    private javax.swing.JComboBox doublyDeleteComboBox;
    private javax.swing.JRadioButton doublyDeleteRadioButton;
    private javax.swing.JButton doublyGoButton;
    private javax.swing.JLabel doublyHeadingLabel;
    private javax.swing.JComboBox doublyInsertComboBox;
    private javax.swing.JRadioButton doublyInsertRadioButton;
    private javax.swing.JPanel doublyLLPanel;
    public javax.swing.JButton doublyNextButton;
    private javax.swing.JLabel doublyOperationLabel;
    public javax.swing.JButton doublyPlayButton;
    public javax.swing.JComboBox doublyPositionComboBox;
    private javax.swing.JLabel doublyPositionLabel;
    public javax.swing.JPanel doublyPracticalPanel;
    private javax.swing.JPanel doublyQuizPanel;
    private javax.swing.JLabel doublyQuizQuestion;
    private javax.swing.JLabel doublyQuizQuestion1;
    private javax.swing.JRadioButton doublyQuizRadioButton1;
    private javax.swing.JRadioButton doublyQuizRadioButton2;
    private javax.swing.JRadioButton doublyQuizRadioButton3;
    private javax.swing.JRadioButton doublyQuizRadioButton4;
    private javax.swing.JLabel doublyQuizWrongAnsLabel;
    public javax.swing.JRadioButton doublyRadioButton;
    public javax.swing.JRadioButtonMenuItem doublyRadioButtonMenuItem;
    private javax.swing.JButton doublyReattemptButton;
    private javax.swing.JRadioButton doublyReverseRadioButton;
    private javax.swing.JRadioButton doublySearchRadioButton;
    private javax.swing.JSlider doublySpeedControllerSlider;
    public javax.swing.JButton doublyStopButton;
    private javax.swing.JPanel doublyTheoryPanel;
    private javax.swing.JTextArea doublyTheoryTextArea;
    private javax.swing.JLabel doublyValueLabel;
    private javax.swing.JTextField doublyValueTextField;
    private javax.swing.JLabel doublyWarningLabel;
    private javax.swing.JRadioButtonMenuItem fastMenuRadioButton;
    private javax.swing.JMenu formatMenu;
    private javax.swing.JRadioButtonMenuItem graphiteMenuRadioButton;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JRadioButtonMenuItem hifiMenuRadioButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JMenu lookandfeelMenu;
    private javax.swing.JRadioButtonMenuItem lunaMenuRadioButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButtonMenuItem mcwinMenuRadioButton;
    private javax.swing.JRadioButtonMenuItem mintMenuRadioButton;
    private javax.swing.JButton nextButton;
    private javax.swing.JRadioButtonMenuItem noireMenuRadioButton;
    private javax.swing.JPanel singlyApplicationPanel;
    private java.awt.Button singlyChangeColorButton;
    private javax.swing.JLabel singlyChangeColorLabel;
    private javax.swing.JButton singlyCheckButton;
    private javax.swing.JLabel singlyCodeSegmentLabel;
    private javax.swing.JTextArea singlyCodeSegmentTextArea;
    public javax.swing.JLabel singlyCountdownLabel;
    private javax.swing.JComboBox singlyDeleteComboBox;
    private javax.swing.JRadioButton singlyDeleteRadioButton;
    private javax.swing.JButton singlyGoButton;
    private javax.swing.JLabel singlyHeadingLabel;
    private javax.swing.JComboBox singlyInsertComboBox;
    private javax.swing.JRadioButton singlyInsertRadioButton;
    private javax.swing.JPanel singlyLLPanel;
    private javax.swing.JLabel singlyOperationLabel;
    public javax.swing.JButton singlyPlayButton;
    public javax.swing.JComboBox singlyPositionComboBox;
    private javax.swing.JLabel singlyPositionLabel;
    public javax.swing.JPanel singlyPracticalPanel;
    public javax.swing.JButton singlyQuizNextButton;
    private javax.swing.JPanel singlyQuizPanel;
    private javax.swing.JLabel singlyQuizQuestion;
    private javax.swing.JLabel singlyQuizQuestion1;
    private javax.swing.JRadioButton singlyQuizRadioButton1;
    private javax.swing.JRadioButton singlyQuizRadioButton2;
    private javax.swing.JRadioButton singlyQuizRadioButton3;
    private javax.swing.JRadioButton singlyQuizRadioButton4;
    private javax.swing.JLabel singlyQuizwrongAnsLabel;
    public javax.swing.JRadioButton singlyRadioButton;
    public javax.swing.JRadioButtonMenuItem singlyRadioButtonMenuItem;
    private javax.swing.JButton singlyReattempt;
    private javax.swing.JRadioButton singlyReverseRadioButton;
    private javax.swing.JRadioButton singlySearchRadioButton;
    private javax.swing.JLabel singlySpeedConrollerLabel;
    private javax.swing.JSlider singlySpeedControllerSlider;
    private javax.swing.JButton singlyStopButton;
    private javax.swing.JPanel singlyTheoryPanel;
    private javax.swing.JTextArea singlyTheoryTextArea;
    private javax.swing.JLabel singlyValueLabel;
    private javax.swing.JTextField singlyValueTextField;
    private javax.swing.JLabel singlyWarningLabel;
    private javax.swing.JRadioButtonMenuItem smartMenuRadioButton;
    private javax.swing.JRadioButtonMenuItem textureMenuRadioButton;
    private javax.swing.JMenuItem theme1;
    private javax.swing.JMenuItem theme2;
    private javax.swing.JMenuItem theme3;
    private javax.swing.JMenuItem theme4;
    private javax.swing.JMenuItem theme5;
    private javax.swing.JMenuItem theme6;
    private javax.swing.JMenu themeMenu;
    // End of variables declaration//GEN-END:variables

    private void createRectangle() {
        int x = 0;
        int y = 270;
        int x1 = 230;
        for(int index = 0; index < 10; index++){
            rec[index] = new JLabel();
            doublyrec[index] = new JLabel();
            circularrec[index] = new JLabel();
            arrowLabel[index] = new JLabel();
            doublyarrowLabel[index] = new JLabel();
            circulararrowLabel[index] = new JLabel();
            rec[index].setBackground(new java.awt.Color(0, 0, 255));
            rec[index].setLocation(x,y);
            rec[index].setVisible(false);
            rec[index].setSize(80,40);
            rec[index].setOpaque(true);
            rec[index].setFont(new java.awt.Font("Tahoma", 1, 14));
            singlyPracticalPanel.add(rec[index]);
            doublyrec[index].setBackground(new java.awt.Color(0, 0, 255));
            doublyrec[index].setLocation(x,y);
            doublyrec[index].setVisible(false);
            doublyrec[index].setSize(80,40);
            doublyrec[index].setOpaque(true);
            doublyrec[index].setFont(new java.awt.Font("Tahoma", 1, 14));
            doublyPracticalPanel.add(doublyrec[index]);
            circularrec[index].setBackground(new java.awt.Color(0, 0, 255));
            circularrec[index].setLocation(x,y);
            circularrec[index].setVisible(false);
            circularrec[index].setSize(80,40);
            circularrec[index].setOpaque(true);
            circularrec[index].setFont(new java.awt.Font("Tahoma", 1, 14));
            circularPracticalPanel.add(circularrec[index]);
            y -= 20;
            arrowLabel[index].setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/22312.png")));
            singlyPracticalPanel.add(arrowLabel[index]);
            arrowLabel[index].setBounds(x1, 210, 20, 20);
            arrowLabel[index].setVisible(false);
            
            doublyarrowLabel[index].setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/doubly.png")));
            doublyPracticalPanel.add(doublyarrowLabel[index]);
            doublyarrowLabel[index].setBounds(x1, 210, 20, 20);
            doublyarrowLabel[index].setVisible(false);
            
            circulararrowLabel[index].setIcon(new javax.swing.ImageIcon(getClass().getResource("/DataStructure/22312.png")));
            circularPracticalPanel.add(circulararrowLabel[index]);
            circulararrowLabel[index].setBounds(x1, 210, 20, 20);
            circulararrowLabel[index].setVisible(false);
            
            x1 += 100;
        }
    }

    private void insertRear(int countofrect) {
        list.op();
        singlyCodeSegmentTextArea.setText(" Node tmp = new Node("+list.end.getData().getText()+");\n end.setLink() = tmp;\n end = tmp;\n size++;");
        rec[countofrect].setLocation(0,270);
        rec[countofrect].setVisible(true);
        if(list.size == 1){
            x_coordinate1 = 150;
            AC.jLabelXRight(0,x_coordinate1,singlyspeedofanimation,noofpixels,rec[countofrect]);
            AC.jLabelYUp(270,200,singlyspeedofanimation,1,rec[countofrect]);
        } else{
            AC.jLabelXRight(0,x_coordinate1+100,singlyspeedofanimation,noofpixels,rec[countofrect]);
            AC.jLabelYUp(270,200,singlyspeedofanimation,1,rec[countofrect]);
            x_coordinate1 += 100;
        }
        noofpixels++;
        if(countofrect > 0){
            arrowLabel[countofrect-1].setVisible(true);
        }
        addItemToComboBox();
    }
    
    private void insertFront(int countofrect) {
        JLabel l;
        list.op();
        singlyCodeSegmentTextArea.setText(" Node tmp = new Node("+list.start.getData().getText()+");\n tmp.setLink() = start;\n start = tmp;\n size++;");
        if (list.start.getLink() == null){
            rec[countofrect].setLocation(0,270);
            rec[countofrect].setVisible(true);
            AC.jLabelXRight(0,150,singlyspeedofanimation,noofpixels,rec[countofrect]);
            AC.jLabelYUp(270,200,singlyspeedofanimation,1,rec[countofrect]);
            noofpixels++;
            return;
        }
        Node ptr;
        ptr = list.start.getLink();
        x_coordinate1 = 150;
        do{
            l = ptr.getData();
            System.out.println(l.getText()+"\t"+x_coordinate1);
            AC.jLabelXRight(x_coordinate1,x_coordinate1+100,singlyspeedofanimation,2,l);
            ptr = ptr.getLink();
            x_coordinate1 += 100;
        }while (ptr!= null);
        rec[countofrect].setLocation(0,270);
        rec[countofrect].setVisible(true);
        AC.jLabelXRight(0,150,singlyspeedofanimation,2,rec[countofrect]);
        AC.jLabelYUp(270,200,singlyspeedofanimation,1,rec[countofrect]);
        noofpixels++;
        if(countofrect > 0){
            arrowLabel[countofrect-1].setVisible(true);
        }
        addItemToComboBox();
    }

    private void insertAnyPosition(int countofrect) {
        JLabel l;
        Node ptr;
        int c = 150;
        int pos = 0;
        list.op();
        singlyCodeSegmentTextArea.setText(" Node tmp = new Node("+singlyValueTextField.getText()+" ,"+singlyPositionComboBox.getSelectedItem()+" );\n Node cur = start, prev = null;\n for( i = 0; cur != null && i <"+singlyPositionComboBox.getSelectedItem()+" ; prev = cur, cur = cur.getLink(), i++);\n if(prev==NULL){\n     start= tmp;\n     tmp.setLink(cur);\n }\n else if(cur == null) {\n     end.setLink(tmp);\n     end = tmp; }\n else {\n     prev.setLink(tmp);\n     tmp.setLink(cur);\n }\n size++;");
        singlyCodeSegmentTextArea.setCaretPosition(0);
        if(singlyPositionComboBox.getSelectedItem().equals(1)){
            if (list.start.getLink() == null){
                rec[countofrect].setLocation(0,270);
                rec[countofrect].setVisible(true);
                AC.jLabelXRight(0,150,singlyspeedofanimation,noofpixels,rec[countofrect]);
                AC.jLabelYUp(270,200,singlyspeedofanimation,1,rec[countofrect]);
                x_coordinate += 100; 
            } else{
                ptr = list.start.getLink();
                x_coordinate1 = 150;
                do{
                    l = ptr.getData();
                    System.out.println(l.getText()+"\t"+x_coordinate1);
                    AC.jLabelXRight(x_coordinate1,x_coordinate1+100,singlyspeedofanimation,2,l);
                    ptr = ptr.getLink();
                    x_coordinate1 += 100;
                }while (ptr!= null);
                rec[countofrect].setLocation(0,270);
                rec[countofrect].setVisible(true);
                AC.jLabelXRight(0,150,singlyspeedofanimation,2,rec[countofrect]);
                AC.jLabelYUp(270,200,singlyspeedofanimation,1,rec[countofrect]);
            }   
            noofpixels++;
        } else if(singlyPositionComboBox.getSelectedItem().equals(j.list.getSize())){
            ptr = list.start;
            while(ptr.getLink() != null){
                ptr = ptr.getLink();
                c += 100; 
            }
            rec[countofrect].setLocation(0,270);
            rec[countofrect].setVisible(true);
            AC.jLabelXRight(0,c,singlyspeedofanimation,Integer.parseInt(""+singlyPositionComboBox.getSelectedItem()),rec[countofrect]);
            AC.jLabelYUp(270,200,singlyspeedofanimation,1,rec[countofrect]);
            x_coordinate1 += 100;
            noofpixels++;
        } else {
            ptr = list.start;
            while(ptr.getLink() != null && pos != Integer.parseInt(""+singlyPositionComboBox.getSelectedItem())-1){
                ptr = ptr.getLink();
                c += 100; 
                pos ++;
            }
            ptr = ptr.getLink();
            x_coordinate1 = c;
            do{
                l = ptr.getData();
                System.out.println(l.getText()+"\t"+x_coordinate1);
                AC.jLabelXRight(x_coordinate1,x_coordinate1+100,singlyspeedofanimation,2,l);
                ptr = ptr.getLink();
                x_coordinate1 += 100;
            }while (ptr!= null);
            rec[countofrect].setLocation(0,270);
            rec[countofrect].setVisible(true);
            AC.jLabelXRight(0,c,singlyspeedofanimation,pos+1,rec[countofrect]);
            AC.jLabelYUp(270,200,singlyspeedofanimation,1,rec[countofrect]);
            noofpixels++;
        }
        if(countofrect > 0){
            arrowLabel[countofrect-1].setVisible(true);
        }
        addItemToComboBox();
    }

    private void deleteFront() {
        JLabel l;
        JLabel del = list.start.getData();
        int x_coordinate2;
        list.op();
        int time = (singlySpeedControllerSlider.getMaximum() - singlySpeedControllerSlider.getValue()) * 100;
        new Timer(5000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actEvt) {
                        singlyGoButton.setEnabled(true);
                    }
                }).start();
        singlyGoButton.setEnabled(false);
        singlyCodeSegmentTextArea.setText(" Node tmp = start;\n start = start.getLink();\n size--;\n delete tmp");
        Node ptr = list.start;
        x_coordinate2 = 250;
        while(ptr != null){
            l = ptr.getData();
            AC.jLabelXLeft(x_coordinate2,x_coordinate2-100,singlyspeedofanimation,1,l);
            x_coordinate2 += 100;
            ptr = ptr.getLink();
        }  
        x_coordinate1 = x_coordinate1 - 100;
        AC.jLabelYDown(200,250,singlyspeedofanimation,1,del);
        
        del.setVisible(false);
        removeItemFromComboBox();
        noofpixels--;
        if(countofrect >= 0){
            arrowLabel[countofrect].setVisible(false);
        }
        /*while(true){
            if(list.start.getData().getX() == 150){
                singlyGoButton.setEnabled(true);
                break;
            } else{
                singlyGoButton.setEnabled(false);
            }
        }*/
    }
    
    private void deleteRear() {
        JLabel del = list.end.getData();
        list.op();
        int time = (singlySpeedControllerSlider.getMaximum() - singlySpeedControllerSlider.getValue()) * 100;
        System.out.println(singlySpeedControllerSlider.getMaximum()+"\t"+singlySpeedControllerSlider.getValue()+"\t"+time);
        new Timer(time, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actEvt) {
                        singlyGoButton.setEnabled(true);
                    }
                }).start();
        singlyGoButton.setEnabled(false);
        singlyCodeSegmentTextArea.setText(" Node cur = start, prev = null;\n while (ptrcur != end){\n prev = cur;\n cur = cur.getLink();\n }\n end = ptrprev;\n end.setLink(null);\n size--;\n delete cur");
        singlyCodeSegmentTextArea.setCaretPosition(0);
        x_coordinate1 = x_coordinate1 - 100;
        AC.jLabelYDown(200,250,singlyspeedofanimation,1,del);
        del.setVisible(false);
        removeItemFromComboBox();
        noofpixels--;
        if(countofrect >= 0){
            arrowLabel[countofrect].setVisible(false);
        }
    }

    private void delete_kth_node() {
        JLabel l;
        JLabel del;
        int c;
        c = 150;
        int pos = 1;
        Node ptr = list.start;
        int time = (singlySpeedControllerSlider.getMaximum() - singlySpeedControllerSlider.getValue()) * 100;
        System.out.println(singlySpeedControllerSlider.getMaximum()+"\t"+singlySpeedControllerSlider.getValue()+"\t"+time);
        new Timer(time, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actEvt) {
                        singlyGoButton.setEnabled(true);
                    }
                }).start();
        singlyGoButton.setEnabled(false);
        while(!singlyPositionComboBox.getSelectedItem().equals(pos)){
            ptr = ptr.getLink();
            System.out.println(singlyPositionComboBox.getSelectedItem()+"\t"+pos);
            System.out.println(pos+"\t"+ptr.getData().getText());
            c += 100; 
            pos ++;
        }
        del = ptr.getData();
        ptr = ptr.getLink();
        list.op();
        singlyCodeSegmentTextArea.setText("Node ptr = start;\n" +
        " for (int i = 1; i < size - 1; i++){\n" +
        "     if (i == "+singlyPositionComboBox.getSelectedItem()+") {\n" +
        "          Node tmp = ptr.getLink();\n" +
        "          tmp = tmp.getLink();\n" +
        "          ptr.setLink(tmp);\n" +
        "          break;\n" +
        "     }\n" +
        "     ptr = ptr.getLink();\n" +
        " }\n" +
        " size-- ;");
        singlyCodeSegmentTextArea.setCaretPosition(0);
        AC.jLabelYDown(200,250,singlyspeedofanimation,1,del);
        del.setVisible(false);
        c += 100;
        while(ptr != null) {
            l = ptr.getData();
            AC.jLabelXLeft(c,c-100,singlyspeedofanimation,1,l);
            c += 100;
            ptr = ptr.getLink();
        }
        x_coordinate1 = x_coordinate1 - 100;   
        removeItemFromComboBox();
        noofpixels--;
        if(countofrect >= 0){
            arrowLabel[countofrect].setVisible(false);
        }
    }

    private void searchNode() {
        Node ptr = list.start;
        final Node searchedNode;
        int TIMER_DELAY = 3000;
        singlyCodeSegmentTextArea.setText("Node tmp = start;\nwhile(tmp != null && tmp.getData() !=" +singlyValueTextField.getText()+"){\n     tmp = tmp.getLink();\n     }if(tmp == null){\n     Node not found\n}else {\n     Node found\n}");
        singlyCodeSegmentTextArea.setCaretPosition(0);
        while(ptr != null){
            System.out.println(ptr.getData().getText()+" = "+singlyValueTextField.getText());
            if(ptr.getData().getText().equals(singlyValueTextField.getText())){
                if(!color1.equals(Color.RED)){
                    ptr.getData().setBackground(Color.red);
                } else{
                    ptr.getData().setBackground(Color.green);
                }
                searchedNode = ptr;
                new Timer(TIMER_DELAY, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actEvt) {
                        searchedNode.getData().setBackground(color1);
                    }
                }).start();
                break;
            }
            
            ptr = ptr.getLink();
        }
        if(ptr == null){
            JOptionPane.showMessageDialog(null,"Node not found","Info",JOptionPane.OK_OPTION);
        }
        singlyValueTextField.setText("");
    }
    
    
    public void addItemToComboBox(){
        if(singlyRadioButton.isSelected() || singlyRadioButtonMenuItem.isSelected()){
            int m = 1;
            singlyPositionComboBox.removeAllItems();
            while(m <= list.size+1){
                singlyPositionComboBox.addItem(m);
                m++;
            }
        }
        if(doublyRadioButton.isSelected() || doublyRadioButtonMenuItem.isSelected()){
            int m = 1;
            System.out.println("ASASs");
            doublyPositionComboBox.removeAllItems();
            while(m <= dlist.size+1){
                doublyPositionComboBox.addItem(m);
                m++;
            }
        }
        
    }
    
    public void removeItemFromComboBox(){
        if(singlyRadioButton.isSelected() || singlyRadioButtonMenuItem.isSelected()){
            int m = 1;
            singlyPositionComboBox.removeAllItems();
            while(m <= list.size){
                singlyPositionComboBox.addItem(m);
                m++;
            }
        } else if(doublyRadioButton.isSelected() || doublyRadioButtonMenuItem.isSelected()){
            int m = 1;
            doublyPositionComboBox.removeAllItems();
            while(m <= dlist.size){
                doublyPositionComboBox.addItem(m);
                m++;
            }
        }
    }

    public boolean reverse() {
        Node ptr = list.start;
        int time = (singlySpeedControllerSlider.getMaximum() - singlySpeedControllerSlider.getValue()) * 100;
        System.out.println(singlySpeedControllerSlider.getMaximum()+"\t"+singlySpeedControllerSlider.getValue()+"\t"+time);
        new Timer(time, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actEvt) {
                        singlyGoButton.setEnabled(true);
                    }
                }).start();
        singlyGoButton.setEnabled(false);
        singlyCodeSegmentTextArea.setText("Node ptrcur = j.list.start;\n" +
        "Node ptrprev = null;\n" +
        "Node ptrnext = ptrcur.getLink();\n" +
        "\n" +
        "while(ptrcur != null){\n" +
        "     ptrcur.setLink(ptrprev);\n" +
        "     ptrprev = ptrcur;\n" +
        "     ptrcur = ptrnext;\n" +
        "     if(ptrnext != null){\n" +
        "          ptrnext = ptrnext.getLink();\n" +
        "     }\n" +
        "}");
        singlyCodeSegmentTextArea.setCaretPosition(0);
        if(ptr == null){
            return false;
        }
        int x=150,x1=x_coordinate1;
        synchronized(this){
            while(ptr != null){
                AC.jLabelXLeft(x,x1,singlyspeedofanimation,1,ptr.getData()); 
                x +=100;
                x1 -=100;
                ptr = ptr.getLink();
            }
        }
        j.list.op();
        return true;
    }
    
    public String setTheme(String thm){
        String theme = "";
        if(acrylMenuRadioButton.isSelected()){
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.acryl.AcrylLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(aeroMenuRadioButton.isSelected()){
            com.jtattoo.plaf.aero.AeroLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.aero.AeroLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(aluminiumMenuRadioButton.isSelected()){
            com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(bernsteinMenuRadioButton.isSelected()){
            com.jtattoo.plaf.bernstein.BernsteinLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.bernstein.BernsteinLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(fastMenuRadioButton.isSelected()){
            com.jtattoo.plaf.fast.FastLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.fast.FastLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(graphiteMenuRadioButton.isSelected()){
            com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.graphite.GraphiteLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(hifiMenuRadioButton.isSelected()){
            com.jtattoo.plaf.hifi.HiFiLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.hifi.HiFiLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(lunaMenuRadioButton.isSelected()){
            com.jtattoo.plaf.luna.LunaLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.luna.LunaLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(mcwinMenuRadioButton.isSelected()){
            com.jtattoo.plaf.mcwin.McWinLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.mcwin.McWinLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(mintMenuRadioButton.isSelected()){
            com.jtattoo.plaf.mint.MintLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.mint.MintLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(noireMenuRadioButton.isSelected()){
            com.jtattoo.plaf.noire.NoireLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.noire.NoireLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(smartMenuRadioButton.isSelected()){
            com.jtattoo.plaf.smart.SmartLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.smart.SmartLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        } else if(textureMenuRadioButton.isSelected()){
            com.jtattoo.plaf.texture.TextureLookAndFeel.setTheme(thm);
            theme = com.jtattoo.plaf.texture.TextureLookAndFeel.getTheme().getName();
            SwingUtilities.updateComponentTreeUI(j);
        }
        return theme;
    }

    private void doublyInsertRear(int doublycountofrect) {
        dlist.doublyop();
        doublyrec[doublycountofrect].setLocation(0,270);
        doublyrec[doublycountofrect].setVisible(true);
        doublyCodeSegmentTextArea.setText(" Node tmp = new Node("+dlist.end.getData().getText()+");\n end.setNextLink() = tmp;\n tmp.setPrevLink(end);\nend = tmp;\n size++;");
        doublyCodeSegmentTextArea.setCaretPosition(0);
        if(dlist.size == 1){
            d_x_coordinate1 = 150;
            AC.jLabelXRight(0,d_x_coordinate1,doublyspeedofanimation,doublynoofpixels,doublyrec[doublycountofrect]);
            AC.jLabelYUp(270,200,doublyspeedofanimation,1,doublyrec[doublycountofrect]);
        } else{
            AC.jLabelXRight(0,d_x_coordinate1+100,doublyspeedofanimation,doublynoofpixels,doublyrec[doublycountofrect]);
            AC.jLabelYUp(270,200,doublyspeedofanimation,1,doublyrec[doublycountofrect]);
            d_x_coordinate1 += 100;
        }
        doublynoofpixels++;
        if(doublycountofrect > 0){
            doublyarrowLabel[doublycountofrect-1].setVisible(true);
        }
        addItemToComboBox();
    }
    
    private void doublyInsertFront(int doublycountofrect) {
        JLabel l;
        dlist.doublyop();
        doublyCodeSegmentTextArea.setText(" Node tmp = new Node("+dlist.start.getData().getText()+");\n tmp.setNextLink(start);\n start.setPrevLink(tmp);\n start = tmp;\n size++;");
        doublyCodeSegmentTextArea.setCaretPosition(0);
        if (dlist.start.getLink() == null){
            doublyrec[doublycountofrect].setLocation(0,270);
            doublyrec[doublycountofrect].setVisible(true);
            AC.jLabelXRight(0,150,doublyspeedofanimation,doublynoofpixels,doublyrec[doublycountofrect]);
            AC.jLabelYUp(270,200,doublyspeedofanimation,1,doublyrec[doublycountofrect]);
            doublynoofpixels++;
            return;
        }
        Node ptr;
        ptr = dlist.start.getLink();
        d_x_coordinate1 = 150;
        do{
            l = ptr.getData();
            System.out.println(l.getText()+"\t"+d_x_coordinate1);
            AC.jLabelXRight(d_x_coordinate1,d_x_coordinate1+100,doublyspeedofanimation,2,l);
            ptr = ptr.getLink();
            d_x_coordinate1 += 100;
        }while (ptr!= null);
        doublyrec[doublycountofrect].setLocation(0,270);
        doublyrec[doublycountofrect].setVisible(true);
        AC.jLabelXRight(0,150,doublyspeedofanimation,2,doublyrec[doublycountofrect]);
        AC.jLabelYUp(270,200,doublyspeedofanimation,1,doublyrec[doublycountofrect]);
        doublynoofpixels++;
        if(doublycountofrect > 0){
            doublyarrowLabel[doublycountofrect-1].setVisible(true);
        }
        addItemToComboBox();
    }

    private void doublyInsertAnyPosition(int doublycountofrect) {
        JLabel l;
        Node ptr;
        int c = 150;
        int pos = 0;
        dlist.doublyop();
        doublyCodeSegmentTextArea.setText(" Node tmp = new Node("+dlist.start.getData().getText()+","+doublyPositionComboBox.getSelectedItem()+");\n Node cur = start;\n for( i = 0; cur != null && i <"+doublyPositionComboBox.getSelectedItem()+" ; cur = cur.getNextLink(), i++);\n if(cur.PrevLink()==NULL){\n     start.setPrevLink() = tmp;\n     tmp.setLink(cur);\n     start = tmp; }\n else if(cur == null) {\n     end.setNextLink(tmp);\n     tmp.setPrevLink(end);\n     end = tmp;\n }\n else {\n     tmp.setPrevLink(cur.getPrevLink());\n     tmp.setNextLink(cur.getNextLink());\n     cur.getPrevLink().setNextLink(tmp);\n     cur.getNextLink().setPrevLink(tmp);\n }\n size++;");
        doublyCodeSegmentTextArea.setCaretPosition(0);
        if(doublyPositionComboBox.getSelectedItem().equals(1)){
            if (dlist.start.getLink() == null){
                doublyrec[doublycountofrect].setLocation(0,270);
                doublyrec[doublycountofrect].setVisible(true);
                AC.jLabelXRight(0,150,doublyspeedofanimation,doublynoofpixels,doublyrec[doublycountofrect]);
                AC.jLabelYUp(270,200,doublyspeedofanimation,1,doublyrec[doublycountofrect]);
                d_x_coordinate1 += 100; 
            } else{
                ptr = dlist.start.getLink();
                d_x_coordinate1 = 150;
                do{
                    l = ptr.getData();
                    System.out.println(l.getText()+"\t"+d_x_coordinate1);
                    AC.jLabelXRight(d_x_coordinate1,d_x_coordinate1+100,doublyspeedofanimation,2,l);
                    ptr = ptr.getLink();
                    d_x_coordinate1 += 100;
                }while (ptr!= null);
                doublyrec[doublycountofrect].setLocation(0,270);
                doublyrec[doublycountofrect].setVisible(true);
                AC.jLabelXRight(0,150,doublyspeedofanimation,2,doublyrec[doublycountofrect]);
                AC.jLabelYUp(270,200,doublyspeedofanimation,1,doublyrec[doublycountofrect]);
            }   
            doublynoofpixels++;
        } else if(doublyPositionComboBox.getSelectedItem().equals(j.dlist.getSize())){
            ptr = dlist.start;
            while(ptr.getLink() != null){
                ptr = ptr.getLink();
                c += 100; 
            }
            doublyrec[doublycountofrect].setLocation(0,270);
            doublyrec[doublycountofrect].setVisible(true);
            AC.jLabelXRight(0,c,doublyspeedofanimation,Integer.parseInt(""+doublyPositionComboBox.getSelectedItem()),doublyrec[doublycountofrect]);
            AC.jLabelYUp(270,200,doublyspeedofanimation,1,doublyrec[doublycountofrect]);
            d_x_coordinate1 += 100;
            doublynoofpixels++;
        } else {
            ptr = dlist.start;
            while(ptr.getLink() != null && pos != Integer.parseInt(""+doublyPositionComboBox.getSelectedItem())-1){
                ptr = ptr.getLink();
                c += 100; 
                pos ++;
            }
            ptr = ptr.getLink();
            d_x_coordinate1 = c;
            do{
                l = ptr.getData();
                System.out.println(l.getText()+"\t"+d_x_coordinate1);
                AC.jLabelXRight(d_x_coordinate1,d_x_coordinate1+100,doublyspeedofanimation,2,l);
                ptr = ptr.getLink();
                d_x_coordinate1 += 100;
            }while (ptr!= null);
            doublyrec[doublycountofrect].setLocation(0,270);
            doublyrec[doublycountofrect].setVisible(true);
            AC.jLabelXRight(0,c,doublyspeedofanimation,pos+1,doublyrec[doublycountofrect]);
            AC.jLabelYUp(270,200,doublyspeedofanimation,1,doublyrec[doublycountofrect]);
            doublynoofpixels++;
        }
        if(doublycountofrect > 0){
            doublyarrowLabel[doublycountofrect-1].setVisible(true);
        }
        addItemToComboBox();
    }
        

    private void doublySearchNode() {
        Node ptr = dlist.start;
        final Node searchedNode;
        int TIMER_DELAY = 1000;
        doublyCodeSegmentTextArea.setText("Node tmp = start;\nwhile(tmp != null && tmp.getData() !=" +doublyValueTextField.getText()+"){\n     tmp = tmp.getLink();\n     }if(tmp == null){\n     Node not found\n}else {\n     Node found\n}");
        doublyCodeSegmentTextArea.setCaretPosition(0);
        while(ptr != null){
            System.out.println(ptr.getData().getText()+" = "+doublyValueTextField.getText());
            if(ptr.getData().getText().equals(doublyValueTextField.getText())){
                if(!color1.equals(Color.RED)){
                    ptr.getData().setBackground(Color.red);
                } else{
                    ptr.getData().setBackground(Color.green);
                }
                searchedNode = ptr;
                new Timer(TIMER_DELAY, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actEvt) {
                        searchedNode.getData().setBackground(Color.blue);
                    }
                }).start();
                break;
            }
            ptr = ptr.getLink();
        }
        if(ptr == null){
            JOptionPane.showMessageDialog(null,"Node not found","Info",JOptionPane.OK_OPTION);
        }
        doublyValueTextField.setText("");
    }

    private void doublyDeleteFront() {
        JLabel l;
        JLabel del = dlist.start.getData();
        int x_coordinate2;
        dlist.doublyop();
        doublyCodeSegmentTextArea.setText(" Node cur = start;\n if(cur = NULL)\n     List is empty\n else {\n     start = start.getNextLink();\n     if(start!=NULL){\n          start.PrevLink()=NULL;\n          Delete Node\n          start = cur;\n     }\n size--;\n}");
        doublyCodeSegmentTextArea.setCaretPosition(0);
        Node ptr = dlist.start;
        x_coordinate2 = 250;
        while(ptr != null){
            l = ptr.getData();
            AC.jLabelXLeft(x_coordinate2,x_coordinate2-100,doublyspeedofanimation,1,l);
            x_coordinate2 += 100;
            ptr = ptr.getLink();
        }  
        d_x_coordinate1 = d_x_coordinate1 - 100;
        AC.jLabelYDown(200,250,doublyspeedofanimation,1,del);
        del.setVisible(false);
        removeItemFromComboBox();
        doublynoofpixels--;
        if(doublycountofrect >= 0){
            doublyarrowLabel[doublycountofrect].setVisible(false);
        }
//        while(true){
//            if(dlist.start.getData().getX() == 150){
//                doublyGoButton.setEnabled(true);
//                break;
//            } else{
//                doublyGoButton.setEnabled(false);
//            } 
//                
//        }
    }

    private void doublyDeleteRear() {
        JLabel del = dlist.end.getData();
        dlist.doublyop();
        d_x_coordinate1 = d_x_coordinate1 - 100;
        doublyCodeSegmentTextArea.setText(" Node cur = end;\n if(end = NULL)\n     List is empty\n else {\n     end = end.getPrevLink();\n     if(end!=NULL){\n          end.NextLink()=NULL;\n          Delete Node\n               }\n size--;\n}");
        doublyCodeSegmentTextArea.setCaretPosition(0);
        AC.jLabelYDown(200,250,doublyspeedofanimation,1,del);
        del.setVisible(false);
        removeItemFromComboBox();
        doublynoofpixels--;
        if(doublycountofrect >= 0){
            doublyarrowLabel[doublycountofrect].setVisible(false);
        }
    }

    private void doublyDelete_kth_node() {
        JLabel l;
        JLabel del;
        int c;
        c = 150;
        int pos = 1;
        Node ptr = dlist.start;
        doublyCodeSegmentTextArea.setText(" Node tmp = getNode("+doublyPositionComboBox.getSelectedItem()+");\n Node prev = tmp.getPrevLink();\n Node next = tmp.getNextLink();\n prev.setNextLink(next);\n next.setPrevLink(prev); Delete tmp node\n size--;");
        doublyCodeSegmentTextArea.setCaretPosition(0);
        while(!doublyPositionComboBox.getSelectedItem().equals(pos)){
            ptr = ptr.getLink();
            System.out.println(doublyPositionComboBox.getSelectedItem()+"\t"+pos);
            System.out.println(pos+"\t"+ptr.getData().getText());
            c += 100; 
            pos ++;
        }
        del = ptr.getData();
        ptr = ptr.getLink();
        dlist.doublyop();
        AC.jLabelYDown(200,250,doublyspeedofanimation,1,del);
        del.setVisible(false);
        c += 100;
        while(ptr != null) {
            l = ptr.getData();
            AC.jLabelXLeft(c,c-100,doublyspeedofanimation,1,l);
            c += 100;
            ptr = ptr.getLink();
        }
        d_x_coordinate1 = d_x_coordinate1 - 100;   
        removeItemFromComboBox();
        doublynoofpixels--;
        if(doublycountofrect >= 0){
            doublyarrowLabel[doublycountofrect].setVisible(false);
        }
    }

    public boolean doublyreverse() {
        Node ptr = dlist.start;
        if(ptr == null){
            return false;
        }
        else if(ptr.getLink() == null){
            return false;
        }
        int x=150,x1=d_x_coordinate1;
        synchronized(this){
            while(ptr != null){
                AC.jLabelXLeft(x,x1,doublyspeedofanimation,1,ptr.getData()); 
                x +=100;
                x1 -=100;
                ptr = ptr.getLink();
            }
        }
        doublyCodeSegmentTextArea.setText("Node temp = NULL;  \n" +
        "Node current = *head_ref;\n" +
        "\n" +
        "while (current !=  NULL)\n" +
        "{\n" +
        "    temp = current.getPrevLink();\n" +
        "    current.getPrevLink() = current.getNextLink();\n" +
        "    current.getNextLink() = temp;\n" +
        "    current = current.getPrevLink();\n" +
        "}\n" +
        "\n" +
        "if(temp != NULL )\n" +
        "    start = temp.getPrevLink();");
        doublyCodeSegmentTextArea.setCaretPosition(0);
        dlist.doublyop();
        return true;
    }

    private void circularSearchNode() {
        Node ptr = clist.start;
        final Node searchedNode;
        int TIMER_DELAY = 3000;
        circularCodeSegmentTextArea.setText("Node tmp = start;\n"+
                "do {\n"+
                "   if(tmp.getData() !=" +circularValueTextField.getText()+")\n"+
                "       tmp = tmp.getLink();\n"+
                "   else{\n"+
                "       Node found\n"+
                "       return;\n"+
                "   }\n"+
                "}while(tmp != start);\n"
                + "Node not found\n");
        circularCodeSegmentTextArea.setCaretPosition(0);
        while(ptr != null){
            System.out.println(ptr.getData().getText()+" = "+circularValueTextField.getText());
            if(ptr.getData().getText().equals(circularValueTextField.getText())){
                if(!color5.equals(Color.RED)){
                    ptr.getData().setBackground(Color.red);
                } else{
                    ptr.getData().setBackground(Color.green);
                }
                searchedNode = ptr;
                new Timer(TIMER_DELAY, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actEvt) {
                        searchedNode.getData().setBackground(color5);
                    }
                }).start();
                break;
            }
            ptr = ptr.getLink();
        }
        if(ptr == null){
            JOptionPane.showMessageDialog(null,"Node not found","Info",JOptionPane.OK_OPTION);
        }
        circularValueTextField.setText("");
    }

    private void circularInsertFront(int circularcountofrect) {
        JLabel l;
        clist.circularop();
        circularCodeSegmentTextArea.setText(" Node tmp = new Node("+clist.start.getData().getText()+");\n "
                + "if(end == NULL){\n"
                + "     end = tmp.setLink() = tmp;\n"
                + "}else{\n"
                + "     tmp.setLink(end.getLink());\n"
                + "     end.setLink(tmp);\n "
                + "}\n"
                + "size++;");
        circularCodeSegmentTextArea.setCaretPosition(0);
        if (clist.start.getLink() == null){
            circularrec[circularcountofrect].setLocation(0,270);
            circularrec[circularcountofrect].setVisible(true);
            AC.jLabelXRight(0,150,circularspeedofanimation,circularnoofpixels,circularrec[circularcountofrect]);
            AC.jLabelYUp(270,200,circularspeedofanimation,1,circularrec[circularcountofrect]);
            circularnoofpixels++;
            return;
        }
        Node ptr;
        ptr = clist.start.getLink();
        c_x_coordinate1 = 150;
        do{
            l = ptr.getData();
            System.out.println(l.getText()+"\t"+x_coordinate1);
            AC.jLabelXRight(c_x_coordinate1,c_x_coordinate1+100,circularspeedofanimation,2,l);
            ptr = ptr.getLink();
            c_x_coordinate1 += 100;
        }while (ptr!= null);
        circularrec[circularcountofrect].setLocation(0,270);
        circularrec[circularcountofrect].setVisible(true);
        AC.jLabelXRight(0,150,circularspeedofanimation,2,circularrec[circularcountofrect]);
        AC.jLabelYUp(270,200,circularspeedofanimation,1,circularrec[circularcountofrect]);
        circularnoofpixels++;
        if(circularcountofrect > 0){
            circulararrowLabel[circularcountofrect-1].setVisible(true);
        }
    }

    private void circularDeleteFront() {
        JLabel l;
        JLabel del = clist.start.getData();
        int x_coordinate2;
        clist.circularop();
        circularCodeSegmentTextArea.setText("start = start.getLink();\n"
                + "end.setLink(start);\n "
                + "size--;");
        circularCodeSegmentTextArea.setCaretPosition(0);
        Node ptr = clist.start;
        x_coordinate2 = 250;
        while(ptr != null){
            l = ptr.getData();
            AC.jLabelXLeft(x_coordinate2,x_coordinate2-100,circularspeedofanimation,1,l);
            x_coordinate2 += 100;
            ptr = ptr.getLink();
        }  
        c_x_coordinate1 = c_x_coordinate1 - 100;
        AC.jLabelYDown(200,250,circularspeedofanimation,1,del);
        del.setVisible(false);
        removeItemFromComboBox();
        circularnoofpixels--;
        if(circularcountofrect >= 0){
            circulararrowLabel[circularcountofrect].setVisible(false);
        }
    }
}