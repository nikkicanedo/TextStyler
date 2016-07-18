package com.nikkay.canedo.textstyler;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView tvOutput;
    CheckBox bold;
    CheckBox italic;
    RadioButton red;
    RadioButton green;
    RadioButton blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText);
        tvOutput = (TextView) findViewById(R.id.textView);
        bold = (CheckBox) findViewById(R.id.cbBold);
        italic = (CheckBox) findViewById(R.id.cbItalic);
        red = (RadioButton) findViewById(R.id.rbtnRed);
        green = (RadioButton) findViewById(R.id.rbtnGreen);
        blue = (RadioButton) findViewById(R.id.rbtnBlue);

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvOutput.setText(et1.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                tvOutput.setText(et1.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                tvOutput.setText(et1.getText().toString());
            }
        });

    }

    public void selectColor(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rbtnRed:
                if(checked)
                {
                    tvOutput.setTextColor(Color.RED);
                    break;
                }

            case R.id.rbtnGreen:
                if(checked)
                {
                    tvOutput.setTextColor(Color.GREEN);
                    break;
                }
            case R.id.rbtnBlue:
                if(checked)
                {
                    tvOutput.setTextColor(Color.BLUE);
                    break;
                }
        }
    }

    public void selectStyle(View view)
    {
        int uncheck = 1;

        //boolean checked = ((CheckBox) view).isChecked();

        if(bold.isChecked())
        {
            tvOutput.setTypeface(null, Typeface.BOLD);
            uncheck = 0;
        }

        if(uncheck == 1)
        {
            tvOutput.setTypeface(null, Typeface.NORMAL);
            uncheck = 0;
        }

        if(italic.isChecked())
        {
            tvOutput.setTypeface(null, Typeface.ITALIC);
        }

        if(bold.isChecked() && italic.isChecked())
        {
            tvOutput.setTypeface(null, Typeface.BOLD_ITALIC);
        }

    }


}
