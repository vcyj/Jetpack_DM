package com.example.caculatortest_2_find_mistake;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.caculatortest_2_find_mistake.databinding.FragmentLoseBinding;


public class LoseFragment extends Fragment {
    public LoseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MyViewModel model;
        model=new ViewModelProvider(requireActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),this)).get(MyViewModel.class);
        FragmentLoseBinding binding=DataBindingUtil.inflate(inflater,R.layout.fragment_lose,container,false);
        binding.setJeeyu(model);
        binding.setLifecycleOwner(this);
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller= Navigation.findNavController(v);
                controller.navigate(R.id.action_loseFragment_to_titleFragment);
            }
        });
        return binding.getRoot();
    }
}
