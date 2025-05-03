package com.fuwafuwa.kaku.Windows.Views;

import android.content.Context;
import androidx.core.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.fuwafuwa.kaku.Windows.Interfaces.WindowListener;

/**
 * Created by 0xbad1d3a5 on 4/13/2016.
 */
public class WindowView extends RelativeLayout
{
    private WindowListener mWindowListener;
    private GestureDetectorCompat mDetector;

    public WindowView(Context context)
    {
        super(context);
    }

    public WindowView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public WindowView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public void setWindowListener(WindowListener windowListener)
    {
        mWindowListener = windowListener;
    }

    public void setDetector(GestureDetectorCompat detector)
    {
        mDetector = detector;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e)
    {
        if (mDetector.onTouchEvent(e))
        {
            return true;
        }

        return mWindowListener.onTouch(e);
    }
}
