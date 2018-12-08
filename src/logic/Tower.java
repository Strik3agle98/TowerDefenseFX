package logic;

import javafx.scene.image.Image;

//parent class for all tower
public abstract class Tower {
	String name = "Tower";
	private int damage;
	private int health;
	private int row, col;
	private boolean isInAttackingState = false;
	private Image attackingImage, standbyImage;
	double x = 0,y = 0;
	public Tower(String name,int health,int damage) {
		this.name = name;
		this.health = health;
		this.setDamage(damage);
	}
	public Tower() {
	}
	public Tower(String name) {
		this.name = name;
	}
	public Tower(double x,double y) {
		this.x = x;
		this.y = y;
	}
	public Tower(String name,double x,double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
//	public void fire(Tower tower) {
//		Bullet bullet = new Bullet();
//		Field.addBullet(bullet);
//	}
	public boolean isCollidingWith(Target target) {
		if(this.getRow() != target.getRow()) return false;
		//System.out.println("colliding distance: " + (this.x - target.x) * (this.x - target.x));
		if((this.x - target.getX()) * (this.x - target.getX()) < 2500) {
			return true;
		}
		return false;
	}
	public void takeDamage(int val) {
		setHealth(getHealth() - val);
	}
	//getter and setter
	public Image getImage() {
		if(isInAttackingState) return attackingImage;
		else return standbyImage;
	}
	public void setImage(Image image1, Image image2) {
		attackingImage = image1;
		standbyImage = image2;
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
		return this.x;
	}
	public void setX(double x) {
		if(x < 0) this.x = 0;
		else this.x = x;
	}
	public double getY() {
		return this.y;
	}
	public void setY(double y) {
		if(y < 0) this.y = 0;
		else this.y = y;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isInAttackingState() {
		return isInAttackingState;
	}
	public void setInAttackingState(boolean isInAttackingState) {
		this.isInAttackingState = isInAttackingState;
	}
	public boolean isDead() {
		return this.health <= 0;
	}
}
