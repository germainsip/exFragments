package com.afpa.frag1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TopFragment extends Fragment {
    private EditText inputTopImageText;
    private EditText inputBottomImageText;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_top,container,false);

        inputTopImageText = (EditText) view.findViewById(R.id.input_top_image_text);
        inputBottomImageText = (EditText) view.findViewById(R.id.input_bottom_image_text);

        Button applyButton = (Button) view.findViewById(R.id.button_send);

        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyText();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof MainActivity){
            this.mainActivity = (MainActivity) context;
        }
    }

    private void applyText() {
        String topText = this.inputTopImageText.getText().toString();
        String bottomText = this.inputBottomImageText.getText().toString();

        this.mainActivity.showText(topText,bottomText);
    }
}
