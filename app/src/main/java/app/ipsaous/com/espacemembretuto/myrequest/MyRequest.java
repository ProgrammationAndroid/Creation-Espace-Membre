package app.ipsaous.com.espacemembretuto.myrequest;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ipsaous on 25/09/2015.
 */
public class MyRequest {

    private Context context;
    private RequestQueue queue;

    public MyRequest(Context context, RequestQueue queue) {
        this.context = context;
        this.queue = queue;
    }

    public void register(final String pseudo, final String email, final String password, final String password2){

        String url = "http://192.168.0.10/tuto_espace_membre/register.php";

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("APP", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("APP", "ERROR = " + error);

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<>();
                map.put("pseudo", pseudo);
                map.put("email", email);
                map.put("password", password);
                map.put("password2", password2);

                return map;
            }
        };

        queue.add(request);

    }

}
