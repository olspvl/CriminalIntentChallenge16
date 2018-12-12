package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class CrimePhotoFragment extends DialogFragment {

    private ImageView mImageView;

    private static final String ARG_PATH = "path";

    public static CrimePhotoFragment newInstance(String path) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PATH, path);

        CrimePhotoFragment fragment = new CrimePhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String path = getArguments().getString(ARG_PATH);
        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.fragment_photo, null);
        mImageView = (ImageView) v.findViewById(R.id.crime_full_photo);
        Bitmap bitmap = PictureUtils.getScaledBitmap(
                path, getActivity());
        mImageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v).create();
    }
}
