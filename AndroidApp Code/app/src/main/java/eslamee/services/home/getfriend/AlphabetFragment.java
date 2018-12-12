package eslamee.services.home.getfriend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import eslamee.R;

/**
 * Created by Manjeet Singh on 7/27/2018.
 */

public class AlphabetFragment extends Fragment implements View.OnClickListener  {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26;
    TextView num;
    Context t1;
    public static char selected;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        t1 = getContext();
        View view = inflater.inflate(R.layout.alphabet_list,container,false);

        b1=(Button) view.findViewById(R.id.b1);
        b1.setOnClickListener(this);

        b2=(Button) view.findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3=(Button) view.findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4=(Button) view.findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5=(Button) view.findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6=(Button) view.findViewById(R.id.b6);
        b6.setOnClickListener(this);
        b7=(Button) view.findViewById(R.id.b7);
        b7.setOnClickListener(this);
        b8=(Button) view.findViewById(R.id.b8);
        b8.setOnClickListener(this);
        b9=(Button) view.findViewById(R.id.b9);
        b9.setOnClickListener(this);
        b10=(Button) view.findViewById(R.id.b10);
        b10.setOnClickListener(this);
        b11=(Button) view.findViewById(R.id.b11);
        b11.setOnClickListener(this);
        b12=(Button) view.findViewById(R.id.b12);
        b12.setOnClickListener(this);
        b13=(Button) view.findViewById(R.id.b13);
        b13.setOnClickListener(this);
        b14=(Button) view.findViewById(R.id.b14);
        b14.setOnClickListener(this);
        b15=(Button) view.findViewById(R.id.b15);
        b15.setOnClickListener(this);
        b16=(Button) view.findViewById(R.id.b16);
        b16.setOnClickListener(this);
        b17=(Button) view.findViewById(R.id.b17);
        b17.setOnClickListener(this);
        b18=(Button) view.findViewById(R.id.b18);
        b18.setOnClickListener(this);
        b19=(Button) view.findViewById(R.id.b19);
        b19.setOnClickListener(this);
        b20=(Button) view.findViewById(R.id.b20);
        b20.setOnClickListener(this);
        b21=(Button) view.findViewById(R.id.b21);
        b21.setOnClickListener(this);
        b22=(Button) view.findViewById(R.id.b22);
        b22.setOnClickListener(this);
        b23=(Button) view.findViewById(R.id.b23);
        b23.setOnClickListener(this);
        b24=(Button) view.findViewById(R.id.b24);
        b24.setOnClickListener(this);
        b25=(Button) view.findViewById(R.id.b25);
        b25.setOnClickListener(this);
        b26=(Button) view.findViewById(R.id.b26);
        b26.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {


        int id = view.getId();
        if(id == R.id.b1) {
            selected = 'A';
        }
        else if(id == R.id.b2)
            selected = 'B';
        else if(id == R.id.b3)
            selected = 'C';

        else if(id == R.id.b4)
            selected = 'D';
        else if(id == R.id.b5)
            selected = 'E';
        else if(id == R.id.b6)
            selected = 'F';
        else if(id == R.id.b7)
            selected = 'G';
        else if(id == R.id.b8)
            selected = 'H';
        else if(id == R.id.b9)
            selected = 'I';
        else if(id == R.id.b10)
            selected = 'J';
        else if(id == R.id.b11)
            selected = 'K';
        else if(id == R.id.b12)
            selected = 'L';
        else if(id == R.id.b13)
            selected = 'M';
        else if(id == R.id.b14)
            selected = 'N';
        else if(id == R.id.b15)
            selected = 'O';
        else if(id == R.id.b16)
            selected = 'P';
        else if(id == R.id.b17)
            selected = 'Q';
        else if(id == R.id.b18)
            selected = 'R';
        else if(id == R.id.b19)
            selected = 'S';
        else if(id == R.id.b20)
            selected = 'T';
        else if(id == R.id.b21)
            selected = 'U';
        else if(id == R.id.b22)
            selected = 'V';
        else if(id == R.id.b23)
            selected = 'W';
        else if(id == R.id.b24)
            selected = 'X';
        else if(id == R.id.b25)
            selected = 'Y';
        else if(id == R.id.b26)
            selected = 'Z';

        Intent intent = new Intent("android.intent.action.FRIENDLIST");

        startActivity(intent);






    }
}
