package org.rohan.com.pallete;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  //  ImageView smapler;
    CardView backcolor;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   //     smapler=(ImageView) findViewById(R.id.sampleImg);
        backcolor=(CardView) findViewById(R.id.cardToTest);
        fab=(FloatingActionButton) findViewById(R.id.sampler);
        fab.setImageResource(R.drawable.a2);

        Bitmap bitmap=((BitmapDrawable)fab.getDrawable()).getBitmap();

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                colorSetting(palette.getVibrantSwatch());
            }
        });


    }

    private void colorSetting(Palette.Swatch mutedSwatch) {

        backcolor.setCardBackgroundColor(mutedSwatch.getRgb());
    }
}
