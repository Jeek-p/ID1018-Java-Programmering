
public class Polylinjer 
{

    public static Polylinje4 Polylinjer(Polylinje4[] polylinjes) 
    {

        Polylinje4 p = polylinjes[0];
        double längd = Double.MAX_VALUE;
        for (int i = 1; i < polylinjes.length; i++) {
            if (längd > p.längd() && polylinjes[i].getFärg().equals("Gul"))
            p = polylinjes[i];
        }
        return p;
    }
}

