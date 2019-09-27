/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructure;

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
public class NewJFrameTest {
    

    /**
     * Test of setTheme method, of class NewJFrame.
     */
    @Test
    public void testSetTheme() {
        System.out.println("setTheme");
        String thm = "Blue";
        NewJFrame instance = new NewJFrame();
        assertEquals(thm,instance.setTheme(thm));
    }
    
    @Test
    public void testReverse() {
        System.out.println("Singly Reverse");
        boolean expected = false;
        NewJFrame instance = new NewJFrame();
        assertEquals(expected,instance.reverse());
    }
    
    @Test
    public void testDoublyReverse() {
        System.out.println("Doubly Reverse");
        boolean expected = false;
        NewJFrame instance = new NewJFrame();
        assertEquals(expected,instance.doublyreverse());
    }
}
