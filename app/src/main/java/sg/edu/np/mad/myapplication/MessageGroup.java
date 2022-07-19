package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageGroup extends AppCompatActivity {

    String tag = "Button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);

        TextView message = findViewById(R.id.grp1Text);
        ImageView image = findViewById(R.id.grp2View);

        image.setVisibility(image.INVISIBLE);
        message.setVisibility(message.INVISIBLE);

        // Group 1 button
        Button grpOne = findViewById(R.id.group1Button);
        grpOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(tag, "Group 1");
                image.setVisibility(image.INVISIBLE);
                message.setVisibility(message.VISIBLE);
            }
        });

        // Group 2 button
        Button grpTwo = findViewById(R.id.group2Button);
        grpTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(tag, "Group 2");
                image.setVisibility(image.VISIBLE);
                message.setVisibility(message.INVISIBLE);
            }
        });
    }
}