package com.massivecraft.factions.cmd;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.struct.Permission;
import com.massivecraft.factions.util.TL;

public class CmdDebug extends FCommand {

    public CmdDebug() {
        super();
        this.aliases.add("debug");

        this.requiredArgs.add("blocknames");

        this.requirements = new CommandRequirements.Builder(Permission.DEBUG_BLOCKNAMES).playerOnly().build();
    }

    @Override
    public void perform(CommandContext context) {
        FPlayer fPlayer = context.fPlayer;

        fPlayer.setDebugBlockNames(!fPlayer.isDebugBlockNames());

        if (fPlayer.isDebugBlockNames()) {
            fPlayer.msg(TL.COMMAND_DEBUG_BLOCKNAMES_ENABLED);
        } else {
            fPlayer.msg(TL.COMMAND_DEBUG_BLOCKNAMES_DISABLED);
        }
    }

    @Override
    public TL getUsageTranslation() {
        return TL.COMMAND_DEBUG_BLOCKNAMES_DESCRIPTION;
    }
}
