/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataStructure;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.swing.JOptionPane;
import javazoom.jl.player.Player;

/**
 *
 * @author Vijay
 */
public class CustomPlayer {
    private Player player;
    private FileInputStream FIS;
    private BufferedInputStream BIS;
    private boolean canResume;
    private String path;
    private int total;
    private int stopped;
    private boolean valid;
    public NewJFrame j;

    public CustomPlayer(NewJFrame j){
        player = null;
        FIS = null;
        valid = false;
        BIS = null;
        path = null;
        total = 0;
        stopped = 0;
        canResume = false;
        this.j=j;
    }

    

    public boolean canResume(){
        return canResume;
    }

    public void setPath(String path){
        this.path = path;
    }

    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch"})
    public void pause(){
        try{
            stopped = FIS.available();
            player.close();
            FIS = null;
            BIS = null;
            player = null;
            if(valid) canResume = true;
        }catch(Exception e){
        }
    }

    public void resume(){
        if(!canResume) return;
        if(play(total-stopped))
            canResume = false;
    }
    
    public void stop(){
        try{
            player.close();
        }catch(Exception e){}
    }

    @SuppressWarnings({"UseSpecificCatch", "BroadCatchBlock", "TooBroadCatch"})
    public boolean play(int pos){
        valid = true;
        canResume = false;
        try{
            FIS = new FileInputStream(path);
            total = FIS.available();
            if(pos > -1) 
                FIS.skip(pos);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            new Thread(
                new Runnable(){
                @Override
                @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch"})
                public void run(){
                    try{
                        player.play();
                        if(player.isComplete()){
                            if(j.singlyRadioButtonMenuItem.isSelected()){
                                j.singlyPlayButton.setText("Play");
                                NewJFrame.singlycount=1;
                            } else if(j.doublyRadioButtonMenuItem.isSelected()){
                                j.doublyPlayButton.setText("Play");
                                NewJFrame.doublycount=1;
                            } else if(j.circularRadioButtonMenuItem.isSelected()){
                                //j.circularPlayButton.setText("Play");
                                NewJFrame.circularcount=1;
                            }
                            player.close();
                        }
                    }catch(Exception e){
                        //JOptionPane.showMessageDialog(null, "Error playing mp3 file");
                        valid = false;
                    }
                }
            }).start();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            valid = false;
        }
        return valid;
    }
}
