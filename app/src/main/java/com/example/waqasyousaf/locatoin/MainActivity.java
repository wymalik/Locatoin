package com.example.waqasyousaf.locatoin;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


public class MainActivity extends AppCompatActivity {

    int i =0;

  double longitude;
    double latitude;

    TextView textLat;
    TextView textLng;


    @Override



    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textLat = (TextView) findViewById(R.id.textLat);
        textLng = (TextView) findViewById(R.id.textLng);

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener ll = new MyLocationListener();

        try {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
        }catch (SecurityException ex){
              ex.printStackTrace();
        }


    }






        class MyLocationListener implements LocationListener {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();

                   textLat.setText(Double.toString(latitude));
                   textLng.setText(Double.toString(longitude));

               /* try {


                    Thread.sleep(10000);
                    //SendQueryString();
                } catch (InterruptedException e) {
                    // recommended because catching InterruptedException clears interrupt flag
                    Thread.currentThread().interrupt();
                    // you probably want to quit if the thread is interrupted
                    return;
                }*/






            }

            @Override
            public void onProviderDisabled(String provider) {


            }

            @Override
            public void onProviderEnabled(String provider) {


            }

            @Override
            public void onStatusChanged(String a, int s, Bundle b) {


            }



        }



    public void SendQueryString() {
       new Thread() {
            public void run() {

                String url = "http://aim.pucit.edu.pk:8085/tomcat-demo/So/NewFile.jsp?Latitude="+latitude+"&Longitude="+longitude;







                try {
                    //HttpClient Client = HttpClientBuilder.create().build();
                   HttpClient Client = new DefaultHttpClient();
                    HttpGet httpget = new HttpGet(url);
                    Client.execute(httpget);

                   // this.interrupt();
                }
                catch(Exception ex) {
                   ex.printStackTrace();

                }
            }
        }.start();
    }



    public void buttonOnClick(View v){

        SendQueryString();

        }

   public void showMap(View view){

       Intent intent= new Intent(Intent.ACTION_VIEW);
           intent.setData(Uri.parse("geo:"+latitude+","+longitude));
       startActivity(intent);
   }


   public void changeURL(View view){

       Toast.makeText(this, "Now in goto  class function ... ", Toast.LENGTH_LONG).show();

       Intent intent=new Intent(this,URLServerAddress.class);
       startActivity(intent);


   }


    public void recordData(View view){

        Toast.makeText(this, "Now in goto B class function ... ", Toast.LENGTH_LONG).show();

        Intent intent=new Intent(this,RecordData.class);
        startActivity(intent);


    }


    public void testUpload(){

        int i=1;
        i++;

        int j=0;
            j=6;


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
