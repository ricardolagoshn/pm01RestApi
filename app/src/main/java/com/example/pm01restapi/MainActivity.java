package com.example.pm01restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest jsonObjectRequest =  new StringRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts", new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                Log.d("Respuesta ",response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.d("Respuesta",error.toString());
            }
        });

        // Envio de la peticion
        requestQueue.add(jsonObjectRequest);

    }

}