package shaden.anfal.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Auto extends AppCompatActivity  implements View.OnClickListener{
    private Button[][]buttons = new Button[3][3];
    private Button []b= new Button[9];
    private boolean player1Turn = true;

    private int roundCount;

    private int player1points;
    private int player2points;

    private TextView textViewplayer1;
    private TextView textViewplayer2;
        View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        auto();


        textViewplayer1 = findViewById(R.id.p1);

        textViewplayer2 = findViewById(R.id.p2);

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                String buttonID = "b"+i+j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j]= findViewById(resID);
                 buttons[i][j].setOnClickListener(this);
            }
        }


        Button buttonReset = findViewById(R.id.restart);
        buttonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        Button back = (Button)findViewById(R.id.back);


    }//end

    public void back(View view) {
        Intent intent1=new Intent(Auto.this, MainActivity.class) ;
        startActivity(intent1);

    }



    @Override
    public void onClick(View v) {


        if(!((Button)v).getText().toString().equals("")){
            return;
        }
        if(player1Turn){
            ((Button)v).setText("X");
        }else{

        auto();

        //  b[y].setText("O");
         // ((Button)v).setText("O");
        }
        roundCount++;

        //
        if(checkForWin()){
            if(player1Turn){
                player1wins();
            }else{
                player2wins();
            }
        } else if (roundCount==9){
            draw();
        }

        else {
            player1Turn=!player1Turn;

        }
    }

   //---------------------------------------
    private boolean checkForWin(){
        String[][]field = new String[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                field[i][j]=buttons[i][j].getText().toString();

            }
        }
        for(int i=0;i<3;i++)
        {
            if(field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    &&!field[i][0].equals("")){
                return true;
            }
        }

        for(int i=0;i<3;i++)
        {
            if(field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    &&!field[0][i].equals("")){
                return true;
            }
        }

        if(field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                &&!field[0][0].equals("")) {
            return true;
        }

        if(field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                &&!field[0][2].equals("")) {
            return true;
        }
        return false;
    }
    private void player1wins() {
        player1points++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        updatePointText();
        resetBoard();
    }

    private void player2wins() {
        player2points++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        updatePointText();
        resetBoard();
    }

    private void draw(){
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointText(){
        textViewplayer1.setText("player 1: "+ player1points);
        textViewplayer2.setText("player 2: "+ player2points);
    }

    private void resetBoard(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }

        roundCount=0;
        player1Turn=true;
    }

    private void resetGame() {
        player1points = 0;
        player2points = 0;
        updatePointText();
        resetBoard();
    }

    {

    }
   private void auto() {
          Random x = new Random();
            int y = 1 + x.nextInt(9);
           switch(y)
            {
                case 1:
                    if(buttons[0][0].getText().toString().equals(""))
                    { buttons[0][0].setText("O"); }
                        else{auto();}
              break;
                case 2:
                    if(buttons[0][1].getText().toString().equals(""))
                    { buttons[0][1].setText("O");}
                    else{auto();}
                    break;
                case 3:
                    if(buttons[0][2].getText().toString().equals(""))
                    { buttons[0][2].setText("O");}
                    else{auto();}
                    break;
                case 4:
                    if(buttons[1][0].getText().toString().equals(""))
                    { buttons[1][0].setText("O");}
                    else{auto();}
                break;
                case 5:
                    if(buttons[1][1].getText().toString().equals(""))
                    { buttons[1][1].setText("O");}
                    else{auto();}
                    break;
                case 6:
                    if(buttons[1][2].getText().toString().equals(""))
                    { buttons[1][2].setText("O");}
                    else{auto();}
                    break;
                case 7:
                    if(buttons[2][0].getText().toString().equals(""))
                    { buttons[2][0].setText("O");}
                    else{auto();}
                    break;
                case 8:
                    if(buttons[2][1].getText().toString().equals(""))
                    { buttons[2][1].setText("O");}
                    else{auto();}
                    break;
                case 9:
                    if(buttons[2][2].getText().toString().equals(""))
                    { buttons[2][2].setText("O");}
                    else{auto();}
                    break;
            }


    }
}
