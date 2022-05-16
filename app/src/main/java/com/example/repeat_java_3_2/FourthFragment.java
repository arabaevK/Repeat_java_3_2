package com.example.repeat_java_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repeat_java_3_2.databinding.FragmentFouthBinding;
import com.example.repeat_java_3_2.databinding.FragmentMainBinding;

public class FourthFragment extends Fragment {
    private FragmentFouthBinding binding;
    public static final String USERNAME_KEY4 = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFouthBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String username = getArguments().getString(ThirdFragment.USERNAME_KEY3);
            binding.text.setText(username);
        }
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                SecondFragment secondFragment = new SecondFragment();
                if (!binding.editText.getText().toString().isEmpty()) {

                    bundle.putString(USERNAME_KEY4, binding.editText.getText().toString());
                    secondFragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
                } else binding.text.setError("Ошибка, введите текст");
            }
        });
    }
}