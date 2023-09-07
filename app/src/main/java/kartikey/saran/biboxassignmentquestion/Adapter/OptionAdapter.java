package kartikey.saran.biboxassignmentquestion.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kartikey.saran.biboxassignmentquestion.Model.Question;
import kartikey.saran.biboxassignmentquestion.R;

public class OptionAdapter extends RecyclerView.Adapter<OptionAdapter.ViewHolder> {

    private List<String> optionList;
    private Context context;

    public OptionAdapter(List<String> responseList) {
        this.optionList = responseList;
    }

    @NonNull
    @Override
    public OptionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_option, parent, false);
        this.context = parent.getContext();
        return new OptionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OptionAdapter.ViewHolder holder, int position) {
        holder.checkBox.setText(optionList.get(position));
    }

    @Override
    public int getItemCount() {
        return optionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.item_option_checkbox);
        }
    }


}


