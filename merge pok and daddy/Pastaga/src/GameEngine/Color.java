package GameEngine;

public class Color {
	public float	red;
	public float	green;
	public float	blue;
	public float	alpha;
	
	public Color(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = 1.0f;
	}
	public Color(float red, float green, float blue, float alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;		
	}
}
