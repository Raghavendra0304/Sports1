package com.nani.sportsinteractiveapp.Adapters

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nani.sportsinteractiveapp.Model.PlayersInfo
import com.nani.sportsinteractiveapp.R

class TeamB_Adapter(val context: Context, val BteamPlayersList:List<PlayersInfo>,):RecyclerView.Adapter<TeamB_Adapter.BteamHolder>() {
    class BteamHolder (iteamView: View):RecyclerView.ViewHolder(iteamView){
        val playerTeamB = itemView.findViewById<TextView>(R.id.name)
        val sub = itemView.findViewById<TextView>(R.id.subname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BteamHolder {
        val viewB = LayoutInflater.from(parent.context).inflate(R.layout.team_custom_layout,parent,false)
        return BteamHolder(viewB)
    }

    override fun onBindViewHolder(holder: BteamHolder, position: Int) {
        holder.playerTeamB.text = ""+BteamPlayersList[position].Name_Full
        if (BteamPlayersList.get(position).Iskeeper=="Keeper"){
            holder.playerTeamB.text = ""+BteamPlayersList[position].Name_Full
            holder.sub.text="Keeper"
            holder.playerTeamB.setTextColor(Color.DKGRAY)
        }
        else if (BteamPlayersList.get(position).Iskeeper=="Captain"){
            holder.playerTeamB.text = ""+BteamPlayersList[position].Name_Full
            holder.sub.text="Captain"
            holder.playerTeamB.setTextColor(Color.CYAN)
            holder.sub.setTextColor(Color.GRAY)
        }
        else{
            holder.playerTeamB.text = ""+BteamPlayersList[position].Name_Full
            holder.sub.visibility = View.INVISIBLE
            holder.playerTeamB.setTextColor(Color.BLACK)
        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
            val alertview:View = LayoutInflater.from(context).inflate(R.layout.alert_dialog,null)
            alertDialog.setView(alertview)
            alertDialog.setCancelable(true)
            val batting = alertview.findViewById<TextView>(R.id.average)
            batting.text = "Average: ${BteamPlayersList.get(position).Batting.Average}"
            val runs = alertview.findViewById<TextView>(R.id.runs)
            runs.text = "Runs: ${BteamPlayersList.get(position).Batting.Runs}"
            val style = alertview.findViewById<TextView>(R.id.style)
            style.text = "Style: ${BteamPlayersList.get(position).Batting.Style}"
            val strikeRate = alertview.findViewById<TextView>(R.id.strikerate)
            strikeRate.text = "Strikerate: ${BteamPlayersList.get(position).Batting.Strikerate}"

            val bowlAverage = alertview.findViewById<TextView>(R.id.bowl_average)
            bowlAverage.text = "Average: ${BteamPlayersList.get(position).Bowling.Average}"
            val wickets = alertview.findViewById<TextView>(R.id.wickets)
            wickets.text = "Wickets: ${BteamPlayersList.get(position).Bowling.Wickets}"
            val economy = alertview.findViewById<TextView>(R.id.economy)
            economy.text = "Economy: ${BteamPlayersList.get(position).Bowling.Economyrate}"
            val bowlStyle = alertview.findViewById<TextView>(R.id.bowl_style)
            bowlStyle.text = "Style: ${BteamPlayersList.get(position).Bowling.Style}"

            val position1 = alertview.findViewById<TextView>(R.id.position)
            position1.text = "In at: ${BteamPlayersList.get(position).Position}"

            val fullname = alertview.findViewById<TextView>(R.id.full_name)
            fullname.text = "${BteamPlayersList.get(position).Name_Full}"+" "+BteamPlayersList.get(position).Iskeeper

            val keeper = alertview.findViewById<TextView>(R.id.keeping)
            if (BteamPlayersList.get(position).Iskeeper=="Keeper"){
                keeper.visibility = View.VISIBLE
                keeper.text = "Keeper"

            }
            else if (BteamPlayersList.get(position).Iskeeper=="Captain"){
                keeper.visibility = View.VISIBLE
                keeper.text = "Captain"

            }
            else{
                keeper.visibility = View.GONE
            }

            alertDialog.create()
            alertDialog.show()

            //Toast.makeText(context, ""+playerList.get(position).Name_Full+""+playerList.get(position).Batting, Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return BteamPlayersList.size
    }
}