package com.vnat.menutimkiem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView lvwTinhThanh;
    ArrayList arrayListTinhThanh;
    ArrayAdapter arrayAdapterTinhThanh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvwTinhThanh = findViewById(R.id.lvwTinhThanh);
        arrayListTinhThanh = new ArrayList(Arrays.asList(getResources().getStringArray(R.array.arrTinhThanh)));
        arrayAdapterTinhThanh = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayListTinhThanh);
        lvwTinhThanh.setAdapter(arrayAdapterTinhThanh);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        MenuItem menuSearch = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) menuSearch.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapterTinhThanh.getFilter().filter(newText);
                return false;
            }
        });

//        MenuItemCompat.setOnActionExpandListener(menuSearch, new MenuItemCompat.OnActionExpandListener() {
//            @Override
//            public boolean onMenuItemActionExpand(MenuItem item) {
//                Toast.makeText(MainActivity.this, "Expand", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//
//            @Override
//            public boolean onMenuItemActionCollapse(MenuItem item) {
//                Toast.makeText(MainActivity.this, "Collapse", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }
}
