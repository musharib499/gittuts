package com.gaadi.sfa.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gaadi.sfa.ApplicationController;
import com.gaadi.sfa.R;
import com.gaadi.sfa.annotations.Email;
import com.gaadi.sfa.annotations.Required;
import com.gaadi.sfa.annotations.rules.Rule;
import com.gaadi.sfa.annotations.rules.Validator;
import com.gaadi.sfa.materialedittext.MaterialEditText;
import com.gaadi.sfa.model.BaseResponseModel;
import com.gaadi.sfa.retrofit.RetrofitRequest;
import com.gaadi.sfa.utils.Logger;
import com.gaadi.sfa.utils.Utils;

import java.util.regex.Pattern;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kanishroshan on 10/2/16.
 */
public class ResetPassword extends AppCompatActivity implements Validator.ValidationListener{

    @Required(order = 1, messageResId = R.string.error_email_required)
    @Email(order = 2, minLength = 8, messageResId = R.string.error_customer_email_invalid)
    private EditText emailid;

    @Required(order = 3, messageResId = R.string.error_password_required)
    private EditText password;

    @Required(order = 4, messageResId = R.string.error_confirm_password_required)
    private EditText confirm_password;

    @Required(order = 5, messageResId = R.string.error_otp_required)
    @Email(order = 6, minLength = 4, messageResId = R.string.error_invalid_otp)
    private EditText otpEditText;

    private static final String TAG = "ForgotPassword";
    private ProgressDialog mProgressDialog;

    private Validator mValidator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resetpassword);
        emailid=(MaterialEditText)findViewById(R.id.user_email);
        password=(MaterialEditText)findViewById(R.id.user_password);
        confirm_password=(MaterialEditText)findViewById(R.id.confirm_password);
        otpEditText=(MaterialEditText)findViewById(R.id.otp);

        emailid.setFilters(new InputFilter[]{new LoginActivity.AllLower()});

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }

    public void onResetPassword(View view){
        validateAndRequest();
    }

    private void validateAndRequest() {
        String email=emailid.getText().toString();
        String pass=password.getText().toString();
        String confirmPass=confirm_password.getText().toString();
        String otp=otpEditText.getText().toString();

        if(!pass.equals(confirmPass)){
            Toast.makeText(ResetPassword.this, R.string.error_password_confirm_password_mismatch,Toast.LENGTH_SHORT).show();
        }
        else{
            resetPassword(email, pass,otp);
        }
    }

    private void resetPassword(String email,String password,String otp) {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
        }
        mProgressDialog.setMessage("Verifying...");

        if (!this.isFinishing() && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }

        RetrofitRequest.resetPassword(email,password,otp, new Callback<BaseResponseModel>() {
            @Override
            public void success(BaseResponseModel loginResponseModel, Response response) {

                if (mProgressDialog != null && mProgressDialog.isShowing())
                    mProgressDialog.dismiss();

                Logger.e(TAG, loginResponseModel.toString());

                if (loginResponseModel.isResultSuccess()) {

                    Toast.makeText(ResetPassword.this,R.string.reset_password_successful,Toast.LENGTH_LONG).show();

                    ResetPassword.this.finish();
                } else {

                    Toast.makeText(ApplicationController.getInstance(),
                            loginResponseModel.getErrors().get(0), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void failure(RetrofitError error) {
                if (mProgressDialog != null && mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                error.printStackTrace();
                Utils.handleErrorToast(error);
            }
        });
    }

    @Override
    public void onValidationSucceeded() {
        validateAndRequest();
    }

    @Override
    public void onValidationFailed(View failedView, Rule<?> failedRule) {
        Logger.e(TAG, "failed rule: " + failedRule.getFailureMessage());

        if (failedView instanceof EditText) {

            failedView.requestFocus();
            Toast.makeText(getApplicationContext(), failedRule.getFailureMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onViewValidationSucceeded(View succeededView) {

    }
}
