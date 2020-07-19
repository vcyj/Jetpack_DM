package com.example.caculatortest_2_find_mistake;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.caculatortest_2_find_mistake.databinding.FragmentWinBinding;

public class WinFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel model;
        model=new ViewModelProvider(getActivity(),
                new SavedStateViewModelFactory(getActivity().getApplication(),
                        this))
                .get(MyViewModel.class);
        FragmentWinBinding binding= DataBindingUtil.inflate(inflater,R.layout.fragment_win,container,false);
        binding.setJeeyu(model);
        binding.setLifecycleOwner(this);

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller= Navigation.findNavController(v);
                controller.navigate(R.id.action_winFragment_to_titleFragment);
            }
        });
        return binding.getRoot();
    }
}
