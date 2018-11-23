package tzl.com.understandcomponent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import tzl.com.annotation.Test;

@Test
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("app://tzl.com.understandcomponent/haha"));
            startActivity(intent);
        } catch (Exception e) {
        }
//        try {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("taobao://"));
//            startActivity(intent);
//        } catch (Exception e) {
//        }

    }




}
