package com.example;

import javax.security.auth.login.LoginException;

import com.example.commands.CowboysCommand;
import com.example.resources.Constants;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.JDA;

public class RamRanchBot 
{       
    public static void main( String[] args ) throws LoginException{   

        JDA bot = JDABuilder.createDefault(Constants.token)
        .setActivity(Activity.playing("JEQLING"))
        .addEventListeners(new CowboysCommand())
        .build();

    }



}
