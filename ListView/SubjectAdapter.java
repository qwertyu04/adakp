package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SubjectAdapter extends ArrayAdapter<Subjects> {
    public SubjectAdapter(Context context, List<Subjects> sub){
        super(context,0,sub);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Subjects current_subject = getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_subject, parent, false);
        }
        TextView subName = convertView.findViewById(R.id.Name);
        TextView subSem = convertView.findViewById(R.id.Semester);

        assert current_subject != null;
        subName.setText(current_subject.getName());
        subSem.setText(current_subject.getSemester());
        return convertView;
    }
}
