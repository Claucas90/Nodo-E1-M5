package com.example.e1m5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentWeb#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentWeb extends Fragment {
    private static final String ARG_URL = "url";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    private String url;

    public FragmentWeb() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FragmentWeb newInstance(String url) {
        FragmentWeb fragment = new FragmentWeb();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web, container, false);
        WebView webView = view.findViewById(R.id.web_show);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        // Inflate the layout for this fragment
        return view;
    }
}