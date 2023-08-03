package com.Aditya.tic_tac_toe.models;

import com.Aditya.tic_tac_toe.factories.BotPlayingStrategyFactory;
import com.Aditya.tic_tac_toe.strategies.BotPlayingStrategy.BotPlayingStrategy;
import com.Aditya.tic_tac_toe.strategies.BotPlayingStrategy.EasyBotPlaingStrategy;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Character symbol,BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.Bot);
        this.botDifficultyLevel = botDifficultyLevel;
        botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyDifficultyLevel(botDifficultyLevel);
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }
    @Override
    public Move decideMove(Board board)
    {
       return botPlayingStrategy.decideMove(this,board);
    }
}
