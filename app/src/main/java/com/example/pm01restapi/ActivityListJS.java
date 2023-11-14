package com.example.pm01restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class ActivityListJS extends AppCompatActivity {

    private ListView listview;
    private RequestQueue requestQueue;
    private ArrayAdapter<String> postadapter;
    private String url = "https://jsonplaceholder.typicode.com/posts";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_js);

        listview = (ListView) findViewById(R.id.listpost);
        postadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listview.setAdapter(postadapter);

        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response)
            {
                for(int i =0; i < response.length(); i++)
                {
                    try
                    {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String mensaje = jsonObject.getString("title");
                        postadapter.add(mensaje);


                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonArrayRequest);

    }
}