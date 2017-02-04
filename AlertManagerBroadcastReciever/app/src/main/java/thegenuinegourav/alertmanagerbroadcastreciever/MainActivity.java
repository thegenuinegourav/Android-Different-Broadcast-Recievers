package thegenuinegourav.alertmanagerbroadcastreciever;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(30000); //Set Alarm after each 30 seconds
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
                                startAlert();
                            }
                        });
                    } catch (Exception e) {

                    }
                }
            }
        }).start();
    }

    public void startAlert() {
        TextView status = (TextView) findViewById(R.id.ok);
        Intent intent = new Intent(this, MyBroadcastReciever.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 1234567, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (10000), pendingIntent);
        Toast.makeText(this, "Alarm set for 10 seconds!",
                Toast.LENGTH_LONG).show();
    }
}
