package com.zkt.app.android.resumeapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zkt.app.android.resumeapp.MainActivity
import com.zkt.app.android.resumeapp.R
import com.zkt.app.android.resumeapp.adapters.ProjectsItemAdapter
import com.zkt.app.android.resumeapp.models.Project

class ProjectsFragment : Fragment() {

    private var projectRecyclerView : RecyclerView? = null;
    private var projectList: ArrayList<HashMap<String, *>>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_projects, container, false)

        projectRecyclerView = rootView.findViewById(R.id.projects_recyclerView_projects);

        getProjectList()
        setProjectList()

        return rootView
    }

    private fun getProjectList() {
        projectList = (activity as MainActivity).getUser()?.getProjects()
    }

    private fun setProjectList() {
        val projectAdapter = projectList?.let { ProjectsItemAdapter(it, activity) };

        projectRecyclerView?.layoutManager = LinearLayoutManager(activity);
        projectRecyclerView?.adapter = projectAdapter
    }
}