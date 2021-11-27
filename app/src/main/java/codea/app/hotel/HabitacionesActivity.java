package codea.app.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;

public class HabitacionesActivity extends AppCompatActivity implements View.OnClickListener {

    Button _btnDoble, _btnFamiliar, _btnMatrimonil, _btnSimple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitaciones);

        _btnDoble= findViewById(R.id.btnDoble) ;
        _btnFamiliar= findViewById(R.id.btnFamiliar);
        _btnMatrimonil= findViewById(R.id.btnMatrimonial);
        _btnSimple= findViewById(R.id.btnSimple);


        _btnDoble.setOnClickListener(this);
        _btnFamiliar.setOnClickListener(this);
        _btnMatrimonil.setOnClickListener(this);
        _btnSimple.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDoble:
                lanzarWhatsapp("2491702808");
                break;
            case R.id.btnFamiliar:
                lanzarWhatsapp("2491702808");
                break;
            case R.id.btnMatrimonial:
                lanzarWhatsapp("2491702808");
                break;
            case R.id.btnSimple:
                lanzarWhatsapp("2491702808");
                break;
        }
    }

    private void lanzarWhatsapp(String telefono) {
        String toNumber = "52"+telefono; // contains spaces.
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
        sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(toNumber)+"@s.whatsapp.net");//phone number without "+" prefix
        startActivity(sendIntent);
    }
}
