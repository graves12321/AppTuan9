package com.cmajor7.customlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    String mSong[] = {"Võ Thành Luân", "Childhood Dream", "Dusk Till Dawn", "Love Is Gone", "Bagaikan Langit", "Funny", "Waiting For Love", "Dancing With Your Ghost"};
    String mSinger[] = {"18T3", "Seraphine", "Sia", "Slander", "Heiakim", "Zedd", "Avicii", "Sasha Sloan"};
    int images[] = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        ListViewAdapter adapter = new ListViewAdapter(this, mSong, mSinger, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Ava Max", Toast.LENGTH_SHORT).show();
                }
                if(position == 1){
                    Toast.makeText(MainActivity.this, "Seraphine", Toast.LENGTH_SHORT).show();
                }
                if(position == 2){
                    Toast.makeText(MainActivity.this, "Sia", Toast.LENGTH_SHORT).show();
                }
                if(position == 3){
                    Toast.makeText(MainActivity.this, "Slander", Toast.LENGTH_SHORT).show();
                }
                if(position == 4){
                    Toast.makeText(MainActivity.this, "Heiakim", Toast.LENGTH_SHORT).show();
                }
                if(position == 5){
                    Toast.makeText(MainActivity.this, "Zedd", Toast.LENGTH_SHORT).show();
                }
                if(position == 6){
                    Toast.makeText(MainActivity.this, "Avicii", Toast.LENGTH_SHORT).show();
                }
                if(position == 7){
                    Toast.makeText(MainActivity.this, "Sasha Sloan", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    class ListViewAdapter extends ArrayAdapter<String>{
        Context context;
        String rSong[];
        String rSinger[];
        int rImage[];
        ListViewAdapter (Context c, String song[], String singer[], int image[]){
            super(c, R.layout.rows, R.id.tv1, song);
            this.context = c;
            this.rSong = song;
            this.rSinger = singer;
            this.rImage = image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rows = layoutInflater.inflate(R.layout.rows, parent, false);
            ImageView images = rows.findViewById(R.id.image);
            TextView mSong = rows.findViewById(R.id.tv1);
            TextView mSinger = rows.findViewById(R.id.tv2);

            images.setImageResource(rImage[position]);
            mSong.setText(rSong[position]);
            mSinger.setText(rSinger[position]);
            return rows;
        }
    }
}