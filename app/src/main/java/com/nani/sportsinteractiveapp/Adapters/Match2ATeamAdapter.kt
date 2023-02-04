package com.nani.sportsinteractiveapp.Adapters

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nani.sportsinteractiveapp.Model2.Match2PlayersInfo
import com.nani.sportsinteractiveapp.R

class Match2ATeamAdapter(val context: Context,val match2AteamplayerList:List<Match2PlayersInfo>):RecyclerView.Adapter<Match2ATeamAdapter.Match2Holder>() {
    class Match2Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        val playerName2 = itemView.findViewById<TextView>(R.id.name)
        val subName2 = itemView.findViewById<TextView>(R.id.subname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Match2Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_custom_layout,parent,false)
        return Match2Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Match2Holder, position: Int) {
        if (match2AteamplayerList.get(position).Iskeeper=="Keeper"&&match2AteamplayerList.get(position).Iscaptain=="Captain"){
            holder.playerName2.text = ""+match2AteamplayerList[position].Name_Full
            holder.subName2.text="C & WK"
            holder.playerName2.setTextColor(Color.CYAN)
        }
        else if (match2AteamplayerList.get(position).Iskeeper=="Keeper"){
            holder.playerName2.text = ""+match2AteamplayerList[position].Name_Full
            holder.subName2.text="Keeper"
            holder.playerName2.setTextColor(Color.DKGRAY)
        }
        else if (match2AteamplayerList.get(position).Iskeeper=="Captain"){
            holder.playerName2.text = ""+match2AteamplayerList[position].Name_Full
            holder.subName2.text="Captain"
            holder.playerName2.setTextColor(Color.CYAN)
            holder.subName2.setTextColor(Color.GRAY)
        }
        else{
            holder.playerName2.text = ""+match2AteamplayerList[position].Name_Full
            holder.subName2.visibility = View.INVISIBLE
            holder.playerName2.setTextColor(Color.BLACK)
        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
            val alertview:View = LayoutInflater.from(context).inflate(R.layout.alert_dialog,null)
            alertDialog.setView(alertview)
            alertDialog.setCancelable(true)

            val batting = alertview.findViewById<TextView>(R.id.average)
            batting.text = "Average: ${match2AteamplayerList.get(position).Batting.Average}"

            val runs = alertview.findViewById<TextView>(R.id.runs)
            runs.text = "Runs: ${match2AteamplayerList.get(position).Batting.Runs}"

            val style = alertview.findViewById<TextView>(R.id.style)
            style.text = "Style: ${match2AteamplayerList.get(position).Batting.Style}"

            val strikeRate = alertview.findViewById<TextView>(R.id.strikerate)
            strikeRate.text = "Strikerate: ${match2AteamplayerList.get(position).Batting.Strikerate}"

            val bowlAverage = alertview.findViewById<TextView>(R.id.bowl_average)
            bowlAverage.text = "Average: ${match2AteamplayerList.get(position).Bowling.Average}"

            val wickets = alertview.findViewById<TextView>(R.id.wickets)
            wickets.text = "Wickets: ${match2AteamplayerList.get(position).Bowling.Wickets}"

            val economy = alertview.findViewById<TextView>(R.id.economy)
            economy.text = "Economy: ${match2AteamplayerList.get(position).Bowling.Economyrate}"

            val bowlStyle = alertview.findViewById<TextView>(R.id.bowl_style)
            bowlStyle.text = "Style: ${match2AteamplayerList.get(position).Bowling.Style}"

            val position1 = alertview.findViewById<TextView>(R.id.position)
            position1.text = "In at: ${match2AteamplayerList.get(position).Position}"

            val fullname = alertview.findViewById<TextView>(R.id.full_name)
            fullname.text = "${match2AteamplayerList.get(position).Name_Full} ${
                match2AteamplayerList.get(position).Iskeeper
            }"

            val keeper = alertview.findViewById<TextView>(R.id.keeping)
            if (match2AteamplayerList.get(position).Iskeeper=="Keeper"&&match2AteamplayerList.get(position).Iscaptain=="Captain"){
                keeper.visibility = View.VISIBLE
                keeper.text = "C & WK"

            }
            else if (match2AteamplayerList.get(position).Iscaptain=="Captain"){
                keeper.visibility = View.VISIBLE
                keeper.text = "Captain"

            }

            else if (match2AteamplayerList.get(position).Iskeeper=="Keeper"){
                keeper.visibility = View.VISIBLE
                keeper.text = "Keeper"

            }
            else{
                keeper.visibility = View.GONE
            }

            alertDialog.create()
            alertDialog.show()

        })
    }

    override fun getItemCount(): Int {
        return match2AteamplayerList.size
    }
}