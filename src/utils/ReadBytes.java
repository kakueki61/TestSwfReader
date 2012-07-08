package utils;

import java.io.IOException;
import java.io.InputStream;

public class ReadBytes {
    private static final String TAG = ReadBytes.class.getSimpleName();
    
    /**
     * Reads UI8 value(no need ?)
     * @param i
     * @return
     * @throws IOException
     */
    public static int readUI8(InputStream i) throws IOException {
        ReadBits.completeReadBits();
        
        return i.read();
    }
    /**
     * UI16値を読み込む
     * @param i
     * @return
     * @throws IOException
     */
    public static int readUI16(InputStream i) throws IOException {
        ReadBits.completeReadBits();
        
        int v = i.read();   //1バイト目を読み込んで格納
        int w = i.read() << 8;
        int x = v | w;
        return x;
    }
    
    public static int readUI32(InputStream i) throws IOException{
        ReadBits.completeReadBits();
        
        int v = i.read();
        v |= i.read() << 8;
        v |= i.read() << 16;
        v |= i.read() << 24;
        return v;
    }    
}
