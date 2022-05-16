package com.example.repeat_java_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repeat_java_3_2.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    public static final String USERNAME_KEY2 = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            String username = getArguments().getString(MainFragment.USERNAME_KEY);
            binding.text.setText(username);

        }
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                ThirdFragment thirdFragment = new ThirdFragment();
                if (!binding.editText.getText().toString().isEmpty()) {
                    thirdFragment.setArguments(bundle);
                    bundle.putString(USERNAME_KEY2, binding.editText.getText().toString());
                    thirdFragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                } else binding.text.setError("Ошибка, введите текст");
            }
        });
    }
}