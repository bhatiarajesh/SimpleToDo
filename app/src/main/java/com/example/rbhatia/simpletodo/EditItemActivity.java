package com.example.rbhatia.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        position = getIntent().getIntExtra("position",0);
        String itemValue = getIntent().getStringExtra("itemValue");
        EditText etName = (EditText) findViewById(R.id.lvEditText);
        etName.setText(itemValue);
        etName.setSelection(itemValue.length());;
        etName.setCursorVisible(true);

    }

    public void onSubmit(View v) {
        EditText etName = (EditText) findViewById(R.id.lvEditText);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("name", etName.getText().toString());
        data.putExtra("code", 200); // ints work too
        data.putExtra("position",position);
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
