package com.example.masteringandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ServerActivity extends AppCompatActivity {

    String URL = "https://jsonplaceholder.typicode.com/users";

    ProgressBar progressBar;
    ListView listView;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);

        progressBar = findViewById(R.id.progressBar);
        listView = findViewById(R.id.listview);

        vollyArrReq();




    }

    private void vollyArrReq(){
        RequestQueue queue = Volley.newRequestQueue(this);

        progressBar.setVisibility(View.VISIBLE);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

               try {

                   progressBar.setVisibility(View.GONE);

                   for (int i =0 ; i< response.length(); i++){
                       JSONObject jsonObject = response.getJSONObject(i);

                       hashMap =  new HashMap<>();
                       hashMap.put("name", jsonObject.getString("name"));
                       hashMap.put("email", jsonObject.getString("email"));
                       hashMap.put("address", jsonObject.getString("address"));
                       arrayList.add(hashMap);

                   }

                   MyAdaptar myAdaptar = new MyAdaptar();
                   listView.setAdapter(myAdaptar);

               }catch (JSONException e){
                   progressBar.setVisibility(View.GONE);
               }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonArrayRequest);

    }


    private class MyAdaptar extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.server_list_item , null);


            TextView tvName = view.findViewById(R.id.tvName);
            TextView tvEmail = view.findViewById(R.id.tvEmail);
            TextView tvAddress = view.findViewById(R.id.tvAddress);


            HashMap<String, String> hashmap = arrayList.get(position);

            String name = hashmap.get("name");
            String email = hashmap.get("email");
            String address = hashmap.get("address");

            tvName.setText(name);
            tvEmail.setText(email);
            tvAddress.setText(address);


            return view;
        }
    }


}