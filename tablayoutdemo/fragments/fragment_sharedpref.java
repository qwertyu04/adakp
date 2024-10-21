//In one fragment
// Initialize SharedPreferences
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        // Save data to SharedPreferences on button click
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("saved_text", text);
                editor.apply();
            }
        });

//In Other fragment 
  savedTextView = view.findViewById(R.id.saved_text_view);

        // Access SharedPreferences and display saved text
        sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedText = sharedPreferences.getString("saved_text", "No text saved yet!");
        savedTextView.setText(savedText);
