package android.gaozh.provider;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by ivanle on 7/23/14. All rights reserved
 */
public class WidgetService extends RemoteViewsService
{

    @Override
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent)
    {
        return (new ListProvider(this.getApplicationContext()));
    }

}
