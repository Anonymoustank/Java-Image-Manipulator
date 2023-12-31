public class NegativeImageFilter extends Filter
{
    public void modifyPixels() {
        Pixel[][] data = super.getData(); 
        
        for (int row = 0; row < data.length; row++){
            for (int col = 0; col < data[row].length; col++){
                data[row][col].setRed(255 - data[row][col].getRed());
                data[row][col].setBlue(255 - data[row][col].getBlue());
                data[row][col].setGreen(255 - data[row][col].getGreen());
            }
        }
        
        //write code to modify pixels
    }
}
