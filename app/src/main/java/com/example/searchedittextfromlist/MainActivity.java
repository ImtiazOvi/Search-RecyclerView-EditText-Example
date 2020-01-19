package com.example.searchedittextfromlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.recyclerView)
    EditText edtTextSearch;


    ArrayList<String> countryName;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryName = new ArrayList<>();

        countryName.add("America");
        countryName.add("Bangladesh");
        countryName.add("Canada");
        countryName.add("Denmark");
        countryName.add("England");
        countryName.add("France");
        countryName.add("Greece");
        countryName.add("Holand");
        countryName.add("Italy");
        countryName.add("Japan");
        countryName.add("Korea");
        countryName.add("Levia");
        countryName.add("Malysia");
        countryName.add("Norway");
        countryName.add("Oman");
        countryName.add("Poland");
        countryName.add("Quatar");
        countryName.add("Rasia");
        countryName.add("South Afriaca");
        countryName.add("Turky");
        countryName.add("Urnishia");
        countryName.add("Vehetnam");
        countryName.add("Westindish");
        countryName.add("Azarbaizan");
        countryName.add("Fingland");
        countryName.add("Span");
        countryName.add("Catalunia");


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        edtTextSearch = (EditText) findViewById(R.id.editTextSearch);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyAdapter(countryName);

        recyclerView.setAdapter(adapter);


        //adding a TextChangedListener
        //to call a method whenever there is some change on the EditText
        edtTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<String> filterdNames = new ArrayList<>();

        //looping through existing elements
        for (String s : countryName) {
            //if the existing elements contains the search input
            if (s.toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);
    }
}
