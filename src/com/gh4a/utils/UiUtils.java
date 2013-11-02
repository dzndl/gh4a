package com.gh4a.utils;

import com.gh4a.Gh4Application;
import com.gh4a.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class UiUtils {
    public static void hideImeForView(View view) {
        if (view == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager)
                view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static AlertDialog.Builder createDialogBuilder(Context context) {
        int dialogTheme = Gh4Application.THEME == R.style.DefaultTheme ?
                R.style.Theme_Sherlock_Dialog : R.style.Theme_Sherlock_Light_Dialog;
        return new AlertDialog.Builder(new ContextThemeWrapper(context, dialogTheme));
    }

    public static void assignTypeface(Activity parent, Typeface typeface, int[] textViewIds) {
        View decor = parent.getWindow() != null ? parent.getWindow().getDecorView() : null;
        assignTypeface(decor, typeface, textViewIds);
    }

    public static void assignTypeface(View parent, Typeface typeface, int[] textViewIds) {
        if (parent == null) {
            return;
        }
        for (int id : textViewIds) {
            TextView textView = (TextView) parent.findViewById(id);
            textView.setTypeface(typeface);
        }
    }
}
