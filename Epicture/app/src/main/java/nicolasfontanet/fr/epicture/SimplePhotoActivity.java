package nicolasfontanet.fr.epicture;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class SimplePhotoActivity extends AppCompatActivity
{
    private TextView _nameImage;
    private ImageView _photo;
    private Button _favori;
    private Intent _pageGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_photo);
        _photo = (ImageView) findViewById(R.id.simplePhoto);
        _nameImage = (TextView) findViewById(R.id.textImage);
        _favori = (Button) findViewById(R.id.btn_favori);
        _favori.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

            }
        });
        _pageGallery = getIntent();


        // Mise à jour du TextView.
        if (_nameImage != null)
        {
            String name = "Nom de l'image : " + _pageGallery.getStringExtra("NameImage") + ".";
            Log.i("NameImage", name);
            _nameImage.setText(name);
        }

        // Mise à jour de l'image.
        if (_photo != null)
        {
            String resource = _pageGallery.getStringExtra("ResourceImage");
            Log.i("RessourceImage", resource);
            Resources res = getResources();
            int resID = res.getIdentifier(resource , "drawable", getPackageName());
            _photo.setImageResource(resID);
            Picasso.with(getBaseContext()).load(resource).into(_photo);
        }
    }
}
