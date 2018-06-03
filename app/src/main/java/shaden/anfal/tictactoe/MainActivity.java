package shaden.anfal.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Button one = (Button)findViewById(R.id.b1);

        //Button tow = (Button)findViewById(R.id.b2);


    }


    public void two_players(View view) {
        Intent intent1=new Intent(MainActivity.this, Main2Activity.class) ;
        startActivity(intent1);

    }

    public void one_players(View view) {
        Intent intent2=new Intent(MainActivity.this, Auto.class) ;
        startActivity(intent2);
    }

}
