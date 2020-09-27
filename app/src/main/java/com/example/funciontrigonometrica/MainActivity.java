package com.example.funciontrigonometrica;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    // Vamos a establecer la funcion principal que llamará que interfaz use utilize
    // al iniciar la aplicación.
    public int funcionOperacion = 0;
    public int gradoSeleccionado = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);
    }

    public void ActualizarResultado(){
        TextView calculores = findViewById( R.id.calculores );
        if( gradoSeleccionado != 0 ) {
            double CalculoFinal = 0.f;
            switch (funcionOperacion) {
                case 0:
                    CalculoFinal = Math.sin( gradoSeleccionado );
                    break;
                case 1:
                    CalculoFinal = Math.cos( gradoSeleccionado );
                    break;
                case 2:
                    CalculoFinal = Math.tan( gradoSeleccionado );
                    break;
                default:
                    break;
            }
            calculores.setText( Double.toString(CalculoFinal) );
        }
    }

    // Encarga de escoger cual metodo utilizamos para calcular despues el tipo de función.
    public void SeleccionarFuncion(View view){
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radiobutton was pressed
        String str = "";
        switch( view.getId() )
        {
            case R.id.buttonsin:
                if(checked)
                    funcionOperacion = 0;
                break;
            case R.id.buttoncos:
                if(checked)
                    funcionOperacion = 1;
                break;
            case R.id.buttontan:
                if(checked)
                    funcionOperacion = 2;
                break;
            default:
                break;
        }
        ActualizarResultado();
    }

    public void SeleccionarGrado(View view){
        boolean checked = ((RadioButton) view).isChecked();
        ImageView MuestraImagen = findViewById( R.id.MuestraImagen );
        switch( view.getId() ) {
            case R.id.Grad45:
                if (checked) {
                    gradoSeleccionado = 45;
                    MuestraImagen.setImageResource(R.drawable.grado_45);
                }
                break;
            case R.id.Grad90:
                if (checked) {
                    gradoSeleccionado = 90;
                    MuestraImagen.setImageResource(R.drawable.grado_90);
                }
                break;
            case R.id.Grad180:
                if (checked) {
                    gradoSeleccionado = 180;
                    MuestraImagen.setImageResource(R.drawable.grado_180);
                }
                break;
            default:
                break;
        }
        ActualizarResultado();
    }
}
