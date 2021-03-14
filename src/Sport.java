//Simple class to create an object for a sport
public class Sport {
    String _name;
    int _teamNumbers;
    //Keeps track of sports names and team numbers
    public Sport(String Name){
        _name = Name;
        switch (_name) {
            case "Basketball": _teamNumbers = 10;
            case "Baseball": _teamNumbers = 10;
            case "Soccer": _teamNumbers = 10;
            case "Football": _teamNumbers = 10;
            case "Hockey": _teamNumbers = 10;
            case "Kickball": _teamNumbers = 10;
            break;
        }
    }
    //Converts the object to a string
    public String toString(){
        String _sport = _name;
        return _sport;
    }
    //returns team numbers
    public int getTeamNumbers(){
        return _teamNumbers;
    }
}
