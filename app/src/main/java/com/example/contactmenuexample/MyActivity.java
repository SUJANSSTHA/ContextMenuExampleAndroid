package com.example.contactmenuexample;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyActivity extends AppCompatActivity {
    EditText editfirstnumber, editSecondNumber;
    Button btnCalculate;
    TextView textResult;


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        editfirstnumber = findViewById(R.id.editfirstnumber);
        editSecondNumber = findViewById(R.id.editSecondNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        textResult = findViewById(R.id.textResult);
        registerForContextMenu(btnCalculate);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.my_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        float firstNumber,secondNumber,result;
        firstNumber = Float.valueOf(editfirstnumber.getText().toString());
        secondNumber = Float.valueOf(editSecondNumber.getText().toString());

        if(item.getItemId()==R.id.mnuAdd){
            result = firstNumber + secondNumber;

        }else if(item.getItemId()==R.id.mnuSub){
            result = firstNumber - secondNumber;

        }else if(item.getItemId()==R.id.mnuDiv){
            result = firstNumber / secondNumber;

        }else if(item.getItemId()==R.id.mnuMul){
            result = firstNumber * secondNumber;

        }else{
            result = 0;
        }
        textResult.setText(String.valueOf(result));
        return super.onContextItemSelected(item);
    }
}
