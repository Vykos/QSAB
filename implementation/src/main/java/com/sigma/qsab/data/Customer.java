package com.sigma.qsab.data;

public class Customer {
    private String firstname;
    private String lastname;
    private String socialID;
    private String street;
    private String zipCode;
    private String city;
    private String phone;
    private String cellPhone;
    private String email;
    private String password;

    public Customer(String firstname, String lastname, String socialID, String street, String zipCode, String city, String phone, String cellPhone, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.socialID = socialID;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.email = email;
        this.password = password;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getSocialID() {
        return socialID;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if ((this.firstname == null) ? (other.firstname != null) : !this.firstname.equals(other.firstname)) {
            return false;
        }
        if ((this.lastname == null) ? (other.lastname != null) : !this.lastname.equals(other.lastname)) {
            return false;
        }
        if ((this.socialID == null) ? (other.socialID != null) : !this.socialID.equals(other.socialID)) {
            return false;
        }
        if ((this.street == null) ? (other.street != null) : !this.street.equals(other.street)) {
            return false;
        }
        if ((this.zipCode == null) ? (other.zipCode != null) : !this.zipCode.equals(other.zipCode)) {
            return false;
        }
        if ((this.city == null) ? (other.city != null) : !this.city.equals(other.city)) {
            return false;
        }
        if ((this.phone == null) ? (other.phone != null) : !this.phone.equals(other.phone)) {
            return false;
        }
        if ((this.cellPhone == null) ? (other.cellPhone != null) : !this.cellPhone.equals(other.cellPhone)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.firstname != null ? this.firstname.hashCode() : 0);
        hash = 89 * hash + (this.lastname != null ? this.lastname.hashCode() : 0);
        hash = 89 * hash + (this.socialID != null ? this.socialID.hashCode() : 0);
        hash = 89 * hash + (this.street != null ? this.street.hashCode() : 0);
        hash = 89 * hash + (this.zipCode != null ? this.zipCode.hashCode() : 0);
        hash = 89 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 89 * hash + (this.phone != null ? this.phone.hashCode() : 0);
        hash = 89 * hash + (this.cellPhone != null ? this.cellPhone.hashCode() : 0);
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 89 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }
    
    
}
