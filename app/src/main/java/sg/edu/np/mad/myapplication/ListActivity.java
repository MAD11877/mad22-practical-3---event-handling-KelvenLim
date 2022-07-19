package sg.edu.np.mad.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    String tag = "Image clicked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        View myImage = findViewById(R.id.imageView2);

        myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(tag, "image clicked");
                clickImage();
            }
        });
    }

    private void clickImage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int integer = randomInteger();
                Bundle extras = new Bundle();
                extras.putString("Message", "MAD " + integer);
                Intent myIntent2 = new Intent(ListActivity.this, MainActivity.class);
                myIntent2.putExtras(extras);
                startActivity((myIntent2));
            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }

    private int randomInteger(){
        Random ran = new Random();
        return ran.nextInt(999999);
    }
}