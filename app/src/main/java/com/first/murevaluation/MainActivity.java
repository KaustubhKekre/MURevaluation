package com.first.murevaluation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String message="",rev="",xe="";
    double p=0, r=0,x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayprice(double i){
        TextView price1=(TextView)findViewById(R.id.price);
        price1.setText("Rs "+i);
    }

    public void calculate(){

        p=r*500+x*50;
        displayprice(p);
    }
    public void calc(View view) {
        rev="";
        xe="";
        CheckBox rmc = (CheckBox) findViewById(R.id.rm);
        boolean rmc1 = rmc.isChecked();
        CheckBox rpc = (CheckBox) findViewById(R.id.rp);
        boolean rpc1 = rpc.isChecked();
        CheckBox rcc = (CheckBox) findViewById(R.id.rc);
        boolean rcc1 = rcc.isChecked();
        CheckBox rsc = (CheckBox) findViewById(R.id.rs);
        boolean rsc1 = rsc.isChecked();
        CheckBox rdc = (CheckBox) findViewById(R.id.rd);
        boolean rdc1 = rdc.isChecked();
        CheckBox rcsc = (CheckBox) findViewById(R.id.rcs);
        boolean rcsc1 = rcsc.isChecked();
        CheckBox xmc = (CheckBox) findViewById(R.id.xm);
        boolean xmc1 = xmc.isChecked();
        CheckBox xpc = (CheckBox) findViewById(R.id.xp);
        boolean xpc1 = xpc.isChecked();
        CheckBox xcc = (CheckBox) findViewById(R.id.xc);
        boolean xcc1 = xcc.isChecked();
        CheckBox xsc = (CheckBox) findViewById(R.id.xs);
        boolean xsc1 = xsc.isChecked();
        CheckBox xdc = (CheckBox) findViewById(R.id.xd);
        boolean xdc1 = xdc.isChecked();
        CheckBox xcsc = (CheckBox) findViewById(R.id.xcs);
        boolean xcsc1 = xcsc.isChecked();
        r = x = 0;

        if (rmc1 == true) {
            r++;
            rev = rev + "\n Applied Mathematics -2";
        }



        if(xmc1==true)
        {
            x++;
            xe=xe+"\n Applied Mathematics -2";
        }
        if(rpc1==true)
        {
            r++;
            rev=rev+"\n Applied Physics -2";
        }
        if(xpc1==true)
        {
            x++;
            xe=xe+"\n Applied Physics -2";
        }
        if(rcc1==true)
        {
            r++;
            rev=rev+"\n Applied Chemistry -2";
        }
        if(xcc1==true)
        {
            x++;
            xe=xe+"\n Applied Chemistry-2";
        }
        if(rsc1==true)
        {
            r++;
            rev=rev+"\n Structured Programming Approach";
        }
        if(xsc1==true)
        {
            x++;
            xe=xe+"\n Structured Programming Approach";
        }
        if(rdc1==true)
        {
            r++;
            rev=rev+"\n Engineering Drawing";
        }
        if(xdc1==true)
        {
            x++;
            xe=xe+"\n Engineering Drawing";
        }
        if(rcsc1==true)
        {
            r++;
            rev=rev+"\n Communication Skills";
        }
        if(xcsc1==true)
        {
            x++;
            xe=xe+"\n Communication Skills";
        }
        p=0;
        calculate();
    }
    public void pro(View view) {
        EditText fn = (EditText) findViewById(R.id.full);
        String fn1 = fn.getText().toString();
        EditText rn = (EditText) findViewById(R.id.roll);
        String rn1 = rn.getText().toString();
        EditText na = (EditText) findViewById(R.id.name);
        String na1 = na.getText().toString();
        message = "Dear Sir/Madam,\nMy name is " + fn1 + " and I am a student of " + na1 + ".My roll number is " + rn1 + " ." + "I would like to raise a request  for the following: \n1.Revaluation:" + rev + "\n2.Xerox: " + xe +  "\n\nI will be sending Rs " + p + " through DD.\nThank You\nRegards,\n" + fn1 + "\n" + rn1;
        if (fn1.equals("")||rn1.equals("")||na1.equals("")) {

            Toast.makeText(this, "Details field cannot be empty", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:examinationdepartment@mumbaiuniversity.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Request for Revaluation and Xerox");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }



}
