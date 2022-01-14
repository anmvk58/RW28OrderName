package entity;

public class Name implements Comparable<Name>{
    String lastName;
    String middleName;
    String firstName;

    public Name(String lastName, String middleName, String firstName) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
    }


    @Override
    public int compareTo(Name obj) {
        int result = this.firstName.compareTo(obj.firstName);
        if(result == 0){
            // so sánh theo tên
            if(this.lastName.compareTo(obj.lastName) == 0 ){
                //so sánh theo tên lót
                return this.middleName.compareTo(obj.middleName);
            } else {
                return this.lastName.compareTo(obj.lastName);
            }
        } else {
            return result;
        }
    }

    @Override
    public String toString() {
        return  this.lastName + " " + this.middleName + " "  + this.firstName;
    }
}
