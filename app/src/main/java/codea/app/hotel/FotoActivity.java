package codea.app.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class FotoActivity extends AppCompatActivity {

    ImageView _foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        _foto = findViewById(R.id.foto);

        String foto = "ic_"+getIntent().getExtras().getString("foto");
        Log.d("NOMBRE",foto);

       _foto.setImageResource(getApplicationContext().getResources().getIdentifier(foto,"drawable",getApplicationContext().getPackageName()));

    }
}
