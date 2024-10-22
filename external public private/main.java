package com.example.externalstoragepublic_private;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    private int STORAGE_PERMISSION_CODE = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText2);
    }

    public void next(View view) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    public void savePublic(View view) {
        //Permission to access external storage
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        String info = editText.getText().toString();
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/demo_public");// Folder Name
        if (! folder.exists()){
            if (! folder.mkdirs()){
                Log.d("error", "failed to create directory");
                Toast.makeText(this, "failed to create directory" , Toast.LENGTH_SHORT).show();
            }
        }
        File myFile = new File(folder, "myData1.txt");// Filename
        writeData(myFile, info);
        editText.setText("");
    }

    public void savePrivate(View view) {
        String info = editText.getText().toString();
        File folder = getExternalFilesDir("demo_Private");// Folder Name
        File myFile = new File(folder, "myData2.txt");// Filename
        writeData(myFile, info);
        /*File internal_folder = getFilesDir();
        File Int_File = new File(internal_folder, "myinternal.txt");// Filename of Internal Storage
        writeData(Int_File, info);*/
        editText.setText("");
    }

    private void writeData(File myFile, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this, "Done" + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
