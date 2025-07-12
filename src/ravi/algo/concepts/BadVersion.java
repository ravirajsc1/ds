package ravi.algo.concepts;

public class BadVersion {

    private int badVersion;

    public BadVersion(int badVersion){
        this.badVersion=badVersion;
    }

    public boolean isBadVersion(int version){
        return version>=badVersion;
    }


}
