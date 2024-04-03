package com.example.week4;

import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox check1, check2;
    RadioGroup rGroup1;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);

        check1.setOnCheckedChangeListener(mCheckListener);
        check2.setOnCheckedChangeListener(mCheckListener);

        imageView1 = (ImageView) findViewById(R.id.imageView);
//        imageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView1.setScaleType(ImageView.ScaleType.MATRIX);
        imageView1.setImageResource(R.drawable.junguk);

        // 크기를 자유자재로(가로세로 20% 줄어듦)
        Matrix matrix = imageView1.getImageMatrix();
        float scale = 0.2f;
        matrix.setScale(scale, scale);
        imageView1.setImageMatrix(matrix);

        rGroup1 = (RadioGroup) findViewById(R.id.rgroup1);
        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                StringBuilder mStr = new StringBuilder();

                if(checkedId == R.id.man)
                    mStr.append("MAN selected");
                else
                    mStr.append("WOMAN selected");

                Toast.makeText(getApplicationContext(), mStr, Toast.LENGTH_SHORT).show();

            }
        });
    }


    CompoundButton.OnCheckedChangeListener mCheckListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            StringBuilder mStr = new StringBuilder(); // 뒤에 append됨, String은 안됨

            if(buttonView.getId() == R.id.checkBox1)
                mStr.append(check1.getText().toString());
            else
                mStr.append(check2.getText().toString());

            if(isChecked)
                mStr.append(" checked");
            else
                mStr.append(" unchecked");

            Toast.makeText(getApplicationContext(), mStr, Toast.LENGTH_SHORT).show();
        }
    };
}

