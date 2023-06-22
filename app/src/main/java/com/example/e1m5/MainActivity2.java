package com.example.e1m5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewFragment;
import android.widget.TextView;

import com.example.e1m5.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;
    TextView url_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle data= getIntent().getExtras();
        String url_value= data.getString("target");
        FragmentWeb fragment = FragmentWeb.newInstance(url_value);
        replaceFragment(fragment);
    }

    private void replaceFragment(FragmentWeb fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentWebView, fragment);
        transaction.commit();
    }
}