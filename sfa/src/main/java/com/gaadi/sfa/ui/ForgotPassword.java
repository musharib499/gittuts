package com.gaadi.sfa.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
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

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kanishroshan on 10/2/16.
 */
public class ForgotPassword extends AppCompatActivity implements Validator.ValidationListener {
    private static final String TAG = "ForgotPassword";

    @Required(order = 1, messageResId = R.string.error_email_required)
    @Email(order = 2, minLength = 8, messageResId = R.string.error_customer_email_invalid)
    private EditText emailid;

    private Validator mValidator;

    private ProgressDialog mProgressDialog;

    private void clearErrors() {
        emailid.setError(null);
        emailid.clearFocus();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpassword);
        emailid=(MaterialEditText)findViewById(R.id.user_email);

        emailid.setFilters(new InputFilter[]{new LoginActivity.AllLower()});

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }

    public void onResetPassword(View view){
        mValidator.validate();
    }

    private void requestReset() {
        String email=emailid.getText().toString();

        forgotPassword(email);
    }

    private void forgotPassword(String email) {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
        }
        mProgressDialog.setMessage("Verifying...");

        if (!this.isFinishing() && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }

        RetrofitRequest.forgotPassword(email, new Callback<BaseResponseModel>() {
            @Override
            public void success(BaseResponseModel loginResponseModel, Response response) {

                if (mProgressDialog != null && mProgressDialog.isShowing())
                    mProgressDialog.dismiss();

                Logger.e(TAG, loginResponseModel.toString());

                if (loginResponseModel.isResultSuccess()) {

                    Toast.makeText(ForgotPassword.this,R.string.reset_email_sent,Toast.LENGTH_LONG).show();

                    startActivity(new Intent(ForgotPassword.this, ResetPassword.class));

                    ForgotPassword.this.finish();
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
        requestReset();
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
