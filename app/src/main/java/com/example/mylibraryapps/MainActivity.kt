package com.example.mylibraryapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylibraryapps.Adapter.ListUserAdapter
import com.example.mylibraryapps.Model.User
import com.example.mylibraryapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<User>()
    private lateinit var  mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        supportActionBar?.hide()

        list.addAll(getDataUser())
        showRecylerList()
    }
    private fun showRecylerList(){
        mainBinding.rvUser.layoutManager = LinearLayoutManager(this)
        var listUserAdapter = ListUserAdapter(list)
        mainBinding.rvUser.setHasFixedSize(true)
        mainBinding.rvUser.adapter = listUserAdapter
    }

    private fun getDataUser(): ArrayList<User> {
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataLike = resources.getStringArray(R.array.like)
        val dataLocation = resources.getStringArray(R.array.location)
        val listUsers = ArrayList<User>()
        for(position in dataName.indices){
            val user = User(
                dataName[position],
                dataUsername[position],
                dataPhoto.getResourceId(position,-1),
                dataFollowers[position].toInt(),
                dataFollowing[position].toInt(),
                dataCompany[position],
                dataLike[position].toInt(),
                dataLocation[position],
            )
            listUsers.add(user)
        }
        return listUsers

    }
}