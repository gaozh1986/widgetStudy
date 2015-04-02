package android.gaozh.provider;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * 自定义 AppWidget
 * 
 * @author qinjuning
 */
public abstract class BaseWidgetProvider extends AppWidgetProvider
{

    private String TAG = "MyAppWidgetProvider";

    // 每次删除该类型的窗口小部件(AppWidget)时都会触发 ，同时发送ACTION_APPWIDGET_DELETED广播，
    // 该广播可被onReceive()方法接受到.
    @Override
    public void onDeleted(Context context, int[] appWidgetIds)
    {
        super.onDeleted(context, appWidgetIds);
        Log.i(TAG, "--- onDeleted ---");
    }

    // 最后删除该类型的窗口小部件(AppWidget)时触发
    @Override
    public void onDisabled(Context context)
    {
        super.onDisabled(context);
        Log.i(TAG, "--- onDisabled ---");
    }

    // 第一次添加该类型的窗口小部件窗口小部件(AppWidget)时触发
    @Override
    public void onEnabled(Context context)
    {
        super.onEnabled(context);
        Log.i(TAG, "--- onEnabled ---");
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        super.onReceive(context, intent);
    }

    // 每次添加一个该类型的窗口小部件窗口小部件(AppWidget)都会触发，同时发送ACTION_APPWIDGET_UPDATE广播
    // 一般在该函数为初始化添加的窗口小部件 , 即为它分配RemoteViews

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds)
    {
        Log.i(TAG, "--- onUpdate start ---");
        RemoteViews remoteViews = getRemoteViews(context);
        for (int i = 0; i < appWidgetIds.length; i++)
        {
            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int appWidgetId,
            Bundle newOptions)
    {
        // TODO Auto-generated method stub
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions);
        Log.i(TAG, "--- onAppWidgetOptionsChanged --- appWidgetId:" + appWidgetId);
        Log.i(TAG,
                "--- onAppWidgetOptionsChanged --- OPTION_APPWIDGET_MIN_WIDTH:"
                        + newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_WIDTH, 0));
        Log.i(TAG,
                "--- onAppWidgetOptionsChanged --- OPTION_APPWIDGET_MIN_HEIGHT:"
                        + newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MIN_HEIGHT, 0));
        Log.i(TAG,
                "--- onAppWidgetOptionsChanged --- OPTION_APPWIDGET_MAX_WIDTH:"
                        + newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_WIDTH, 0));
        Log.i(TAG,
                "--- onAppWidgetOptionsChanged --- OPTION_APPWIDGET_MAX_HEIGHT:"
                        + newOptions.getInt(AppWidgetManager.OPTION_APPWIDGET_MAX_HEIGHT, 0));
    }

    public abstract void updateWidgetView(Context context, boolean isDefaultIcon);

    public abstract RemoteViews getRemoteViews(Context context);
}
