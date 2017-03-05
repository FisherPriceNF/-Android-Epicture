package nicolasfontanet.fr.epicture;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GalleryActivity extends AppCompatActivity
{
    private Button _addButton;
    private Intent _pageSamplePhoto;
    private List<ItemObject> _gallery;
    private GridView _gridview;
    private Toolbar _toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        _pageSamplePhoto = new Intent(getApplicationContext(), SimplePhotoActivity.class);
        _gridview = (GridView) findViewById(R.id.activity_gallery);
        _addButton = (Button) findViewById(R.id.btn_add);
        _addButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

            }
        });
        _gallery =  new ArrayList<>();
        CustomAdapter customAdapter = new CustomAdapter(GalleryActivity.this /*Context*/, _gallery);
        //getAllItemObject();
        try {
            JSONreader();
        } catch (Exception e) {
        }
        _gridview.setAdapter(customAdapter);
        _gridview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ItemObject _item = _gallery.get(position);
                String name = "Content : " + _item.getContent() + " |ImageResource: " + _item.getImageResource();
                Log.i("Item", name);
                _pageSamplePhoto.putExtra("NameImage", _item.getContent());
                _pageSamplePhoto.putExtra("ResourceImage", _item.getImageResource());
                startActivity(_pageSamplePhoto);
            }
        });
    }

    public void JSONreader() throws Exception
    {
        /*String section = "hot";
        String sort = "viral";
        String page = "0";
        URL url = new URL ("https://api.imgur.com/3/gallery/hot/viral/0.json");

        Scanner scan = new Scanner(url.openStream());
        _gallery.add(new ItemObject("Image One", "http://i.imgur.com/DvpvklR.png"));
        String str = new String();
        while(scan.hasNext())
            str += scan.nextLine();
        scan.close();*/

        URL url = new URL("https://google.com");
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputline;
        System.out.println("test");

        /*_gallery.add(new ItemObject("Image One", "http://i.imgur.com/DvpvklR.png"));
        JSONObject obj = new JSONObject(str);
        if (! obj.getString("success").equals("true"))
            return;
        JSONObject data = obj.getJSONArray("data").getJSONObject(0);
        String id = data.getString("cover");
        String title = data.getString("title");
        System.out.println("id = " + id + "\ntitle = " + title);
        _gallery.add(new ItemObject(title, "http://i.imgur.com/" + id + ".png"));*/
    }

    public void addImage(String name, String path)
    {
        _gallery.add(new ItemObject(name, path));
    }

    public void removeImage(ItemObject item)
    {
        _gallery.remove(item);
    }

    private void getAllItemObject()
    {
        //_gallery.add(new ItemObject("Image One", "http://i.imgur.com/DvpvklR.png"));
        /*_gallery.add(new ItemObject("Image Two", "@drawable/two"));
        _gallery.add(new ItemObject("Image Three", "@drawable/three"));
        _gallery.add(new ItemObject("Image Four", "@drawable/four"));
        _gallery.add(new ItemObject("Image Five", "@drawable/five"));
        _gallery.add(new ItemObject("Image Six", "@drawable/six"));
        _gallery.add(new ItemObject("Image Seven", "@drawable/seven"));
        _gallery.add(new ItemObject("Image Eight", "@drawable/eight"));
        _gallery.add(new ItemObject("Image One", "@drawable/one"));
        _gallery.add(new ItemObject("Image Two", "@drawable/two"));
        _gallery.add(new ItemObject("Image Three", "@drawable/three"));
        _gallery.add(new ItemObject("Image Four", "@drawable/four"));
        _gallery.add(new ItemObject("Image Five", "@drawable/five"));
        _gallery.add(new ItemObject("Image Six", "@drawable/six"));
        _gallery.add(new ItemObject("Image Seven", "@drawable/seven"));
        _gallery.add(new ItemObject("Image Eight", "@drawable/eight"));
        _gallery.add(new ItemObject("Image One", "@drawable/one"));
        _gallery.add(new ItemObject("Image Two", "@drawable/two"));
        _gallery.add(new ItemObject("Image Three", "@drawable/three"));
        _gallery.add(new ItemObject("Image Four", "@drawable/four"));
        _gallery.add(new ItemObject("Image Five", "@drawable/five"));
        _gallery.add(new ItemObject("Image Six", "@drawable/six"));
        _gallery.add(new ItemObject("Image Seven", "@drawable/seven"));
        _gallery.add(new ItemObject("Image Eight", "@drawable/eight"));*/
    }
}
