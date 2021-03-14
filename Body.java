public class Body {
    private static final double G = 1;
    public double rx, ry;       // holds the cartesian positions
    public double vx, vy;       // velocity components 
    public double fx, fy;       // force components
    public double mass;

    public Body(double rx, double ry, double vx, double vy, double mass) {
        this.rx    = rx;
        this.ry    = ry;
        this.vx    = vx;
        this.vy    = vy;
        this.mass  = mass;
    }

    public void update(double dt) {
        vx += dt * fx / mass;
        vy += dt * fy / mass;
        rx += dt * vx;
        ry += dt * vy;
    }

    // returns the distance between two bodies
    public double distanceTo(Body b) {
        double dx = rx - b.rx;
        double dy = ry - b.ry;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public void resetForce() {
        fx = 0.0;
        fy = 0.0;
    }

    public void addForce(Body b) {
        Body a = this;
        double EPS = 0.000001;      // softening parameter (just to avoid infinities)
        double dx = b.rx - a.rx;
        double dy = b.ry - a.ry;
        double dist = Math.sqrt(dx*dx + dy*dy);
        double F = (G * a.mass * b.mass) / (dist*dist + EPS*EPS);
        //if(dist>0.5){F = (G * a.mass * b.mass) / (dist*dist + EPS*EPS);}
        //else{F = 0.001;}
        a.fx += F * dx / dist;
        a.fy += F * dy / dist;
    }
}
