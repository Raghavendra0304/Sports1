package com.nani.sportsinteractiveapp.Model

data class MatchDetails(
    val Innings: List<Inning>,
    val Matchdetail: Matchdetail,
    val Notes: Notes,
    val Nuggets: List<String>,
    val Teams: Teams
)