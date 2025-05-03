package com.kakutools.kaku.Windows.Views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by 0xbad1d3a5 on 1/10/2017.
 */

@SuppressLint("AppCompatCustomView")
public class ChoiceEditText extends EditText
{
    public interface InputDoneListener
    {
        void onEditTextInputDone(String input);
    }

    private static final String TAG = ChoiceEditText.class.getName();

    private InputMethodManager mImeManager;
    private InputDoneListener mCallback;

    public ChoiceEditText(Context context)
    {
        super(context);
        Init(context);
    }

    public ChoiceEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        Init(context);
    }

    public ChoiceEditText(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        Init(context);
    }

    public ChoiceEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        Init(context);
    }

    private void Init(Context context)
    {
        mImeManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        showKeyboard();
    }

    public void showKeyboard()
    {
        post(new Runnable() {
            @Override
            public void run() {
                requestFocus();
                mImeManager.showSoftInput(ChoiceEditText.this, InputMethodManager.SHOW_FORCED);
            }
        });
    }

    public void setInputDoneCallback(InputDoneListener callback)
    {
        mCallback = callback;
    }

    @Override
    public void onEditorAction(int actionCode)
    {
        if (actionCode == EditorInfo.IME_ACTION_DONE){
            if (mCallback != null){
                mImeManager.hideSoftInputFromWindow(getWindowToken(), 0);
                mCallback.onEditTextInputDone(getText().toString());
            }
        }
        super.onEditorAction(actionCode);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            if (mCallback != null){
                mImeManager.hideSoftInputFromWindow(getWindowToken(), 0);
                mCallback.onEditTextInputDone(getText().toString());
            }
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
