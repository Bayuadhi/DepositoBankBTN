package edmt.dev.depositobankbtn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButtonDeposito;
    private Button mButtonRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mButtonDeposito = (Button) findViewById(R.id.deposito);
        mButtonDeposito.setOnClickListener(this);

        mButtonRule = (Button) findViewById(R.id.rule);
        mButtonRule.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.deposito:
                Intent moveIntent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(moveIntent);
                break;

            case R.id.rule:
                Intent moveIntent1 = new Intent(HomeActivity.this, RuleActivity.class);
                startActivity(moveIntent1);
                break;
        }
    }
}
