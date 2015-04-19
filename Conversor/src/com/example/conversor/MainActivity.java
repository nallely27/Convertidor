package com.example.conversor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends Activity implements OnClickListener {
	
	
	EditText dollars;
	EditText euros;
	EditText cambio;
    	RadioButton dtoe;
    	RadioButton etod;
	Button convert;
	
	



    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        
        
        dollars = (EditText)this.findViewById(R.id.edtDolares);
        euros = (EditText)this.findViewById(R.id.edtEuros);
        cambio = (EditText)this.findViewById(R.id.etCambio);
        
        dtoe = (RadioButton)this.findViewById(R.id.rbDolarApeso);
        dtoe.setChecked(true);
        etod = (RadioButton)this.findViewById(R.id.rbPesoAdolar);
        
        convert = (Button)this.findViewById(R.id.btnConvertir);
       
        
        
      
        convert.setOnClickListener(this);
        dtoe.setOnClickListener(this);
        etod.setOnClickListener(this);
        
        
    }

	public void onClick(View v) {
		
		
		if (v == convert){
			if (dtoe.isChecked()) {
				convertDollarsToEuros();
			}
			if (etod.isChecked()) {
				convertEurosToDollars();
			}
		}
		
		
		if (v == dtoe){
			etod.setChecked(false);
		}
		
		if (v == etod){
			dtoe.setChecked(false);
		}
		
	}
	

	
	protected void convertDollarsToEuros() {
		
		double val;
		double tmp;
		
		
		if ("".equals(dollars.getText().toString())){
			val = 0;
		}
		else{
			val = Double.parseDouble(dollars.getText().toString());
		}
		
		if ("".equals(cambio.getText().toString())){
			tmp = 0;
		}
		else{
			tmp = Double.parseDouble(cambio.getText().toString());
		}
		
		
		euros.setText(Double.toString(val* tmp));
	}
	
	
	protected void convertEurosToDollars() {
		
		double val;
		double tmp;
		
		
		if ("".equals(euros.getText().toString())){
			val = 0;
		}
		else{
			val = Double.parseDouble(euros.getText().toString());
		}
		
		if ("".equals(cambio.getText().toString())){
			tmp = 0;
		}
		else{
			tmp = Double.parseDouble(cambio.getText().toString());
		}
		
		
		
		dollars.setText(Double.toString(val/tmp));
	}
}