package com.lmax.singleselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class VoteActivity extends AppCompatActivity {

    TextView textView ;
    Button btn ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);


        List<Item> image_details = getListData();
        final GridView gridView = findViewById(R.id.gv);
        final CustomGridAdapter customGridAdapter = new CustomGridAdapter(this, image_details);
        gridView.setAdapter(customGridAdapter);

        textView = findViewById( R.id.txtmsg );
        btn = findViewById( R.id.btn );

        // When the user clicks on the GridItem
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                customGridAdapter.setSelectedPosition(position);
                customGridAdapter.notifyDataSetChanged();


                Object o = gridView.getItemAtPosition(position);
                Item Item = (Item) o;

                textView.setText( Item.getUrl() + " is selected" );
                if( !btn.isEnabled() ){
                    //btn.setClickable(true);
                    btn.setEnabled(true);
                }

            }
        });


    }

    private  List<Item> getListData() {
        List<Item> list = new ArrayList<Item>();
        Item vietnam = new Item("Vietnam", "vn");
        Item usa = new Item("United States", "us");
        Item russia = new Item("Russia", "ru");
        Item australia = new Item("Australia", "au");
        Item morocco = new Item("Morocco", "ma");
        Item japan = new Item("Japan", "jp");

        list.add(vietnam);
        list.add(usa);
        list.add(russia);
        list.add(australia);
        list.add(morocco);
        list.add(japan);

        return list;
    }
}
