package com.example.kevinparker.pcpartpicker;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MemoryActivity extends ComputerPartActivity {
    String baseUrl = "https://pcpartpicker.com/products/memory/fetch/?sort=&page=&mode=list&xslug=&search=";

    public void createDialog() {
        //put the code to create the filter dialog here
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.memory_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.filter_menu_itemmemory:
                break;
            case R.id.ram_name_mi:
                populateCardview(getSortedURL(item, "name"));
                swapMenuItemTitle(item);
                break;
            case R.id.ram_speed_mi:
                populateCardview(getSortedURL(item, "speed"));
                swapMenuItemTitle(item);
                break;
            case R.id.ram_type_mi:
                populateCardview(getSortedURL(item, "formfactor"));
                swapMenuItemTitle(item);
                break;
            case R.id.ram_cas_mi:
                populateCardview(getSortedURL(item, "cas"));
                swapMenuItemTitle(item);
                break;
            case R.id.ram_modules_mi:
                populateCardview(getSortedURL(item, "modules"));
                swapMenuItemTitle(item);
                break;
            case R.id.ram_size_mi:
                populateCardview(getSortedURL(item, "capacity"));
                swapMenuItemTitle(item);
                break;
            case R.id.ram_priceGB_mi:
                populateCardview(getSortedURL(item, "ppgb"));
                swapMenuItemTitle(item);
                break;
            case R.id.ram_price_mi:
                populateCardview(getSortedURL(item, "price"));
                swapMenuItemTitle(item);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        getSupportActionBar().setTitle("Choose memory");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createDialog();
        createCardview(R.id.memory_recycler_view);
        populateCardview(baseUrl);
    }
}
