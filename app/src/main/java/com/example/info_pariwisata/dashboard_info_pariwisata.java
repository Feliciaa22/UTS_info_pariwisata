package com.example.info_pariwisata;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class dashboard_info_pariwisata extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WisataAdapter adapter;
    private ArrayList<Wisata> wisataList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard_info_pariwisata);

        // Mengatur sistem bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi RecyclerView dan SearchView
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);

        // Inisialisasi data tempat wisata
        wisataList = new ArrayList<>();
        wisataList.add(new Wisata("Danau Toba", "Sumatra Utara", R.drawable.danau_toba, getString(R.string.danau_toba_desc),2.6108377,98.9023081));
        wisataList.add(new Wisata("Candi Muara Takus", "Riau", R.drawable.candi_muara_takus, getString(R.string.candi_muara_takus_desc), 0.3359614, 100.6421489));
        wisataList.add(new Wisata("Kepulauan Derawan", "Kalimantan Timur", R.drawable.derawan, getString(R.string.derawan_desc), 2.2841235, 118.2435287));
        wisataList.add(new Wisata("Gunung Kerinci", "Sumatra Barat", R.drawable.gunung_kerinci, getString(R.string.kerinci_desc), -1.9094457,101.3034337));
        wisataList.add(new Wisata("Garuda Wisnu Kencana", "Bali", R.drawable.gwk, getString(R.string.gwk_desc), -8.814106941223145,115.16661834716797 ));
        wisataList.add(new Wisata("Pegunungan Jayawijaya", "Papua Pegunungan", R.drawable.jayawijaya, getString(R.string.jayawijaya_desc), -4.5375586,120.3228216 ));
        wisataList.add(new Wisata("Jembatan Ampera", "Sumatra Selatan", R.drawable.jembatan_ampera, getString(R.string.ampera_desc), -7.712703,114.09834));
        wisataList.add(new Wisata("Kawah Ijen", "Jawa Timur", R.drawable.kawah_ijen, getString(R.string.kawah_ijen_desc), -8.0579203,114.2417131));
        wisataList.add(new Wisata("Lawang Sewu", "Jawa Tengah", R.drawable.lawang_sewu, getString(R.string.lawang_sewu_desc), -6.983958, 110.4107756));
        wisataList.add(new Wisata("Monas", "DKI Jakarta", R.drawable.monas, getString(R.string.monas_desc), -6.1754024,106.8271692));
        wisataList.add(new Wisata("Morotai", "Maluku Utara", R.drawable.morotai, getString(R.string.morotai_desc),2.3129234,128.4418556));
        wisataList.add(new Wisata("Candi Prambanan", "Daerah Istimewa Yogyakarta", R.drawable.prambanan, getString(R.string.prambanan_desc), -7.7520157,110.4914556));
        wisataList.add(new Wisata("Pulau Bintan", "Kepulauan Riau", R.drawable.pulau_bintan, getString(R.string.bintan_desc), 1.0196577, 104.5698189));
        wisataList.add(new Wisata("Raja Ampat", "Papua Barat", R.drawable.raja_ampat, getString(R.string.raja_ampat_desc), -0.7125553, 130.3034473));
        wisataList.add(new Wisata("Taman Nasional Komodo", "Nusa Tenggara Timur", R.drawable.taman_nasional_komodo, getString(R.string.taman_nasional_komodo_desc), -8.529777526855469,119.48539733886719));
        wisataList.add(new Wisata("Tana Toraja", "Sulawesi Selatan", R.drawable.tana_toraja, getString(R.string.tana_toraja_desc),-3.1169403,119.6937644));
        wisataList.add(new Wisata("Tanjung Kelayang", "Bangka Belitung", R.drawable.tanjung_kelayang, getString(R.string.tanjung_kelayang_desc), -0.4715467, 102.0376014));
        wisataList.add(new Wisata("Taman Nasional Tanjung Puting", "Kalimantan Tengah", R.drawable.tanjung_puting, getString(R.string.tanjung_puting_desc), -3.0512355191260885,112.01756064903087));
        wisataList.add(new Wisata("Taman Nasional Ujung Kulon", "Banten", R.drawable.ujung_kulon, getString(R.string.ujung_kulon_desc), -6.770055064051792,105.3477017583337 ));
        wisataList.add(new Wisata("Taman Nasional Way Kambas", "Lampung", R.drawable.way_kambas, getString(R.string.way_kambas_desc), -4.938442165158821,105.73984434695834));

        // Set adapter dan layout manager untuk RecyclerView
        adapter = new WisataAdapter(wisataList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);  // Memanggil metode filter di adapter
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);  // Memanggil metode filter di adapter saat teks berubah
                return false;
            }
        });
    }
}
