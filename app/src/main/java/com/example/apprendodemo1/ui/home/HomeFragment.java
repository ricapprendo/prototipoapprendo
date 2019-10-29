package com.example.apprendodemo1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apprendodemo1.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public void onActivityCreated(){

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        System.out.println("onCreateView");
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        System.out.println("onActivityCreated");
        recyclerView = (RecyclerView) root.findViewById(R.id.listaActividades);
        layoutManager = new LinearLayoutManager(root.getContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Dinamica> arrActividades = new ArrayList();
        arrActividades.add(new Dinamica("Así soy yo","Promover el acercamiento a la corporalidad a través de la integración de la dimensión sexual en los niños y niñas, enmarcado en el desarrollo de su ciclo vital."));
        arrActividades.add(new Dinamica("Así soy yo","Promover el acercamiento a la corporalidad a través de la integración de la dimensión sexual en los niños y niñas, enmarcado en el desarrollo de su ciclo vital."));
        arrActividades.add(new Dinamica("Así soy yo","Promover el acercamiento a la corporalidad a través de la integración de la dimensión sexual en los niños y niñas, enmarcado en el desarrollo de su ciclo vital."));

        mAdapter = new ActividadesAdapter(arrActividades);
        System.out.println("pasa por acá");
        recyclerView.setAdapter(mAdapter);


        return root;
    }
}