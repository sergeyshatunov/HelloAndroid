package by.shatunov.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    TextView greetingTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        Intent intent = getIntent();
        String username = getApplicationContext().getString(R.string.greetingText, intent.getStringExtra(MainActivity.USERNAME));

        greetingTextView = findViewById(R.id.greetingText);
        greetingTextView.setText(username);
    }
}
