package net.nevzatgunay.pathytest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.InjectView;

/**
 * Created by Nevzat on 3/25/2017.
 */

public class AccountCheckActivity extends AppCompatActivity {


    @InjectView(R.id.input_registration_password) EditText _registrationpasswordText;
    @InjectView(R.id.btn_submit) Button _submitButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountcheck);

        _submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    public void submit(){
        if (!validate()) {
            onSubmitFailed();
            return;
        }

        _submitButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(AccountCheckActivity.this,
                R.style.AppTheme_NoActionBar);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Verified...");
        progressDialog.show();

        String password = _registrationpasswordText.getText().toString();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSubmitSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);


    }

    public boolean validate() {
        boolean valid = true;

        String password = _registrationpasswordText.getText().toString();

        if (password.isEmpty() || password.length() != 6) {
            _registrationpasswordText.setError("password must be 6 characters");
            valid = false;
        } else {
            _registrationpasswordText.setError(null);
        }
        return valid;
    }

    public void onSubmitFailed(){
        Toast.makeText(getBaseContext(), "Registration failed", Toast.LENGTH_LONG).show();

        _submitButton.setEnabled(true);
    }

    public void onSubmitSuccess(){
        _submitButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
        startActivity(new Intent(this,LoginActivity.class));
    }
}
