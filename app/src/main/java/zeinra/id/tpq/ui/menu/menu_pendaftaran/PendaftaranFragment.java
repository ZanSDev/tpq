package zeinra.id.tpq.ui.menu.menu_pendaftaran;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zeinra.id.tpq.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PendaftaranFragment extends Fragment {


    public PendaftaranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pendaftaran, container, false);
    }

}
