package greene.ctis310;

public class NoDupWord implements Comparable<NoDupWord>{
    //create a string variable to store the word
    private String word;
    //create an integer variable to store the number of times the word appears
    private int count;

    //constructor
    public NoDupWord(String word){
        this.word = word;
        this.count = 1;
    }

    //override the compareTo method
    @Override
    public int compareTo(NoDupWord o) {
        //compare the number of times the word appears
        //if the word appears more than the other word, return 1
        if(this.count > o.count){
            return 1;
        }
        //if the word appears less than the other word, return -1
        else if(this.count < o.count){
            return -1;
        }
        //if the word appears the same amount of times as the other word, return 0
        else{
            return 0;
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //override the toString method
    @Override
    public String toString() {
        return "[word=" + word + ", count=" + count + "]";
    }
}