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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class CountDownTimer {
   JLabel label;
   Timer countdownTimers;
   Timer countdownTimerd;
   Timer countdownTimerc;
   
   int timeRemaining = 30;
   NewJFrame j;

   public CountDownTimer(NewJFrame j) {
        this.j = j;
        if(j.singlyRadioButton.isSelected() || j.singlyRadioButtonMenuItem.isSelected()){
            label = j.singlyCountdownLabel;
            
            countdownTimers = new Timer(1000, new CountdownTimerListener());
            countdownTimers.start();
        } 
        if(j.doublyRadioButton.isSelected() || j.doublyRadioButtonMenuItem.isSelected()){
            label = j.doublyCountdownLabel;
            
            countdownTimerd = new Timer(1000, new CountdownTimerListener());
            countdownTimerd.start();
        }
        if(j.circularRadioButton.isSelected() || j.circularRadioButtonMenuItem.isSelected()){
            label = j.circularCountdownLabel;
            
            countdownTimerc = new Timer(1000, new CountdownTimerListener());
            countdownTimerc.start();
        }
        label.setText("Time Remaining :"+String.valueOf(timeRemaining));
    }

    class CountdownTimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (--timeRemaining > 0) {
                label.setText("Time Remaining :"+String.valueOf(timeRemaining));
                return;
            } 
            if(j.singlyRadioButton.isSelected() || j.singlyRadioButtonMenuItem.isSelected()){
                countdownTimers.stop();
                label.setText("Time's up!");
                j.singlyQuizNextButton.doClick();
            } 
            if(j.doublyRadioButton.isSelected() || j.doublyRadioButtonMenuItem.isSelected()){
                countdownTimerd.stop();
                label.setText("Time's up!");
                j.doublyNextButton.doClick();
            } 
            if(j.circularRadioButton.isSelected() || j.circularRadioButtonMenuItem.isSelected()){
                countdownTimerc.stop();
                label.setText("Time's up!");
                j.circularNextButton.doClick();
            }
        }
    }
}
