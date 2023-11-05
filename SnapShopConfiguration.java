/**
 * A class to configure the SnapShop application
 * Set the defaultFileName class variable, and add any appropriate Filters.
 */
public class SnapShopConfiguration
{
    public static String defaultFilename = "monet.jpg";
    /**
     * Method to configure the SnapShop.  Call methods like addFilter
     * and setDefaultFilename here.
     * @param theShop A pointer to the application
     */
    public static void configure(SnapShop theShop)
    {   
        theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal (Invertible)");
        theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical (Invertible)");
        theShop.addFilter(new NegativeImageFilter(), "Reverse Image (Invertible)");  
        theShop.addFilter(new GreyScaleFilter(), "Gray Scale Image (Not invertible)" );
        theShop.addFilter(new Lighten10Filter(), "Lighten 10% Filter (Not invertible)" );
        theShop.addFilter(new GuassianBlurFilter(), "Gaussian Blur Image (Not invertible)"); 
        //theShop.addFilter(new LaplacianFilter(), "Laplacian Image");   
        //theShop.addFilter(new UnsharpMaskFilter(), "UnsharpMask" );
        //theShop.addFilter(new EdgyFilter(), "Edgy Image" );
        //theShop.addFilter(new EmbossFilter(), "Emboss Filter" );
        
        //you can add any additional Filters that you want.  You just have to create a class that extends Filter
    }
    public static String getDefaultFilename()
    {
        return defaultFilename;
    }
}
