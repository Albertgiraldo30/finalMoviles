package com.albertoochoa.albertoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VehiculoAdapter extends RecyclerView.Adapter<VehiculoAdapter.VehiculoViewHolder> {

    private List<Vehiculo> vehiculoList;

    public VehiculoAdapter(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @NonNull
    @Override
    public VehiculoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_vehiculo, parent, false);
        return new VehiculoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculoViewHolder holder, int position) {
        Vehiculo vehiculo = vehiculoList.get(position);
        holder.tvPlaca.setText(vehiculo.getPlaca());
        holder.tvPropietario.setText(vehiculo.getPropietario());
        holder.tvMarca.setText(vehiculo.getMarca());
        holder.tvModelo.setText(vehiculo.getModelo());
        holder.tvColor.setText(vehiculo.getColor());
    }

    @Override
    public int getItemCount() {
        return vehiculoList.size();
    }

    public static class VehiculoViewHolder extends RecyclerView.ViewHolder {
        TextView tvPlaca, tvPropietario, tvMarca, tvModelo, tvColor;

        public VehiculoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlaca = itemView.findViewById(R.id.tvPlaca);
            tvPropietario = itemView.findViewById(R.id.tvPropietario);
            tvMarca = itemView.findViewById(R.id.tvMarca);
            tvModelo = itemView.findViewById(R.id.tvModelo);
            tvColor = itemView.findViewById(R.id.tvColor);
        }
    }
}
