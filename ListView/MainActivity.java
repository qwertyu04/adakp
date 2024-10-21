package com.example.listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private String[] Subjects = {
//            "Programming for Problem Solving",
//            "Data Structure",
//            "Operating System",
//            "Java",
//            "Android Application Development"
//    };
//    ListView listView;

    List<Subjects> subjects = new ArrayList<>();
    ListView listView;
    public void loadSubject(){
        subjects.add(new Subjects("Programming for Problem Solving","First"));
        subjects.add(new Subjects("Data Structures","Third"));
        subjects.add(new Subjects("Operating System","Sixth"));
        subjects.add(new Subjects("Machine Learning","Seventh"));
        subjects.add(new Subjects("Advance Java Technology","Fifth"));
        subjects.add(new Subjects("Database Management System","Third"));
        subjects.add(new Subjects("Computer Organization","Fifth"));
        subjects.add(new Subjects("Theory of Computation","Fifth"));
        subjects.add(new Subjects("Compiler Design","Seventh"));
        subjects.add(new Subjects("Full Stack Development","Sixth"));
        subjects.add(new Subjects("Cloud Computing","Seventh"));
        subjects.add(new Subjects("Data Science","Optional"));
        subjects.add(new Subjects("Artificial Intelligence","Optional"));
        subjects.add(new Subjects("Cyber-Security","Optional"));




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadSubject();
        listView=findViewById(R.id.list_view);
        SubjectAdapter adapter=new SubjectAdapter(this,subjects);
        listView.setAdapter(adapter);

//        listView = findViewById(R.id.list_view);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Subjects);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String selected_item = (String)adapterView.getItemAtPosition(position);
//                Toast.makeText(MainActivity.this, "You Selected "+selected_item,Toast.LENGTH_LONG).show();
//            }
//        });
        }



}
