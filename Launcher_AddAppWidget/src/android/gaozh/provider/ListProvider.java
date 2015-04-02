package android.gaozh.provider;

import java.util.ArrayList;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.gaozh.R;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

/**
 * Created by ivanle on 7/23/14. All rights reserved
 */

public class ListProvider implements RemoteViewsService.RemoteViewsFactory
{
    private ArrayList<String> listItemList = new ArrayList<String>();

    private Context context = null;

    public ListProvider(Context context)
    {
        this.context = context;
        listItemList.add("aaa");
        listItemList.add("bbb");
        listItemList.add("ccc");
        listItemList.add("ddd");
        listItemList.add("eee");
        listItemList.add("fff");
        listItemList.add("ggg");
        listItemList.add("hhh");
        listItemList.add("iii");
        listItemList.add("jjj");
        listItemList.add("kkk");
        listItemList.add("lll");
        listItemList.add("mmm");
        listItemList.add("nnn");
        populateListItem();
    }

    private void populateListItem()
    {
    }

    @Override
    public void onCreate()
    {

    }

    @Override
    public void onDataSetChanged()
    {
        populateListItem();
    }

    @Override
    public void onDestroy()
    {

    }

    @Override
    public int getCount()
    {
        return listItemList.size();
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public RemoteViews getViewAt(int position)
    {

        final RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget_list_item);
        String listItem = listItemList.get(position);
        remoteView.setTextViewText(R.id.tvTaskTitle, listItem);

        Intent intent = new Intent();
        intent.putExtra("Item", listItem);
        remoteView.setOnClickFillInIntent(R.id.item, intent);
        return remoteView;
    }

    @Override
    public RemoteViews getLoadingView()
    {
        return null;
    }

    @Override
    public int getViewTypeCount()
    {
        return 1;
    }
}
