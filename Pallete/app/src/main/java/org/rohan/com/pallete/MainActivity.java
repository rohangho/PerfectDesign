package org.rohan.com.pallete;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;

public class MainActivity extends AppCompatActivity {

  //  ImageView smapler;
    CardView backcolor;
    FloatingActionButton fab;
    CardView buttonBacktoCustomize;
    CardView buttonBacktoQuickBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   //     smapler=(ImageView) findViewById(R.id.sampleImg);
        backcolor=(CardView) findViewById(R.id.cardToTest);
        fab=(FloatingActionButton) findViewById(R.id.sampler);
        buttonBacktoCustomize=(CardView) findViewById(R.id.buttonPanelforCustomize);
        buttonBacktoQuickBuy=(CardView) findViewById(R.id.buttonPanelforQuickbuy);
        fab.setImageResource(R.drawable.a2);

        final Bitmap bitmap=((BitmapDrawable)fab.getDrawable()).getBitmap();

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                colorSetting(palette.getVibrantSwatch());
            }
        });
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                buttonBackground(palette.getLightMutedSwatch());
            }
        });


    }

    private void buttonBackground(Palette.Swatch mutedSwatch ) {
        buttonBacktoCustomize.setCardBackgroundColor(mutedSwatch.getRgb());
        buttonBacktoQuickBuy.setCardBackgroundColor(mutedSwatch.getRgb());
    }

    private void colorSetting(Palette.Swatch vibrantSwatch) {

        backcolor.setCardBackgroundColor(vibrantSwatch.getRgb());
    }
}
