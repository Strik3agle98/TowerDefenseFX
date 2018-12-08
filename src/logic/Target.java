package logic;

import javafx.scene.image.Image;

//parent class for all target
public class Target {
	private String name = "Target";
	private int health = 100;
	private Image attackingImage,standbyImage;
	private int row;
	private int damage;
	private boolean isInAttackingState = false;
	private double x = 0, y = 0;
	private double dx = 1;
	
	public Target() {
		
	}
	public Target(String name) {
		this.setName(name);
	}
	public Target(String name,int health) {
		this.setName(name);
		this.health = health;
	}
	public void startAttacking(Tower tower) {
		if(!isInAttackingState) {
			
			isInAttackingState = true;
			attack(tower);
		}
	}
	public void stopAttacking() {
		isInAttackingState = false;
	}
	public void attack(Tower tower) {
		tower.takeDamage(damage);
	}
	public void takeDamage(int val) {
		health -= val;
	}
	public void startWalk() {
		setdx(1);
	}
	public void stopWalk() {
		setdx(0);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int amount) {
		if(amount < 0) this.health = 0;
		else this.health = amount;
	}
	
	public double getdx() {
		return dx;
	}
	public void setdx(double dx) {
		this.dx = dx;
	}
	public boolean isDead() {
		return this.health <= 0;
	}
	public Image getImage() {
		if(isInAttackingState) return attackingImage;
		else return standbyImage;
	}
	public void setImage(Image img1, Image img2) {
		attackingImage = img1;
		standbyImage = img2;
	}
	public Image getAttackingImage() {
		return attackingImage;
	}
	public void setAttackingImage(Image image) {
		attackingImage = image;
	}
	public Image getStandbyImage() {
		return standbyImage;
	}
	public void setStandbyImage(Image image) {
		standbyImage = image;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		if(x < 0) this.x = 0;
		else this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public boolean isInAttackingState() {
		return isInAttackingState;
	}
	public void setInAttackingState(boolean isInAttackingState) {
		this.isInAttackingState = isInAttackingState;
	}
	public void update() {
		setX(getX() - dx);
		//System.out.println("target x : " + getX() + " , y : " + getY());
	}
}
