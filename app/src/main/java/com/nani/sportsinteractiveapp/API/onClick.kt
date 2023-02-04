package com.nani.sportsinteractiveapp.API

import com.nani.sportsinteractiveapp.Model.PlayersInfo
import com.nani.sportsinteractiveapp.Model2.Match2PlayersInfo

interface onClick {
    fun onClick(playersInfo: PlayersInfo)
    fun onClick(match2PlayersInfo: Match2PlayersInfo)
}