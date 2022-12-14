package com.example.dagger_hilt_mvvm_room_ld_nav_coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.dagger_hilt_mvvm_room_ld_nav_coroutines.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //View binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var mNavController: NavController
    private lateinit var mAppBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationView()
    }

    private fun setupNavigationView() {
        val navHostFrag =
            supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment

        mNavController = navHostFrag.navController

        setupActionBarWithNavController(mNavController)
        mAppBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.todoListFragment,
                R.id.addTodoFragment,
            )
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp(mAppBarConfiguration) || super.onSupportNavigateUp()
    }


}