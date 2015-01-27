package com.beasty.transitionold;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class DetailActivity extends ActionBarActivity {

    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_AVATAR_URL = "extra_avatar";

    private String title;
    private String avatarUrl;

    private TextView titleView;
    private ImageView coverView;
    private ScrollView scrollView;
    private int primaryDark;
    private int accent;
    private int accentLight;
    private TextView contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(EXTRA_TITLE);
            avatarUrl = intent.getStringExtra(EXTRA_AVATAR_URL);
        }

        mapUi();
        initValue();
    }

    private void mapUi() {
        titleView = ((TextView) findViewById(R.id.tv_detail_title));
        contentView = ((TextView) findViewById(R.id.tv_detail_content));
        coverView = ((ImageView) findViewById(R.id.iv_detail_cover));
        scrollView = ((ScrollView) findViewById(R.id.sv_detail_scroll));

        primaryDark = getResources().getColor(R.color.theme_default_primary_dark);
        accent = getResources().getColor(R.color.theme_default_accent);
        accentLight = getResources().getColor(R.color.theme_default_accent_light);

    }

    private void initValue() {
        titleView.setText(title);
        contentView.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        if ((avatarUrl != null) && !avatarUrl.equals("")) {
            Picasso.with(getBaseContext()).load(avatarUrl)
                    .into(imageLoaded);
        }
    }

    private Target imageLoaded = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            Palette palette = Palette.generate(bitmap);

            coverView.setImageBitmap(bitmap);

            scrollView.setBackgroundColor(palette.getDarkMutedColor(primaryDark));
            titleView.setTextColor(palette.getVibrantColor(accent));
            contentView.setTextColor(palette.getLightVibrantColor(accentLight));
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            scrollView.setBackgroundColor(primaryDark);
            titleView.setBackgroundColor(accent);
            contentView.setBackgroundColor(accentLight);
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

}
