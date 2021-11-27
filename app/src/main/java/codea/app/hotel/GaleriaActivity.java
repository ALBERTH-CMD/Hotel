package codea.app.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GaleriaActivity extends AppCompatActivity  implements View.OnClickListener {


    ImageView _f1,_f2,_f3,_f4,_f5,_f6,_f7,_f8,_f9,_f10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        _f1 = findViewById(R.id.foto1);
        _f2 = findViewById(R.id.foto2);
        _f3 = findViewById(R.id.foto3);
        _f4 = findViewById(R.id.foto4);
        _f5 = findViewById(R.id.foto5);
        _f6 = findViewById(R.id.foto6);
        _f7 = findViewById(R.id.foto7);
        _f8 = findViewById(R.id.foto8);
        _f9 = findViewById(R.id.foto9);
        _f10 = findViewById(R.id.foto10);


        _f1.setOnClickListener(this);
        _f2.setOnClickListener(this);
        _f3.setOnClickListener(this);
        _f4.setOnClickListener(this);
        _f5.setOnClickListener(this);
        _f6.setOnClickListener(this);
        _f7.setOnClickListener(this);
        _f8.setOnClickListener(this);
        _f9.setOnClickListener(this);
        _f10.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        String foto="";
        switch (v.getId()){
            case R.id.foto1: foto ="foto1"; break;
            case R.id.foto2: foto ="foto2"; break;
            case R.id.foto3: foto ="foto3"; break;
            case R.id.foto4: foto ="foto4"; break;
            case R.id.foto5: foto ="foto5"; break;
            case R.id.foto6: foto ="foto6"; break;
            case R.id.foto7: foto ="foto7"; break;
            case R.id.foto8: foto ="foto8"; break;
            case R.id.foto9: foto ="foto9"; break;
            case R.id.foto10: foto ="foto10"; break;
        }
        startActivity(new Intent(getApplicationContext(),FotoActivity.class).putExtra("foto",foto));
    }
}
