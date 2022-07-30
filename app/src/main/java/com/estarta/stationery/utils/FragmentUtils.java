package com.estarta.stationery.utils;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.text.NumberFormat;
import java.util.Locale;


public class FragmentUtils {


    public static void addFragment(AppCompatActivity activity, Fragment fragment, int id, boolean addToBackStack) {
        if (null == activity)
            return;

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();


        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getCanonicalName());

        transaction.add(id, fragment, fragment.getClass().getCanonicalName());
        transaction.commit();

    }

    private FragmentUtils() {
        // Private constructor to hide the implicit one
    }

    public static FragmentManager getSupportFragment(AppCompatActivity activity) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        return fragmentManager;
    }


    public static void replaceFragment(AppCompatActivity activity, Fragment fragment, int id, boolean addToBackStack) {

        if (null == activity)
            return;

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();


        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getCanonicalName());

        transaction.replace(id, fragment, fragment.getClass().getCanonicalName());
        transaction.commit();
    }


    public static String getFormatedNumber(String number) {
        if (!number.isEmpty()) {
            double val = Double.parseDouble(number);
            return NumberFormat.getNumberInstance(Locale.US).format(val);
        } else {
            return "0";
        }
    }


    public static boolean getTextNull(String value) {
        if (value.isEmpty() || value == null) {
            return true;
        } else {
            return false;
        }
    }


}
