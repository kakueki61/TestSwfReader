package utils;

import java.io.IOException;
import java.io.InputStream;

public class ReadBytes {
    private static final String TAG = ReadBytes.class.getSimpleName();
    
    /**
     * UI16�l��ǂݍ���
     * @param i
     * @return
     * @throws IOException
     */
    public static int readUI16(InputStream i) throws IOException {
        ReadBits.completeReadBits();
        
        int v = i.read();   //1�o�C�g�ڂ�ǂݍ���Ŋi�[
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
