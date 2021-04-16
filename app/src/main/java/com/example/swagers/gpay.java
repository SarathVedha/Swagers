package com.example.swagers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gpay extends AppCompatActivity {

    public static final String GPay_Package_Name = "com.google.android.apps.nbu.paisa.user";
    private EditText Amount_send;
    private Button Pay;
    private String payerName,noteMsg,UpiId,amount_send,status;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpay);

        Amount_send = findViewById(R.id.amountet);
        Pay = findViewById(R.id.tnsButton);

        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                amount_send = Amount_send.getText().toString();
                noteMsg = "Test";
                UpiId = "xxxxxxxx@okhdfcbank";
                payerName = "Vedha";

                if (amount_send.isEmpty()){
                    Toast.makeText(gpay.this, " Amount Not Entered ", Toast.LENGTH_SHORT).show();
                }else {
                    uri = getUpiPaymentUri(payerName, UpiId, noteMsg, amount_send);
                    payWithGpay(GPay_Package_Name);
                }
            }
        });

    }

    private static Uri getUpiPaymentUri (String name, String upiId, String note, String amount){
        return new Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa",upiId)
                .appendQueryParameter("pn",name)
                .appendQueryParameter("tn",note)
                .appendQueryParameter("am",amount)
                .appendQueryParameter("cu","INR")
                .build();

    }

    private void payWithGpay (String packageName){

        if (isAppInstalled(this,packageName)) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(packageName);
            startActivityForResult(intent, 0);
        }else {
            Toast.makeText(this," GPay not installed in your Device ",Toast.LENGTH_SHORT).show();
        }

    }

    public void onActivityResult(int requestCode, int resultCode , Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if (data!= null){
            status = data.getStringExtra("status");
        }
        if ((RESULT_OK == resultCode ) && status.equals("success")){
            Toast.makeText(this," Transaction Successful.. ",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this," Transaction Cancelled or Failed Try again ",Toast.LENGTH_SHORT).show();
        }

    }

    public static boolean isAppInstalled (Context context,String packageName){

        try {
            context.getPackageManager().getApplicationInfo(packageName,0);
            return true;
        }catch (PackageManager.NameNotFoundException e){
            return false;
        }
    }

}