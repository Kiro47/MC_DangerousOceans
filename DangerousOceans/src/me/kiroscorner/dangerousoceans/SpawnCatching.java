package me.kiroscorner.dangerousoceans;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import me.kiroscorner.dangerousoceans.utils.DataAccess;

public class SpawnCatching implements Listener {

	// Modulus because people are stupid
	private int squidOverrideChance = Integer.parseInt(DataAccess.SQUID_SPAWN_CHANCE_CHANCE.getValue()) % 101;
	private boolean squidChangeCanBeElder = Boolean.parseBoolean(DataAccess.SQUID_CHANGE_CAN_BE_ELDER.getValue());
	// Modulus removes anything above 100%
	private int squidElderChance = Integer.parseInt(DataAccess.SQUID_CHANGE_ELDER_CHANCE.getValue()) % 101;
	private Random random = new Random();

	/**
	 * onCreatureSpawn()
	 * 
	 * EventHandler for any entity that spawns in the game
	 * 
	 * @param event
	 *            The specific CreatureSpawnEvent that was caught
	 */
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {

		if (event.getSpawnReason() == SpawnReason.NATURAL || event.getSpawnReason() == SpawnReason.CHUNK_GEN) {
			// If the spawn event was for a squid execute options, otherwise
			// ignore
			if (event.getEntityType().equals(EntityType.SQUID)) {

				// If the roll of the dice agrees override squid spawn to
				// guardian spawn
				if (random.nextInt(100) < squidOverrideChance) {
					// Cancel the event so the normal squids don't spawn
					event.setCancelled(true);
					// Spawn the guardian replacements
					spawnGuardian(event.getLocation());
				}
			}
		}
	}

	/**
	 * spawnGuardian()
	 * 
	 * Spawns a random number of guardians based on configuration settings.
	 * 
	 * @param location
	 *            Location to spawn the guardians
	 */
	private void spawnGuardian(Location location) {
		// Maximum of 5, but minimum of 1
		int numberOfSpawnedEntities = random.nextInt(4) + 1;

		// Cycle through spawning as many as randomly generated
		while (numberOfSpawnedEntities != 0) {

			// If elders are allowed to be spawned and the dice roll agrees
			// spawn an elder guardian
			if (squidChangeCanBeElder && (random.nextInt(100) < squidElderChance)) {

				location.getWorld().spawnEntity(location, EntityType.ELDER_GUARDIAN);

			}
			// Otherwise spawn a normal guardian
			else {
				location.getWorld().spawnEntity(location, EntityType.GUARDIAN);
			}

			// Decrease spawn cycle amount
			numberOfSpawnedEntities--;
		}
	}
}
