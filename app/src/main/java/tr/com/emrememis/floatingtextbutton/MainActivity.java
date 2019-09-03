package tr.com.emrememis.floatingtextbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import tr.com.emrememis.library.FloatingTextButton;

public class MainActivity extends AppCompatActivity implements FloatingTextButton.FloatingTextButtonClickListener {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingTextButton floatingTextButton = findViewById(R.id.floatingTextButton);
        floatingTextButton.setCallback(this);
    }

    @Override
    public void clicked() {
        Log.d(TAG,"clicked");
    }
}
