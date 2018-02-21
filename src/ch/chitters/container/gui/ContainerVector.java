package ch.chitters.container.gui;

public class ContainerVector {
	protected int x;
	protected int y;
	protected int index;
	
	public ContainerVector(int index) {
		this.index = index;
		this.y = (int) Math.floor(index / 9.0F);
		this.x = index - (this.y * 9);
	}
	public ContainerVector(int x, int y) {
		this.x = x;
		this.y = y;
		this.index = y * 9 + x;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getIndex() {
		return index;
	}
}
