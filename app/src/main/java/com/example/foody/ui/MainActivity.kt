package com.example.foody.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.foody.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navcontroller:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navcontroll = findNavController(R.id.navhostfragment)
        val appbarconfig = AppBarConfiguration(setOf(R.id.recipeFragment, R.id.favoriteRecipesFragment, R.id.foodJokeFragment))
        bottomNavigationView.setupWithNavController(navcontroll)
        setupActionBarWithNavController(navcontroll,appbarconfig)
    }

    override fun onSupportNavigateUp(): Boolean {

        return navcontroller.navigateUp() || super.onSupportNavigateUp()
    }
}