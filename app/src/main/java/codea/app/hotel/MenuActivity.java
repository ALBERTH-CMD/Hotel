package codea.app.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    Button _btnHabitaciones, _btnUbicacion, _btnReserva, _btnNosotros, _btnGaleria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        _btnHabitaciones=findViewById(R.id.btnHabitaciones);
        _btnUbicacion=findViewById(R.id.btnUbicacion);
        _btnReserva=findViewById(R.id.btnReserva);
        _btnNosotros=findViewById(R.id.btnNosotros);
        _btnGaleria=findViewById(R.id.btnGaleria);

        _btnHabitaciones.setOnClickListener(this);
        _btnUbicacion.setOnClickListener(this);
        _btnReserva.setOnClickListener(this);
        _btnNosotros.setOnClickListener(this);
        _btnGaleria.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHabitaciones:
                startActivity(new Intent(getApplicationContext(),HabitacionesActivity.class));
                break;
            case R.id.btnUbicacion:
                // google maps
                ubicacion();
                break;
            case R.id.btnReserva:
                // whatsapp
                reservas();
                break;
            case R.id.btnNosotros:
                startActivity(new Intent(getApplicationContext(),NosotrosActivity.class));
                break;
            case R.id.btnGaleria:
                startActivity(new Intent(getApplicationContext(),GaleriaActivity.class));
                break;

        }

    }
    public void ubicacion(){
        double latitude  = 20.6222200;
        double longitude = -87.0694400;

        String label = "Spacer HOTELES";

        String uriBegin = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        Uri uri = Uri.parse(uriString);
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        startActivity(mapIntent);

    }
    public void reservas(){
        String toNumber = "522491702808"; // contains spaces.
        try {
            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
            sendIntent.putExtra(Intent.EXTRA_TEXT,"Hola, una consulta");
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(toNumber)+"@s.whatsapp.net");//phone number without "+" prefix
            startActivity(sendIntent);
        }catch (Exception e){
            Log.d("ERROR CHAT",e.getMessage());
        }
    }
}
