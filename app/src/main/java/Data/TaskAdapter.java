package Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.askndrtaskmanger.R;

import java.util.zip.Inflater;

public class TaskAdapter extends ArrayAdapter<MyTask>
{

    public TaskAdapter(@NonNull Context context ) {
        super(context, R.layout.taskitem);
    }

    /**
     *
     * @param position //number of mo3ta
     * @param convertView//view of my item
     * @param parent//listview
     * @return
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //building item view
        View vitem= LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,false);
        TextView tvTitle=vitem.findViewById(R.id.itmTvTitle);
        TextView tvSubject=vitem.findViewById(R.id.itmTvSubject);
        RatingBar rbPrio=vitem.findViewById(R.id.itmRatingPrio);
        CheckBox cbIsCompleted=vitem.findViewById(R.id.itmChbxIsCompleted);
        ImageView ivInfo=vitem.findViewById(R.id.itmImgInfo);

        MyTask myTask = getItem(position);//getting data source

        //connect item view to data source
        tvTitle.setText(myTask.getTitle());
        tvSubject.setText(myTask.getSubject());
        rbPrio.setRating(myTask.getPriority());
        cbIsCompleted.setChecked(false);

        return vitem;
    }
}
