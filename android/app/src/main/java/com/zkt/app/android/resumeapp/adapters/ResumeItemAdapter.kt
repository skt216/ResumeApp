package com.zkt.app.android.resumeapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zkt.app.android.resumeapp.R
import com.zkt.app.android.resumeapp.interfaces.OnResumeMainItemClick
import kotlinx.android.synthetic.main.list_item_home.view.*

class ResumeItemAdapter(val mainItems: Array<String>, val context:Context?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onResumeMainItemClick: OnResumeMainItemClick? = null;

    fun setOnResumeMainItemClick(onResumeMainItemClick: OnResumeMainItemClick) {
        this.onResumeMainItemClick = onResumeMainItemClick;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //To change body of created functions use File | Settings | File Templates.
        return ResumeMainItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_home, parent, false))
    }

    override fun getItemCount(): Int {
        //To change body of created functions use File | Settings | File Templates.
        return mainItems.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //To change body of created functions use File | Settings | File Templates.
        val viewHolder: ResumeMainItemViewHolder = holder as ResumeMainItemViewHolder;
        viewHolder?.resumeItemTextView?.text = mainItems[position]

        viewHolder.itemView.setOnClickListener {
            onResumeMainItemClick?.onResumeMainItemClick(position)
        }
    }

    class ResumeMainItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val resumeItemTextView = itemView.listItemHome_text_name;
    }
}