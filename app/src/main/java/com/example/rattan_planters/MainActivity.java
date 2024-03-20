package com.example.rattan_planters;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rattan_planters.adapter.FiltersAdapter;
import com.example.rattan_planters.adapter.ProductAdapter;
import com.example.rattan_planters.model.Filters;
import com.example.rattan_planters.model.Products;

import java.util.ArrayList;
import java.util.List;

/**
 * Главная страница приложения, на которой отображаются иконки товаров с минимальным описанием и ценами
 * При нажатии на иконки совершается переход на страницу выбранного товара
 * Так же на данной странице есть возможность фильтрации товара по выбранному параметру
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView filtersRecycler, productRecycler;
    FiltersAdapter filtersAdapter;
    static ProductAdapter productAdapter;
    static List<Products> productsList = new ArrayList<>();
    static List<Products> fullProductsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Filters> filtersList = new ArrayList<>();
        filtersList.add(new Filters(0, "Все"));
        filtersList.add(new Filters(1, "\"Ваза\""));
        filtersList.add(new Filters(2, "Напольное\nвысокое"));
        filtersList.add(new Filters(3, "Подвесное"));
        filtersList.add(new Filters(4, "Напольное\nнизкое"));
        filtersList.add(new Filters(5, "Прямоугольное\nбалконное"));


        setFiltersRecycler(filtersList);


        productsList.add(new Products(
                1,
                "rattan1",
                "mainrat1",
                "Кашпо напольное",
                "60 литров",
                "Кашпо, оплетенное полиротангом, объёмом 60 литров. Объёмная пухлая форма, дренажные отверстия по низу.",
                "3100 руб",
                "мореная сосна",
                "34 см.",
                "42.5 см.",
                "62 см",
                4));
        productsList.add(new Products(
                2,
                "rattan2",
                "mainrat2",
                "Кашпо напольное",
                "20 литров",
                "Кашпо из экоротанга плетёное. Имеет дренажные отверстия снизу. " +
                        "Пухлая красивая форма шара. Ротанг отличного качества, достаточно жёсткий и очень хорошо держит форму.",
                "1600 руб",
                "берёзка",
                "34 см.",
                "42.5 см.",
                "62 см",
                4));
        productsList.add(new Products(
                3,
                "rattan3",
                "mainrat3",
                "Кашпо напольное",
                "20 литров",
                "Кашпо, оплетенное полиротангом, объёмом 60 литров. Объёмная пухлая форма, дренажные отверстия по низу.",
                "2200 руб",
                "мореная сосна",
                "34 см.",
                "42.5 см.",
                "62 см",
                2));
        productsList.add(new Products(
                4,
                "rattan4",
                "mainrat4",
                "Кашпо напольное",
                "20 литров",
                "Кашпо, оплетенное полиротангом, объёмом 60 литров. Объёмная пухлая форма, дренажные отверстия по низу.",
                "2200 руб",
                "берёзка",
                "34 см.",
                "42.5 см.",
                "62 см",
                2));

        fullProductsList.addAll(productsList);


        setProductsRecycler(productsList);
    }

    private void setProductsRecycler(List<Products> productsList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        productRecycler = findViewById(R.id.productRecycler);
        productRecycler.setLayoutManager(new GridLayoutManager(this, 2));

        productAdapter = new ProductAdapter(this, productsList);
        productRecycler.setAdapter(productAdapter);

    }

    /**
     *
     * @param view параметр на основе класса View
     */
    public void openShoppingCart(View view){

        // переход между страницами
        Intent intent = new Intent(this, OrderPage.class);

        // выполнение перехода, передаем настройку перехода
        startActivity(intent);

    }

    private void setFiltersRecycler(List<Filters> filtersList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        filtersRecycler = findViewById(R.id.filtersRecycler);
        filtersRecycler.setLayoutManager(layoutManager);

        filtersAdapter = new FiltersAdapter(this, filtersList);
        filtersRecycler.setAdapter(filtersAdapter);

    }

    /**
     * @param filter - тот тип фильтра товара, что мы нажали на панели фильтров
     *
     * метод showProductByFilters показывает отфильтрованный товар
     */
    public static void showProductByFilters(int filter) {

        //обновление (очистка и заполнение) списка для каждого нового клика по фильтру
        productsList.clear();
        productsList.addAll(fullProductsList);

        List<Products> filterProduct = new ArrayList<>();

        // список всех категорий товаров
        if (filter == 0){
            for (Products p: productsList){
                filterProduct.add(p);
            }
        }

        //перебор списка товаров, если фильтр совпадает с тем фильтром ,
        // что указан в параметрах товара, то мы его добавляем в пустой список
        else {
            for (Products p : productsList) {
                if (p.getFilter() == filter) {
                    filterProduct.add(p);
                }
            }
        }

        //отображение отфильтрованного списка
        productsList.clear();
        productsList.addAll(filterProduct);

        productAdapter.notifyDataSetChanged();

    }
}