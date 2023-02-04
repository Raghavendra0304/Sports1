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
import com.nani.sportsinteractiveapp.Adapters.Match2ATeamAdapter
import com.nani.sportsinteractiveapp.Adapters.Match2BTeamAdapter
import com.nani.sportsinteractiveapp.Adapters.TeamB_Adapter
import com.nani.sportsinteractiveapp.Model.MatchDetails
import com.nani.sportsinteractiveapp.Model.PlayersInfo
import com.nani.sportsinteractiveapp.Model2.Match2PlayersInfo
import com.nani.sportsinteractiveapp.Model2.SecondMatchModelClass
import com.nani.sportsinteractiveapp.databinding.ActivityTeamsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamsActivity : AppCompatActivity(){
    lateinit var binding: ActivityTeamsBinding
    lateinit var matchDetailsInterface: MatchDetailsInterface

    lateinit var adapter: Adapter
    lateinit var adapterB: TeamB_Adapter

    lateinit var match2ATeamAdapter: Match2ATeamAdapter
    lateinit var match2BTeamAdapter: Match2BTeamAdapter

    lateinit var progressDialog: ProgressDialog

    var players = ArrayList<PlayersInfo>()
    var playersB = ArrayList<PlayersInfo>()

    var match2PlayerA = ArrayList<Match2PlayersInfo>()
    var match2PlayerB = ArrayList<Match2PlayersInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        val screenVal = intent.getIntExtra("TeamVal",1)

        progressDialog = ProgressDialog(this)
        progressDialog.show()

        matchDetailsInterface =
            MatchRetrofitInstance.getmatchDetails().create(MatchDetailsInterface::class.java)

        binding.recyclerlist.setHasFixedSize(true)
        binding.recyclerlistB.setHasFixedSize(true)

        binding.recyclerlist.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerlistB.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


        if (screenVal==1){
            adapter = Adapter(this,players)
            binding.recyclerlist.adapter = adapter

            adapterB= TeamB_Adapter(this,playersB)
            binding.recyclerlistB.adapter = adapterB


            loadTeams()
        }else {
            match2ATeamAdapter = Match2ATeamAdapter(this,match2PlayerA)
            binding.recyclerlist.adapter = match2ATeamAdapter

            match2BTeamAdapter = Match2BTeamAdapter(this,match2PlayerB)
            binding.recyclerlistB.adapter = match2BTeamAdapter

            loadMatch2Teams()}
    }

    private fun loadMatch2Teams() {
        val getMatch2Teams = matchDetailsInterface.getMatch2DetailsInterface()
        getMatch2Teams.enqueue(object :Callback<SecondMatchModelClass>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<SecondMatchModelClass>,
                response: Response<SecondMatchModelClass>,
            ) {
                progressDialog.dismiss()
                when(response.code()){
                    200 ->{

                        val match2playerDetails:SecondMatchModelClass =response.body()!!
                        val match2InfoA = match2playerDetails.Teams.x6.Players
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x63084.Batting,match2InfoA.x63084.Bowling,"","",match2InfoA.x63084.Name_Full,match2InfoA.x63084.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x57492.Batting,match2InfoA.x57492.Bowling,"","",match2InfoA.x57492.Name_Full,match2InfoA.x57492.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x59429.Batting,match2InfoA.x59429.Bowling,"","",match2InfoA.x59429.Name_Full,match2InfoA.x59429.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x3472.Batting,match2InfoA.x3472.Bowling,"","",match2InfoA.x3472.Name_Full,match2InfoA.x3472.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x2734.Batting,match2InfoA.x2734.Bowling,"","",match2InfoA.x2734.Name_Full,match2InfoA.x2734.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x4038.Batting,match2InfoA.x4038.Bowling,"Captain","Keeper",match2InfoA.x4038.Name_Full,match2InfoA.x4038.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x65739.Batting,match2InfoA.x65739.Bowling,"","",match2InfoA.x65739.Name_Full,match2InfoA.x65739.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x64073.Batting,match2InfoA.x64073.Bowling,"","",match2InfoA.x64073.Name_Full,match2InfoA.x64073.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x64321.Batting,match2InfoA.x64321.Bowling,"","",match2InfoA.x64321.Name_Full,match2InfoA.x64321.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x64306.Batting,match2InfoA.x64306.Bowling,"","",match2InfoA.x64306.Name_Full,match2InfoA.x64306.Position))
                        match2PlayerA.add(Match2PlayersInfo(match2InfoA.x66833.Batting,match2InfoA.x66833.Bowling,"","",match2InfoA.x66833.Name_Full,match2InfoA.x66833.Position))

                        val match2BplayerDetails:SecondMatchModelClass = response.body()!!
                        val match2InfoB = match2BplayerDetails.Teams.x7.Players
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x3667.Batting,match2InfoB.x3667.Bowling,"","",match2InfoB.x3667.Name_Full,match2InfoB.x3667.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x4356.Batting,match2InfoB.x4356.Bowling,"","",match2InfoB.x4356.Name_Full,match2InfoB.x4356.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x12518.Batting,match2InfoB.x12518.Bowling,"","",match2InfoB.x12518.Name_Full,match2InfoB.x12518.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x28891.Batting,match2InfoB.x28891.Bowling,"Captain","",match2InfoB.x28891.Name_Full,match2InfoB.x28891.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x5313.Batting,match2InfoB.x5313.Bowling,"","",match2InfoB.x5313.Name_Full,match2InfoB.x5313.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x59736.Batting,match2InfoB.x59736.Bowling,"","Keeper",match2InfoB.x59736.Name_Full,match2InfoB.x59736.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x64221.Batting,match2InfoB.x64221.Bowling,"","",match2InfoB.x64221.Name_Full,match2InfoB.x64221.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x63611.Batting,match2InfoB.x63611.Bowling,"","",match2InfoB.x63611.Name_Full,match2InfoB.x63611.Position))

                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x24669.Batting,match2InfoB.x24669.Bowling,"","",match2InfoB.x24669.Name_Full,match2InfoB.x24669.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x48191.Batting,match2InfoB.x48191.Bowling,"","",match2InfoB.x48191.Name_Full,match2InfoB.x48191.Position))
                        match2PlayerB.add(Match2PlayersInfo(match2InfoB.x57458.Batting,match2InfoB.x57458.Bowling,"","",match2InfoB.x57458.Name_Full,match2InfoB.x57458.Position))

                        match2ATeamAdapter.notifyDataSetChanged()
                        match2BTeamAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<SecondMatchModelClass>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(applicationContext, ""+t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }


    private fun loadTeams() {
         val getTeams = matchDetailsInterface.getDetailsInterface()
         getTeams.enqueue(object :Callback<MatchDetails>{
             @SuppressLint("NotifyDataSetChanged")
             override fun onResponse(call: Call<MatchDetails>, response: Response<MatchDetails>) {
                 progressDialog.dismiss()
                 when (response.code()) {
                     200 -> {

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
                 progressDialog.dismiss()
                 Toast.makeText(applicationContext, ""+t.localizedMessage, Toast.LENGTH_SHORT).show()
             }

         })

     }
}

