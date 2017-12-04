package by.shatunov.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String USERNAME = "by.shatunov.helloandroid.USERNAME";

    private EditText usernameEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);

        sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GreetingActivity.class);
                String username = usernameEditText.getText().toString();
                if (!username.trim().isEmpty()) {
                    intent.putExtra(USERNAME, username);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, R.string.emptyNameError, Toast.LENGTH_SHORT).show();
                }
            }
        });

        usernameEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    sendButton.callOnClick();
                }
                return true;
            }
        });
    }
}
