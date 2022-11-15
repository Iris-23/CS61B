public class Planet{
    public double xxPos,yyPos,xxVel,yyVel,mass;
    public String imgFileName;
    private static final double G=6.67e-11;// double somenumber=1.03e-7
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p){
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }
    public double calcDistance(Planet p){
        return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
        //调用Math
    }
    public double calcForceExertedBy(Planet p){
        double r=calcDistance(p);
        return (G*mass*p.mass)/(r*r);
    }
    public double calcForceExertedByX(Planet p){
        double dx=p.xxPos-xxPos;
        double r=calcDistance(p);
        return calcForceExertedBy(p)*dx/r;
    }
    public double calcForceExertedByY(Planet p){
        double dy=p.yyPos-yyPos;
        double r=calcDistance(p);
        return calcForceExertedBy(p)*dy/r;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double totalForce=0;
        //for simple way=== for (Planet planet : allPlanets)
        for(int i=0;i<allPlanets.length;i++){
            Planet p=allPlanets[i];
            if(this.equals(p)) {
                Object coutinue;
            }

            totalForce+=calcForceExertedByX(p);
        }
        return totalForce;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double totalForce=0;
        for(int i=0;i<allPlanets.length;i++){
            Planet p=allPlanets[i];
            if(this.equals(p)) {
                Object coutinue;

            }
            else totalForce+=calcForceExertedByY(p);
        }
        return totalForce;
    }
    public double update(double dt,double fx,double fy){
        double ax=fx/mass;
        double ay=fy/mass;
        xxVel+=dt*ax;
        yyVel+=dt*ay;
        xxPos+=xxVel*dt;
        yyPos+=yyVel*dt;
    }
}
