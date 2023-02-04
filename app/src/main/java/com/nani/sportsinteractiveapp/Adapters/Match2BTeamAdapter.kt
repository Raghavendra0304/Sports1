package com.nani.sportsinteractiveapp.Adapters

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

class Match2BTeamAdapter(val context: Context,val match2BteamplayerList:List<Match2PlayersInfo>):RecyclerView.Adapter<Match2BTeamAdapter.Match2BHolder>() {
    class Match2BHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val playerBname2 = itemView.findViewById<TextView>(R.id.name)
        val subnameB2 = itemView.findViewById<TextView>(R.id.subname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Match2BHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_custom_layout,parent,false)
        return Match2BHolder(view)
    }

    override fun onBindViewHolder(holder: Match2BHolder, position: Int) {
        if (match2BteamplayerList.get(position).Iskeeper == "Keeper") {
            holder.playerBname2.text = "" + match2BteamplayerList[position].Name_Full
            holder.subnameB2.text = "Keeper"
            holder.playerBname2.setTextColor(Color.DKGRAY)
        } else if (match2BteamplayerList.get(position).Iscaptain == "Captain") {
            holder.playerBname2.text = "" + match2BteamplayerList[position].Name_Full
            holder.subnameB2.text = "Captain"
            holder.playerBname2.setTextColor(Color.CYAN)
            holder.subnameB2.setTextColor(Color.GRAY)
        } else {
            holder.playerBname2.text = "" + match2BteamplayerList[position].Name_Full
            holder.subnameB2.visibility = View.INVISIBLE
            holder.playerBname2.setTextColor(Color.BLACK)
        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
            val alertview: View = LayoutInflater.from(context).inflate(R.layout.alert_dialog, null)
            alertDialog.setView(alertview)
            alertDialog.setCancelable(true)
            val batting = alertview.findViewById<TextView>(R.id.average)
            batting.text = "Average: ${match2BteamplayerList.get(position).Batting.Average}"
            val runs = alertview.findViewById<TextView>(R.id.runs)
            runs.text = "Runs: ${match2BteamplayerList.get(position).Batting.Runs}"
            val style = alertview.findViewById<TextView>(R.id.style)
            style.text = "Style: ${match2BteamplayerList.get(position).Batting.Style}"
            val strikeRate = alertview.findViewById<TextView>(R.id.strikerate)
            strikeRate.text =
                "Strikerate: ${match2BteamplayerList.get(position).Batting.Strikerate}"

            val bowlAverage = alertview.findViewById<TextView>(R.id.bowl_average)
            bowlAverage.text = "Average: ${match2BteamplayerList.get(position).Bowling.Average}"
            val wickets = alertview.findViewById<TextView>(R.id.wickets)
            wickets.text = "Wickets: ${match2BteamplayerList.get(position).Bowling.Wickets}"
            val economy = alertview.findViewById<TextView>(R.id.economy)
            economy.text = "Economy: ${match2BteamplayerList.get(position).Bowling.Economyrate}"
            val bowlStyle = alertview.findViewById<TextView>(R.id.bowl_style)
            bowlStyle.text = "Style: ${match2BteamplayerList.get(position).Bowling.Style}"

            val position1 = alertview.findViewById<TextView>(R.id.position)
            position1.text = "In at: ${match2BteamplayerList.get(position).Position}"

            val fullname = alertview.findViewById<TextView>(R.id.full_name)
            fullname.text =
                "${match2BteamplayerList.get(position).Name_Full}" + " " + match2BteamplayerList.get(
                    position).Iskeeper

            val keeper = alertview.findViewById<TextView>(R.id.keeping)
            if (match2BteamplayerList.get(position).Iskeeper == "Keeper") {
                keeper.visibility = View.VISIBLE
                keeper.text = "Keeper"

            } else if (match2BteamplayerList.get(position).Iscaptain == "Captain") {
                keeper.visibility = View.VISIBLE
                keeper.text = "Captain"

            } else {
                keeper.visibility = View.GONE
            }

            alertDialog.create()
            alertDialog.show()

        })
    }

    override fun getItemCount(): Int {
        return match2BteamplayerList.size
    }
}