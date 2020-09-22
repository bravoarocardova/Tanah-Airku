package com.bac.tanahairku;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public final static String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgLambang = findViewById(R.id.img_lambang);
        ImageView imgWilayah = findViewById(R.id.img_wilayah);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvIbukota = findViewById(R.id.tv_ibukota);
        TextView tvDescription = findViewById(R.id.tv_description);

        Provinsi provinsi = getIntent().getParcelableExtra(EXTRA_DATA);
        assert provinsi != null;
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(provinsi.getName());
        }

        tvName.setText(provinsi.getName());
        tvIbukota.setText(provinsi.getIbukota());
        tvDescription.setText(provinsi.getDescription());
        Glide.with(this).load(provinsi.getLambang()).into(imgLambang);
        Glide.with(this).load(provinsi.getWilayah()).into(imgWilayah);
    }
}
