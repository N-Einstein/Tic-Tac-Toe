package com.example.android.tic_tac_toe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.logging.Handler;


public class MainActivity extends ActionBarActivity {

    int player = 0;
    int s1 = 0, s2 = 0;
    TextView[] cells = new TextView[9];
    public void newgame()
    {
        player = s1 = s2 = 0;
        String out = "00";
        TextView p1 = (TextView) findViewById(R.id.score1);
        TextView p2 = (TextView) findViewById(R.id.score2);
        p1.setText(out);
        p2.setText(out);
        clear_board();
    }
   private void clear_board() {
        for (int i = 0; i < 9; i ++)
        {
            cells[i].setText("");
        }
    }
    private void check_winner(int turn) {
        if((cells[0].getText() == cells[1].getText() && cells[0].getText() == cells[2].getText() && cells[0].getText() != "")      ||
                (cells[3].getText() == cells[4].getText() && cells[3].getText() == cells[5].getText() && cells[3].getText() != "") ||
                (cells[6].getText() == cells[7].getText() && cells[7].getText() == cells[8].getText() && cells[6].getText() != "") ||
                (cells[0].getText() == cells[4].getText() && cells[4].getText() == cells[8].getText() && cells[0].getText() != "") ||
                (cells[2].getText() == cells[4].getText() && cells[2].getText() == cells[6].getText() && cells[2].getText() != "") ||
                (cells[0].getText() == cells[3].getText() && cells[3].getText() == cells[6].getText() && cells[0].getText() != "") ||
                (cells[1].getText() == cells[4].getText() && cells[1].getText() == cells[7].getText() && cells[7].getText() != "") ||
                (cells[2].getText() == cells[5].getText() && cells[8].getText() == cells[5].getText() && cells[5].getText() != "")   )
        {
            String out = "";
            if(turn == 0) {
                TextView p1 = (TextView) findViewById(R.id.score1);
                out += ++s1;
                p1.setText(out);
                //Toast.makeText(MainActivity.this, "Player 1", Toast.LENGTH_SHORT).show();
            }
            else {
                TextView p2 = (TextView) findViewById(R.id.score2);
                out += ++s2;
                p2.setText(out);
               // Toast.makeText(MainActivity.this, "Player 2", Toast.LENGTH_SHORT).show();

            }
            clear_board();
        }
        else if(cells[0].getText() != "" && cells[1].getText() != "" &&cells[2].getText() != ""&&cells[3].getText() != "" &&cells[4].getText() != ""
                &&cells[5].getText() != ""&&cells[6].getText() != ""&&cells[7].getText() != ""&&cells[8].getText() != ""){
            Toast.makeText(MainActivity.this, "Draw", Toast.LENGTH_SHORT).show();
            clear_board();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.new_game);
        dialog.setTitle(R.string.let);
        Button OK = (Button) (dialog.findViewById(R.id.ok));
        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText play1 = (EditText) dialog.findViewById(R.id.X);
                EditText play2 = (EditText) dialog.findViewById(R.id.O);
                Boolean wantToCloseDialog1 = (play1.getText().toString().trim().isEmpty() || play2.getText().toString().trim().isEmpty());
                String playx = play1.getText().toString();
                String playo = play2.getText().toString();

                TextView px = (TextView) findViewById(R.id.name1);
                px.setText(playx.trim());
                TextView po = (TextView) findViewById(R.id.name2);
                po.setText(playo.trim());
               if(!wantToCloseDialog1)
                   dialog.dismiss();
               /* Log.v("MainActivity","YES");
                else
                    Log.v("MainActivity","NO");*/


            }
        });
        Button can = (Button) (dialog.findViewById(R.id.cancel));
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


        cells[0] = (TextView) findViewById(R.id.b0);
        cells[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[0].getText() == "") {
                    if (player == 0)
                        cells[0].setText("X");
                    else
                        cells[0].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        cells[1] = (TextView) findViewById(R.id.b1);
        cells[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[1].getText() == "") {
                    if (player == 0)
                        cells[1].setText("X");
                    else
                        cells[1].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        cells[2] = (TextView) findViewById(R.id.b2);
        cells[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[2].getText() == "") {
                    if (player == 0)
                        cells[2].setText("X");
                    else
                        cells[2].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        cells[3] = (TextView) findViewById(R.id.b3);
        cells[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[3].getText() == "") {
                    if (player == 0)
                        cells[3].setText("X");
                    else
                        cells[3].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        cells[4] = (TextView) findViewById(R.id.b4);
        cells[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[4].getText() == "") {
                    if (player == 0)
                        cells[4].setText("X");
                    else
                        cells[4].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        cells[5] = (TextView) findViewById(R.id.b5);
        cells[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[5].getText() == "") {
                    if (player == 0)
                        cells[5].setText("X");
                    else
                        cells[5].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        cells[6] = (TextView) findViewById(R.id.b6);
        cells[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[6].getText() == "") {
                    if (player == 0)
                        cells[6].setText("X");
                    else
                        cells[6].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        cells[7] = (TextView) findViewById(R.id.b7);
        cells[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[7].getText() == "") {
                    if (player == 0)
                        cells[7].setText("X");
                    else
                        cells[7].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        cells[8] = (TextView) findViewById(R.id.b8);
        cells[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cells[8].getText() == "") {
                    if (player == 0)
                        cells[8].setText("X");
                    else
                        cells[8].setText("O");
                    check_winner(player);
                    player = player ^ 1;
                }
            }
        });
        final Button newGame = (Button) findViewById(R.id.newgame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.new_game);
                dialog.setTitle(R.string.let);
                Button OK = (Button) (dialog.findViewById(R.id.ok));
                OK.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        EditText play1 = (EditText) dialog.findViewById(R.id.X);
                        EditText play2 = (EditText) dialog.findViewById(R.id.O);
                        Boolean wantToCloseDialog = (play1.getText().toString().trim().isEmpty() || play2.getText().toString().trim().isEmpty());

                        if (!wantToCloseDialog){
                        String playx = play1.getText().toString();
                        String playo = play2.getText().toString();
                        TextView px = (TextView) findViewById(R.id.name1);
                        px.setText(playx.trim());
                        TextView po = (TextView) findViewById(R.id.name2);
                        po.setText(playo.trim());
                        dialog.dismiss();
                        newgame();}

                    }
                });
                Button can = (Button) (dialog.findViewById(R.id.cancel));
                can.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            dialog.dismiss();
                    }
                });
                //dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

            }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
