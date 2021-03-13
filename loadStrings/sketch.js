let texts;
let words = [];

let wordPrinter;

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
      words.push(arrayWords[index]);
      wordPrinter = new word(100, 100, words[index]);
    }
  }

  console.log(words);
}

function draw() 
{
  background(220);

  /*for(let index = 0; index < words.length; index++)
  {
    text(words[index], 250, 250);
  }*/

  wordPrinter.draw();
}
