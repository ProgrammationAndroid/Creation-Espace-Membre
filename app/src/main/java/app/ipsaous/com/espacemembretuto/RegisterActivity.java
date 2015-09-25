package app.ipsaous.com.espacemembretuto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;

import app.ipsaous.com.espacemembretuto.myrequest.MyRequest;

public class RegisterActivity extends AppCompatActivity {

    private Button btn_send;
    private EditText et_pseudo, et_email, et_password, et_password2;
    private RequestQueue queue;
    private MyRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_send = (Button) findViewById(R.id.btn_send);
        et_pseudo = (EditText) findViewById(R.id.et_pseudo);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        et_password2 = (EditText) findViewById(R.id.et_password2);

        queue = VolleySingleton.getInstance(this).getRequestQueue();
        request = new MyRequest(this, queue);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pseudo = et_pseudo.getText().toString().trim();
                String email = et_email.getText().toString().trim();
                String password = et_password.getText().toString().trim();
                String password2 = et_password2.getText().toString().trim();
                request.register(pseudo, email, password, password2);
            }
        });
     }

}
