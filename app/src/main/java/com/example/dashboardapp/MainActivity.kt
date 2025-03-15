package com.example.dashboardapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dashboardapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Define your target app package names and GitHub URLs here
    private val compilerPackage = "com.example.compiler" // replace with actual package name
    private val compilerGitHub = "https://github.com/Umaidkhan12/Compiler.git"

    private val broadcastingPackage = "com.example.broadcastingandgps" // replace with actual package name
    private val broadcastingGitHub = "https://github.com/Umaidkhan12/BroadcastingAndGPS.git"

    private val uberClonePackage = "com.example.uberclone" // replace with actual package name
    private val uberCloneGitHub = "https://github.com/Umaidkhan12/Uber_Clone.git"

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =  binding.root

        enableEdgeToEdge()
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set click listeners for each project button
        binding.cardCompiler.setOnClickListener {
            launchAppOrRedirect(compilerPackage, compilerGitHub)
        }

        binding.cardBroadcasting.setOnClickListener {
            launchAppOrRedirect(broadcastingPackage, broadcastingGitHub)
        }

        binding.cardUberClone.setOnClickListener {
            launchAppOrRedirect(uberClonePackage, uberCloneGitHub)
        }
    }

    /**
     * Checks if the given package is installed.
     */
    private fun isAppInstalled(packageName: String): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    /**
     * Launches the target app if installed, otherwise opens the GitHub URL in a browser.
     */
    private fun launchAppOrRedirect(packageName: String, githubUrl: String) {
        Log.d("MainActivity", "Checking installation for package: $packageName")
        if (isAppInstalled(packageName)) {
            val launchIntent = packageManager.getLaunchIntentForPackage(packageName)
            Log.d("MainActivity", "Launch intent: $launchIntent")
            if (launchIntent != null) {
                startActivity(launchIntent)
                return
            } else {
                Log.e("MainActivity", "No launcher activity for package: $packageName")
            }
        }
        // If not installed or no launch intent available, open the GitHub link
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
        startActivity(browserIntent)
    }
}