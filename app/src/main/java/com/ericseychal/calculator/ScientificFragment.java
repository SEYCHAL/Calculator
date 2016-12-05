package com.ericseychal.calculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hugo.weaving.DebugLog;


public class ScientificFragment extends Fragment implements View.OnClickListener  {
    OnNormalFragmentListener onNormalFragmentListener;

    public void setOnNormalFragmentListener(OnNormalFragmentListener onNormalFragmentListener) {
        this.onNormalFragmentListener = onNormalFragmentListener;
    }

    public ScientificFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scientific, container, false);
        initialButtons(view);
        return view;
    }

    @DebugLog
    private void initialButtons(View view) {
        int[] idButton = {R.id.sin,R.id.cos,R.id.tan,R.id.carre,R.id.sin_1,R.id.cos_1,R.id.tan_1,R.id.x3,R.id.ex,R.id.power10,R.id.x1,R.id.xy,R.id.ln,R.id.log,R.id.sqrl,R.id.sign};

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
