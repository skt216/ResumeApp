package com.zkt.app.android.resumeapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zkt.app.android.resumeapp.R
import com.zkt.app.android.resumeapp.interfaces.OnProjectItemClick
import com.zkt.app.android.resumeapp.interfaces.OnResumeMainItemClick
import com.zkt.app.android.resumeapp.models.Project
import kotlinx.android.synthetic.main.list_item_projects.view.*
import java.util.*

class ProjectsItemAdapter(val projectItems: ArrayList<HashMap<String, *>>, val context: Context?) :

    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onProjectItemClick: OnProjectItemClick? = null;

    fun setOnProjectItemClick(onProjectItemClick: OnProjectItemClick) {
        this.onProjectItemClick = onProjectItemClick;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //To change body of created functions use File | Settings | File Templates.
        return ProjectItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_projects, parent, false))
    }

    override fun getItemCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        return projectItems.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //To change body of created functions use File | Settings | File Templates.
        val viewHolder: ProjectItemViewHolder = holder as ProjectItemViewHolder;
        viewHolder.nameItemTextView?.text = projectItems[position]["Name"] as String
        viewHolder.descriptionTextView?.text = projectItems[position]["Description"] as String
        viewHolder.projectNumberTextView?.text = "#" + projectItems[position]["num"]
    }

    class ProjectItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameItemTextView = itemView.listItemProjects_text_name;
        val descriptionTextView = itemView.listItemProjects_text_desc
        val projectNumberTextView = itemView.listItemProjects_text_projectNum
    }
}