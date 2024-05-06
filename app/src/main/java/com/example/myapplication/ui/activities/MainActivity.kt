package com.example.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var navController: NavController? = null
    private var navHostFragment: NavHostFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment?.navController
        navController?.addOnDestinationChangedListener(this)
        navController?.let { binding?.bottomNav?.setupWithNavController(it) }
        binding.run {
            bottomNav.setOnNavigationItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.fragment_home -> {
                        // Handle Home item click
                        if (navController?.currentDestination?.id != R.id.idHomeFragment) {
                            navController?.popBackStack()
                            navController?.navigate(R.id.idHomeFragment)
                        }
//                        navController?.navigate(R.id.idHomeFragment)
                        true
                    }

                    R.id.fragment_tools -> {
                        // Handle Search item click
//                        navController?.navigate(R.id.idMoreFragment)
                        if (navController?.currentDestination?.id != R.id.idToolsFragment) {
                            navController?.popBackStack()
                            navController?.navigate(R.id.idToolsFragment)
                        }
                        true
                    }

                    else -> false
                }
            }

        }
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {

    }
}