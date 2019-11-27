package zeinra.id.tpq.ui.menu.menu_home;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import zeinra.id.tpq.R;
import zeinra.id.tpq.util.SliderAdapterExample;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static RecyclerView.Adapter adapterMenuUtama;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView rcMenuUtama;
    private static ArrayList<PojoMenuHome> data;

    public Menu menu;
    public MenuItem item;

    //Menu Utama
    static Integer[] imageArrayMenuUtama = {
            R.drawable.ic_tv,
            R.drawable.ic_materi,
            R.drawable.ic_jadwal,
            R.drawable.ic_pendaftaran,
    };

    static String[] titleArrayMenuUtama = {
            //Menu Utama
            "ETPQ\nTV",
            "Materi\nPengajian",
            "Jadwal\nMengaji",
            "Cek\nPendaftaran",
    };

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false) ;

        sliderMenu(view);

        //Menu Utama
        rcMenuUtama = view.findViewById(R.id.rc_menu_utama);
        rcMenuUtama.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getContext(), 4, LinearLayoutManager.VERTICAL, false);
        rcMenuUtama.setLayoutManager(layoutManager);
        rcMenuUtama.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<>();
        for (int i = 0; i < titleArrayMenuUtama.length; i++) {
            data.add(new PojoMenuHome(
                    titleArrayMenuUtama[i],
                    imageArrayMenuUtama[i]
            ));
        }

        adapterMenuUtama = new AdapterMenuUtamaHome(data);
        rcMenuUtama.setAdapter(adapterMenuUtama);

        return view;
    }

    //fitur slider menu
    private void sliderMenu(View view) {
        SliderView sliderView = view.findViewById(R.id.image_slider);
        SliderAdapterExample adapter = new SliderAdapterExample();

        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();
    }

}
