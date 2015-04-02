package android.gaozh.provider;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * �Զ��� AppWidget
 * 
 * @author qinjuning
 */
public abstract class BaseWidgetProvider extends AppWidgetProvider
{

    private String TAG = "MyAppWidgetProvider";

    // ÿ��ɾ�������͵Ĵ���С����(AppWidget)ʱ���ᴥ�� ��ͬʱ����ACTION_APPWIDGET_DELETED�㲥��
    // �ù㲥�ɱ�onReceive()�������ܵ�.
    @Override
    public void onDeleted(Context context, int[] appWidgetIds)
    {
        super.onDeleted(context, appWidgetIds);
        Log.i(TAG, "--- onDeleted ---");
    }

    // ���ɾ�������͵Ĵ���С����(AppWidget)ʱ����
    @Override
    public void onDisabled(Context context)
    {
        super.onDisabled(context);
        Log.i(TAG, "--- onDisabled ---");
    }

    // ��һ����Ӹ����͵Ĵ���С��������С����(AppWidget)ʱ����
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

    // ÿ�����һ�������͵Ĵ���С��������С����(AppWidget)���ᴥ����ͬʱ����ACTION_APPWIDGET_UPDATE�㲥
    // һ���ڸú���Ϊ��ʼ����ӵĴ���С���� , ��Ϊ������RemoteViews

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
