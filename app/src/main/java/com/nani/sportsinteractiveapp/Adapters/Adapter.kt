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
import com.nani.sportsinteractiveapp.Model.PlayersInfo
import com.nani.sportsinteractiveapp.R

class Adapter(val context:Context, val playerList:List<PlayersInfo>):RecyclerView.Adapter<Adapter.MatchHolder>() {
    class MatchHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        //val imageView = itemView.findViewById<ImageView>(R.id.image_player)
        val playerName = itemView.findViewById<TextView>(R.id.name)
        val subname = itemView.findViewById<TextView>(R.id.subname)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.team_custom_layout,parent,false)
        return MatchHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MatchHolder, position: Int) {

        if (playerList.get(position).Iskeeper=="Keeper"){
            holder.playerName.text = ""+playerList[position].Name_Full
            holder.subname.text="Keeper"
            holder.playerName.setTextColor(Color.DKGRAY)
        }
        else if (playerList.get(position).Iskeeper=="Captain"){
            holder.playerName.text = ""+playerList[position].Name_Full
            holder.subname.text="Captain"
            holder.playerName.setTextColor(Color.CYAN)
            holder.subname.setTextColor(Color.GRAY)
        }
        else{
            holder.playerName.text = ""+playerList[position].Name_Full
            holder.subname.visibility = View.INVISIBLE
            holder.playerName.setTextColor(Color.BLACK)
        }

        holder.itemView.setOnClickListener(View.OnClickListener {

            val alertDialog: AlertDialog.Builder = AlertDialog.Builder(context)
            val alertview:View = LayoutInflater.from(context).inflate(R.layout.alert_dialog,null)
            alertDialog.setView(alertview)
            alertDialog.setCancelable(true)
            val batting = alertview.findViewById<TextView>(R.id.average)
            batting.text = "Average: ${playerList.get(position).Batting.Average}"
            val runs = alertview.findViewById<TextView>(R.id.runs)
            runs.text = "Runs: ${playerList.get(position).Batting.Runs}"
            val style = alertview.findViewById<TextView>(R.id.style)
            style.text = "Style: ${playerList.get(position).Batting.Style}"
            val strikeRate = alertview.findViewById<TextView>(R.id.strikerate)
            strikeRate.text = "Strikerate: ${playerList.get(position).Batting.Strikerate}"

            val bowlAverage = alertview.findViewById<TextView>(R.id.bowl_average)
            bowlAverage.text = "Average: ${playerList.get(position).Bowling.Average}"
            val wickets = alertview.findViewById<TextView>(R.id.wickets)
            wickets.text = "Wickets: ${playerList.get(position).Bowling.Wickets}"
            val economy = alertview.findViewById<TextView>(R.id.economy)
            economy.text = "Economy: ${playerList.get(position).Bowling.Economyrate}"
            val bowlStyle = alertview.findViewById<TextView>(R.id.bowl_style)
            bowlStyle.text = "Style: ${playerList.get(position).Bowling.Style}"

            val position1 = alertview.findViewById<TextView>(R.id.position)
            position1.text = "In at: ${playerList.get(position).Position}"

            val fullname = alertview.findViewById<TextView>(R.id.full_name)
            fullname.text = "${playerList.get(position).Name_Full}"+" "+playerList.get(position).Iskeeper

            val keeper = alertview.findViewById<TextView>(R.id.keeping)
            if (playerList.get(position).Iskeeper=="Keeper"){
                keeper.visibility = View.VISIBLE
                keeper.text = "Keeper"

            }
            else if (playerList.get(position).Iskeeper=="Captain"){
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
        return playerList.size
    }
}