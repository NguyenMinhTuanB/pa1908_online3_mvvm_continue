package com.example.mvvmexample;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class LoginViewModel extends BaseObservable {

    private User mUser;

    private String mSuccessMessage = "Login was successful";
    private String mErrorMessage = "Email or Password not valid";

    private String mToastMessage;

    @Bindable
    public String getToastMessage() {
        return mToastMessage;
    }

    public void setToastMessage(String toastMessage) {
        mToastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public void setUserEmail(String email) {
        mUser.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    public void setUserPassword(String password) {
        mUser.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel() {
        mUser = new User();
    }

    @Bindable
    public String getUserEmail() {
        return mUser.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return mUser.getPassword();
    }

    public void onLoginClicked() {
        if (isInputDataValid()) {
            setToastMessage(mSuccessMessage);
        } else {
            setToastMessage(mErrorMessage);
        }
    }

    private boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail())
                && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length() > 7;
    }
}
