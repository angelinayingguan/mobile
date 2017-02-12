package com.example.angelina.login;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;


//public class ScrapingTaskActivity extends Activity {
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.main);
//
//        // This starts the AsyncTask
//        // Doesn't need to be in onCreate()
//        String todayDate = DateFormat.getDateTimeInstance().format(YEAR-MONTH-DATE);
//        new MyTask().execute(todayDate);
//    }
//

public class MyAsyncTaskBreakfast extends AsyncTask<String, Void, ArrayList<Menu>> {

    // Runs in UI before background thread is called
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Do something like display a progress bar
    }

    // This is run in a background thread
    @Override
    protected ArrayList<Menu> doInBackground(String... params) {
        // get the string from params, which is an array
        String date = params[0];

        Scraper scrap1 = new Scraper(){};
        ArrayList<Menu> items = new ArrayList<>();
        try{
            ArrayList<ArrayList<ArrayList<String>>> result = scrap1.scrapeMenu(date);
            for(int a = 0; a<result.size();a++) {
                //loops through lunch breakfast dinner
                for (int b = 0; b<result.get(a).size();b++) {
                    //loops through foodType
                    for (int i = 1; i < result.get(a).get(b).size(); i++) {
                        //loops through the food items.
                        Menu m = new Menu();
                        if(a == 0) {
                            m.setType("Breakfast");
                            m.setSection(result.get(a).get(b).get(0));
                            m.setItems(result.get(a).get(b).get(i));
                            items.add(m);
                        }
                        else if(a == 1){
                            m.setType("Lunch");
                            m.setSection(result.get(a).get(b).get(0));
                            m.setItems(result.get(a).get(b).get(i));
                            items.add(m);
                        }
                        else if(a == 2){
                            m.setType("Dinner");
                            m.setSection(result.get(a).get(b).get(0));
                            m.setItems(result.get(a).get(b).get(i));
                            items.add(m);
                        }
                    }
                }
            }
        }
        catch(IOException e1){
            Log.e("IOException", "there is an IO exception");
        }
        // Do something that takes a long time, for example:
//            for (int i = 0; i <= 100; i++) {
//
//                // Do things
//
//                // Call this to update your progress
//                publishProgress(i);
//            }

        return items;
    }

    // This is called from background thread but runs in UI
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
//
//            // Do things like update the progress bar
//        }

    // This runs in UI when background thread finishes

    protected void onPostExecute(ArrayList<Menu> result1) {
        super.onPostExecute(result1);
        //return result1;
        // Do things like hide the progress bar or change a TextView
    }
}