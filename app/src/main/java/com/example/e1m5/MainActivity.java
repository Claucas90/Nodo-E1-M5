package com.example.e1m5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e1m5.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Button btn;
    private EditText url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        btn= binding.button;
        url= binding.urlText;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url1 = binding.urlText.getText().toString().trim();

                if (!url1.isEmpty()) {
                    if (!url1.startsWith("http://") && (!url1.startsWith("https://"))) {
                        url1 = "https://" + url1;
                        binding.urlText.setText(url1);
                        Toast.makeText(MainActivity.this, "Agregamos http", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("target", url.getText().toString());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "debe ingresar direccion web", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
