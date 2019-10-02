package com.zkt.app.android.resumeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.zkt.app.android.resumeapp.R

class AboutMeFragment : Fragment() {

    private var aboutMeTextView : TextView? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_about_me, container, false)

        aboutMeTextView = rootView.findViewById(R.id.aboutMe_textView_description);

        setAboutMe()

        return rootView
    }

    private fun setAboutMe() {
        val aboutMe = arguments?.get("About Me");
        aboutMeTextView?.text = aboutMe.toString();
    }
}