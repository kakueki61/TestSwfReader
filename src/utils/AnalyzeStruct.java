package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import model.StructFrameRate;
import model.StructRect;

public class AnalyzeStruct {
    private static final String TAG = AnalyzeStruct.class.getSimpleName();
    
    public static StructRect getRect(FileInputStream fis) throws IOException {
        ReadBits.completeReadBits();
        
        StructRect rect = new StructRect();
        
        int nBits = ReadBits.readUB(fis, 5);
        rect.setnBits(nBits);
        
        int xMin = ReadBits.readSB(fis, nBits);
        rect.setxMin(xMin);
        
        int xMax = ReadBits.readSB(fis, nBits);
        rect.setxMax(xMax);
        
        int yMin = ReadBits.readSB(fis, nBits);
        rect.setyMin(yMin);
        
        int yMax = ReadBits.readSB(fis, nBits);
        rect.setyMax(yMax);
        
        return rect;
    }
    
    public static StructFrameRate getFrameRate(InputStream i) throws IOException {
        ReadBits.completeReadBits();
        
        StructFrameRate frameRate = new StructFrameRate();
        
        int fractional = i.read();
        frameRate.setFractionalPotion(fractional);
        
        int integer = i.read();
        frameRate.setIntegerPotion(integer);
        
        return frameRate;
    }
}
