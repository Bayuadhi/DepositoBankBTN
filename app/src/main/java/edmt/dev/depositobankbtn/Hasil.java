package edmt.dev.depositobankbtn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class Hasil extends AppCompatActivity {

    private TextView tv_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        final Locale localeID = new Locale("in", "ID");
        final NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        tv_hasil = findViewById(R.id.tv_hasil);


        Intent intent = getIntent();
        double answer = intent.getDoubleExtra(MainActivity.TAG_HASIL,0);
        tv_hasil.setText(formatRupiah.format(answer));
    }
}
