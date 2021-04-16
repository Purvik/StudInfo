package com.purvik.studinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

public class AddStudentDialog extends DialogFragment {

    ////interface to handle the Events
    interface AddStudentDialogListener{

        void onSaveButtonClick(DialogFragment dialog);
        //void onCancelButtonClick(DialogFragment dialog);

    }

    //create an Instance to deliver the action
    AddStudentDialogListener addStudentListener;
    Context context;

    // Override the Fragment.onAttach() method to instantiate the SetAddStudentListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the SetAddStudentListener so we can send events to the host
            addStudentListener = (AddStudentDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement AddStudentDialogListener");
        }
    }
    //END

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.student_form, null))
                // Add action buttons
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        addStudentListener.onSaveButtonClick(AddStudentDialog.this);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddStudentDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
