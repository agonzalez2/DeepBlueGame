package Battle;

import java.util.ArrayList;

//import Rooms.Item;
//import Action;

/*Change Log as of 3/30/2015
 * Included no parameter default constructor
 * changed capitalization of health, inventory
 * inventory is now arrayList
 * performAction parameter changed from int to Action
 * temporary item class was created thus rooms.Item is changed to just Item
 * Action class is independent of any package (wat)
 * changed removeFromInventory parameter from int to Item and changed to String
 * changed getInventory return type from item[] to String because of toString of inventory
 * 
*/
public class Player {

	private int health;
	
	private ArrayList<Item> inventory;

//	private Rooms.Item[] inventory;

	private Action[] actionArray;
	
	private Action nextAction;

	//paramatrized constructor allows for save/loading non-full health players
	public Player(int health) {
		this.health = health;
	}
	
	//default constructor
	public Player() {
		this.health = 100;
	}
	
	//stores player's current action
	public Action getNextAction(){
		return nextAction;
	}
	
	//
	public void setNextAction(Action nextAction){
		this.nextAction = nextAction;
	}

	//All these actions are called by the monsterBattle class
	public void performAction(Action nextAction) {
		switch(nextAction){
		//Attack calls upon weapon's damage amount
		case attack:
		//Defends calls upon shield's defend amount
		case defend:
		}
	}
	
	//Adds an item to inventory when player obtains an item
	public void addToInventory(Item itemToAdd) {
		inventory.add(itemToAdd);
	}
	
	//Removes an item from inventory by player request or item use
	public String removeFromInventory(Item itemToRemove) {
		inventory.remove(inventory.indexOf(itemToRemove));
		return itemToRemove.toString() + "Has been removed!";
	}
	
	//Returns a list of items inside of the player's inventory
	public String getInventory() {
		return inventory.toString();
	}

	//Ask Alexander about item use
	public String useItem(int itemPosition) {
		return null;
	}
	
	//Navigation 
	public void moveToNext(int nextRoom) {
//		setCurrentRoomID(nextRoom);
	}

	public void updateHealth(int num) {
		health += num;
	}
}