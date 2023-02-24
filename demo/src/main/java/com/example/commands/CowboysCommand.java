package com.example.commands;

import com.example.resources.Constants;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.JDA;

import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;


public class CowboysCommand extends ListenerAdapter{
    
    public static void main(String[] args)
    {
        if (args.length < 1) {
            System.out.println("You have to provide a token as first argument!");
            System.exit(1);
        }

        JDA jda = JDABuilder.createLight(Constants.token)
            .addEventListeners()
            .setActivity(Activity.playing("Type /Cowboys"))
            .build();

        jda.updateCommands().addCommands(
            Commands.slash("ping", "Calculate ping of the bot"),
            Commands.slash("Cowboys", "Send a random gif of hot hard buff cowboys")
                    .setGuildOnly(true) 
        ).queue();
    }

    public void onSlashCommandInteraction(SlashCommandInteraction ctx){

        int randomIndex = (int) (Math.random()*(Constants.links.length));

        if(ctx.getName().equals("cowboys")){
            ctx.reply(Constants.links[randomIndex]).queue();
        }
        
    }

}

