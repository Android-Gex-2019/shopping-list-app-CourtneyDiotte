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


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Serializable {

    private Map shoppingList = new HashMap<>();

    //if the shopping list is not empty
    // and it contains the item already
    //add one to item count
    //or else add the item
    protected void addItemToList(String item){

        if(this.shoppingList != null) {

            if (this.shoppingList.containsKey(item)) {
                this.shoppingList.replace(item, (int) shoppingList.get(item) + 1);
            } else {
                this.shoppingList.put(item, 1);
            }
        }
    }

    //return the shopping list
    protected Map<String, Integer> getShoppingList(){

        return shoppingList;
    }

}
