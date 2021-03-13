let texts = [];
let words = [];

let wordPrinter = [];

function preload()
{
  texts = loadStrings('./assets/strings.txt');
}

function setup() 
{
  createCanvas(400, 400);
  console.log(texts);

  //wordPrinter = new word(100, 100, "string");

  for (let index = 0; index < texts.length; index++) 
  {
    let arrayWords = texts[index].split(' '); 
    for (let index = 0; index < arrayWords.length; index++) 
    {
      words.push(new word(random(400), random(-400, 0), arrayWords[index]));
    }
  }

  console.log(words);

}

function draw()
{
  background(220);

  for(let index = 0; index < words.length; index++)
  {
  words[index].draw();
  }
}
