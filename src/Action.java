/**
 * @author Maxim
 * Class: ITEC 3860 SPRING 2015
 * Date: March 9, 2015
 * Purpose: Pure list of possible actions called by player/monsters.
 * Serves only as a connector and to categorize player input.
 */

public enum Action
{
	//Player attack commands
	attack_pistol,
	attack_stun,
	//Player reload commands
	reload_stun,
	reload_pistol,
	//Player navigation & interaction
	move,
	open_inventory,
	use,
	//Monster's basic attack
	attack,
	//Player and monster's defense command
	defend,
	//puzzle commands
	jump, eat, hit, toss, drop, relax, yell, sit;	
	
}