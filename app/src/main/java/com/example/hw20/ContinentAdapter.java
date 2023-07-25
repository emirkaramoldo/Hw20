package com.example.hw20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ViewHolder> {

    private List<Continent> continents;
    private OnItemClickListener listener;

    public ContinentAdapter(List<Continent> continents, OnItemClickListener listener) {
        this.continents = continents;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continent, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Continent continent = continents.get(position);
        holder.bind(continent);
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContinentName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvContinentName = itemView.findViewById(R.id.tvContinentName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Continent continent = continents.get(position);
                        listener.onItemClick(continent);
                    }
                }
            });
        }

        public void bind(Continent continent) {
            tvContinentName.setText(continent.getName());
        }
    }

    // Интерфейс для обработки нажатий на элемент списка континентов
    public interface OnItemClickListener {
        void onItemClick(Continent continent);
    }
}
