/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object_Classes;

/**
 *
 * @author jhonny-G
 */
public class User {
private String Nombre;
private String Username;
private String Pansword;
private String UserType;

public User(String Nombre,String Username,String Pansword,String UserType){
this.Nombre=Nombre;
this.Pansword=Pansword;
this.UserType=UserType;
this.Username=Username;
}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPansword() {
        return Pansword;
    }

    public void setPansword(String Pansword) {
        this.Pansword = Pansword;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

}
