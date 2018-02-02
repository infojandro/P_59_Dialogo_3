package com.example.alu.p_59_dialogo_3;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by alu on 02/02/2018.
 */

public class MiDialogo extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        miEscuchador.onDialogPositiveClick(i+" "+i1+" "+i2);
    }
    public interface MiDialogoListener {
        void onDialogPositiveClick(String devuelto);
    }

    MiDialogoListener miEscuchador;

    // Sobreescribimos el método onAttach() para instanciar el
//escuchador
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            miEscuchador = (MiDialogoListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement MiDialogoListener");
        }
    }
    public void onDetach () {
        super.onDetach();
        miEscuchador=null;
    }
}
