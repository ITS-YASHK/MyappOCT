package com.example.myappoct;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText phone;
    EditText password;
    EditText confirm_password;
    CheckBox box;

    Button create_accountButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        phone = findViewById(R.id.phone_no);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        box = findViewById(R.id.box);
        create_accountButton = findViewById(R.id.create_accountButton);


        create_accountButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (username.getText().toString().equals("yash") && password.getText().toString().equals("1234")) {
//                    Toast.makeText(MainActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "UnSuccessful", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });



        @Override
        public void onClick(View v) {
            checkCredentials();
        }
    });

//        VewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//        v.isetPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//        return insets;
//    });

    }
    private void checkCredentials() {
        String inputusername=username.getText().toString();
        String inputmail_id=phone.getText().toString();
        String inputemt_password=password.getText().toString();
        String inputconfirm_password=confirm_password.getText().toString();
        boolean right=box.isChecked();
        if(inputusername.isEmpty()){
            showError(username,"Enter username");
        } else if (phone.length()!=10) {
            showError(phone,"Phone No is not valid");
        } else if (inputemt_password.isEmpty()) {
            showError(password,"Enter password");

        } else if (inputconfirm_password.isEmpty() || !inputconfirm_password.equals(inputemt_password)) {
            showError(confirm_password,"Password did not match");

        } else if (!right) {
            Toast.makeText(this, "Accept terms and conditions", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show();
        }
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}
