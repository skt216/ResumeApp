package com.zkt.app.android.resumeapp.models

class User {
    private var about: String? = null
    private var projects: ArrayList<HashMap<String, *>>? = null

    fun getAbout(): String? {
        return about;
    }

    fun setAbout(about: String) {
        this.about = about;
    }

    fun getProjects(): ArrayList<HashMap<String, *>>? {
        return projects;
    }

    fun setProjects(projects: ArrayList<HashMap<String, *>>) {
        this.projects = projects
    }
}