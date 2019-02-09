/**
 *
 * @author Courtney Diotte
 *
 * @version 1.0
 * *
 * @section DESCRIPTION
 *
 *
 * @section LICENSE
 * *
 * Copyright 2018
 * Permission to use, copy, modify, and/or distribute this software for
 * any purpose with or without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 *
 * @section Academic Integrity
 * I certify that this work is solely my own and complies with
 * NBCC Academic Integrity Policy (policy 1111)
 */

package android.example.com.shoppinglistassignment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    public static final int TEXT_REQUEST = 1;
    private ShoppingCart cart = new ShoppingCart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            cart = (ShoppingCart)savedInstanceState.getSerializable("cart");
        }
        showShoppingList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showShoppingList();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("cart", cart);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            cart = (ShoppingCart)savedInstanceState.getSerializable("cart");
        }

        showShoppingList();
    }


    private void showShoppingList() {

        Iterator<Map.Entry<String, Integer>> itr = cart.getShoppingList().entrySet().iterator();

        int itemCount = 1;
        while (itr.hasNext()) {

            Map.Entry<String, Integer> mapPair = itr.next();


            String itemId = "txtItem" + itemCount; //get item id
            TextView shopItem = findViewById(getResources().getIdentifier(itemId, "id", getPackageName()));

            if(shopItem != null) {
                shopItem.setVisibility(View.VISIBLE);
                shopItem.setText(mapPair.getValue()+ " - " + mapPair.getKey());
            }

            itemCount++;
        }
    }

    public void StartItemList(View view) {
        Intent intent = new Intent(this, ShoppingItems.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int request, int result, Intent data)
    {
        super.onActivityResult(request, result, data);
        if (request == TEXT_REQUEST)
        {
            String item = data.getStringExtra(ShoppingItems.EXTRA_REPLY);
            if(item != null) {
                cart.addItemToList(item);
            }
        }
        showShoppingList();
    }


}