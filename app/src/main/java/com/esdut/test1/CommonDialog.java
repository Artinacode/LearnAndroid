package com.esdut.test1;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

public class CommonDialog extends AlertDialog {

    protected CommonDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p10_custom_dialog);
    }
}
