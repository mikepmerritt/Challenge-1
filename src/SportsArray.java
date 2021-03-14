//Class to store all available sports to play
public class SportsArray {
    String[] _sportArray;
    public SportsArray(){
        _sportArray = new String[]{"Basketball,", "Baseball,", "Soccer,", "Football,", "Hockey,", "Kickball."};
    }
    //prints all elements of the array when called
    public String toString(){
        String _sports = "Offered Sports are: ";
        for(int i = 0; i < _sportArray.length; i++){
            _sports += (_sportArray[i] + " ");
        }
        return  _sports;
    }
}
