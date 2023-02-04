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
import com.nani.sportsinteractiveapp.Model.PlayersInfo
import com.nani.sportsinteractiveapp.Model2.SecondMatchModelClass
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
                progressDialog.dismiss()
                when(response.code()){
                    200 -> {


                        val M: MatchDetails = response.body()!!
                        binding.matchTitle.text=M.Matchdetail.Series.Name
                        binding.dateTitle.text="Date: "+M.Matchdetail.Match.Date
                        binding.timeTitle.text="Time: "+M.Matchdetail.Match.Time
                        binding.venueTitle.text="Venue: "+M.Matchdetail.Venue.Name
                    }
                }
            }

            override fun onFailure(call: Call<MatchDetails>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(applicationContext, ""+t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
        binding.apply {
            aboutBtn.setOnClickListener(View.OnClickListener {
                val intent = Intent(this@MainActivity, TeamsActivity::class.java)
                intent.putExtra("TeamVal",1)
                startActivity(intent)
            })
        }

        val getMatch2Details = matchDetailsInterface.getMatch2DetailsInterface()
        getMatch2Details.enqueue(object :Callback<SecondMatchModelClass>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<SecondMatchModelClass>,
                response: Response<SecondMatchModelClass>,
            ) {
                progressDialog.dismiss()
                when(response.code()){
                    200->{
                        val M2:SecondMatchModelClass = response.body()!!
                        binding.matchTitle2.text = ""+M2.Matchdetail.Series.Name
                        binding.dateTitle2.text = "Date: "+M2.Matchdetail.Match.Date
                        binding.timeTitle2.text = "Time: "+M2.Matchdetail.Match.Time
                        binding.venueTitle2.text = "Venue: "+M2.Matchdetail.Venue.Name

                    }

                }
            }

            override fun onFailure(call: Call<SecondMatchModelClass>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(applicationContext, ""+t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
         binding.aboutBtn2.setOnClickListener(View.OnClickListener {
             val intent = Intent(this@MainActivity, TeamsActivity::class.java)
             intent.putExtra("TeamVal",2)
             startActivity(intent)
         })

    }
}