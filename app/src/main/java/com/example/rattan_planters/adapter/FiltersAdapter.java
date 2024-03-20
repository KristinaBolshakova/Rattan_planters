package com.example.rattan_planters.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rattan_planters.MainActivity;
import com.example.rattan_planters.ProductPage;
import com.example.rattan_planters.R;
import com.example.rattan_planters.model.Filters;

import java.util.List;

/**
 * Класс фильтрации товаров
 */
public class FiltersAdapter extends RecyclerView.Adapter<FiltersAdapter.FiltersViewHolder> {

    Context context;
    List<Filters> filters;

    /**
     *
     * @param context - передаваемые данные
     * @param filters - категориии фильтров
     */
    public FiltersAdapter(Context context, List<Filters> filters) {
        this.context = context;
        this.filters = filters;
    }

    @NonNull
    @Override
    public FiltersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View filtersItems = LayoutInflater.from(context).inflate(R.layout.filters_item, parent, false);
        return new FiltersViewHolder(filtersItems);
    }

    @Override
    public void onBindViewHolder(@NonNull FiltersViewHolder holder, int position) {
        holder.filtersTitle.setText(filters.get(position).getTitle());
        /**
         * обработчик событий, который срабатывает каждый раз при нажатии на определенный тип фильтра
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showProductByFilters(filters.get(position).getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return filters.size();
    }

    public static final class FiltersViewHolder extends RecyclerView.ViewHolder{

        TextView filtersTitle;

        public FiltersViewHolder(@NonNull View itemView) {
            super(itemView);

            filtersTitle = itemView.findViewById(R.id.filtersTitle);
        }
    }
}
