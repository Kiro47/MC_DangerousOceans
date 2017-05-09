package me.kiroscorner.dangerousoceans;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.kiroscorner.dangerousoceans.utils.FileManager;

public class PrimaryCommand implements CommandExecutor {

	// Prefix for commands
	private String prefix = ChatColor.LIGHT_PURPLE + "[DangerousOceans]";

	/**
	 * onCommand()
	 * 
	 * handling of command events for /dango
	 * 
	 * @param sender Sender of the command
	 * @param command command that was sent
	 * @param label irrelevant
	 * @param args Arguments accompanying the command
	 * 
	 * @return true on essentially all pieces so I can use custom messages
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// What happens if only /dango is entered
		if (args.length == 0) {
			showHelpMenu(sender);
			return true;
		}
		// What happens if /dango reload .... is entered
		if (args[0].equalsIgnoreCase("reload")) {
			FileManager.getInstance().reloadConfig();
			return true;
		}
		
		// What happens if none of the above happen
		sender.sendMessage(prefix + ChatColor.RED + "Command not found");
		sender.sendMessage(prefix + ChatColor.RED + "For a list of options use /dango");
		return true;

	}

	public void showHelpMenu(CommandSender sender) {

	}
}
