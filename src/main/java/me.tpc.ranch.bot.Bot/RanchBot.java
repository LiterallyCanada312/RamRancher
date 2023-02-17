package me.tpc.ranch.bot.Bot;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;


class RanchBot{

    private final ShardManager shardManager;

    public RanchBot(){
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(Constants.token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Ram Ranch"));
        shardManager = builder.build();
    }

    public static void main(String[] args){
        try{
            RanchBot ranchBot = new RanchBot();
        } catch(LoginException e) {
            System.out.println("Ur not logged in dumbass");
        }
    }

    public ShardManager getShardManager(){
        return this.shardManager;
    }

}