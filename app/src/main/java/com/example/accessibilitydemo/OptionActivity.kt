package com.example.accessibilitydemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.accessibilitydemo.databinding.ActivityOptionBinding

class OptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val to: String? = intent.getStringExtra(NAVIGATION)
        if (to != null) {
            showSelectedOption(to)
        } else {
            // Handle the intent this activity was launched with.
            intent?.handleIntent()
        }
    }

    fun showSelectedOption(str: String) {
        // Handle navigation view item clicks here.

        when (str) {
            TRANSFER -> {
                title = getString(R.string.title_transfer)
                // Handle the overview action
                // Load OverviewFragment

                var transferFragment =
                    getSupportFragmentManager().findFragmentById(R.id.fragment_container)
                if (transferFragment == null || transferFragment !is TransferFragment) {
                    transferFragment =
                        TransferFragment.newInstance()
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, transferFragment).commit();
                }
            }
            SHARE -> {
                title = getString(R.string.title_share)
                // Handle the overview action
                // Load OverviewFragment

                var shareFragment =
                    getSupportFragmentManager().findFragmentById(R.id.fragment_container)
                if (shareFragment == null || shareFragment !is ShareFragment) {
                    shareFragment =
                        ShareFragment.newInstance()
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, shareFragment).commit();
                }
            }
        }
    }

    private fun handleDeepLink(data: Uri?) {
        when (data?.path) {
            DeepLink.SHARE -> {
                updateView(ShareFragment::class.java)
            }
            DeepLink.TRANSFER -> {
                updateView(TransferFragment::class.java)
            }
            else -> {
                // Path is not supported or invalid, start normal flow.
                showDefaultView()
            }
        }
    }

    private fun Intent.handleIntent() {
        when (action) {
            // When the action is triggered by a deep-link, Intent.ACTION_VIEW will be used
            Intent.ACTION_VIEW -> handleDeepLink(data)
            // Otherwise start the app as you would normally do.
            else -> showDefaultView()
        }
    }

    /**
     * Show ongoing activity or stats if none
     */
    private fun showDefaultView() {
        /*val onGoing = FitRepository.getInstance(this).getOnGoingActivity().value
        val fragmentClass = if (onGoing != null) {
            FitTrackingFragment::class.java
        } else {
            FitStatsFragment::class.java
        }
        updateView(fragmentClass)*/
    }

    /**
     * Utility method to update the Fragment with the given arguments.
     */
    private fun updateView(
        newFragmentClass: Class<out Fragment>,
        toBackStack: Boolean = false
    ) {
        val currentFragment = supportFragmentManager.fragments.firstOrNull()
        if (currentFragment != null && currentFragment::class.java == newFragmentClass) {
            return
        }

        val fragment = supportFragmentManager.fragmentFactory.instantiate(
            newFragmentClass.classLoader!!,
            newFragmentClass.name
        )

        supportFragmentManager.beginTransaction().run {
            replace(R.id.fragment_container, fragment)
            if (toBackStack) {
                addToBackStack(null)
            }
            commit()
        }
    }
}