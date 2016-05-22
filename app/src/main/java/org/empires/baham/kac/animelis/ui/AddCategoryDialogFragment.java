package org.empires.baham.kac.animelis.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.empires.baham.kac.animelis.R;

/**
 * Created by Chatofrey on 28/04/2016.
 * chatofrey@gmail.com
 * Animelis
 */
public class AddCategoryDialogFragment extends DialogFragment {


    private TextView mCategoryName;

    public static AddCategoryDialogFragment newInstance() {

        Bundle args = new Bundle();
        AddCategoryDialogFragment fragment = new AddCategoryDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater()
                .inflate(R.layout.add_category, null);

        mCategoryName = (TextView) view.findViewById(R.id.category_name);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton(R.string.add_category, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), mCategoryName.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                });

        return builder.create();
    }
}
