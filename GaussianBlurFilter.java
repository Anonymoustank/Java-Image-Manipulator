public class GaussianBlurFilter extends Filter
{
    public void modifyPixels() {
        Pixel[][] data = getData();
        //we will need to leave the original pixels in place until we generate
        //all of the modified pixels, so we need a new Pixel[][]
        Pixel[][] modifiedData = new Pixel[data.length][data[0].length];

        //first and last rows, and first and last columns stay the same.
        //1) set first and last rows of modifiedData to same as data
        for(int col=0; col<data[0].length; col++)
        {
            modifiedData[0][col] = data[0][col];
            modifiedData[data.length-1][col] = data[data.length-1][col];
        }
        //2) set first and last columns of modifiedData to same as data
        for (int row = 0; row < data.length; row++){
            modifiedData[row][0] = data[row][0];
            modifiedData[row][data[row].length - 1] = data[row][data[row].length - 1];
        }


        //3) now set all of the rest of the pixels, to calculation that 
        //uses weighted values of the original pixel, and the pixels around it.
        // multiply original value by 4, add values around it multiplied by 2, add corner values multiplied by 1, then divide by 16
        for (int row = 1; row < data.length - 1; row++){
            for (int col = 1; col < data[row].length - 1; col++){
                Pixel modPixel = data[row][col];
                Pixel modPixelLeft = data[row][col - 1];
                Pixel modPixelRight = data[row][col + 1];
                Pixel modPixelDown = data[row - 1][col];
                Pixel modPixelUp = data[row + 1][col];
                Pixel modPixelUpRightDiag = data[row - 1][col + 1];
                Pixel modPixelUpLeftDiag = data[row - 1][col - 1];
                Pixel modPixelDownRightDiag = data[row + 1][col + 1];
                Pixel modPixelDownLeftDiag = data[row + 1][col - 1];
                modifiedData[row][col] = new Pixel(0, 0, 0);
                modifiedData[row][col].setRed((4 * modPixel.getRed() + 2 * (modPixelRight.getRed() + modPixelLeft.getRed() + modPixelDown.getRed() + modPixelUp.getRed())));
                modifiedData[row][col].setRed(modifiedData[row][col].getRed() + modPixelUpRightDiag.getRed() + modPixelUpLeftDiag.getRed() + modPixelDownRightDiag.getRed() + modPixelDownLeftDiag.getRed());
                modifiedData[row][col].setRed(modifiedData[row][col].getRed()/16);
                
                modifiedData[row][col].setBlue((4 * modPixel.getBlue() + 2 * (modPixelRight.getBlue() + modPixelLeft.getBlue() + modPixelDown.getBlue() + modPixelUp.getBlue())));
                modifiedData[row][col].setBlue(modifiedData[row][col].getBlue() + modPixelUpRightDiag.getBlue() + modPixelUpLeftDiag.getBlue() + modPixelDownRightDiag.getBlue() + modPixelDownLeftDiag.getBlue());
                modifiedData[row][col].setBlue(modifiedData[row][col].getBlue()/16);
                
                modifiedData[row][col].setGreen((4 * modPixel.getGreen() + 2 * (modPixelRight.getGreen() + modPixelLeft.getGreen() + modPixelDown.getGreen() + modPixelUp.getGreen())));
                modifiedData[row][col].setGreen(modifiedData[row][col].getGreen() + modPixelUpRightDiag.getGreen() + modPixelUpLeftDiag.getGreen() + modPixelDownRightDiag.getGreen() + modPixelDownLeftDiag.getGreen());
                modifiedData[row][col].setGreen(modifiedData[row][col].getGreen()/16);
            }
        }
        // 1 2 1
        // 2 4 2
        // 1 2 1
        
        //uncomment the below line to set the imagePanel's image
        //to the new modified Pixel[][] modifiedData
        setData(modifiedData);
    }
}
