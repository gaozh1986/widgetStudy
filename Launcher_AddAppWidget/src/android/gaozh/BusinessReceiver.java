package android.gaozh;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.gaozh.provider.BaseWidgetProvider;
import android.gaozh.provider.Widget1X1Provider;
import android.gaozh.provider.Widget2X2Provider;
import android.gaozh.provider.Widget4X3Provider;
import android.util.Log;

public class BusinessReceiver extends BroadcastReceiver
{
    private String TAG = "MyAppWidgetProvider";

    public static boolean isDefaultIcon = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i(TAG, "--- onReceive and action is ---" + intent.getAction());

        Log.i(TAG, "--- idDefaultIcon---" + isDefaultIcon);
        if (intent.getAction().equals("com.qin.action.CHANGE_IMAGE"))
        {
            BaseWidgetProvider provider = new Widget1X1Provider();
            provider.updateWidgetView(context, BusinessReceiver.isDefaultIcon);
            provider = new Widget2X2Provider();
            provider.updateWidgetView(context, BusinessReceiver.isDefaultIcon);
            provider = new Widget4X3Provider();
            provider.updateWidgetView(context, BusinessReceiver.isDefaultIcon);
            isDefaultIcon = !isDefaultIcon;
        }
    }
}
