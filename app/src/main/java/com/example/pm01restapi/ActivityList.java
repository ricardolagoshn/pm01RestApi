package com.example.pm01restapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pm01restapi.Config.Personas;
import com.example.pm01restapi.Config.RestApiMethods;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityList extends AppCompatActivity {

    private RequestQueue requestQueue;

    List<Personas> listperson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listperson = new ArrayList<>();
        SendData();
    }

    private void SendData()
    {
        requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest request  = new JsonObjectRequest(Request.Method.GET,
                RestApiMethods.EndpointGet, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {


                    String mensaje = response.toString();
                    //Toast.makeText(getApplicationContext(), mensaje,Toast.LENGTH_LONG).show();

                    JSONArray arreglo = new JSONArray(response.toString());

                    for(int i=0; i < arreglo.length(); i++)
                    {
                        JSONObject arrayperson = arreglo.getJSONObject(i);
                        Personas persona = new Personas();
                        persona.setId(arrayperson.getString("id"));
                        persona.setNombres(arrayperson.getString("nombres"));
                        persona.setApellidos(arrayperson.getString("apellidos"));
                        persona.setFechanac(arrayperson.getString("fechanac"));
                        persona.setFoto(arrayperson.getString("fechanac"));

                        listperson.add(persona);
                    }

                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getApplicationContext(), error.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

        requestQueue.add(request);
    }
}