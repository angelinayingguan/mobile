package com.example.angelina.login;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by aprasad on 1/29/17.
 */

public class MenuArrayAdapterDinner extends ArrayAdapter <MenuDinner> {

    private final Context context;
//    private final String[] values;

    String priorType = "";
    String priorSection = "";

    ArrayList<MenuDinner> itemsdinner;

    public MenuArrayAdapterDinner(Context ctx, ArrayList<MenuDinner> items)
    {
        super(ctx, R.layout.list_menu_dinner);
        this.context = ctx;
        // items = FileUtil.readFromFile(context);

        this.itemsdinner = items;
        Log.d("MenuArrayAdapterDinner", "Read " + items.size() + " items");
    }

    public View getView (int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_menu_dinner, parent, false);
        TextView textView1 = (TextView) rowView.findViewById(R.id.type);
        TextView textView2 = (TextView) rowView.findViewById(R.id.section);
        TextView textView3 = (TextView) rowView.findViewById(R.id.items);

        Log.d("MenuArrayAdapterLunch", "Row "+position);

        String type = getItem(position).getType();
        if(!priorType.equals(type)) {
            priorType=type;
            textView1.setText(type);

        }

        String section = itemsdinner.get(position).getSection();
        if(!priorSection.equals(section)) {
            priorSection=section;
            textView2.setText(section);

        }

        textView3.setText(itemsdinner.get(position).getItems());

        return rowView;
    }

    //1
    @Override
    public int getCount() {
        return itemsdinner.size();
    }

    //2
    @Override
    public MenuDinner getItem(int position) {
        return itemsdinner.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

//    //4
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Get view for row item
//        View rowView = mInflater.inflate(R.layout.list_item_recipe, parent, false);
//
//        return rowView;
//    }

}
