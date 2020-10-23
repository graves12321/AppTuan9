package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String [] m= new String[] { "Võ Thành Luân", "Love is gone", "Someone you like", "Childhood dream", "Love story",
                                "Apolo", "Savage love", "We still break up", "See you again", "Dusk till dawn", "What lovers do?",
                                "You don't know me", "Please don't go", "Past life"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter=
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,m);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);//dang ki context menu cho listview
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int i = info.position;
        if(item.getItemId()==R.id.them)
        {
            Toast.makeText(this,"Thêm bài hát: "+m[i].toString(),Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.sua)
        {
            Toast.makeText(this,"Sửa tên bài hát: "+m[i].toString(),Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.xoa)
        {
            Toast.makeText(this,"Xóa bài hát: "+m[i].toString(),Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }
}