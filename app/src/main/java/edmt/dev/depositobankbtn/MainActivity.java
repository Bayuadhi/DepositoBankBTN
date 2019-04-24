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

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_HASIL = "HASIL";

    EditText currency_input ;
    Button hasil;
    private double answer;

    Double input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Views
        currency_input = (EditText) findViewById(R.id.editText_currency_input);
        hasil = findViewById(R.id.btn_hasil);
        // Default value
        currency_input.setText("0");

        Spinner spinner_convert_from = (Spinner) findViewById(R.id.spinner_convert_from);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_convert_from.setAdapter(adapter);


        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHasil();
            }
        });
        // Add item selected listener
        spinner_convert_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int pos,
                                       long id) {

                // Get input text
                input = Double.parseDouble(currency_input.getText().toString());
                double hasil;
                if (pos == 0) {
                    answer = input*0;
                } else if (pos == 1) {
                    answer = input* 0.05 * 0.002739726 * 30 * 0.8;
                } else if (pos == 2) {
                    if (input <= 100000000) {
                        answer = (input* 0.05 * 0.002739726 * 60 * 0.8);;
                    }
                    else {
                        answer = input * 0.0525 * 0.002739726 * 60 * 0.8;;
                    }
                } else if (pos == 3) {
                    if (input <= 100000000) {
                        answer = input * 0.05 * 0.002739726 * 90 * 0.8;;
                    }
                    else {
                        answer = input * 0.0525 * 0.002739726 * 90 * 0.8;;
                    }
                } else if (pos == 4) {
                    if (input <= 100000000) {
                        answer = input * 0.0525 * 0.002739726 * 180 * 0.8;;
                    }
                    else {
                        answer = (input * 0.055 * 0.002739726 * 180 * 0.8);;
                    }
                } else if (pos == 5) {
                    if (input <= 100000000) {
                        answer = (input * 0.0525 * 0.002739726 * 360 * 0.8);;
                    }
                    else {
                        answer = (input * 0.055 * 0.002739726 * 360 * 0.8);;
                    }
                } else if (pos == 6) {
                    if (input <= 100000000) {
                        answer = input * 0.0525 * 0.002739726 * 720 * 0.8;;
                    }
                    else {
                        answer = (input * 0.055 * 0.002739726 * 720 * 0.8);
                    }
                }
//                jawaban.setText(formatRupiah.format((double)answer));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void showHasil(){
        Intent intent = new Intent(this,Hasil.class);
        intent.putExtra(TAG_HASIL,answer);
        startActivity(intent);
    }
}

