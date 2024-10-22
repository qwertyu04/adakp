package com.example.async;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnRun;
    private EditText editTextInTime;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRun = (Button) findViewById(R.id.btn_run);
        editTextInTime = findViewById(R.id.edittext_intime);
        textViewResult = findViewById(R.id.textview_result);

        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTaskRunner runner = new MyAsyncTaskRunner();
                String sleepTime = editTextInTime.getText().toString();
                runner.execute(sleepTime);
            }
        });
    }

    private class MyAsyncTaskRunner extends AsyncTask<String, String, String> {

        private String response;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this, "Progress Dialog", "Wait for " + editTextInTime.getText().toString() + " seconds");
        }

        @Override
        protected void onProgressUpdate(String... updateText) {
            textViewResult.setText(updateText[0]);
        }

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping...");

            try {
                int timeInSeconds = Integer.parseInt(params[0]);
                for (int i = 0; i < timeInSeconds; i++) {
                    Thread.sleep(1000);
                    response = "Slept for " + (i + 1) + " of " + timeInSeconds + " seconds";
                    publishProgress(response);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            textViewResult.setText(result);
        }
    }
}
