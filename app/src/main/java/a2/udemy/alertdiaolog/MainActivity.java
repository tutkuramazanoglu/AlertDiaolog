package a2.udemy.alertdiaolog;
/*
*AlertDialog.Builder() method takes one parameter which is context.
* context shows where the dialog box create
*
* pop-up message
* Toast.makeText(context,text,duration).show();
*
* What is Context?
* Context keeps who related with whom, what is going on background.
* Otherwise it keeps situation.It has two type context
* 1-Activity Context is about to activity. ex:Multi-screen
* Sometimes we should reached general context in app. In this time we use this or MainActivity.this
* 2-App Context if situation about general app use getApplicationContext();
*
* What is this?
* It give a references for upperClass
* */
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //All three is correct.
        //Toast.makeText(MainActivity.this,"Data is saved",Toast.LENGTH_LONG).show();
        //Toast.makeText(this,"Data is saved",Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext,"Data is saved",Toast.LENGTH_LONG).show();
    }

    //create alert message
    public void pressSaveButton(View view){
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        //define alert message
        alert.setTitle("Save");
        alert.setMessage("Are you Sure");
        //first parameter is text and second parameter is click listener
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { //it shows what happen when user click yes button
                //toast
                Toast.makeText(MainActivity.this,"Data is saved",Toast.LENGTH_LONG).show();
                //Toast.makeText(this,"Data is saved",Toast.LENGTH_LONG).show();  --> it gives error because this gives references to onnCLickListener
                //Toast.makeText(getApplicationContext(),"Data is saved",Toast.LENGTH_LONG).show(); --> you can use like this because this about all app
            }
        });

        alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Data is not saved.",Toast.LENGTH_LONG).show();
            }
        });

        //show alert
        alert.show();
    }
}