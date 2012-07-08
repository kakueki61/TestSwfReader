package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import model.StructFrameRate;
import model.StructRect;
import utils.AnalyzeStruct;
import utils.ReadBytes;

public class HeaderLoader {

    /**
     * @param args SWF file name
     */
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            System.out.println(args[0]);
            
            load(fis);
            
            //experiment();
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void load(FileInputStream fis) {
        try {
            for(int i = 0; i < 4; i++) {
                System.out.println(i + 1 + "th: " + fis.read());
            }
            System.out.println("FileLength: " + ReadBytes.readUI32(fis));
            
            System.out.println("");
            
            //analysis of RECT
            StructRect structRect = AnalyzeStruct.getRect(fis);
            System.out.println("xMin: " + structRect.getxMin());
            System.out.println("xMax: " + structRect.getxMax());
            System.out.println("yMin: " + structRect.getyMin());
            System.out.println("yMax: " + structRect.getyMax());
            
            //FrameRate
            StructFrameRate structFrameRate = AnalyzeStruct.getFrameRate(fis);
            System.out.println("FrameRate: " + structFrameRate.getIntegerPotion() + "." + structFrameRate.getFractionalPotion());
            
            //FrameCount
            int frameCount = ReadBytes.readUI16(fis);
            System.out.println("FrameCount: " + frameCount);
            
            fis.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void experiment() {
        byte byteValue = (byte)0xFF;
        int intValue = byteValue;
        System.out.println(String.format("byte型 byteValue (16進数表示)：%x", byteValue));
        System.out.println(String.format("byte型 byteValue (10進数表示)：%d", byteValue));
        System.out.println(String.format("int型 intValue (16進数表示)：%x", intValue));
        System.out.println(String.format("int型 intValue (10進数表示)：%d", intValue));
    }
}
