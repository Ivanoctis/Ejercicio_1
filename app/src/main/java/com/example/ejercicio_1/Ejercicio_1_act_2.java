package com.example.ejercicio_1;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Ejercicio_1_act_2 extends AppCompatActivity {

    private TextView _name;
    private TextView _count;
    private TextView _age;
    private TextView _mail;
    private TextView _sign;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_1_act_2);

        _name = findViewById(R.id.Name2);
        _count = findViewById(R.id.Num_cuenta2);
        _age = findViewById(R.id.Age);
        _mail = findViewById(R.id.Mail2);
        _sign = findViewById(R.id.Sign);
        image = findViewById(R.id.imagesign);

        String nombre = getIntent().getStringExtra("Nombre");
        String count = getIntent().getStringExtra("Num_cuenta");
        String age = getIntent().getStringExtra("Edad");
        String mail = getIntent().getStringExtra("Mail");
        String sign = getIntent().getStringExtra("Horoscopo");

        _name.setText(nombre);
        _count.setText(count);
        _age.setText(age);
        _mail.setText(mail);
        _sign.setText(sign);

        switch (sign){
            case "Mono": image.setImageResource(R.drawable.monkey); break;
            case "Gallo": image.setImageResource(R.drawable.gallo); break;
            case "Perro": image.setImageResource(R.drawable.dog); break;
            case "Cerdo": image.setImageResource(R.drawable.pig); break;
            case "Rata": image.setImageResource(R.drawable.rat); break;
            case "Buey": image.setImageResource(R.drawable.buey); break;
            case "Tigre": image.setImageResource(R.drawable.tiger); break;
            case "Conejo": image.setImageResource(R.drawable.conejo); break;
            case "Dragon": image.setImageResource(R.drawable.dragon); break;
            case "Serpiente": image.setImageResource(R.drawable.serpiente); break;
            case "Caballo": image.setImageResource(R.drawable.horse); break;
            case "Cabra": image.setImageResource(R.drawable.cabra); break;
            default: image.setImageResource(R.drawable.cryandroid);
                Toast.makeText(this,"Algo se rompio :'(",Toast.LENGTH_LONG).show(); break;

        }

    }

    //Regreso
    public void Regresar(View view){
        Intent back = new Intent(this,MainActivity.class);
        startActivity(back);
    }
}
