package com.nani.sportsinteractiveapp.ActivityScreens

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nani.sportsinteractiveapp.API.MatchDetailsInterface
import com.nani.sportsinteractiveapp.API.MatchRetrofitInstance
import com.nani.sportsinteractiveapp.Adapters.Adapter
import com.nani.sportsinteractiveapp.Adapters.TeamB_Adapter
import com.nani.sportsinteractiveapp.Model.MatchDetails
import com.nani.sportsinteractiveapp.Model.PlayersInfo
import com.nani.sportsinteractiveapp.databinding.ActivityTeamsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamsActivity : AppCompatActivity(){
    lateinit var binding: ActivityTeamsBinding
    lateinit var matchDetailsInterface: MatchDetailsInterface
    lateinit var adapter: Adapter
    lateinit var adapterB: TeamB_Adapter
    lateinit var progressDialog: ProgressDialog
    var players = ArrayList<PlayersInfo>()
    var playersB = ArrayList<PlayersInfo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        progressDialog = ProgressDialog(this)
        progressDialog.show()

        matchDetailsInterface =
            MatchRetrofitInstance.getmatchDetails().create(MatchDetailsInterface::class.java)
        binding.recyclerlist.setHasFixedSize(true)
        binding.recyclerlist.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapter = Adapter(this,players)
        binding.recyclerlist.adapter = adapter

        binding.recyclerlistB.setHasFixedSize(true)
        binding.recyclerlistB.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        adapterB= TeamB_Adapter(this,playersB)
        binding.recyclerlistB.adapter = adapterB
        loadTeams()
    }


     private fun loadTeams() {
         val getTeams = matchDetailsInterface.getDetailsInterface()
         getTeams.enqueue(object :Callback<MatchDetails>{
             @SuppressLint("NotifyDataSetChanged")
             override fun onResponse(call: Call<MatchDetails>, response: Response<MatchDetails>) {
                 when (response.code()) {
                     200 -> {
                         progressDialog.dismiss()
                         //Toast.makeText(applicationContext, "Success in screentwo", Toast.LENGTH_SHORT).show()
                         val playerdetails: MatchDetails = response.body()!!
                         val info = playerdetails.Teams.x4.Players
                         players.add(PlayersInfo(info.x3852.Batting,info.x3852.Bowling,"Captain",info.x3852.Name_Full,info.x3852.Position))
                         players.add(PlayersInfo(info.x3722.Batting,info.x3722.Bowling,"",info.x3722.Name_Full,info.x3722.Position))
                         players.add(PlayersInfo(info.x66818.Batting,info.x66818.Bowling,"",info.x66818.Name_Full,info.x66818.Position))
                         players.add(PlayersInfo(info.x4176.Batting,info.x4176.Bowling,"",info.x4176.Name_Full,info.x4176.Position))
                         players.add(PlayersInfo(info.x3632.Batting,info.x3632.Bowling,"Keeper",info.x3632.Name_Full,info.x3632.Position))
                         players.add(PlayersInfo(info.x4532.Batting,info.x4532.Bowling,"",info.x4532.Name_Full,info.x4532.Position))
                         players.add(PlayersInfo(info.x63751.Batting,info.x63751.Bowling,"",info.x63751.Name_Full,info.x63751.Position))
                         players.add(PlayersInfo(info.x63187.Batting,info.x63187.Bowling,"",info.x63187.Name_Full,info.x63187.Position))
                         players.add(PlayersInfo(info.x9844.Batting,info.x9844.Bowling,"",info.x9844.Name_Full,info.x9844.Position))
                         players.add(PlayersInfo(info.x5132.Batting,info.x5132.Bowling,"",info.x5132.Name_Full,info.x5132.Position))
                         players.add(PlayersInfo(info.x65867.Batting,info.x65867.Bowling,"",info.x65867.Name_Full,info.x65867.Position))

                         val bTeamPlayers: MatchDetails = response.body()!!
                         val bTeamInfo = bTeamPlayers.Teams.x5.Players
                         playersB.add(PlayersInfo(bTeamInfo.x4964.Batting,bTeamInfo.x4964.Bowling,"",bTeamInfo.x4964.Name_Full,bTeamInfo.x4964.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x57594.Batting,bTeamInfo.x57594.Bowling,"",bTeamInfo.x57594.Name_Full,bTeamInfo.x57594.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x4330.Batting,bTeamInfo.x4330.Bowling,"Captain",bTeamInfo.x4330.Name_Full,bTeamInfo.x4330.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x3752.Batting,bTeamInfo.x3752.Bowling,"",bTeamInfo.x3752.Name_Full,bTeamInfo.x3752.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x10167.Batting,bTeamInfo.x10167.Bowling,"Keeper",bTeamInfo.x10167.Name_Full,bTeamInfo.x10167.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x10172.Batting,bTeamInfo.x10172.Bowling,"",bTeamInfo.x10172.Name_Full,bTeamInfo.x10172.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x57903.Batting,bTeamInfo.x57903.Bowling,"",bTeamInfo.x57903.Name_Full,bTeamInfo.x57903.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x11703.Batting,bTeamInfo.x11703.Bowling,"",bTeamInfo.x11703.Name_Full,bTeamInfo.x11703.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x11706.Batting,bTeamInfo.x11706.Bowling,"",bTeamInfo.x11706.Name_Full,bTeamInfo.x11706.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x60544.Batting,bTeamInfo.x60544.Bowling,"",bTeamInfo.x60544.Name_Full,bTeamInfo.x60544.Position))
                         playersB.add(PlayersInfo(bTeamInfo.x4338.Batting,bTeamInfo.x4338.Bowling,"",bTeamInfo.x4338.Name_Full,bTeamInfo.x4338.Position))


                         adapter.notifyDataSetChanged()
                         adapterB.notifyDataSetChanged()

                     }
                     400 ->{
                         Toast.makeText(applicationContext, "Something went wrong please try after some time", Toast.LENGTH_SHORT).show()
                     }
                 }
             }

             override fun onFailure(call: Call<MatchDetails>, t: Throwable) {
                 Toast.makeText(applicationContext, ""+t.localizedMessage, Toast.LENGTH_SHORT).show()
             }

         })

     }
}

