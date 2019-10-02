package com.zkt.app.android.resumeapp


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import com.zkt.app.android.resumeapp.fragments.AboutMeFragment
import com.zkt.app.android.resumeapp.fragments.HomeFragment
import com.zkt.app.android.resumeapp.fragments.ProjectsFragment
import com.zkt.app.android.resumeapp.interfaces.OnFragmentInteractionListener
import com.zkt.app.android.resumeapp.models.Project
import com.zkt.app.android.resumeapp.models.User
import java.io.StringReader

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    private var db: FirebaseFirestore? = null
    private var loadingLinearLayout : LinearLayout? = null;

    private var user:User? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadingLinearLayout = findViewById(R.id.linear_home_loadingContainer);

        db = FirebaseFirestore.getInstance()

        showInitialLoading(true);
        val myData = db!!.collection("Users")
        myData.get().addOnSuccessListener { document ->
            if (document != null) {
                Log.d("skt", "data = $document")
                setUserData(document.documents)
                showInitialLoading(false)
                openHomePage()
            } else {

            }
        }
            .addOnFailureListener { exception ->

            }
    }

    fun getUser(): User? {
        return user
    }

    private fun showInitialLoading(show: Boolean) {
        if (show) {
            loadingLinearLayout?.visibility = View.VISIBLE
        } else {
            loadingLinearLayout?.visibility = View.INVISIBLE
        }
    }

    private fun setUserData (documentList: List<DocumentSnapshot>) {
        documentList.forEach {
            @Suppress("UNCHECKED_CAST")
            val projectList = it.get("Projects") as ArrayList<HashMap<String, *>>

            user = User();
            user?.setAbout(it.get("About Me") as String)
            user?.setProjects(projectList)

            Log.d("skt", "projects = $projectList");
        }
    }

    private fun openHomePage() {
        val transaction = supportFragmentManager.beginTransaction();
        val fragment = HomeFragment();
        fragment.setFragmentTransactionListener(this);
        transaction.replace(R.id.frameLayout_main_fragmentContainer, fragment);
        transaction.commit()
    }

    private fun openAboutMePage() {
        val transaction = supportFragmentManager.beginTransaction();
        val fragment = AboutMeFragment()
        val bundle = Bundle()
        bundle.putString("About Me", user?.getAbout())
        fragment.arguments = bundle


        transaction.replace(R.id.frameLayout_main_fragmentContainer, fragment);
        transaction.addToBackStack("About Me")
        transaction.commit()
    }

    private fun openProjectsPage() {
        val transaction = supportFragmentManager.beginTransaction();
        val fragment = ProjectsFragment()
        /*val bundle = Bundle()
        bundle.putString("About Me", user?.getAbout())
        fragment.arguments = bundle*/


        transaction.replace(R.id.frameLayout_main_fragmentContainer, fragment);
        transaction.addToBackStack("Projects")
        transaction.commit()
    }

    override fun onFragmentChange(name: String) {
        if (name == "About Me") {
            openAboutMePage()
        } else if (name == "Projects") {
            openProjectsPage()
        }
    }

    override fun onFragmentData(params: Array<String>) {
        //To change body of created functions use File | Settings | File Templates.
    }
}
