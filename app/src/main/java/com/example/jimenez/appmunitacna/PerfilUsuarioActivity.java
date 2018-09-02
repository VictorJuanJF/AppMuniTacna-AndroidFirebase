package com.example.jimenez.appmunitacna;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jimenez.appmunitacna.objects.Global;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PerfilUsuarioActivity extends AppCompatActivity {


    @BindView(R.id.tvProfileName)
    TextView tvProfileName;
    @BindView(R.id.tvProfileCorreo)
    TextView tvProfileCorreo;
    @BindView(R.id.ivProfileUser)
    ImageView ivProfileUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeData();

    }

    private void initializeData() {
        tvProfileName.setText("" + Global.getGlobalNameUser().getDisplayName());
        tvProfileCorreo.setText("" + Global.getGlobalNameUser().getEmail());

            ivProfileUser.setImageResource(R.drawable.ic_star);

    }

}
