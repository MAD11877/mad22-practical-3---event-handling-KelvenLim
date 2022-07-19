package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String tag = "button pressed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User myUser = new User("john", "abc", 123, false);

        // Follow button
        Button myFollowButton = findViewById(R.id.followButton);
        myFollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView followText = findViewById(R.id.followButton);

                if (myUser.isFollowed() == false){
                    myUser.setFollowed(true);
                    followText.setText("Unfollow");
                    Toast toast = Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    myUser.setFollowed(false);
                    followText.setText("Follow");
                }

                Log.v(tag, String.valueOf(myUser.isFollowed()));
            }
        });

        // View ListActivity page
        Button nextPage = findViewById(R.id.nextPage);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ListActivity.class);
                Log.v(tag, "Next Page");
                startActivity((myIntent));
            }
        }
        );

        // Message button
        Button messageButton = findViewById(R.id.messageButton);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MessageGroup.class);
                Log.v(tag, "Message Page");
                startActivity((myIntent));
            }
        });

        Intent receivingEnd = getIntent();
        String newMessage = receivingEnd.getStringExtra("Message");
        TextView helloWorld = findViewById(R.id.helloWorld);
        helloWorld.setText(newMessage);
    }
}