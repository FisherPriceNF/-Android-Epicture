package nicolasfontanet.fr.epicture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends BaseAdapter
{
        private LayoutInflater _layoutInFlater;
        private List<ItemObject> _listStorage;
        private Context _context;

    public CustomAdapter(Context context, List<ItemObject> customizedListView)
    {
        this._context = context;
        _layoutInFlater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        _listStorage = customizedListView;
    }

    @Override
    public int getCount()
    {
        return _listStorage.size();
    }

    @Override
    public Object getItem(int position)
    {
        return position;
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolder listViewHolder;
        if(convertView == null)
        {
            listViewHolder = new ViewHolder();
            convertView = _layoutInFlater.inflate(R.layout.itemimage, parent, false);
            listViewHolder.textInListView = (TextView)convertView.findViewById(R.id.textView);
            listViewHolder.imageInListView = (ImageView)convertView.findViewById(R.id.imageView);
            convertView.setTag(listViewHolder);
        }
        else
        {
            listViewHolder = (ViewHolder)convertView.getTag();
        }

        listViewHolder.textInListView.setText(_listStorage.get(position).getContent());
        int imageResourceId = this._context.getResources().getIdentifier(_listStorage.get(position).getImageResource(), "drawable", this._context.getPackageName());
        listViewHolder.imageInListView.setImageResource(imageResourceId);

        return convertView;
    }

    static class ViewHolder
    {
        TextView textInListView;
        ImageView imageInListView;
    }
}
