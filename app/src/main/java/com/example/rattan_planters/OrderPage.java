package com.example.rattan_planters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rattan_planters.model.Order;
import com.example.rattan_planters.model.Products;

import java.util.ArrayList;
import java.util.List;

/**
 * Страница корзины
 */
public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView orders_list = findViewById(R.id.orders_list);

        // отображение имени продукта в корзине
        List<String> productTitle = new ArrayList<>();

        // перебор списка, состоящего и всех товаров и поиск в нем по id нужного товара
        for(Products p: MainActivity.fullProductsList){
            if(Order.items_id.contains(p.getId()))
                productTitle.add(p.getTitle());
        }

        //обращаемся к списку и используем дизайн Adapter (Стандартный)
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productTitle));
    }
}