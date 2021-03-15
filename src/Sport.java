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
            case "Football": _teamNumbers = 11;
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
    //Method to take in an array of names entered and turn them into teams
    public void teams(String[] Players){
        String _team1 = "Team 1 is: ";
        String _team2 = "Team 2 is: ";
        for(int i = 0; i < 5; i++){
            _team1 += (Players[i] + ", ");
        }
        for(int i = 5; i < 10; i++){
            _team2 += (Players[i] + ", ");
        }
        System.out.println(_team1);
        System.out.println((_team2));
    }
}
