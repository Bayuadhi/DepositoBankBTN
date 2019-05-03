package edmt.dev.depositobankbtn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_HASIL = "HASIL";

    EditText currency_input ;
    Button hasil;
    Spinner spinner_convert_from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Views
        currency_input = (EditText) findViewById(R.id.editText_currency_input);
        hasil = findViewById(R.id.btn_hasil);
        // Default value
        currency_input.setText("0");

        spinner_convert_from = (Spinner) findViewById(R.id.spinner_convert_from);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_convert_from.setAdapter(adapter);


        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHasil();
            }
        });


    }
    
    private double hitungDeposito(double input){
        int pos = spinner_convert_from.getSelectedItemPosition();
        if (pos == 0) {
            return input*0;
        } else if (pos == 1) {
            return input* 0.05 * 0.002739726 * 30 * 0.8;
        } else if (pos == 2) {
            if (input <= 100000000) {
                return (input* 0.05 * 0.002739726 * 60 * 0.8);
            }
            else {
                return input * 0.0525 * 0.002739726 * 60 * 0.8;
            }
        } else if (pos == 3) {
            if (input <= 100000000) {
                return input * 0.05 * 0.002739726 * 90 * 0.8;
            }
            else {
                return input * 0.0525 * 0.002739726 * 90 * 0.8;
            }
        } else if (pos == 4) {
            if (input <= 100000000) {
                return input * 0.0525 * 0.002739726 * 180 * 0.8;
            }
            else {
                return (input * 0.055 * 0.002739726 * 180 * 0.8);
            }
        } else if (pos == 5) {
            if (input <= 100000000) {
                return (input * 0.0525 * 0.002739726 * 360 * 0.8);
            }
            else {
                return (input * 0.055 * 0.002739726 * 360 * 0.8);
            }
        } else if (pos == 6) {
            if (input <= 100000000) {
                return input * 0.0525 * 0.002739726 * 720 * 0.8;
            }
            else {
                return (input * 0.055 * 0.002739726 * 720 * 0.8);
            }
        }
        return 0;
    }

    private void showHasil(){
        double input = Double.parseDouble(currency_input.getText().toString());
        if (input<1000000000) {
            double hasil = hitungDeposito(input);
            Intent intent = new Intent(this, Hasil.class);
            intent.putExtra(TAG_HASIL, hasil);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Input Tidak Boleh Lebih Dari 1M", Toast.LENGTH_SHORT).show();
        }
    }
}

