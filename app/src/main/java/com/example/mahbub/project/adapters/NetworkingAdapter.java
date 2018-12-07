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
import com.example.mahbub.project.models.normalmodel.FragmentDataStructureModel;
import com.example.mahbub.project.models.normalmodel.FragmentNetworkingModel;

import java.util.List;

public class NetworkingAdapter extends RecyclerView.Adapter<NetworkingAdapter.ViewHolder> {

    List<FragmentNetworkingModel> listFragmentNetworking;


    Context context;

    public NetworkingAdapter(List<FragmentNetworkingModel> listFragmentNetworkindlist, Context context) {
        this.listFragmentNetworking = listFragmentNetworkindlist;
        this.context = context;
    }


    @Override
    public NetworkingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.designforadapter, parent, false);
        return new NetworkingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NetworkingAdapter.ViewHolder holder, int position) {
        FragmentNetworkingModel model = listFragmentNetworking.get(position);


        holder.txtTitle.setText(model.getName());
        holder.txtDetails.setText(model.getDetails() + " ");

    }

    @Override
    public int getItemCount() {
        return listFragmentNetworking.size();
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
                        FragmentNetworkingModel clickedDataItem = listFragmentNetworking.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);

                        intent.putExtra("A", listFragmentNetworking.get(pos).getName());
                        intent.putExtra("B", listFragmentNetworking.get(pos).getDetails());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }

            });



        }
    }
}




