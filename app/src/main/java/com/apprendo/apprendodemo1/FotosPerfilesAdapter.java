package com.apprendo.apprendodemo1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class FotosPerfilesAdapter extends PagerAdapter {

    private final Context contexto;

    public FotosPerfilesAdapter(Context c){
        contexto = c;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LinearLayout linearLayout = new LinearLayout(contexto);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final ImageView image = new ImageView(contexto);
        if(position==0)
            image.setImageResource(R.drawable.maestra);
        if(position==1)
            image.setImageResource(R.drawable.maestro);

        linearLayout.addView(image);

        container.addView(linearLayout,0);

        return linearLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

}
