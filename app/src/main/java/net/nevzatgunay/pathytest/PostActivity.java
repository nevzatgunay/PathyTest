package net.nevzatgunay.pathytest;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Nevzat on 5/21/2017.
 *
 */

public class PostActivity extends AppCompatActivity {
    private static final String TAG = "PostActivity";

    @InjectView(R.id.input_from)EditText input_from;
    @InjectView(R.id.input_to) EditText input_to;
    @InjectView(R.id.input_date) EditText input_date;
    @InjectView(R.id.input_time) EditText input_time;
    @InjectView(R.id.input_price)EditText input_price;
    @InjectView(R.id.btn_post) Button btn_post;

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        ButterKnife.inject(this);
/*
        dateView = (EditText) findViewById(R.id.input_date);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post();
            }
        });

        */

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    public void post() {
        Log.d(TAG, "Post");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        btn_post.setEnabled(false);

        // TODO: Implement your own post logic here.



        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                    }
                }, 3000);

    }

    public void onSignupSuccess() {
        btn_post.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Post failed", Toast.LENGTH_LONG).show();

        btn_post.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String from = input_from.getText().toString();
        String to = input_to.getText().toString();
        String date = input_date.getText().toString();
        String time = input_time.getText().toString();
        String price = input_price.getText().toString();

        if (from.isEmpty() || from.length() < 3) {
            input_from.setError("at least 3 characters");
            valid = false;
        } else {
            input_from.setError(null);
        }

        if (to.isEmpty() || to.length() < 3) {
            input_to.setError("at least 3 characters");
            valid = false;
        } else {
            input_to.setError(null);
        }

        if (date.isEmpty() || date.length() < 11) {
            input_date.setError("it must be date format");
            valid = false;
        } else {
            input_date.setError(null);
        }

        if (time.isEmpty() || time.length() < 6) {
            input_time.setError("it must be time format");
            valid = false;
        } else {
            input_time.setError(null);
        }

        if (price.isEmpty() || price.length() < 1) {
            input_price.setError("it must be time format");
            valid = false;
        } else {
            input_price.setError(null);
        }

        return valid;

    }

}
