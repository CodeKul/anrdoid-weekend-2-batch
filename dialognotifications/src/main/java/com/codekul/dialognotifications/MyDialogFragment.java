package com.codekul.dialognotifications;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {

    public static final String TAG_ALERT = "alert";
    public static final String TAG_DATE_PICKER = "datePicker";
    public static final String TAG_TIME_PICKER = "timePicker";
    public static final String TAG_PROGRESS_DIALOG = "progressDialog";
    public static final String TAG_CUSTOM = "custom";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if(getTag().equals(TAG_ALERT))
            dialog = createAlertDialog();
        else if(getTag().equals(TAG_DATE_PICKER))
            dialog = createDatePicker();
        else if(getTag().equals(TAG_TIME_PICKER))
            dialog = createTimePicker();
        else if(getTag().equals(TAG_PROGRESS_DIALOG))
            dialog = createProgressDialog();
        else dialog = createCustomDialog();

        return dialog;
    }

    private AlertDialog createAlertDialog(){

        AlertDialog.Builder bulder =
                new AlertDialog.Builder(getActivity())
                .setIcon(R.mipmap.ic_launcher)
                .setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mt("Yes Clicked");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mt("No Clicked");
                    }
                });

        AlertDialog dialog = bulder.create();

        return dialog;
    }

    private DatePickerDialog createDatePicker(){

        DatePickerDialog datePickerDialog =
                new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                mt(""+dayOfMonth +" - "+ (monthOfYear+1) +" - "+year);
                            }
                        },
                        2016,
                        6,
                        15);

        return datePickerDialog;
    }

    public TimePickerDialog createTimePicker(){

        TimePickerDialog timePickerDialog =
                new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                mt(""+hourOfDay + " : "+minute);
                            }
                        },12,57,true);

        return timePickerDialog;
    }

    private ProgressDialog createProgressDialog(){

        ProgressDialog progressDialog =
                new ProgressDialog(getActivity());
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Title");
        progressDialog.setMessage("Message");

        return progressDialog;
    }

    private AlertDialog createCustomDialog(){

        LayoutInflater inflater = getActivity()
                .getLayoutInflater();

        View myView = inflater.inflate(R.layout.fragment_my_dialog,null,false);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity())
                .setView(myView);

        return builder.create();

    }

    private void mt(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
