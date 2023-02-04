package com.nani.sportsinteractiveapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nani.sportsinteractiveapp.Model.Batsmen
import com.nani.sportsinteractiveapp.Model.BatsmenDetails
import com.nani.sportsinteractiveapp.Model.Batting
import com.nani.sportsinteractiveapp.Model.Inning
import com.nani.sportsinteractiveapp.R

class ScoreCardAdapter(val context:Context,val batsmenPerformanceList:List<BatsmenDetails>):RecyclerView.Adapter<ScoreCardAdapter.ScoreHolder>() {
    class ScoreHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        val batterInfo = itemview.findViewById<TextView>(R.id.batter)
        val batterRuns = itemview.findViewById<TextView>(R.id.b_runs)
        val batterBalls = itemview.findViewById<TextView>(R.id.balls)
        val batter4s = itemview.findViewById<TextView>(R.id.fours)
        val batter6s = itemview.findViewById<TextView>(R.id.sixes)
        val batterSR = itemview.findViewById<TextView>(R.id.strike_rate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_scorecard,parent,false)
        return ScoreHolder(view)
    }

    override fun getItemCount(): Int {
        return batsmenPerformanceList.size
    }

    override fun onBindViewHolder(holder: ScoreHolder, position: Int) {
        holder.batterInfo.text = ""+batsmenPerformanceList[position].Batsman
        holder.batterRuns.text = ""+batsmenPerformanceList[position].Runs
        holder.batterBalls.text = ""+batsmenPerformanceList[position].Balls
        holder.batter4s.text = ""+batsmenPerformanceList[position].Fours
        holder.batter6s.text = ""+batsmenPerformanceList[position].Sixes
        holder.batterSR.text = ""+batsmenPerformanceList[position].Strikerate

    }


}