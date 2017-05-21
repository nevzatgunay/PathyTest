package net.nevzatgunay.pathytest;

/**
 * Created by Nevzat on 3/25/2017.
 */

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.os.Bundle;

public class MyProfile extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment{

        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.myprofile);
        }
    }
}
