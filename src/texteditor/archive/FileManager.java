/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor.archive;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author João Hudson
 */
public class FileManager {
    
    private static JFileChooser fileCh = new JFileChooser();
    
    public static void saveText(String text, JFrame frame)
    {
        String diretory;
        
        fileCh.showSaveDialog(frame);
        diretory = fileCh.getSelectedFile().getPath();
        
        try
        {
            FileWriter writer = new FileWriter(diretory);
            PrintWriter print = new PrintWriter(writer);
            print.print(text);
            print.flush();
            writer.flush();
            print.close();
            writer.close();
        }
        catch(Exception e)
        {
            showErrorMessage(frame);
        }
    }
    
    public static String openText(JFrame frame)
    {
        String text = "";
        File file;
        
        fileCh.showOpenDialog(frame);
        file = fileCh.getSelectedFile();
        
        if(file == null)
        {
            return null;
        }
        
        try
        {
            FileReader reader = new FileReader(file.getPath());
            Scanner scan = new Scanner(reader);
            
            while(scan.hasNextLine())
            {
                text += scan.nextLine() + "\n";
            }
            
            return text;
        }
        catch(Exception e)
        {
            showErrorMessage(frame);
            
            return null;
        }
    }
    
    private static void showErrorMessage(JFrame frame)
    {
        JOptionPane.showMessageDialog(frame, "Erro de arquivo!", "Erro",
                               JOptionPane.ERROR_MESSAGE);
    }
}
