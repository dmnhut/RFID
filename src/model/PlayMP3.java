/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author langduong
 */
public class PlayMP3 {
    public static boolean Mp3(String pathName){
        try {
            Player player=new Player(new FileInputStream(pathName));
            player.play();
            return true;
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(PlayMP3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JavaLayerException ex) {
            //Logger.getLogger(PlayMP3.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
