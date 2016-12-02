package com.ericseychal.calculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hugo.weaving.DebugLog;


/**
 * A simple {@link Fragment} subclass.
 */
public class NormalFragment extends Fragment implements View.OnClickListener {
    OnNormalFragmentListener onNormalFragmentListener;

    public void setOnNormalFragmentListener(OnNormalFragmentListener onNormalFragmentListener) {
        this.onNormalFragmentListener = onNormalFragmentListener;
    }

    public NormalFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_normal, container, false);
            initialButtons(view);
//            onNormalFragmentListener = (OnNormalFragmentListener) getActivity();

        return view;
    }

    @DebugLog
    private void initialButtons(View view) {
        int[] idButton = {R.id.clear_button, R.id.addition_button, R.id.multilication_button, R.id.point_button, R.id.substraction_button, R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9};

        for (int ids : idButton) {
            view.findViewById(ids).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String touch = button.getText().toString();
        if (onNormalFragmentListener != null) {
            onNormalFragmentListener.onClickButton(touch);
        }
    }
}
