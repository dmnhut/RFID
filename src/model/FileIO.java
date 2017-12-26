/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author langduong
 */
public class FileIO {

    public static String readPathNameSQL() {
        String pathName = "";
        File file = new File("C:\\RFID\\pathNameSQL");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line="";
            while ((line=br.readLine())!= null) {
                pathName=line;
                //System.out.println(pathName);
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException ex) {
            //  Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pathName;
    }
}
