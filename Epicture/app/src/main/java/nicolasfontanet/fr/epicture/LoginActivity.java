package nicolasfontanet.fr.epicture;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class LoginActivity extends AppCompatActivity
{
    private static int SPLASH_TIME_OUT = 3000;
    Intent _pageSlapsh;

    @Override // Redefinie une méthode de la Classe Parent.
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        System.out.println("Slapsh chargé");
        Log.i("Etat","Slapsh chargé");

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                _pageSlapsh = new Intent(LoginActivity.this, GalleryActivity.class);
                startActivity(_pageSlapsh);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
