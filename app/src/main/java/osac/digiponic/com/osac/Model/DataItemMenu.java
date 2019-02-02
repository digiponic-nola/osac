package osac.digiponic.com.osac.Model;

public class DataItemMenu {

    private String _itemName;
    private String _itemPrice;
    private boolean selected = false;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public DataItemMenu() {
    }

    public DataItemMenu(String _itemName, String _itemPrice) {
        this._itemName = _itemName;
        this._itemPrice = _itemPrice;
    }

    public String get_itemName() {
        return _itemName;
    }

    public void set_itemName(String _itemName) {
        this._itemName = _itemName;
    }

    public String get_itemPrice() {
        return _itemPrice;
    }

    public void set_itemPrice(String _itemPrice) {
        this._itemPrice = _itemPrice;
    }
}