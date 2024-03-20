package com.example.rattan_planters.adapter;

import static android.app.ActivityOptions.makeSceneTransitionAnimation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rattan_planters.ProductPage;
import com.example.rattan_planters.R;
import com.example.rattan_planters.model.Products;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Products> products;

    /**
     * @param context  - передаваемая информация
     * @param products - товары
     */
    public ProductAdapter(Context context, List<Products> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productItems = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductAdapter.ProductViewHolder(productItems);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        int imageId = context.getResources().getIdentifier(products.get(position).getImg(), "drawable", context.getPackageName());
        holder.productImage.setImageResource(imageId);
        int imagePageId = context.getResources().getIdentifier(products.get(position).getPageImage(), "drawable", context.getPackageName());


        holder.productTitle.setText(products.get(position).getTitle());
        holder.volumeTitle.setText(products.get(position).getVolume());
        holder.priceTitle.setText(products.get(position).getPrice());

        /**
         * обработчик события
         */

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, ProductPage.class);
                /**
                 * создается опция перехода между страницами
                 */
                ActivityOptions options = makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.productImage, "pageImage")
                );

                intent.putExtra("productPageImage", imagePageId); // фото товара
                intent.putExtra("productPageTitle", products.get(position).getTitle()); // название товара
                intent.putExtra("volumePageTitle", products.get(position).getVolume()); // объем тоовара
                intent.putExtra("discrPageTitle", products.get(position).getDescription()); //описание товара
                intent.putExtra("colorPageProduct", products.get(position).getColorProduct()); // цвет изделия на фото
                intent.putExtra("heightPageProduct", products.get(position).getHeight()); // высота
                intent.putExtra("dawnDiam", products.get(position).getLowerDiameter()); // нижний диаметр
                intent.putExtra("outDiam", products.get(position).getMaxDiameter()); // внешний широкий диаметр
                intent.putExtra("pricePageTitle", products.get(position).getPrice()); // цена товара
                intent.putExtra("productId", products.get(position).getId());  //идентификатор товара

                context.startActivity(intent, options.toBundle());
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage, pageImage;
        TextView productTitle, volumeTitle, priceTitle;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.productImage);
            productTitle = itemView.findViewById(R.id.productTitle);
            volumeTitle = itemView.findViewById(R.id.volumeTitle);
            priceTitle = itemView.findViewById(R.id.priceTitle);
            pageImage = itemView.findViewById(R.id.productPageImage);
        }
    }


}
