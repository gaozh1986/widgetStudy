package android.gaozh.provider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.gaozh.BusinessReceiver;
import android.gaozh.R;
import android.widget.RemoteViews;

public class Widget2X2Provider extends BaseWidgetProvider
{
    public void updateWidgetView(Context context, boolean isDefaultIcon)
    {
        // ��ʼ��remoteView����
        RemoteViews remoteViews = getRemoteViews(context);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        appWidgetManager.updateAppWidget(new ComponentName(context, Widget2X2Provider.class), remoteViews);
    }

    public RemoteViews getRemoteViews(Context context)
    {
        // ��ʼ��remoteView����
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_change_image_2_2);

        // ��������ͼƬ��Դ
        Intent resetIntent = new Intent("com.qin.action.CHANGE_IMAGE");
        PendingIntent resetNoPending = PendingIntent.getBroadcast(context, 0, resetIntent, 0);

        // ������Ӧ����
        remoteViews.setOnClickPendingIntent(R.id.btn_resetNumber, resetNoPending);
        remoteViews.setImageViewResource(R.id.img, R.drawable.icon);

        if (BusinessReceiver.isDefaultIcon)
        {
            remoteViews.setImageViewResource(R.id.img, R.drawable.girl);
        }
        else
        {
            remoteViews.setImageViewResource(R.id.img, R.drawable.icon);
        }
        return remoteViews;
    }
}
