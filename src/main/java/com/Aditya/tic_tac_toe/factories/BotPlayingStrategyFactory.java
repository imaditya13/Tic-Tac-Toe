package com.Aditya.tic_tac_toe.factories;

import com.Aditya.tic_tac_toe.models.BotDifficultyLevel;
import com.Aditya.tic_tac_toe.strategies.BotPlayingStrategy.BotPlayingStrategy;
import com.Aditya.tic_tac_toe.strategies.BotPlayingStrategy.EasyBotPlaingStrategy;
import com.Aditya.tic_tac_toe.strategies.BotPlayingStrategy.HardBotPlayingStrategy;
import com.Aditya.tic_tac_toe.strategies.BotPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
   public static BotPlayingStrategy getBotPlayingStrategyDifficultyLevel(BotDifficultyLevel botDifficultyLevel)
    {
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY))
        {
            return new EasyBotPlaingStrategy();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM))
        {
            return new MediumBotPlayingStrategy();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.HARD))
        {
            return new HardBotPlayingStrategy();
        }
        return null;
    }
}
