package com.example.caculatortest_2_find_mistake;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.caculatortest_2_find_mistake.databinding.FragmentQuestionBinding;

public class QuestionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final MyViewModel myViewModel;
        myViewModel=new ViewModelProvider(getActivity(),new SavedStateViewModelFactory(getActivity().getApplication(),this)).get(MyViewModel.class);
        myViewModel.generator();
        myViewModel.getCurrentScore().setValue(0);
        final FragmentQuestionBinding binding;
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_question,container,false);
        binding.setJeeyu(myViewModel);
        binding.setLifecycleOwner(getActivity());
        final StringBuilder builder=new StringBuilder();
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.Button_0:
                        builder.append(0);
                        break;
                    case R.id.Button_1:
                        builder.append(1);
                        break;
                    case R.id.Button_2:
                        builder.append(2);
                        break;
                    case R.id.Button_3:
                        builder.append(3);
                        break;
                    case R.id.Button_4:
                        builder.append(4);
                        break;
                    case R.id.Button_5:
                        builder.append(5);
                        break;
                    case R.id.Button_6:
                        builder.append(6);
                        break;
                    case R.id.Button_7:
                        builder.append(7);
                        break;
                    case R.id.Button_8:
                        builder.append(8);
                        break;
                    case R.id.Button_9:
                        builder.append(9);
                        break;
                    case R.id.buttonclear:
                        builder.append("Clear");
                        builder.setLength(0);
                        break;
                }
                if(builder.length()==0){
                    binding.textView9.setText(R.string.input_indicator);
                }else {
                    binding.textView9.setText(builder.toString());
                }
            }
        };
        binding.Button0.setOnClickListener(listener);
        binding.Button1.setOnClickListener(listener);
        binding.Button2.setOnClickListener(listener);
        binding.Button3.setOnClickListener(listener);
        binding.Button4.setOnClickListener(listener);
        binding.Button5.setOnClickListener(listener);
        binding.Button6.setOnClickListener(listener);
        binding.Button7.setOnClickListener(listener);
        binding.Button8.setOnClickListener(listener);
        binding.Button9.setOnClickListener(listener);
        binding.buttonclear.setOnClickListener(listener);
        binding.buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(builder.toString().equals("")){
                    builder.append(-1);
                }
                if(Integer.valueOf(builder.toString()).intValue()==myViewModel.getanswer().getValue()){
                    myViewModel.answerCorrect();
                    builder.setLength(0);
                    binding.textView9.setText(R.string.answer_correct_msg);

                }else {
                    NavController controller= Navigation.findNavController(v);

                    if(myViewModel.win_flag){
                        controller.navigate(R.id.action_questionFragment_to_winFragment);
                        myViewModel.win_flag=false;
                        myViewModel.save();
                    }
                    else {
                       controller.navigate(R.id.action_questionFragment_to_loseFragment);
                    }
                }
            }
        });
        return binding.getRoot();

    }
}
