public class GreyScaleFilter extends Filter
{
    public void modifyPixels() {
        Pixel[][] data = super.getData(); 
        
        for (int row = 0; row < data.length; row++){
            for (int col = 0; col < data[row].length; col++){
                Pixel currentPixel = data[row][col];
                int intensity = (int)((currentPixel.getRed() + currentPixel.getBlue() + currentPixel.getGreen())/(255.0 * 3) * 255.0);
                data[row][col].setRed(intensity);
                data[row][col].setBlue(intensity);
                data[row][col].setGreen(intensity);
            }
        }
        
        //write code to modify pixels
    }
}
