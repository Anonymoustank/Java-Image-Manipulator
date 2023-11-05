public class Lighten10Filter extends Filter
{
    public void modifyPixels() {
        Pixel[][] data = super.getData(); 
        
        for (int row = 0; row < data.length; row++){
            for (int col = 0; col < data[row].length; col++){
                Pixel temp = data[row][col];
                int red = (int)(temp.getRed() * 1.1);
                int green = (int)(temp.getGreen() * 1.1);
                int blue = (int)(temp.getBlue() * 1.1);
                
                if (red >= 255){
                    data[row][col].setRed(255);
                }
                else {
                    data[row][col].setRed(red);
                }
                if (green >= 255){
                    data[row][col].setGreen(255);
                }
                else {
                    data[row][col].setGreen(green);
                }
                if (blue >= 255){
                    data[row][col].setBlue(255);
                }
                else {
                    data[row][col].setBlue(blue);
                }
            }
        }
        
        //write code to modify pixels
    }
}
