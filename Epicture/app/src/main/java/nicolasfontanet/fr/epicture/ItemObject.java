package nicolasfontanet.fr.epicture;

public class ItemObject
{
    private String _content;
    private String _imageResource;

    public ItemObject(String content, String imageResource)
    {
        this._content = content;
        this._imageResource = imageResource;
    }

    public ItemObject()
    {
        this._content = "";
        this._imageResource = "";
    }

    public String getContent()
    {
        return _content;
    }

    public void setContent(String content)
    {
        this._content = content;
    }

    public String getImageResource()
    {
        return _imageResource;
    }

    public void setImageResource(String imageResource)
    {
        this._imageResource = imageResource;
    }
}
