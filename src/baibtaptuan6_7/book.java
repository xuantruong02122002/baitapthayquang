/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baibtaptuan6_7;

/**
 *
 * @author TechCare
 */
public class book {
    int Id;
    String  Title,Price;
      public book(){}

    public book(int Id, String Title, String Price) {
        this.Id = Id;
        this.Title = Title;
        this.Price = Price;
    }

    public book(String Title, String Price) {
        this.Title = Title;
        this.Price = Price;
    }



    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    


    
}
