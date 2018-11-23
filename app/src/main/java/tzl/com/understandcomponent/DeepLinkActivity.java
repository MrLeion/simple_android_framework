package tzl.com.understandcomponent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import tzl.com.annotation.Test;


/**
 * [scheme]://[host]/[path]?[query]"
 */
@Test
public class DeepLinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);
        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        Uri uri = intent.getData();
        String url = uri.toString();

        if ("app://tzl.com.understandcomponent/haha".equals(url)) {
            Toast.makeText(this,         uri.getPath(), Toast.LENGTH_LONG).show();
        }
    }
}
