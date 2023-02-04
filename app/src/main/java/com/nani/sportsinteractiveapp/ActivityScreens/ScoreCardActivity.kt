package com.nani.sportsinteractiveapp.ActivityScreens

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nani.sportsinteractiveapp.API.MatchDetailsInterface
import com.nani.sportsinteractiveapp.API.MatchRetrofitInstance
import com.nani.sportsinteractiveapp.Adapters.ScoreCardAdapter
import com.nani.sportsinteractiveapp.Model.*
import com.nani.sportsinteractiveapp.R
import com.nani.sportsinteractiveapp.databinding.ActivityScoreCardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import kotlin.math.log

class ScoreCardActivity : AppCompatActivity() {
    lateinit var binding: ActivityScoreCardBinding
    lateinit var matchDetailsInterface: MatchDetailsInterface
    lateinit var scoreCardAdapter: ScoreCardAdapter
    var batsmenInfo = ArrayList<BatsmenDetails>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        matchDetailsInterface =
            MatchRetrofitInstance.getmatchDetails().create(MatchDetailsInterface::class.java)

        binding.recyclerScorecard.setHasFixedSize(true)

        binding.recyclerScorecard.layoutManager = LinearLayoutManager(this)

        scoreCardAdapter = ScoreCardAdapter(this, batsmenInfo)
        binding.recyclerScorecard.adapter = scoreCardAdapter

        getBatsmenInfo()


    }

    private fun getBatsmenInfo() {
        val getBatsmenStats = matchDetailsInterface.getBatsmenStats()
        getBatsmenStats.enqueue(object : Callback<Inning> {
            override fun onResponse(call: Call<Inning>, response: Response<Inning>) {
                when (response.code()) {
                    200 ->{
                        val inning:Inning = response.body()!!
                       // Log.d("Hello",""+response.body())
                        val btsmn = inning.Batsmen
                        Toast.makeText(applicationContext, "success "+btsmn, Toast.LENGTH_SHORT).show()

                    /*for (batsmendata in btsmn){
                           val batsmenName = batsmendata.Batsman
                           val ballsFaced = batsmendata.Balls
                            val fours = batsmendata.Fours
                            val sixes = batsmendata.Sixes
                            val strikeRate = batsmendata.Strikerate
                            val runsScored = batsmendata.Runs

                            Toast.makeText(applicationContext, ""+batsmenName, Toast.LENGTH_SHORT).show()

                            *//*batsmenInfo.add(BatsmenDetails(""+ballsFaced,""+batsmenName,""+fours,""+runsScored,""+sixes,""+strikeRate))
                            scoreCardAdapter = ScoreCardAdapter(applicationContext, batsmenInfo)
                            binding.recyclerScorecard.adapter = scoreCardAdapter
                            scoreCardAdapter.notifyDataSetChanged()*//*

                        }*/

                    }
                }
            }

            override fun onFailure(call: Call<Inning>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}
