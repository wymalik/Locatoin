package com.example.waqasyousaf.locatoin;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class URLServerAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urlserver_address);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_urlserver_address, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public void load(View view){

        String URL;

        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
         URL=sharedPreferences.getString("name","No data");
        if(URL.equals("No data")  ){

            Toast.makeText(this, "no data found ", Toast.LENGTH_SHORT).show();


        }else
        {
            Toast.makeText(this,"Data found ",Toast.LENGTH_SHORT).show();


        }


    }






}
