/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructure;

import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vijay
 */
public class SearchTest {
    
    @Test
    public void test(){
        CustomLinkedList l = new CustomLinkedList(4);
        boolean expected = true;
        boolean actual = l.searchTest(new JLabel(""+41));
        assertEquals(expected,actual);
    }
}
