
public class Polylinjer 
{

    public static Polylinje4 Polylinjer(Polylinje4[] polylinjes) 
    {

        Polylinje4 p = polylinjes[0];
        double l�ngd = Double.MAX_VALUE;
        for (int i = 1; i < polylinjes.length; i++) {
            if (l�ngd > p.l�ngd() && polylinjes[i].getF�rg().equals("Gul"))
            p = polylinjes[i];
        }
        return p;
    }
}

