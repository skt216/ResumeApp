package com.zkt.app.android.resumeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.zkt.app.android.resumeapp.R
import com.zkt.app.android.resumeapp.adapters.ResumeItemAdapter
import com.zkt.app.android.resumeapp.interfaces.OnFragmentInteractionListener
import com.zkt.app.android.resumeapp.interfaces.OnResumeMainItemClick

class HomeFragment : Fragment(), OnResumeMainItemClick {
    private var resumeRecyclerView : RecyclerView? = null;

    private var onFragmentInteractionListener: OnFragmentInteractionListener? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        resumeRecyclerView = rootView.findViewById(R.id.homeFragment_recycler_resumeContents);

        setRecyclerViewInMainPage()

        return rootView
    }

    private fun setRecyclerViewInMainPage() {

        val resumeMainItem : Array<String> = arrayOf("About Me", "App Links", "Education",
                                                "Experience", "Name" , "Other Projects", "Personal",
                                                "Projects", "Skills")

        val resumeItemAdapter = ResumeItemAdapter(resumeMainItem, activity);
        resumeItemAdapter.setOnResumeMainItemClick(this);

        resumeRecyclerView?.layoutManager =LinearLayoutManager(activity);
        resumeRecyclerView?.adapter = resumeItemAdapter
    }

    fun setFragmentTransactionListener(onFragmentInteractionListener: OnFragmentInteractionListener) {
        this.onFragmentInteractionListener = onFragmentInteractionListener;
    }

    override fun onResumeMainItemClick(position: Int) {
        if (position == 0) {
            onFragmentInteractionListener?.onFragmentChange("About Me");
        } else if (position == 7) {
            onFragmentInteractionListener?.onFragmentChange("Projects")
        }
        //To change body of created functions use File | Settings | File Templates.
    }
}