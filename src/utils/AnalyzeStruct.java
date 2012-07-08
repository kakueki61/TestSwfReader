package utils;

import java.io.FileInputStream;
import java.io.IOException;

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
}
