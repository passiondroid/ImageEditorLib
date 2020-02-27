package com.passiondroid.imageeditorlib;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.AnimRes;


public class AnimationHelper {
    public static void animate(Context context, View view, @AnimRes int anim, int visibility, Animation.AnimationListener animationListener)
    {
        if(view.getVisibility()!=visibility) {
            Animation animation = AnimationUtils.loadAnimation(context, anim);
            animation.setAnimationListener(animationListener);

            view.startAnimation(animation);
            view.setVisibility(visibility);
        }
    }
}
