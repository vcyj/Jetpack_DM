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

import com.example.caculatortest_2_find_mistake.databinding.FragmentTitleBinding;

public class TitleFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        MyViewModel model;
        model= new ViewModelProvider(requireActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),this)).get(MyViewModel.class);
        FragmentTitleBinding binding;
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false);
        binding.setJeeyu(model);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller= Navigation.findNavController(v);
                controller.navigate(R.id.action_titleFragment_to_questionFragment);
            }
        });
        binding.setLifecycleOwner(getActivity());
        return binding.getRoot();


    }
}
