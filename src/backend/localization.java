package backend;

public class localization {
	
	public routerPositions routers;

	public localization()
	{
		routers = new routerPositions();
		
		routers = trilaterate(routers);

	}
	
	public routerPositions trilaterate(routerPositions routers)
	{
		
		double A = (-2*routers.x1 + 2*routers.x2);
		double B = (-2*routers.y1 + 2*routers.y2);
		double C = (Math.pow(routers.r1, 2.0)-Math.pow(routers.r2, 2.0)-Math.pow(routers.x1, 2.0)+Math.pow(routers.x2, 2.0)-Math.pow(routers.y1, 2.0)+Math.pow(routers.y2, 2.0));
		double D = (-2*routers.x2 + 2*routers.x3);
		double E = (-2*routers.y2 + 2*routers.y3);
		double F = (Math.pow(routers.r2, 2.0)-Math.pow(routers.r3, 2.0)-Math.pow(routers.x2, 2.0)+Math.pow(routers.x3, 2.0)-Math.pow(routers.y2, 2.0)+Math.pow(routers.y3, 2.0));
		
		routers.x = ((C*D)-(F*A))/((B*D)-(E*A));

		if(E == 0)
		{
			routers.y = 0;
		}
		else
		{
			routers.y = (F - (D*routers.x))/E;
		}

		
//		double S = (Math.pow(routers.x3, 2.0) - Math.pow(routers.x2, 2) + Math.pow(routers.y3, 2.0) - Math.pow(routers.y2, 2.0) + Math.pow(routers.r3, 2.0) - Math.pow(routers.r2, 2))/2.0;
//		double T = (Math.pow(routers.x1, 2.0) - Math.pow(routers.x2, 2) + Math.pow(routers.y1, 2.0) - Math.pow(routers.y2, 2.0) + Math.pow(routers.r1, 2.0) - Math.pow(routers.r2, 2))/2.0;
//		
//		routers.y = ((T * (routers.x2 - routers.x3)) - (S * (routers.x2-routers.x1)))/(((routers.y1-routers.y2)*(routers.x2-routers.x3))-((routers.y3-routers.y2)*(routers.x2-routers.x1)));
//		routers.x = ((routers.y * (routers.y1 - routers.y2)) - T) / (routers.x2 - routers.x1);
//		
//		
//		//TODO this is aweful lets change it later though
 		return routers;
	}
	
}