package edmt.dev.depositobankbtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class Splashart extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashart);

    handler = new Handler();
        handler.postDelayed(new Runnable()  {
            @Override
            public void run() {
                Intent intent = new Intent(Splashart.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, 600);
    }
}
