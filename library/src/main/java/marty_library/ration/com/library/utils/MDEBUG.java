package marty_library.ration.com.library.utils;

import android.util.Log;

/**
 * Created by Charny on 2018-12-04.
 */
public class MDEBUG {

    public static void debug(String msg){
        Log.d("<Marty>",msg);

    }
    public static void debug(double msg){
        Log.d("<Marty>",msg + "");

    }
    public static void debug(int msg){
        Log.d("<Marty>",msg + "");
    }
}