package com.example.repeat_java_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.repeat_java_3_2.databinding.FragmentThirdBinding;

public class ThirdFragment extends Fragment {
    private FragmentThirdBinding binding;
    public static final String USERNAME_KEY3 = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            String username = getArguments().getString(SecondFragment.USERNAME_KEY2);
            binding.text.setText(username);
        }
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                FourthFragment fourthFragment = new FourthFragment();
                if (!binding.editText.getText().toString().isEmpty()){
                    fourthFragment.setArguments(bundle);
                    bundle.putString(USERNAME_KEY3, binding.editText.getText().toString());
                    fourthFragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fourthFragment).commit();
                }else binding.text.setError("Ошибка, введите текст");
            }
        });
    }
}