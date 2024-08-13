package com.example.signuplogin;



import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class playActivity extends AppCompatActivity {
    int currentQuetsion=0;
    String[] question_list ={"Number of primitive data types in Java are ?",
            "What is the size of float and double in java ?",
            "Automatic type conversion is possible in which of the possible cases ?",
            "Which of the following is not a Java features ?",
            " _____ is used to find and fix bugs in the Java programs ?",
            "What is the return type of the hashCode() method in the Object class ?",
            "Which package contains the Random class ?",
            "An interface with no fields or methods is known as a ______ ?",





    };
    String[] choose_list ={"6","7","8","9",
            "32 and 64","32 and 32","64 and 64","64 and 32",
            "Byte to Int","Int to long","Long to Int","Short to Int",
            "Dynamic","Architecture Neutral","Use of pointers","Object-oriented",
            "JVM","JRE","JDK","JDB",
            "Object","int","long","void",
            "java.util package","java.lang package","java.awt package","java.io package",
            "Runnable Interface","Marker Interface","Abstract Interface","CharSequence Interface",
            "","","",
            "","","",
    };
    String[] correct_list={"8","32 and 32","Int to long","Use of pointers","JDB","int","java.util package","Marker Interface"};
    TextView cpt_question, text_question,text_ans_show,txt_count;
    Button btn_choose1,btn_choose2,btn_choose3,btn_choose4,btn_next;

    boolean isclickBtn= false;
    String valuechoose ="";
    Button btn_click;
    String TAG="values";
    String str;
    int count=0;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        text_question=findViewById(R.id.text_question);
        cpt_question=findViewById(R.id.cpt_question);
        btn_choose1=findViewById(R.id.btn_choose1);
        btn_choose2=findViewById(R.id.btn_choose2);
        btn_choose3=findViewById(R.id.btn_choose3);
        btn_choose4=findViewById(R.id.btn_choose4);
        btn_next=findViewById(R.id.btn_next);
        text_ans_show=findViewById(R.id.text_ans_show);
        txt_count=findViewById(R.id.txt_count);

        findViewById(R.id.image_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isclickBtn){
                    isclickBtn = false;
                    if (!valuechoose.equals(correct_list[currentQuetsion])) {
                        //Log.d(TAG, "value:" + valuechoose);
                        //Log.d(TAG, "list_value:" + correct_list[currentQuetsion]);
                        //Log.d(TAG, "Q_no:" +currentQuetsion);
                        Toast.makeText(playActivity.this, "incorrect", Toast.LENGTH_SHORT).show();
                        btn_click.setBackgroundResource(R.drawable.background_btn_error);
                        text_ans_show.setText("Ans: " +correct_list[currentQuetsion]);
                        if (count>=1) {
                            count--;
                        }
                        txt_count.setText(""+count);
                    } else {
                        Toast.makeText(playActivity.this, "correct", Toast.LENGTH_SHORT).show();
                        btn_click.setBackgroundResource(R.drawable.background_btn_correct);
                        text_ans_show.setText("");
                        count++;
                        txt_count.setText(""+count);

                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (currentQuetsion!=question_list.length-1){
                                currentQuetsion = currentQuetsion + 1;
                                reimplementData();
                                valuechoose="";
                                btn_choose1.setBackgroundResource(R.drawable.background_btn_lay_colour);
                                btn_choose2.setBackgroundResource(R.drawable.background_btn_lay_colour);
                                btn_choose3.setBackgroundResource(R.drawable.background_btn_lay_colour);
                                btn_choose4.setBackgroundResource(R.drawable.background_btn_lay_colour);

                            }else {
                                Toast.makeText(playActivity.this,"SCORE:"+count,Toast.LENGTH_LONG).show();
                                finish();
                            }

                        }
                    },1000);




                }else {

                    Toast.makeText(playActivity.this,"choose any options",Toast.LENGTH_LONG).show();
                }
            }
        });
        reimplementData();

    }

    void reimplementData(){
        cpt_question.setText((currentQuetsion+1) +"/" + question_list.length);
        text_question.setText(question_list[currentQuetsion]);
        btn_choose1.setText(choose_list[4 * currentQuetsion]);
        btn_choose2.setText(choose_list[4 * currentQuetsion+1]);
        btn_choose3.setText(choose_list[4 * currentQuetsion+2]);
        btn_choose4.setText(choose_list[4 * currentQuetsion+3]);

    }


    public void ClickChoose(View view) {
        btn_click = (Button) view;
        if(isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_lay_colour);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_lay_colour);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_lay_colour);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_lay_colour);

            chooseBtn();
        }else {
            //Toast.makeText(playActivity.this,"choose any options",Toast.LENGTH_LONG).show();

            chooseBtn();
        }
    }
    void chooseBtn(){

        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valuechoose=btn_click.getText().toString();
    }
}