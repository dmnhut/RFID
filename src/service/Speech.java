/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Android Studio
 */
public class Speech {

    public void TextToSpeech() {
        try {
            FileInputStream inputStream = new FileInputStream("C:\\RFID\\sound\\audio.mp3");
            Player player = new Player(inputStream);
            player.play();
        } catch (FileNotFoundException | JavaLayerException e) {
            System.out.println("Error Speech file " + e.getMessage());
        }
    }
}
