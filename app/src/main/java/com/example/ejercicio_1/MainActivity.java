package com.example.ejercicio_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText _Name;
    private EditText _Count;
    private EditText _Day;
    private EditText _Mes;
    private EditText _Year;
    private EditText _Mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _Name = findViewById(R.id.Name);
        _Count = findViewById(R.id.Numero_de_cuenta);
        _Day = findViewById(R.id.Day);
        _Mes = findViewById(R.id.mes);
        _Year = findViewById(R.id.year);
        _Mail = findViewById(R.id.Correo);
    }

    //Zodiaco chino
    public String Zoodiac(int _year){
        String horoscopo = "";
        int resto = _year%12;
        switch (resto){
            case 0: horoscopo = "Mono"; break;
            case 1: horoscopo = "Gallo"; break;
            case 2: horoscopo = "Perro"; break;
            case 3: horoscopo = "Cerdo"; break;
            case 4: horoscopo = "Rata"; break;
            case 5: horoscopo = "Buey"; break;
            case 6: horoscopo = "Tigre"; break;
            case 7: horoscopo = "Conejo"; break;
            case 8: horoscopo = "Dragon"; break;
            case 9: horoscopo = "Serpiente"; break;
            case 10: horoscopo = "Caballo"; break;
            case 11: horoscopo = "Cabra"; break;
        }

        return horoscopo;
    }

    //Salto
    public void Submit(View view){
        String Name = _Name.getText().toString();
        String Count = _Count.getText().toString();
        String day = _Day.getText().toString();
        String month = _Mes.getText().toString();
        String year = _Year.getText().toString();
        String Mail = _Mail.getText().toString();

        int Day = 0;
        int Mes = 0;
        int Year = 0;

        if (day.length()!= 0){
            Day = Integer.parseInt(day);
        }
        if (month.length() != 0){
            Mes = Integer.parseInt(month);
        }
        if (year.length() != 0){
            Year = Integer.parseInt(year);
        }

        if (Name.length() != 0){
            if (Count.length() != 0){
                if (Day>0 & Day<32){
                    if (Mes>0 & Mes<13){
                        if (Year>0 & Year<2019){
                            if (Mail.length() != 0){
                                Toast.makeText(this,"Todo completado",Toast.LENGTH_LONG).show();
                                Calendar fecha = Calendar.getInstance();
                                int anno = fecha.get(Calendar.YEAR);
                                int mes = fecha.get(Calendar.MONTH) + 1;
                                int edad = anno - Year;

                                if (mes<Mes){
                                    edad = edad - 1;
                                }
                                String signo = Zoodiac(Year);

                                Intent sig = new Intent(this,Ejercicio_1_act_2.class);
                                sig.putExtra("Nombre",Name);
                                sig.putExtra("Num_cuenta",Count);
                                sig.putExtra("Mail",Mail);
                                sig.putExtra("Edad",String.valueOf(edad));
                                sig.putExtra("Horoscopo",signo);
                                startActivity(sig);
                            }
                            else {
                                Toast.makeText(this,"Inserte correo",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(this,"Error en el año",Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(this,"Error en el mes",Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(this,"Error en el día",Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(this,"Inserte numero de cuenta",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,"Inserte Nombre",Toast.LENGTH_LONG).show();
        }
    }
}
