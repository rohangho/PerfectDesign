package org.rohan.com.pallete2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;

public class MainActivity extends AppCompatActivity {


    CardView backcolor;
    CardView backcolor2;
    FloatingActionButton fab;
    FloatingActionButton fab2;
    CardView buttonBacktoCustomize;
    CardView buttonBacktoQuickBuy;
    CardView buttonBacktoCustomize2nd;
    CardView buttonBacktoQuickBuy2nd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backcolor=(CardView) findViewById(R.id.cardToTest);
        backcolor2=(CardView) findViewById(R.id.cardToTest2nd);
        fab=(FloatingActionButton) findViewById(R.id.sampler);
        fab2=(FloatingActionButton) findViewById(R.id.samplerright);
        buttonBacktoCustomize=(CardView) findViewById(R.id.buttonPanelforCustomize);
        buttonBacktoQuickBuy=(CardView) findViewById(R.id.buttonPanelforQuickbuy);
        buttonBacktoCustomize2nd=(CardView) findViewById(R.id.buttonPanelforCustomizefor2nd);
        buttonBacktoQuickBuy2nd=(CardView)findViewById(R.id.buttonPanelforQuickbuyfoe2nd);


        fab.setImageResource(R.drawable.a2);
        fab2.setImageResource(R.drawable.a1);

        final Bitmap bitmap=((BitmapDrawable)fab.getDrawable()).getBitmap();
        final Bitmap bitmap1=((BitmapDrawable) fab2.getDrawable()).getBitmap();

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                colorSetting(palette.getVibrantSwatch(),palette.getLightMutedSwatch());
            }
        });
        Palette.from(bitmap1).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                buttonBackground(palette.getVibrantSwatch(),palette.getLightMutedSwatch());

            }
        });


    }

    private void buttonBackground(Palette.Swatch vibrantSwatch,Palette.Swatch mutedSwatch ) {
        backcolor2.setCardBackgroundColor(vibrantSwatch.getRgb());
        buttonBacktoCustomize2nd.setCardBackgroundColor(mutedSwatch.getRgb());
        buttonBacktoQuickBuy2nd.setCardBackgroundColor(mutedSwatch.getRgb());

    }

    private void colorSetting(Palette.Swatch vibrantSwatch,Palette.Swatch mutedSwatch) {

        backcolor.setCardBackgroundColor(vibrantSwatch.getRgb());
        buttonBacktoCustomize.setCardBackgroundColor(mutedSwatch.getRgb());
        buttonBacktoQuickBuy.setCardBackgroundColor(mutedSwatch.getRgb());
    }
}
