package com.essentialappsfm.testapp;


import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback
{
    private static final String TAG = "FergusPreview tag";
    private SurfaceHolder myHold;
    private Camera theCamera;

    public CameraPreview(Context context, Camera camera)
    {
        super(context);
        theCamera = camera;
        myHold = getHolder();
        myHold.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        try {
            theCamera.setPreviewDisplay(holder);
            theCamera.startPreview();
        }
        catch(IOException e){
            Log.d(TAG, "Error setting camera preview: " + e.getMessage());
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0)
    {
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3)
    {
    }
}
