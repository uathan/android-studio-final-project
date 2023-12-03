package com.example.androidproject.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.preference.CheckBoxPreference;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import com.example.androidproject.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);

        CheckBoxPreference largerTextPreference = findPreference("largeText");

        if (largerTextPreference != null) {
            largerTextPreference.setOnPreferenceChangeListener((preference, newValue) -> {
                boolean disableAnimations = (boolean) newValue;
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
                preferences.edit().putBoolean("disableAnimations", disableAnimations).apply();
                return true;
            });

        }
    }
}