package thegenuinegourav.custombroadcastrecieverintents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MyReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Custom Intent Detected.", Toast.LENGTH_LONG).show();
    }
}
