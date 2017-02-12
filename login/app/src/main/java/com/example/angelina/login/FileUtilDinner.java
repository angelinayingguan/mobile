package com.example.angelina.login;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * Created by angelina on 2/2/17.
 */



public class FileUtilDinner {


    public static ArrayList<MenuDinner> readFromFile(Context ctx)
    {
        ArrayList<MenuDinner> menuItems = new ArrayList<>();

        Calendar todayDate = Calendar.getInstance();
        Date nowDate = todayDate.getTime();
        SimpleDateFormat form1 = new SimpleDateFormat("yyyy-MM-dd");
        String dateToday = form1.format(nowDate);

       /* InputStream inputStream = ctx.getResources().openRawResource(R.raw.valdinner);
        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;*/

        try {
            ArrayList<MenuDinner> items = new MyAsyncTaskDinner().execute(dateToday).get();
            ArrayList<String> listItems = new ArrayList<String>();
            ArrayList<MenuDinner>itemSet = new ArrayList<MenuDinner>();
            for(int i = 0; i < items.size();i++){
                if(items.get(i).getType().equals("Dinner")){
                    itemSet.add(items.get(i));
                    MenuDinner mItem = items.get(i);
                    listItems.add(mItem.getItems());
                }
            }
            return itemSet;
            //MenuArrayAdapter adapter = new MenuArrayAdapter (this,itemSet);
            //listview.setAdapter(adapter);
        }

        catch(InterruptedException e){}
        catch(ExecutionException e1){}

        return null;
    }

//        try {
//            while (( line = buffreader.readLine()) != null) {
//
//                MenuLunch m = new MenuLunch();
//                Log.d("FileUtilLunch", line);
//                String[] parts = line.split(",");
//                m.setType(parts[0]);
//                m.setSection(parts[1]);
//                m.setItems(parts[2]);
//                menuItems.add(m);
////                text.append(line);
////                text.append('\n');
//            }
//        } catch (IOException e) {
//            return null;
//        }

    //return ;
}

