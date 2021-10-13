package database.beans;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
public class MyBean implements Serializable
{
    private List<String> items;
    private String selectedItem;

    @PostConstruct
    public void init()
    {
        items = new ArrayList<>();
        selectedItem = "Item 1";
        items.add( selectedItem );
        items.add( "Item 2" );
        items.add( "Item 3" );
    }

    public String getSelectedItem() { return selectedItem; }
    public void setSelectedItem( String selectedItem_ ) { selectedItem = selectedItem_; }
    public List<String> getItems() { return items; }
}