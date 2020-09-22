package com.bac.tanahairku;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterProvinsi extends RecyclerView.Adapter<AdapterProvinsi.ProvinsiHolder> {
    private ArrayList<Provinsi> list;

    AdapterProvinsi(ArrayList<Provinsi> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProvinsiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ProvinsiHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProvinsiHolder holder, int position) {
        final Provinsi data = list.get(position);
        holder.tvName.setText(data.getName());
        holder.tvDescription.setText(data.getDescription());
        Glide.with(holder.itemView.getContext())
                .load(data.getLambang())
                .into(holder.imgLambang);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                Provinsi provinsi = new Provinsi();
                provinsi.setName(data.getName());
                provinsi.setLambang(data.getLambang());
                provinsi.setIbukota(data.getIbukota());
                provinsi.setWilayah(data.getWilayah());
                provinsi.setDescription(data.getDescription());
                detailIntent.putExtra(DetailActivity.EXTRA_DATA, provinsi);
                holder.itemView.getContext().startActivity(detailIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProvinsiHolder extends RecyclerView.ViewHolder {
        ImageView imgLambang;
        TextView tvName, tvDescription;

        ProvinsiHolder(@NonNull View itemView) {
            super(itemView);

            imgLambang = itemView.findViewById(R.id.img_lambang);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
        }
    }
}
