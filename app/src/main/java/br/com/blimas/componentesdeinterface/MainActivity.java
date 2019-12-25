package br.com.blimas.componentesdeinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButtonLembrarSenha;
    private Switch switchLembrarSenha;
    private CheckBox checkBoxLembrarSenha;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switchLembrarSenha = findViewById(R.id.switch_lembrar_senha);
        toggleButtonLembrarSenha = findViewById(R.id.toggleButton_lembrar_senha);
        checkBoxLembrarSenha = findViewById(R.id.checkBox_lembrar_senha);
        resultado = findViewById(R.id.text_resultado);

    }


    public void enviar (View view){

        if (switchLembrarSenha.isChecked()){
            resultado.setText("Switch ligado");
        }else{
            resultado.setText("Switch desligado");
        }

//        if (toggleButtonLembrarSenha.isChecked()){
//            resultado.setText("Toggle ligado");
//        }else{
//            resultado.setText("Toggle desligado");
//        }

//        if (checkBoxLembrarSenha.isChecked()){
//            resultado.setText("Checkbox ligado");
//        }else{
//            resultado.setText("Checkbox desligado");
//        }

    }

    public void abrirToast(View view){
        if (switchLembrarSenha.isChecked()){
            Toast.makeText(this, "Ligado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Desligado", Toast.LENGTH_SHORT).show();
        }
    }


    public void abrirAlerta(View view){

        //cria um alert dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //configura titulo do alerta e mensagem
        dialog.setTitle("Confirmar escolha");
        dialog.setMessage("Deseja lembrar sua senha?");

        //configura cancelamento
        dialog.setCancelable(false);

        //configura icone
        dialog.setIcon(android.R.drawable.ic_dialog_info);

        //configura acoes para botao (sim ou nao)
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Aceito sua escolha", Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Voce vai esquecer sua senha", Toast.LENGTH_LONG).show();
            }
        });

        //criar e exibir alerta
        dialog.create();
        dialog.show();
    }
}
