package com.klinker.android.twitter_l.ui.launcher_page;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.klinker.android.twitter_l.R;
import com.klinker.android.twitter_l.ui.MainActivityPopup;

public class LauncherPopup extends MainActivityPopup {

    @Override
    public void setDim() {
        // Params for the window.
        // You can easily set the alpha and the dim behind the window from here
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 1.0f;
        params.dimAmount = .75f;  // set it higher if you want to dim behind the window

        getWindow().setAttributes(params);
    }

    @Override
    public void setLauncherPage() {
        mViewPager.setCurrentItem(getIntent().getIntExtra("launcher_page", 0));

        LinearLayout drawer = (LinearLayout) findViewById(R.id.left_drawer);
        drawer.setVisibility(View.GONE);
    }

    @Override
    public Intent getRestartIntent() {
        Intent restart = new Intent(context, LauncherPopup.class);
        restart.putExtra("launcher_page", getIntent().getIntExtra("launcher_page", 0));
        restart.putExtra("from_launcher", true);
        return restart;
    }
}