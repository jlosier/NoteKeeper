package com.josephosier.notekeeper;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.josephosier.notekeeper.data.CourseInfo;
import com.josephosier.notekeeper.data.DataManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

/*
    Notes:
        - views are the basic UI building blocks
        - one type of view are layouts which handle positioning behavior
        - activity/layout relationship
            - no implicit relationship exists - must load layout yourself
                - use setContentView
            - must request layout View references
                - use findByViewId
        - R class provides important constants and is how you access your views and layouts

 */

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // links the activity class to the activity_note layout, which in turn, activity_note
        // includes content_note within it
        setContentView(R.layout.activity_note);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinnerCourses = findViewById(R.id.spinner_courses);

        List<CourseInfo> courses = DataManager.getInstance().getCourses();

        // arguments are stating what you want displayed (arg[2]) and how you want it displayed (arg[1])
        ArrayAdapter<CourseInfo> adapterCourses = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);

        // set the layout for the spinner's drop down list
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // finally, set the adapter to the spinner
        spinnerCourses.setAdapter(adapterCourses);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
