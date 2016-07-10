package com.codekul.fragments;


//import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater
                .inflate(R.layout.fragment_first, container, false);

        animate(R.anim.rotate,rootView.findViewById(R.id.textHeader));

        rootView.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity hostActivity = (MainActivity)
                        getActivity();
                hostActivity.runFragmentTxn(R.id.frameContainer,
                        new LoginFragment());
            }
        });

        rootView.findViewById(R.id.btnRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity hostActivity = (MainActivity)
                        getActivity();
                hostActivity.runFragmentTxn(R.id.frameContainer,
                        new RegisterFragment());
            }
        });
        return rootView;
    }

    private void animate(int id, View view){
        Animation animation = AnimationUtils.loadAnimation(getActivity(),id);
        animation.setRepeatMode(Animation.INFINITE);
        animation.setRepeatCount(-1);
        view.startAnimation(animation);
    }

}
