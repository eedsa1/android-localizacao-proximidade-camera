package com.eric.aula_ufc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtMark;
    private Button btnMark;
    private FragmentManager fm;
    MapsFragment frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMark = (EditText)findViewById(R.id.edtMarcacao);
        btnMark = (Button)findViewById(R.id.btnMark);

        fm = getSupportFragmentManager();

        frag = new MapsFragment();

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frmMap, frag, "MapsFragment1");
        ft.commitAllowingStateLoss();
    }

    public void marcarMapa(View v){
        frag.markMap(edtMark.getText().toString());
    }
}
