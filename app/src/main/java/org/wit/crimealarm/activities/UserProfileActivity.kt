package org.wit.crimealarm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.wit.crimealarm.R
import org.wit.crimealarm.databinding.ActivityLoginBinding
import org.wit.crimealarm.databinding.ActivityUserProfileBinding
import org.wit.crimealarm.models.User
import org.wit.crimealarm.utils.Constants




class UserProfileActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUserProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityUserProfileBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Create a instance of the User model class.
        var userDetails: User = User()
        if(intent.hasExtra(Constants.EXTRA_USER_DETAILS)) {
            // Get the user details from intent as a ParcelableExtra.
            userDetails = intent.getParcelableExtra(Constants.EXTRA_USER_DETAILS)!!
        }

        binding.etFirstName.isEnabled = false
        binding.etFirstName.setText(userDetails.firstName)

        binding.etLastName.isEnabled = false
        binding.etLastName.setText(userDetails.lastName)

        binding.etEmail.isEnabled = false
        binding.etEmail.setText(userDetails.email)

        binding.ivUserPhoto.setOnClickListener(this@UserProfileActivity)

    }

//    override fun onClick(p0: View?) {
//        TODO("Not yet implemented")
//    }
}