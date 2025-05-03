package com.kakutools.kaku;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.kakutools.kaku.Ocr.OcrResult;
import com.kakutools.kaku.Windows.InformationWindow;
import com.kakutools.kaku.Windows.InstantKanjiWindow;
import com.kakutools.kaku.Windows.WindowCoordinator;

/**
 * Created by 0xbad1d3a5 on 4/15/2016.
 */
public class MainServiceHandler extends Handler {

    private static final String TAG = MainServiceHandler.class.getName();

    private MainService mKakuService;
    private WindowCoordinator mWindowCoordinator;

    public MainServiceHandler(MainService mainService, WindowCoordinator windowCoordinator)
    {
        mKakuService = mainService;
        mWindowCoordinator = windowCoordinator;
    }

    @Override
    public void handleMessage(Message message)
    {
        if (message.obj instanceof String){
            Toast.makeText(mKakuService, message.obj.toString(), Toast.LENGTH_SHORT).show();
        }
        else if (message.obj instanceof OcrResult)
        {
            OcrResult result = (OcrResult) message.obj;

            Log.d(TAG, result.toString());

            if (result.getDisplayData().getInstantMode())
            {
                InstantKanjiWindow instantKanjiWindow = mWindowCoordinator.getWindowOfType(Constants.WINDOW_INSTANT_KANJI);
                instantKanjiWindow.setResult(result.getDisplayData());
                instantKanjiWindow.show();
            }
            else {
                InformationWindow infoWindow = mWindowCoordinator.getWindowOfType(Constants.WINDOW_INFO);
                infoWindow.setResult(result.getDisplayData());
                infoWindow.show();
            }
        }
        else {
            Toast.makeText(mKakuService, String.format("Unable to handle type: %s", message.obj.getClass().getName()), Toast.LENGTH_SHORT).show();
        }
    }
}