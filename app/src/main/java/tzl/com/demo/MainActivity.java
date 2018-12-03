package tzl.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import tzl.com.sub1.Sub1Activity;
import tzl.com.sub2.Sub2Activity;
import tzl.com.understandcomponent.R;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener mViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.jump1:
                    jump1();
                    break;
                case R.id.jump2:
                    jump2();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.jump1).setOnClickListener(mViewOnClickListener);
        findViewById(R.id.jump2).setOnClickListener(mViewOnClickListener);
    }



    public void jump1() {
        startActivity(new Intent(MainActivity.this,Sub1Activity.class));
    }

    public void jump2() {
        startActivity(new Intent(MainActivity.this,Sub2Activity.class));
    }
}
