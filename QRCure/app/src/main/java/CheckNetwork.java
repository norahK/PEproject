/**
 * Created by IT team on 27/07/17.
 */
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
public class CheckNetwork extends Application
{

    public static boolean isNetworkAvailable(Context context) {
        // TODO Auto-generated method stub
        ConnectivityManager connectivity =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
/*usage
if(CheckNetwork.isNetworkAvailable(MainActivity.this) ){
//network available
}else{
//not available
}
 */