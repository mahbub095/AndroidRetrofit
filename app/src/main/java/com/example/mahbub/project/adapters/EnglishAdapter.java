package com.example.mahbub.project.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahbub.project.R;
import com.example.mahbub.project.activity.DetailActivity;
import com.example.mahbub.project.models.normalmodel.EnglishModel;
import com.example.mahbub.project.models.normalmodel.FragmentDataStructureModel;

import java.util.List;

public class EnglishAdapter extends RecyclerView.Adapter<EnglishAdapter.ViewHolder> {
    List<EnglishModel> listFragmentEnglishlList;


    Context context;

    public EnglishAdapter(List<EnglishModel> listFragmentEnglishlist, Context context) {
        this.listFragmentEnglishlList = listFragmentEnglishlist;
        this.context = context;
    }


    @Override
    public EnglishAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.designforadapter, parent, false);
        return new EnglishAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EnglishAdapter.ViewHolder holder, int position) {
        EnglishModel model = listFragmentEnglishlList.get(position);


        holder.txtTitle.setText(model.getName());
        holder.txtDetails.setText(model.getDetails() + " ");

    }

    @Override
    public int getItemCount() {
        return listFragmentEnglishlList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        private TextView txtDetails;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDetails = (TextView) itemView.findViewById(R.id.txtDetails);


            //on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        EnglishModel clickedDataItem = listFragmentEnglishlList.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);

                        intent.putExtra("A", listFragmentEnglishlList.get(pos).getName());
                        intent.putExtra("B", listFragmentEnglishlList.get(pos).getDetails());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }

            });



        }
    }
}


