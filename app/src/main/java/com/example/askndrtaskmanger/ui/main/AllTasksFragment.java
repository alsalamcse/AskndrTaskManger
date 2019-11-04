package com.example.askndrtaskmanger.ui.main;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.askndrtaskmanger.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Data.MyTask;
import Data.TaskAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllTasksFragment extends Fragment {

    private TaskAdapter taskAdapter;
    private ListView lvTasks;


    public AllTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        taskAdapter=new TaskAdapter(getContext());

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_tasks, container, false);
        lvTasks=view.findViewById(R.id.lstvTasks);

        return view;

    }
    public void readTasksFromFirebase(){
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        FirebaseAuth auth=FirebaseAuth.getInstance();
        String uid=auth.getUid();
        DatabaseReference reference=database.getReference();
        reference.child("Tasks").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    MyTask task=d.getValue(MyTask.class);
                    Log.d("MyTask",task.toString());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
