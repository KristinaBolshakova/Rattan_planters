package com.example.rattan_planters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rattan_planters.model.Order;

/**
 * Страница товара, на которой отображается полное описание, характеристики и цена
 * Кнопка перехода на главную
 * Кнопка добавления товора в корзину
 */
public class ProductPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        /**
         * @param productPageImage - фото товара
         * @param productPageImage - фото товара
         *@param productPageTitle - название товара
         *@param volumePageTitle - объем тоовара
         *@param discrPageTitle -описание товара
         *@param colorPageProduct - цвет изделия на фото
         *@param heightPageProduct - высота
         *@param dawnDiam - нижний диаметр
         *@param outDiam - внешний широкий диаметр
         *@param pricePageTitle - цена товара
         */

        ImageView productPageImage = findViewById(R.id.productPageImage);
        TextView productPageTitle = findViewById(R.id.productPageTitle);
        TextView volumePageTitle = findViewById(R.id.volumePageTitle);
        TextView discrPageTitle = findViewById(R.id.discrPageTitle);
        TextView colorPageProduct = findViewById(R.id.colorPageProduct);
        TextView heightPageProduct = findViewById(R.id.heightPageProduct);
        TextView dawnDiam = findViewById(R.id.dawnDiam);
        TextView outDiam = findViewById(R.id.outDiam);
        TextView pricePageTitle = findViewById(R.id.pricePageTitle);

        productPageImage.setImageResource(getIntent().getIntExtra("productPageImage", 0));
        productPageTitle.setText(getIntent().getStringExtra("productPageTitle"));
        volumePageTitle.setText(getIntent().getStringExtra("volumePageTitle"));
        discrPageTitle.setText(getIntent().getStringExtra("discrPageTitle"));
        colorPageProduct.setText(getIntent().getStringExtra("colorPageProduct"));
        heightPageProduct.setText(getIntent().getStringExtra("heightPageProduct"));
        dawnDiam.setText(getIntent().getStringExtra("dawnDiam"));
        outDiam.setText(getIntent().getStringExtra("outDiam"));
        pricePageTitle.setText(getIntent().getStringExtra("pricePageTitle"));
    }

    public void addToCart(View view){
        int item_id = getIntent().getIntExtra("productId", 0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Товар добавлен в корзину", Toast.LENGTH_LONG).show();
    }


    //Работа кнопки "Назад" на странице карточки товара для возврата на главную
    public void goBack(View v){

        // переход между страницами
        Intent intent = new Intent(this, MainActivity.class);

        // выполнение перехода, передаем настройку перехода
        startActivity(intent);
    }
}