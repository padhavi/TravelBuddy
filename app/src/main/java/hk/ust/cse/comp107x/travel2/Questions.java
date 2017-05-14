package hk.ust.cse.comp107x.travel2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Questions extends AppCompatActivity {
    private int id;
    private DatabaseReference mDatabase;
    Button submitbtn;
    private String uid, currentUserName,currentuserchoice;
    private TextView txt, userNameTextView;
    private FirebaseAuth auth;

    public static ArrayList<String>  choice=new ArrayList<>();

    CheckBox cb,cb1,cb2,cb3;
    ArrayList<String> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);




        mDatabase= FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();
        uid=auth.getCurrentUser().getUid();

        list = new ArrayList<String>();

        submitbtn=(Button)findViewById(R.id.registerbutton);
        userNameTextView=(TextView)findViewById(R.id.name);
        CheckBox cb=(CheckBox)findViewById(R.id.checkBox);
        CheckBox cb1=(CheckBox)findViewById(R.id.checkBox2);
        CheckBox cb2=(CheckBox)findViewById(R.id.checkBox3);
        CheckBox cb3=(CheckBox)findViewById(R.id.checkBox4);
        txt = (TextView)findViewById(R.id.text);


        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText("food");

                choice.add(txt.getText().toString());
            }
        });

        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(choice+"movies");
                choice.add(txt.getText().toString());
            }
        });


        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(choice+"Art");
                choice.add(txt.getText().toString());
            }
        });

        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setText(choice+"NightClub");
                choice.add(txt.getText().toString());
            }
        });


        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object

                mDatabase= FirebaseDatabase.getInstance().getReference();
                String name = userNameTextView.getText().toString().trim();
                String choice=txt.getText().toString().trim();


                userchoice form = new userchoice();

                //Adding values
                form.setName(name);
                form.settxt(choice);


                mDatabase.child("Choice").setValue(form);

                Intent j = new Intent(Questions.this, time.class);
                j.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(j);


            }
        });




    }


}
