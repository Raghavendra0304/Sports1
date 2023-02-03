package com.nani.sportsinteractiveapp.ActivityScreens

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nani.sportsinteractiveapp.API.MatchDetailsInterface
import com.nani.sportsinteractiveapp.API.MatchRetrofitInstance
import com.nani.sportsinteractiveapp.Model.MatchDetails
import com.nani.sportsinteractiveapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
lateinit var matchDetailsInterface: MatchDetailsInterface
lateinit var binding: ActivityMainBinding
lateinit var progressDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        matchDetailsInterface = MatchRetrofitInstance.getmatchDetails().create(MatchDetailsInterface::class.java)

        progressDialog = ProgressDialog(this)
        progressDialog.show()
        progressDialog.setMessage("Loading....")

        val getDetails = matchDetailsInterface.getDetailsInterface()
        getDetails.enqueue(object : Callback<MatchDetails>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<MatchDetails>, response: Response<MatchDetails>) {
                when(response.code()){
                    200 -> {
                        progressDialog.dismiss()

                        val M: MatchDetails = response.body()!!
                        Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
                        Log.d("Tag",""+M.Matchdetail.Series.Name)
                        binding.matchTitle.text=M.Matchdetail.Series.Name
                        binding.dateTitle.text="Date: "+M.Matchdetail.Match.Date
                        binding.timeTitle.text="Time: "+M.Matchdetail.Match.Time
                        binding.venueTitle.text="Venue: "+M.Matchdetail.Venue.Name
                    }
                }
            }

            override fun onFailure(call: Call<MatchDetails>, t: Throwable) {
                Toast.makeText(applicationContext, ""+t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
        binding.apply {
            aboutBtn.setOnClickListener(View.OnClickListener {
                val intent:Intent= Intent(this@MainActivity, TeamsActivity::class.java)
                startActivity(intent)
            })
        }
    }
}