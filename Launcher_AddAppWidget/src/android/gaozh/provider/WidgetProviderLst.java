package android.gaozh.provider;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.gaozh.R;
import android.net.Uri;
import android.widget.RemoteViews;

/**
 */
public class WidgetProviderLst extends AppWidgetProvider
{

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        final int N = appWidgetIds.length;
        for (int i = 0; i < N; ++i)
        {
            RemoteViews remoteViews = updateWidgetListView(context, appWidgetIds[i]);
            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
        }
    }

    private RemoteViews updateWidgetListView(Context context, int appWidgetId)
    {

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.app_widget_layout);

        Intent btIntent = new Intent().setAction("com.android.gaozh.tst.onclickItem");
        PendingIntent btPendingIntent = PendingIntent.getBroadcast(context, 0, btIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setPendingIntentTemplate(R.id.listViewWidget, btPendingIntent);

        Intent svcIntent = new Intent(context, WidgetService.class);
        svcIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        svcIntent.setData(Uri.parse(svcIntent.toUri(Intent.URI_INTENT_SCHEME)));
        remoteViews.setRemoteAdapter(R.id.listViewWidget, svcIntent);
        remoteViews.setEmptyView(R.id.listViewWidget, R.id.empty_view);

        return remoteViews;
    }

}
