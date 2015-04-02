package android.gaozh.provider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TostBroadCast extends BroadcastReceiver
{

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReceive(Context arg0, Intent arg1)
    {
        String tmp = arg1.getStringExtra("Item");
        Toast t = Toast.makeText(arg0, tmp + " ±»µã»÷£¡£¡", 3000);
        t.show();
    }

}
