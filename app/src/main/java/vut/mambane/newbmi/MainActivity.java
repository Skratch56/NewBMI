package vut.mambane.newbmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtHeight;
    private RadioButton rdoFirst, rdoSecond, rdoThird, rdoFourth, rdoFifth;
    private TextView txtCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHeight = (EditText) findViewById(R.id.height);
        txtCounter = (TextView) findViewById(R.id.timer);
        rdoFirst = (RadioButton) findViewById(R.id.first);
        rdoSecond = (RadioButton) findViewById(R.id.second);
        rdoThird = (RadioButton) findViewById(R.id.third);
        rdoFourth = (RadioButton) findViewById(R.id.fourth);
        rdoFifth = (RadioButton) findViewById(R.id.fifth);
    }


    public void OnClick(View view) {
        double weight = 0, height, bmi;
       try{
           height = Double.parseDouble(edtHeight.getText().toString());
           if (rdoFirst.isChecked()) {
               weight = 50;
           } else if (rdoSecond.isChecked()) {
               weight = 60;
           } else if (rdoThird.isChecked()) {
               weight = 70;
           } else if (rdoFourth.isChecked()) {
               weight = 85;
           } else if (rdoFifth.isChecked()) {
               weight = 100;
           }bmi = calcBMI(weight, height);

           Toast.makeText(this,"The BMI is " + bmi,Toast.LENGTH_LONG).show();
       }catch (Exception ex){
           Toast.makeText(this,"Enter the height in meters",Toast.LENGTH_LONG).show();
       }


    }

    public double calcBMI(double weight, double height) {
        return weight / (height * height);
    }

}
