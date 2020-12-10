package com.kan.api_taipai;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Initialize variable
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        listView = findViewById(R.id.list_view);
        //Initialize JASON Array
        //String url = "http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=a880adf3-d574-430a-8e29-3192a41897a5";


        String student_array = "{\"students\": [\n"+
        "{\"id\":\"1\",\"name\":\"abcd\",\"email\":\"abcd@gmail.com\"},\n"+
        "{\"id\":\"2\",\"name\":\"efgh\",\"email\":\"efgh@gmail.com\"},\n"+
        "{\"id\":\"3\",\"name\":\"ijkl\",\"email\":\"ijkl@gmail.com\"},\n"+
        "{\"id\":\"4\",\"name\":\"mnop\",\"email\":\"mnop@gmail.com\"},\n"+
        "{\"id\":\"5\",\"name\":\"qrst\",\"email\":\"qrst@gmail.com\"},\n"+
        "{\"id\":\"6\",\"name\":\"uvwx\",\"email\":\"uvwx@gmail.com\"},\n"+
        "{\"id\":\"7\",\"name\":\"yz\",\"email\":\"yz@gmail.com\"}";



        //Fetch JASON Array
        try {
            JSONObject jsonObject = new JSONObject(student_array);
            JSONArray jsonArray = jsonObject.getJSONArray("students");
            for (int i=0 ;i<jsonArray.length() ;i++){
                JSONObject object = jsonArray.getJSONObject(i);
                String resultID = object.getString("id");
                String resultName = object.getString("name");
                String resultEmail = object.getString("email");
                arrayList.add(resultID+")"+resultName+"| |"+resultEmail);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        //Initialize Array Adapter
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        //Set Array Adapter to ListView
        listView.setAdapter(arrayAdapter);

        //Displayed toast message OnItemClick
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext()
                        ,arrayList.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }

}

