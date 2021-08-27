/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;

/**
 *
 * @author Qzheng
 */
public class Register {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private long phoneNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    @Override
    public String toString() {
        return "Register [firstName = " + firstName + ", lastName = " + lastName + ", Email = " + email + ", Username = " +
            username + ", Email = " + email + ", PhoneNo = " + phoneNo + "]";
    }
    
}
