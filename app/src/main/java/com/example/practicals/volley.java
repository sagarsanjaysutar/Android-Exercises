package com.example.practicals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class volley extends AppCompatActivity {
    private TextView textView;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        requestQueue = Volley.newRequestQueue(this);
        getReference();
        getJSONData();

    }

    private void getJSONData() {
        final String url = "https://coronavirus-worlddata.herokuapp.com/total";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    textView.append("URL: "+url);


                    textView.append("\n\n\nCorona virus impact world wide.\n");
                    textView.append("\nActive  : " + response.get("active") + "\nCured : " + response.get("cured") + "\nDeaths: " + response.get("deaths"));
                    } catch (JSONException ex) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("---", "Error in getData " + error);
            }
        });
        requestQueue.add(request);
    }

    private void getReference() {
        textView = findViewById(R.id.volley_tv2);
    }


}
