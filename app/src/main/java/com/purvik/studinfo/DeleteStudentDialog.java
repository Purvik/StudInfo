package com.purvik.studinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Created by 3537 on 30-11-2015.
 */
public class DeleteStudentDialog extends DialogFragment {

    ////interface to handle the Events
    interface DeleteStudentDialogListener{

        void onDeleteButtonClick(DialogFragment dialog);
        //void onCancelButtonClick(DialogFragment dialog);

    }

    //create an Instance to deliever the action
    DeleteStudentDialogListener deleteStudentListener;
    Context context;

    // Override the Fragment.onAttach() method to instantiate the SetPasswordDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the deleteStudentListener  so we can send events to the host
            deleteStudentListener = (DeleteStudentDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement DeleteStudentDialogListener");
        }
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.delete_student, null))

                // Add action buttons
                .setPositiveButton(R.string.btnLabel_delete, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        deleteStudentListener.onDeleteButtonClick(DeleteStudentDialog.this);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DeleteStudentDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();

    }
}
