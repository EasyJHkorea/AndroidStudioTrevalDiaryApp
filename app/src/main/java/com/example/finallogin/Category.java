package com.example.finallogin;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class Category extends AppCompatActivity {

    private ImageButton enter;
    private Button gender[],age[],city[],day[],money[],who[],type[];
    private Boolean check[];
    private int choice[];
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        enter=(ImageButton)findViewById(R.id.enter);

        gender = new Button[3];
        age = new Button[8];
        city = new Button[9];
        day = new Button[8];
        money = new Button[9];
        who = new Button[8];
        type = new Button[9];
        check = new Boolean[8];
        choice = new int[8];
        for(int i=0;i<8;i++)
        {
            check[i]=false;
            choice[i]=0;
        }

        gender[1]=(Button)findViewById(R.id.Men);
        gender[2]=(Button)findViewById(R.id.Woman);

        age[1]=(Button)findViewById(R.id.age1);
        age[2]=(Button)findViewById(R.id.age2);
        age[3]=(Button)findViewById(R.id.age3);
        age[4]=(Button)findViewById(R.id.age4);
        age[5]=(Button)findViewById(R.id.age5);
        age[6]=(Button)findViewById(R.id.age6);

        city[1]=(Button)findViewById(R.id.city1);
        city[2]=(Button)findViewById(R.id.city2);
        city[3]=(Button)findViewById(R.id.city3);
        city[4]=(Button)findViewById(R.id.city4);
        city[5]=(Button)findViewById(R.id.city5);
        city[6]=(Button)findViewById(R.id.city6);
        city[7]=(Button)findViewById(R.id.city7);

        day[1]=(Button)findViewById(R.id.day1);
        day[2]=(Button)findViewById(R.id.day2);
        day[3]=(Button)findViewById(R.id.day3);
        day[4]=(Button)findViewById(R.id.day4);

        money[1]=(Button)findViewById(R.id.money1);
        money[2] =(Button)findViewById(R.id.money2);
        money[3]=(Button)findViewById(R.id.money3);
        money[4]=(Button)findViewById(R.id.money4);
        money[5]=(Button)findViewById(R.id.money5);
        money[6]=(Button)findViewById(R.id.money6);
        money[7]=(Button)findViewById(R.id.money7);
        money[8]=(Button)findViewById(R.id.money8);

        who[1]=(Button)findViewById(R.id.who1);
        who[2]=(Button)findViewById(R.id.who2);
        who[3]=(Button)findViewById(R.id.who3);
        who[4]=(Button)findViewById(R.id.who4);
        who[5]=(Button)findViewById(R.id.who5);

        type[1]=(Button)findViewById(R.id.type1);
        type[2]=(Button)findViewById(R.id.type2);
        type[3]=(Button)findViewById(R.id.type3);
        type[4]=(Button)findViewById(R.id.type4);
        type[5]=(Button)findViewById(R.id.type5);
        type[6]=(Button)findViewById(R.id.type6);
        type[7]=(Button)findViewById(R.id.type7);
        type[8]=(Button)findViewById(R.id.type8);
    }

    public void aOnClick(View v){
        if(!check[0]){
            switch (v.getId()) {
                case R.id.Men:
                    gender[1].setBackgroundResource(R.color.Fink);
                    choice[0] = 1;
                    break;
                case R.id.Woman:
                    gender[2].setBackgroundResource(R.color.Fink);
                    choice[0] = 2;
                    break;
            }
            check[0]=true;
        }
        else
        {
            gender[choice[0]].setBackgroundResource(R.color.snow);
            switch (v.getId()) {
                case R.id.Men:
                    gender[1].setBackgroundResource(R.color.Fink);
                    choice[0] = 1;
                    break;
                case R.id.Woman:
                    gender[2].setBackgroundResource(R.color.Fink);
                    choice[0] = 2;
                    break;
            }
        }

    }
    public void bOnClick(View v){
        if(!check[1])
        {
            switch (v.getId()){
                case R.id.age1:
                    age[1].setBackgroundResource(R.color.Fink);
                    choice[1]=1;
                    break;
                case R.id.age2:
                    age[2].setBackgroundResource(R.color.Fink);
                    choice[1]=2;
                    break;
                case R.id.age3:
                    age[3].setBackgroundResource(R.color.Fink);
                    choice[1]=3;
                    break;
                case R.id.age4:
                    age[4].setBackgroundResource(R.color.Fink);
                    choice[1]=4;
                    break;
                case R.id.age5:
                    age[5].setBackgroundResource(R.color.Fink);
                    choice[1]=5;
                    break;
                case R.id.age6:
                    age[6].setBackgroundResource(R.color.Fink);
                    choice[1]=6;
                    break;
            }
            check[1]=true;
        }
        else{
            age[choice[1]].setBackgroundResource(R.color.snow);
            switch (v.getId()){
                case R.id.age1:
                    age[1].setBackgroundResource(R.color.Fink);
                    choice[1]=1;
                    break;
                case R.id.age2:
                    age[2].setBackgroundResource(R.color.Fink);
                    choice[1]=2;
                    break;
                case R.id.age3:
                    age[3].setBackgroundResource(R.color.Fink);
                    choice[1]=3;
                    break;
                case R.id.age4:
                    age[4].setBackgroundResource(R.color.Fink);
                    choice[1]=4;
                    break;
                case R.id.age5:
                    age[5].setBackgroundResource(R.color.Fink);
                    choice[1]=5;
                    break;
                case R.id.age6:
                    age[6].setBackgroundResource(R.color.Fink);
                    choice[1]=6;
                    break;
            }
        }
    }
    public void cOnClick(View v){
        if(!check[2])
        {
            switch (v.getId())
            {
                case R.id.city1:
                    city[1].setBackgroundResource(R.color.Fink);
                    choice[2]=1;
                    break;
                case R.id.city2:
                    city[2].setBackgroundResource(R.color.Fink);
                    choice[2]=2;
                    break;
                case R.id.city3:
                    city[3].setBackgroundResource(R.color.Fink);
                    choice[2]=3;
                    break;
                case R.id.city4:
                    city[4].setBackgroundResource(R.color.Fink);
                    choice[2]=4;
                    break;
                case R.id.city5:
                    city[5].setBackgroundResource(R.color.Fink);
                    choice[2]=5;
                    break;
                case R.id.city6:
                    city[6].setBackgroundResource(R.color.Fink);
                    choice[2]=6;
                    break;
                case R.id.city7:
                    city[7].setBackgroundResource(R.color.Fink);
                    choice[2]=7;
                    break;
            }
            check[2]=true;
        }
        else {
            city[choice[2]].setBackgroundResource(R.color.snow);
            switch (v.getId()) {
                case R.id.city1:
                    city[1].setBackgroundResource(R.color.Fink);
                    choice[2] = 1;
                    break;
                case R.id.city2:
                    city[2].setBackgroundResource(R.color.Fink);
                    choice[2] = 2;
                    break;
                case R.id.city3:
                    city[3].setBackgroundResource(R.color.Fink);
                    choice[2] = 3;
                    break;
                case R.id.city4:
                    city[4].setBackgroundResource(R.color.Fink);
                    choice[2] = 4;
                    break;
                case R.id.city5:
                    city[5].setBackgroundResource(R.color.Fink);
                    choice[2] = 5;
                    break;
                case R.id.city6:
                    city[6].setBackgroundResource(R.color.Fink);
                    choice[2] = 6;
                    break;
                case R.id.city7:
                    city[7].setBackgroundResource(R.color.Fink);
                    choice[2] = 7;
                    break;

            }
        }
    }

    public void dOnClick(View v) {
        if (!check[3])
        {
            switch (v.getId()) {
                case R.id.day1:
                    day[1].setBackgroundResource(R.color.Fink);
                    choice[3]=1;
                    break;

                case R.id.day2:
                    day[2].setBackgroundResource(R.color.Fink);
                    choice[3]=2;
                    break;

                case R.id.day3:
                    day[3].setBackgroundResource(R.color.Fink);
                    choice[3]=3;
                    break;

                case R.id.day4:
                    day[4].setBackgroundResource(R.color.Fink);
                    choice[3]=4;
                    break;
            }
            check[3]=true;
        }
        else
        {
            day[choice[3]].setBackgroundResource(R.color.snow);
            switch (v.getId()) {
                case R.id.day1:
                    day[1].setBackgroundResource(R.color.Fink);
                    choice[3] = 1;
                    break;

                case R.id.day2:
                    day[2].setBackgroundResource(R.color.Fink);
                    choice[3] = 2;
                    break;

                case R.id.day3:
                    day[3].setBackgroundResource(R.color.Fink);
                    choice[3] = 3;
                    break;

                case R.id.day4:
                    day[4].setBackgroundResource(R.color.Fink);
                    choice[3] = 4;
                    break;
            }
        }
    }

    public void eOnClick(View v) {
        if (!check[4]) {
            switch (v.getId()) {
                case R.id.money1:
                    money[1].setBackgroundResource(R.color.Fink);
                    choice[4]=1;
                    break;

                case R.id.money2:
                    money[2].setBackgroundResource(R.color.Fink);
                    choice[4]=2;
                    break;
                case R.id.money3:
                    money[3].setBackgroundResource(R.color.Fink);
                    choice[4]=3;
                    break;

                case R.id.money4:
                    money[4].setBackgroundResource(R.color.Fink);
                    choice[4]=4;
                    break;

                case R.id.money5:
                    money[5].setBackgroundResource(R.color.Fink);
                    choice[4]=5;
                    break;

                case R.id.money6:
                    money[6].setBackgroundResource(R.color.Fink);
                    choice[4]=6;
                    break;

                case R.id.money7:
                    money[7].setBackgroundResource(R.color.Fink);
                    choice[4]=7;
                    break;

                case R.id.money8:
                    money[8].setBackgroundResource(R.color.Fink);
                    choice[4]=8;
                    break;
            }
            check[4]=true;
        }
        else {
            money[choice[4]].setBackgroundResource(R.color.snow);
            switch (v.getId()) {
                case R.id.money1:
                    money[1].setBackgroundResource(R.color.Fink);
                    choice[4]=1;
                    break;

                case R.id.money2:
                    money[2].setBackgroundResource(R.color.Fink);
                    choice[4]=2;
                    break;
                case R.id.money3:
                    money[3].setBackgroundResource(R.color.Fink);
                    choice[4]=3;
                    break;

                case R.id.money4:
                    money[4].setBackgroundResource(R.color.Fink);
                    choice[4]=4;
                    break;

                case R.id.money5:
                    money[5].setBackgroundResource(R.color.Fink);
                    choice[4]=5;
                    break;

                case R.id.money6:
                    money[6].setBackgroundResource(R.color.Fink);
                    choice[4]=6;
                    break;

                case R.id.money7:
                    money[7].setBackgroundResource(R.color.Fink);
                    choice[4]=7;
                    break;

                case R.id.money8:
                    money[8].setBackgroundResource(R.color.Fink);
                    choice[4]=8;
                    break;
            }
        }
    }

    public void fOnClick(View v){
        if (!check[5])
        {
            switch (v.getId())
            {
                case R.id.who1:
                    who[1].setBackgroundResource(R.color.Fink);
                    choice[5]=1;
                    break;

                case R.id.who2:
                    who[2].setBackgroundResource(R.color.Fink);
                    choice[5]=2;
                    break;
                case R.id.who3:
                    who[3].setBackgroundResource(R.color.Fink);
                    choice[5]=3;
                    break;

                case R.id.who4:
                    who[4].setBackgroundResource(R.color.Fink);
                    choice[5]=4;
                    break;

                case R.id.who5:
                    who[5].setBackgroundResource(R.color.Fink);
                    choice[5]=5;
                    break;
            }
            check[5]=true;
        }
        else {
            who[choice[5]].setBackgroundResource(R.color.snow);
            switch (v.getId())
            {
                case R.id.who1:
                    who[1].setBackgroundResource(R.color.Fink);
                    choice[5]=1;
                    break;

                case R.id.who2:
                    who[2].setBackgroundResource(R.color.Fink);
                    choice[5]=2;
                    break;
                case R.id.who3:
                    who[3].setBackgroundResource(R.color.Fink);
                    choice[5]=3;
                    break;

                case R.id.who4:
                    who[4].setBackgroundResource(R.color.Fink);
                    choice[5]=4;
                    break;

                case R.id.who5:
                    who[5].setBackgroundResource(R.color.Fink);
                    choice[5]=5;
                    break;
            }
        }
    }

    public void gOnClick(View v) {
        if (!check[6]) {
            switch (v.getId()) {
                case R.id.type1:
                    type[1].setBackgroundResource(R.color.Fink);
                    choice[6]=1;
                    break;

                case R.id.type2:
                    type[2].setBackgroundResource(R.color.Fink);
                    choice[6]=2;
                    break;
                case R.id.type3:
                    type[3].setBackgroundResource(R.color.Fink);
                    choice[6]=3;
                    break;

                case R.id.type4:
                    type[4].setBackgroundResource(R.color.Fink);
                    choice[6]=4;
                    break;
                case R.id.type5:
                    type[5].setBackgroundResource(R.color.Fink);
                    choice[6]=5;
                    break;
                case R.id.type6:
                    type[6].setBackgroundResource(R.color.Fink);
                    choice[6]=6;
                    break;
                case R.id.type7:
                    type[7].setBackgroundResource(R.color.Fink);
                    choice[6]=7;
                    break;
                case R.id.type8:
                    type[8].setBackgroundResource(R.color.Fink);
                    choice[6]=8;
                    break;
            }
            check[6]=true;
        }

        else {
            type[choice[6]].setBackgroundResource(R.color.snow);
            switch (v.getId()) {
                case R.id.type1:
                    type[1].setBackgroundResource(R.color.Fink);
                    choice[6]=1;
                    break;

                case R.id.type2:
                    type[2].setBackgroundResource(R.color.Fink);
                    choice[6]=2;
                    break;
                case R.id.type3:
                    type[3].setBackgroundResource(R.color.Fink);
                    choice[6]=3;
                    break;

                case R.id.type4:
                    type[4].setBackgroundResource(R.color.Fink);
                    choice[6]=4;
                    break;
                case R.id.type5:
                    type[5].setBackgroundResource(R.color.Fink);
                    choice[6]=5;
                    break;
                case R.id.type6:
                    type[6].setBackgroundResource(R.color.Fink);
                    choice[6]=6;
                    break;
                case R.id.type7:
                    type[7].setBackgroundResource(R.color.Fink);
                    choice[6]=7;
                    break;
                case R.id.type8:
                    type[8].setBackgroundResource(R.color.Fink);
                    choice[6]=8;
                    break;
            }
        }
    }
    Boolean complete = true;
    public void enter(View v){
        for (int i = 0; i < 7; i++) {
            if (!check[i]) {
                Toast.makeText(this, "카테고리를 모두 선택해주세요", Toast.LENGTH_LONG).show();
                complete = false;
                break;
            }
        }

        if(complete) {

            Intent CategoryIntent = new Intent(this, Categorypost.class);
            CategoryIntent.putExtra("gender", choice[0]);
            CategoryIntent.putExtra("age", choice[1]);
            CategoryIntent.putExtra("city", choice[2]);
            CategoryIntent.putExtra("day", choice[3]);
            CategoryIntent.putExtra("money", choice[4]);
            CategoryIntent.putExtra("who", choice[5]);
            CategoryIntent.putExtra("type", choice[6]);
            startActivity(CategoryIntent);
            finish();
        }
        complete=true;

    }

    protected void onStop(){
        super.onStop();
        if (dialog!=null){
            dialog.dismiss();
            dialog=null;
        }
    }
}
