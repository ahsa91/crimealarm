package org.wit.crimealarm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.wit.crimealarm.R
import org.wit.crimealarm.databinding.ActivitySettingsBinding
import org.wit.crimealarm.firestore.FirestoreClass
import org.wit.crimealarm.models.User
import org.wit.crimealarm.utils.GlideLoader

class SettingsActivity : BaseActivity() {

    private lateinit var binding: ActivitySettingsBinding

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {

        binding=ActivitySettingsBinding.inflate(layoutInflater)

        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(binding.root)


        setupActionBar()

    }


    override fun onResume() {
        super.onResume()

        getUserDetails()
    }
    // END


    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {

        setSupportActionBar(binding.toolbarSettingsActivity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        binding.toolbarSettingsActivity.setNavigationOnClickListener { onBackPressed() }
    }
    
    /**
     * A function to get the user details from firestore.
     */
    private fun getUserDetails() {

        // Show the progress dialog

        // Call the function of Firestore class to get the user details from firestore which is already created.
        FirestoreClass().getUserDetails(this@SettingsActivity)
    }


    /**
     * A function to receive the user details and populate it in the UI.
     */
    fun userDetailsSuccess(user: User) {

        // Load the image using the Glide Loader class.
        GlideLoader(this@SettingsActivity).loadUserPicture(user.image, binding.ivUserPhoto)

        binding.tvName.text = "${user.firstName} ${user.lastName}"
        binding.tvGender.text = user.gender
        binding.tvEmail.text = user.email
        binding.tvMobileNumber.text = "${user.mobile}"
    }
}