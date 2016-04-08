package com.gaadi.sfa.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
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
import com.gaadi.sfa.utils.AppPrefrences;
import com.gaadi.sfa.utils.Logger;
import com.gaadi.sfa.utils.Utils;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kanishroshan on 28/1/16.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener, Validator.ValidationListener {

    private static final String TAG = "LoginActivity.java";

    @Required(order = 1, messageResId = R.string.error_email_required)
    @Email(order = 2, minLength = 8, messageResId = R.string.error_customer_email_invalid)
    private EditText emailid;

    @Required(order = 3, messageResId = R.string.error_password_required)
    private EditText password;

    private Button signin;
    private Context context;
    private ProgressDialog mProgressDialog;
    View view1, view2;
    private Validator mValidator;

    public static class AllLower implements InputFilter {
        public CharSequence filter(CharSequence source, int start, int end,
                                   Spanned dest, int dstart, int dend) {
            for (int i = start; i < end; i++) {
                if (Character.isUpperCase(source.charAt(i))) {
                    char[] v = new char[end - start];
                    TextUtils.getChars(source, start, end, v, 0);
                    String s = new String(v).toLowerCase();

                    if (source instanceof Spanned) {
                        SpannableString sp = new SpannableString(s);
                        TextUtils.copySpansFrom((Spanned) source,
                                start, end, null, sp, 0);
                        return sp;
                    } else {
                        return s;
                    }
                }
            }
            return null; // keep original
        }
    }

    private void clearErrors() {
        emailid.setError(null);
        emailid.clearFocus();

        password.setError(null);
        password.clearFocus();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        emailid = (MaterialEditText) findViewById(R.id.user_email);
        password = (MaterialEditText) findViewById(R.id.user_password);
        signin = (Button) findViewById(R.id.sig_in);
        view1 = (View) findViewById(R.id.email_view);
        view2 = (View) findViewById(R.id.password_view);
        signin.setOnClickListener(this);

        emailid.setFilters(new InputFilter[]{new AllLower()});

        emailid.setOnFocusChangeListener(this);
        emailid.setOnClickListener(this);
        password.setOnClickListener(this);
        password.setOnFocusChangeListener(this);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sig_in:
                clearErrors();
                mValidator.validate();
                break;
            case R.id.user_email:
                changeVisibility(view1, View.VISIBLE);
                break;
            case R.id.user_password:
                changeVisibility(view1, View.VISIBLE);
        }
    }

    public void onResetPassword(View view) {
        startActivity(new Intent(this, ForgotPassword.class));
    }

    private void loginNow() {
        String email = emailid.getText().toString();
        String pass = password.getText().toString();

        login(email, pass);
    }

    private void changeVisibility(View view, int state) {
        view.setVisibility(state);
    }

    private void login(final String email, final String password) {

        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_DARK);
        }
        mProgressDialog.setMessage("Verifying...");
        mProgressDialog.setCancelable(false);

        if (!this.isFinishing() && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }

        RetrofitRequest.getLoginResponse(email, password, new Callback<BaseResponseModel>() {
            @Override
            public void success(BaseResponseModel loginResponseModel, Response response) {

                if (mProgressDialog != null && mProgressDialog.isShowing())
                    mProgressDialog.dismiss();

                Logger.e(TAG, loginResponseModel.toString());

                if (loginResponseModel.isResultSuccess()) {
                    loginResponseModel.getLoginData().setEmail(email);
                    loginResponseModel.getLoginData().setPassword(password);

                    AppPrefrences.saveLoginResult(getApplicationContext(), loginResponseModel);

                    startActivity(new Intent(LoginActivity.this, LandingDboard.class));

                    LoginActivity.this.finish();
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
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.hasFocus() == true) {
            changeVisibility(view1, View.VISIBLE);
        }
    }

    @Override
    public void onValidationSucceeded() {
        loginNow();
    }

    @Override
    public void onValidationFailed(View failedView, Rule<?> failedRule) {

        Logger.e(TAG, "failed rule: " + failedRule.getFailureMessage());

        if (failedView instanceof EditText) {

            if (failedView.getId() == emailid.getId())
                changeVisibility(view1, View.GONE);
            else
                changeVisibility(view2, View.GONE);

            failedView.requestFocus();
            Toast.makeText(getApplicationContext(), failedRule.getFailureMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onViewValidationSucceeded(View succeededView) {
    }
}
