public class Planet {
    String pl_name;
    String pl_hostname;
    Double ra;
    Double dec;

    @Override
    public String toString() {
        return "Planet Name: '" + this.pl_name +
                "', Host Star Name: '" + this.pl_hostname +
                "', Planet Radius: '" + this.ra +
                "', decimal degrees: '" + this.dec + "'";
    }
}
