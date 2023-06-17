package com.example.mobileproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobileproject.SesionUser;
import com.example.mobileproject.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private SesionUser sesionUser;
    private TextView txtDatos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        sesionUser = (SesionUser) getActivity().getIntent().getSerializableExtra("User");

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        int verificador = (sesionUser.users.returnUser());
        txtDatos = binding.txtDatos;

        String infoPerfil = "Nombre: " + sesionUser.users.user[verificador].getNombre() + "\n" +
                            "Apellido: " + sesionUser.users.user[verificador].getApellido() + "\n" +
                            "Correo electronico: " + sesionUser.users.user[verificador].getEmail() + "\n" +
                            "Contraseña: " + sesionUser.users.user[verificador].getPass() + "\n" +
                            "Registro: " + sesionUser.users.user[verificador].getRegistro() + "\n" +
                            "Grado: " + sesionUser.users.user[verificador].getGrado() + "\n" +
                            "Materias: " + sesionUser.users.user[verificador].getSubjects().get(0).getNameSub();
        txtDatos.setText(infoPerfil);

        final TextView textView = binding.txtBienvenida;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}