package com.mrvijay.mealrecipes.others;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.mrvijay.mealrecipes.api.CategoryAPI;
import com.mrvijay.mealrecipes.api.CategoryClient;

public class Utils {

    public static CategoryAPI getApi()
    {
        return CategoryClient.getFoodClient().create(CategoryAPI.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }

}
