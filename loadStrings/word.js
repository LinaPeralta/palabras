class word
{
    constructor(posX, posY, value) 
    {
        this.posX = posX;
        this.posY = posY;
        this.value = value;
    }

    draw()
    {
        text(this.value, this.posX, this.posY);

        this.posY++;
    }
}