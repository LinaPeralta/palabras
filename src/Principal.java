import java.io.PrintWriter;
import java.util.ArrayList;

import processing.core.PApplet;

public class Principal extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() // void Awake
	{
		size(800, 700);
	}

	String[] texts;

	private ArrayList<word> words;
	private ArrayList<BottomWords> bottomWords;

	float randomNum, randomNum1, randomNum2, randomNum3;

	int counter;

	boolean equalsTrue;
	
	PrintWriter output;
	
	String savedWords;
	String[] newWords;

	@Override
	public void setup() // void Start
	{
		savedWords = "funciona";
		newWords = split(savedWords, ' ');
		
		texts = loadStrings("strings.txt");
		words = new ArrayList<word>();
		bottomWords = new ArrayList<BottomWords>();

		randomNum = (int) random(0, 50);
		randomNum1 = (int) random(0, 50);
		randomNum2 = (int) random(0, 50);
		randomNum3 = (int) random(0, 50);

		counter = 0;
		frameRate = 60;

		for (int i = 0; i < texts.length; i++) 
		{
			String[] arrayWords = texts[i].split(" ");
			for (int j = 0; j < arrayWords.length; j++) 
			{
				words.add(new word((int) random(780), (int) random(-880, 0), arrayWords[j]));
			}			
		}
		
		for (int j = 0; j < 4; j++) 
		{
			int randomNumber = (int) random(0, words.size() - 1);
			bottomWords.add(new BottomWords(50 * j + 100, 680, words.get(randomNumber).getValue()));
		}


	}

	@Override
	public void draw() // void Update
	{
		counter++;

		if (counter == 5) 
		{
			counter = 0;
		}

		textAlign(CENTER);
		background(142, 168, 145);
		System.out.println(mouseX + ", " + mouseY);

		fill(0);
		textSize(15);

		for (int i = 0; i < words.size(); i++) 
		{
			words.get(i).paint(this);

			if (words.get(i).getPosY() > 630) 
			{
				words.get(i).setPosY(0);
			}
		}

		for (int i = 0; i < bottomWords.size(); i++) 
		{
			bottomWords.get(i).paint(this);

		}

		fill(201, 188, 154, 90);
		noStroke();
		rect(0, 650, 800, 50);

		fill(0);

		fill(0, 0, 0, 50);
		if (dist(mouseX, mouseY, 50, 480) < 20 || dist(mouseX, mouseY, 150, 480) < 20
				|| dist(mouseX, mouseY, 250, 480) < 20 || dist(mouseX, mouseY, 350, 480) < 20) 
		{
			circle(mouseX, mouseY, 20);
		}
		
		match();
		saveWords();
	}

	public void mousePressed() 
	{
		for (int i = 0; i < bottomWords.size(); i++) {
			if (dist(mouseX, mouseY, bottomWords.get(i).getPosX(), bottomWords.get(i).getPosY()) < 10 && mousePressed) 
			{
				bottomWords.get(i).isActive = true;
				circle(bottomWords.get(i).getPosX(), bottomWords.get(i).getPosY(), 20);
			}
		}
	}

	public void mouseDragged() 
	{
		for (int i = 0; i < bottomWords.size(); i++) 
		{
			for (int j = 0; j < words.size(); j++) 
			{
				if (dist(mouseX, mouseY, bottomWords.get(i).getPosX(), bottomWords.get(i).getPosY()) < 20
						&& mousePressed && bottomWords.get(i).isActive) 
				{
					bottomWords.get(i).setPosX(mouseX);
					bottomWords.get(i).setPosY(mouseY);
				}
			}
		}
	}
	
	public void match()
	{
		for(int i = 0; i < bottomWords.size(); i++)
		{
			for(int j = 0; j < words.size(); j++)
			{
				if(dist(bottomWords.get(i).getPosX(), bottomWords.get(i).getPosY(), words.get(j).getPosX(), words.get(j).getPosY()) < 10 && 
						bottomWords.get(i).getValue().equals(words.get(j).getValue()))
				{
					words.get(j).setR(255);
					bottomWords.get(i).setR(255);
					bottomWords.get(i).hasMatched = true;
					System.out.println("funciona");
				}
			}
		}
	}
	
	public void saveWords()
	{
		for(int i = 0; i < bottomWords.size(); i++)
		{
			if(bottomWords.get(i).hasMatched)
			{
				fill(87, 113, 93);
				strokeWeight(2);
				rect(603, 656, 150, 40);
				fill(255, 255, 255);
				textSize(14);
				text("GUARDAR", 679, 681);
				
				if(mousePressed && mouseX > 603 && mouseX < 752 && mouseY > 656 && mouseY < 694)
				{
					saveStrings("newStrings.txt", newWords);
					exit();
				}
			}
		}
	}
}
